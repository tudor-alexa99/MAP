package Model.Statements;

import Model.ADT.MyIDictionary;
import Model.ADT.MyIStack;
import Model.DataTypes.Type;
import Model.Exceptions.MyException;
import Model.Expressions.Expression;
import Model.Expressions.NotExpression;
import Model.ProgramState;
import Model.Values.Value;

public class RepeatUntilStatement implements IStatement {
    Expression condition;
    IStatement stm;


    public RepeatUntilStatement(Expression _e, IStatement _s) {this.condition = _e; this.stm = _s;}

    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        MyIDictionary<String, Value> symTable = state.getSymTable();

        IStatement repeatUntil =new CompStatement(this.stm,
                new WhileStatement(new NotExpression(this.condition), this.stm));
        MyIStack<IStatement> exeStack = state.getExeStack();

        exeStack.push(repeatUntil);
        return null;
    }

    @Override
    public MyIDictionary<String, Type> typecheck(MyIDictionary<String, Type> typeEnv) throws MyException {
        return typeEnv;
    }

    @Override
    public String toString(){
        return "Repeat ( " + this.stm.toString() + ") until (" + this.condition.toString() + ") ";
    }
}
