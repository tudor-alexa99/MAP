package Controller;

import Model.ADT.*;
import Model.Exceptions.MyException;
import Model.ProgramState;
import Model.Statements.IStatement;
import Model.Values.RefValue;
import Model.Values.StringValue;
import Model.Values.Value;
import Repository.IRepository;

import java.io.BufferedReader;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class Controller_ {
    private IRepository repo;
    private ExecutorService executor;

    public Controller_(IRepository _repo) {
        this.repo = _repo;
    }

    //2 metode
    //1 care odata apelatas iti executa un singur statement
    //a doua care exxecuta toate statementurile de pe stack (programState)

    public ProgramState oneStep(ProgramState state) throws MyException {
        MyIStack<IStatement> exeStack =  state.getExeStack();
        if(exeStack.isEmpty())
            throw new MyException("Empty exe stack");
        IStatement s1 = exeStack.pop();
        return s1.execute(state);
    }

    public void allSteps() throws MyException{
        this.executor = Executors.newFixedThreadPool(2);
//        ProgramState state = this.repo.getCurrentProgram();
        List<ProgramState> states = this.getIncompletePrograms(this.repo.getPrgList());

        while (!states.isEmpty()) {
            Collection<Value> allAddresses = states.stream()
                    .map(ProgramState::getSymTable)
                    .map(symTable -> symTable.getContent().values())
                    .reduce(new ArrayList<>(), (acc, values) -> {
                        acc.addAll(values);
                        return acc;
                    });

            this.garbageCollector(states.get(0));
            try {this.oneStepForAllPrograms(states);}
            catch (InterruptedException ignored){}
            states = this.getIncompletePrograms(this.repo.getPrgList());
//        this.repo.logProgStateExec();
//        MyIStack<IStatement> exeStack = state.getExeStack();
//        while(! exeStack.isEmpty()){
//            System.out.println(state);
//            this.oneStep(state);
//            garbageCollector();
//            this.repo.logProgStateExec();
//        }

//        garbageCollector();
//        state.getHeap().setContent(unsafeGarbageCollector(
//                    getAddrFromSymTable(state.getSymTable().getContent().values()),
//                    state.getHeap().getContent()));
//            System.out.println(state);
        }
        executor.shutdownNow();
        this.repo.setPrgList(states);
    }

    public List<Integer> getListOfThreadIds(){
        return repo.getPrgList().stream().map(ProgramState::getThreadId).collect(Collectors.toList());
    }

    private void oneStepForAllPrograms(List<ProgramState> states) throws InterruptedException{
        states.forEach(state -> {
            try {
                this.repo.logProgStateExec(state);
            }
            catch (MyException ignore) {}
        });

        List<Callable<ProgramState>> callableList = states.stream()
                .map(p->(Callable<ProgramState>) (p::oneStep))
                .collect(Collectors.toList());

        List<ProgramState> newStates = this.executor.invokeAll(callableList).stream()
                .map(futureObj -> {
                    try {
                        return futureObj.get();
                    }
                    catch (ExecutionException | InterruptedException ignored){}
                    return null;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        states.addAll(newStates);
        states.forEach(state -> {
            try{
                this.repo.logProgStateExec(state);
                System.out.println(state);
            }
            catch (MyException ignored) {}
        });
        this.repo.setPrgList(states);
    }


    private void garbageCollector(ProgramState current) {
//        ProgramState current = this.repo.getCurrentProgram();
        List<Integer> add = getAddrFromSymTable(current.getSymTable().values());
        List<Integer> add2 = getAddrFromHeap(current.getHeap().values());
        add.addAll(add2);
        current.getHeap().setContent(unsafeGarbageCollector(add,current.getHeap().getContent()));
    }

    public MyIHeap<Integer, Value> getHeap(){ return this.repo.getPrgList().get(0).getHeap(); }

    private Map<Integer, Value> unsafeGarbageCollector(List<Integer> symTableAddr, Map<Integer,Value> heap){
        return heap.entrySet().stream()
                .filter(e->symTableAddr.contains(e.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
    private List<Integer> getAddrFromSymTable(Collection<Value> symTableValues){
        return symTableValues.stream()
                .filter(v-> v instanceof RefValue)
                .map(v-> {RefValue v1 = (RefValue) v; return v1.getAddress();})
                .collect(Collectors.toList());
    }
    private List<Integer> getAddrFromHeap(Collection<Value> heapValues){
        /* For the case when an address from the heap will reference to another reference
        1->(22,int) YES
        2-> 3  NO
        3->(33,string) YES
        ......
         */
        return heapValues.stream().
                filter(v->v instanceof RefValue)
                .map(v->((RefValue)v).getAddress())
                .collect(Collectors.toList());
    }

    public MyIList<Value> getOutTable(){
        MyIList<Value> outTable = new MyList<>();
        outTable = this.repo.getPrgList().get(0).getOut();
        return outTable;
    }
    public Integer getNumberOfProgramStates(){
        Integer nr = 0;
        nr = this.repo.noOfPrgStates();
        return nr;
    }
    public MyIDictionary<StringValue, BufferedReader> getFileTable () {return this.repo.getPrgList().get(0).getFileTable(); }


    public List<ProgramState> getIncompletePrograms(List<ProgramState> states){
        return states.stream()
                .filter(ProgramState::isNotCompleted)
                .collect(Collectors.toList());
    }
    public ProgramState getProgramWithID(Integer id){
        if(id==null)
            return null;
        for(ProgramState pro: repo.getPrgList())
            if(pro.getThreadId() == id.intValue())
                return pro;
        return null;
    }
    public void oneStepGUI() throws InterruptedException {
        executor = Executors.newFixedThreadPool(5);
        getIncompletePrograms(repo.getPrgList());
        List<ProgramState> programs = repo.getPrgList();

        if(programs.size()>0){
            garbageCollector(this.repo.getCurrentProgram());
            oneStepForAllPrograms(programs);
            getIncompletePrograms(repo.getPrgList());
            executor.shutdownNow();
        }
    }

}
