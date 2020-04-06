package Model.Statements;

import Model.ADT.MyIDictionary;
import Model.DataTypes.Type;
import Model.Exceptions.MyException;
import Model.ProgramState;
import Model.Values.IntValue;

public class CountDownStatement implements IStatement {
    private String var;

    public CountDownStatement(String _var) {
        this.var = _var;
    }

    @Override
    public String toString() {
        return "countDown(" + this.var + ")";
    }

    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        if(!state.getSymTable().isDefined(this.var))
            throw new MyException("Var not defined ");
        Integer foundIndex = ((IntValue) state.getSymTable().getValue(this.var)).getVal();
//        if(!state.getLatchTable().isDefined(foundIndex))
            //throw new MyException("Var not defined in the LatchTable!");

        if(state.getLatchTable().isDefined(foundIndex) && state.getLatchTable().getValue(foundIndex) > 0) {
            state.getLatchTable().put(foundIndex, state.getLatchTable().getValue(foundIndex) - 1);
            state.getOut().add(new IntValue(state.getThreadId()));
        }
        return null;
    }

    @Override
    public MyIDictionary<String, Type> typecheck(MyIDictionary<String, Type> typeEnv) throws MyException {
        return null;
    }
}
