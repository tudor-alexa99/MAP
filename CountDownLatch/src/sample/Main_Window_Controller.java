package sample;

import Controller.Controller_;
import Model.ADT.*;
import Model.ProgramState;
import Model.Statements.IStatement;
import Model.Values.StringValue;
import Model.Values.Value;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.SnapshotResult;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.lang.management.BufferPoolMXBean;
import java.nio.Buffer;
import java.util.*;
import java.util.stream.Collectors;

public class Main_Window_Controller {
    private Integer currentThreadId = -1;
    private Controller_ controller;
    private Stage self = null;

    @FXML
    private TextField no_of_prg_state_textField;

    //LatchTable
    @FXML private TableView<Map.Entry<Integer, Integer>> LatchTable;

    @FXML private TableColumn<Map.Entry<Integer, Integer>, Integer> latch_name;

    @FXML private TableColumn<Map.Entry<Integer, Integer>, Integer> latch_value;


    //Heap table:
    @FXML
    private TableView<Map.Entry<Integer, String>> heapTable;

    @FXML
    private TableColumn<Map.Entry<Integer, String>, Integer> addressColumn;

    @FXML
    private TableColumn<Map.Entry<Integer, String>, String> heapValueColumn;
    ////////////

    //Sym Table:
    @FXML
    private TableView<Map.Entry<String, String>> symTable;

    @FXML
    private TableColumn<Map.Entry<String, String>, String> variableNameColumn;

    @FXML
    private TableColumn<Map.Entry<String, String>, String> symValueColumn;
    /////////////
    @FXML
    private ListView<String> fileTable;

    @FXML
    private ListView<String> outTable;

    @FXML
    private ListView<String> exeStack;

    @FXML
    private Button one_step_for_all_button;

    @FXML
    private ListView<?> program_states_list_view;

    @FXML
    private ListView<Integer> threads_list_view;

    @FXML
    public void oneStepButtonClicked(MouseEvent event){
        try{
            if(this.currentThreadId == -1)
                currentThreadId = controller.getListOfThreadIds().get(0);
            if(!controller.getListOfThreadIds().contains(currentThreadId))
                currentThreadId=controller.getListOfThreadIds().get(0);

            controller.oneStepGUI();

            no_of_prg_state_textField.clear();
            no_of_prg_state_textField.setText(controller.getNumberOfProgramStates().toString());
            populateAll();

            if(controller.getNumberOfProgramStates() == 0 || controller.getProgramWithID(currentThreadId).getExeStack().isEmpty()){
                Alert  endOfExecution = new Alert(Alert.AlertType.INFORMATION);
                endOfExecution.setResizable(true);
                endOfExecution.setHeaderText("End of Program Exectuion!");
                endOfExecution.setContentText("Window Will Close Now!");
                endOfExecution.showAndWait();
                //self.close();
            }
            if(!controller.getListOfThreadIds().contains(currentThreadId))
                currentThreadId=controller.getListOfThreadIds().get(0);
        }
        catch (Exception e){
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("Something went wrong!");
            error.setContentText(e.getMessage());
            error.showAndWait();
        }
    }

