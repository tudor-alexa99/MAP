package Model.Statements;

import Model.ADT.MyIDictionary;
import Model.DataTypes.Type;
import Model.Exceptions.MyException;
import Model.ProgramState;

public class NopStatement implements IStatement {

    @Override
    public ProgramState execute(ProgramState state) throws MyException {
//        return state;
        return null;
    }

    @Override
    public MyIDictionary<String, Type> typecheck(MyIDictionary<String, Type> typeEnv) throws MyException {
        return typeEnv;
    }
    @Override
    public String toString(){return "Nop statement() ";}
}
