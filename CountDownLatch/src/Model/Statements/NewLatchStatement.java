package Model.Statements;

import Model.ADT.MyIDictionary;
import Model.DataTypes.Type;
import Model.Exceptions.MyException;
import Model.Expressions.Expression;
import Model.ProgramState;
import Model.Values.IntValue;
import Model.Values.Value;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NewLatchStatement implements IStatement {
    private String var;
    private Expression exp;
    private Lock mutex = new ReentrantLock();

    public NewLatchStatement(String _var, Expression _exp){
        this.var = _var;
        this.exp = _exp;
    }

    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        mutex.lock();

        MyIDictionary<String, Value> symTable = state.getSymTable();
        Value v = this.exp.eval(symTable, state.getHeap());
        Integer number = ((IntValue)v).getVal();

        Integer currentLocation = state.getLatchTable().getFreeLocation();
        state.getLatchTable().put(currentLocation, number);
        symTable.update(this.var,new IntValue(currentLocation));

        mutex.unlock();
        return null;
    }

    @Override
    public MyIDictionary<String, Type> typecheck(MyIDictionary<String, Type> typeEnv) throws MyException {
        return typeEnv;
    }

    @Override
    public String toString() {
        return "NewLatchStatement(" +
                exp +
                ')';
    }
}