    @FXML
    public void initialize(){

        no_of_prg_state_textField.setEditable(false);
        addressColumn.setCellValueFactory(p->new SimpleIntegerProperty(p.getValue().getKey()).asObject());
        heapValueColumn.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getValue() + ""));

        latch_name.setCellValueFactory(p->new SimpleObjectProperty<>(p.getValue().getKey()));
        latch_value.setCellValueFactory(p->new SimpleObjectProperty<>(p.getValue().getValue()));
        variableNameColumn.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getKey() + ""));
        symValueColumn.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getValue() + ""));
    }

    public void setCurrentStage(Stage _stage) { this.self = _stage; }

    public void setProgramController(Controller_ ctrl){
        this.controller = ctrl;
        this.no_of_prg_state_textField.setText(Integer.toString(controller.getNumberOfProgramStates()));
    }

    public void populateOutList(){
        //out table = listView<String>
//        System.out.println("Waddup");
        List<String> outStr = this.controller.getOutTable().getAll().stream().map(Objects::toString).collect(Collectors.toList());
        ObservableList<String> outList = FXCollections.observableArrayList(outStr);
        this.outTable.setItems(outList);
    }

    //you need populate functions for everything

    public void populateAll(){
        this.currentThreadId = this.threads_list_view.getSelectionModel().getSelectedItem();
        this.no_of_prg_state_textField.setText(this.controller.getNumberOfProgramStates().toString());

        if(currentThreadId == null)
            currentThreadId = 0;

        this.populateThreadId();
        this.populateHeapTable();
        this.populateSymTable(controller.getProgramWithID(this.currentThreadId));
        this.populateExeStack(controller.getProgramWithID(this.currentThreadId));
        this.populateOutList();
        this.populateFileTable(controller.getProgramWithID(this.currentThreadId));
        this.populateLatchTable(controller.getProgramWithID(this.currentThreadId));
        if(controller.getProgramWithID(currentThreadId).getExeStack().isEmpty())
            this.one_step_for_all_button.setDisable(true);
        else
            this.one_step_for_all_button.setDisable(false);
    }

    public void populateThreadId(){
        ObservableList<Integer> threadsList = FXCollections.observableArrayList();
        threads_list_view.refresh();
        threadsList.addAll(this.controller.getListOfThreadIds());
        this.threads_list_view.setItems(threadsList);
    }

    public void populateLatchTable(ProgramState prgState){
        ILatchTable latchTable = prgState.getLatchTable();
        Map<Integer,Integer> heap = new HashMap<>();

        for(Integer k:latchTable.getContent().keySet())
            heap.put(k,latchTable.getContent().get(k));

        Map<Integer,Integer> heapMap = new HashMap<>();
        for(Map.Entry<Integer,Integer> entry : heap.entrySet())
            heapMap.put(entry.getKey(),entry.getValue());

        List<Map.Entry<Integer,Integer>> heapTableList = new ArrayList<>(heapMap.entrySet());
        this.LatchTable.setItems(FXCollections.observableList(heapTableList));
        this.LatchTable.refresh();

    }

    public void populateExeStack(ProgramState prgState){
        MyIStack<IStatement> exeStack = prgState.getExeStack();
        List<String> statements = new ArrayList<>();
        for(IStatement statement : exeStack.getElems())
            statements.add(statement.toString());
        this.exeStack.setItems(FXCollections.observableList(statements));
    }

    public void populateFileTable(ProgramState prgState){
        Collection<BufferedReader> fileTableValues = prgState.getFileTable().values();
        List<String> files = new ArrayList<>();
        for(BufferedReader val : fileTableValues)
            files.add(val.toString());
        this.fileTable.setItems(FXCollections.observableList(files));
//

    }

    public void populateSymTable(ProgramState prgState){
        MyIDictionary<String,Value> symbol_table = prgState.getSymTable();
        Map<String,String> symbolTable= new HashMap<>();

        for(String key:symbol_table.keySet())
            symbolTable.put(key,symbol_table.getValue(key).toString());

        Map<String,String> symbolMap = new HashMap<>();
        for(Map.Entry<String,String> entry: symbolTable.entrySet())
            symbolMap.put(entry.getKey(),entry.getValue());


        List<Map.Entry<String,String>> symbolList = new ArrayList<>(symbolMap.entrySet());
        this.symTable.setItems(FXCollections.observableList(symbolList));
        this.symTable.refresh();
    }

    private void populateHeapTable(){
        MyIHeap<Integer, Value> originalHeap = controller.getHeap();
        Map<Integer,String> heap = new HashMap<>();

        for(Integer k:originalHeap.getContent().keySet())
            heap.put(k,originalHeap.getContent().get(k).toString());

        Map<Integer,String> heapMap = new HashMap<>();
        for(Map.Entry<Integer,String> entry : heap.entrySet())
            heapMap.put(entry.getKey(),entry.getValue());

        List<Map.Entry<Integer,String>> heapTableList = new ArrayList<>(heapMap.entrySet());
        this.heapTable.setItems(FXCollections.observableList(heapTableList));
        this.heapTable.refresh();

    }

}
