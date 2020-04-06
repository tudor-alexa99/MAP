package Model.Statements;

import Model.ADT.MyIDictionary;
import Model.DataTypes.IntType;
import Model.DataTypes.Type;
import Model.Exceptions.MyException;
import Model.ProgramState;
import Model.Values.IntValue;

public class AwaitStatement implements IStatement {
    private String var;

    public AwaitStatement(String _var) {
        this.var = _var;
    }

    @Override
    public String toString() {
        return "await(" + this.var + ")";
    }

    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        if ( !state.getSymTable().isDefined(this.var)){
            throw new MyException("Var not in SymTable! ");
        }
        Integer index = ((IntValue)state.getSymTable().getValue(this.var)).getVal();
        if (! state.getLatchTable().isDefined(index))
            throw new MyException("Index not defined in LatchTable!");
        else if (state.getLatchTable().getValue(index) != 0){
            state.getExeStack().push(this);
        }
        return null;
    }

    @Override
    public MyIDictionary<String, Type> typecheck(MyIDictionary<String, Type> typeEnv) throws MyException {
        if(! typeEnv.isDefined(this.var))
            throw new MyException("Variable " + this.var + " is not defined! ");
        Type t = typeEnv.getValue(this.var);
        if(! t.equals(new IntType()))
            throw new MyException("Incompatible types!");
        return typeEnv;
    }
}
