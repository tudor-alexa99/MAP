package Model.Statements;

import Model.ADT.MyDictionary;
import Model.ADT.MyIDictionary;
import Model.ADT.MyStack;
import Model.DataTypes.Type;
import Model.Exceptions.MyException;
import Model.ProgramState;
import Model.Values.Value;

import java.util.Map;

public class Fork implements IStatement {
    private IStatement stm;

    public  Fork(IStatement _stm) {
        this.stm = _stm;
    }

    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        MyIDictionary<String, Value> forkSymTable = new MyDictionary<>();
        for (Map.Entry<String, Value> entry : state.getSymTable().getContent().entrySet())
            forkSymTable.update(entry.getKey(), entry.getValue());

        ProgramState forkProgState = new ProgramState(
                new MyStack<>(),
                forkSymTable,
                state.getOut(),
                state.getFileTable(),
                this.stm,
                state.getHeap(),
                state.getLatchTable()
        );

        forkProgState.setNewId();
        return forkProgState;
    }

    @Override
    public String toString(){
        return "Fork( " + this.stm.toString() + ")";
    }

    @Override
    public MyIDictionary<String, Type> typecheck(MyIDictionary<String, Type> typeEnv) throws MyException {
        this.stm.typecheck(typeEnv);
        return typeEnv;
    }
}
