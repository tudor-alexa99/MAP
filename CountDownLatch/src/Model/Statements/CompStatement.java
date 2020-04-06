package Model.Statements;

import Model.ADT.MyIDictionary;
import Model.ADT.MyIStack;
import Model.DataTypes.Type;
import Model.Exceptions.MyException;
import Model.ProgramState;

public class CompStatement implements IStatement {
    IStatement first;
    IStatement second;

    public CompStatement(IStatement s1, IStatement s2){
        this.first = s1;
        this.second = s2;
    }

    public String toString() {
        return first.toString() + "; " + second.toString() + " ";
    }

    @Override
    public ProgramState execute(ProgramState state) throws MyException{
        MyIStack<IStatement> stk = state.getExeStack();
        stk.push(second);
        stk.push(first);
//        return state;
        return null;
    }

    @Override
    public MyIDictionary<String, Type> typecheck(MyIDictionary<String, Type> typeEnv) throws MyException {
        return this.second.typecheck(this.first.typecheck(typeEnv));
    }
}
