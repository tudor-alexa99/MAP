package Model.Statements;

import Model.ADT.MyIDictionary;
import Model.ADT.MyIHeap;
import Model.ADT.MyIStack;
import Model.ADT.MyStack;
import Model.DataTypes.BoolType;
import Model.DataTypes.Type;
import Model.Exceptions.MyException;
import Model.Expressions.Expression;
import Model.ProgramState;
import Model.Values.BoolValue;
import Model.Values.Value;

import java.util.concurrent.ExecutionException;

public class WhileStatement implements IStatement {
    private Expression expr;
    private IStatement statement;

    public WhileStatement(Expression expr, IStatement stat) {
        this.expr = expr;
        this.statement = stat;
    }

    @Override
    public String toString() {
        return "while (" + this.expr.toString() + ") " + this.statement.toString();
    }

    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        MyIStack<IStatement> stack = state.getExeStack();
        Value evalExpr = this.expr.eval(state.getSymTable(), state.getHeap());
        if (evalExpr.getType() instanceof BoolType) {
            boolean condition = ((BoolValue) evalExpr).getVal();
            if (condition) {
                stack.push(this);
                stack.push(this.statement);
            }
        } else {
            throw new MyException("Expected expression of type bool, got " + evalExpr.getType());
        }
        return null;
//        return state;
    }

    @Override
    public MyIDictionary<String, Type> typecheck(MyIDictionary<String, Type> typeEnv) throws MyException {
        Type typeExp = this.expr.typecheck(typeEnv);
        if(! typeExp.equals(new BoolType()))
            throw new MyException("While condition is not of bool type!");

        this.statement.typecheck(typeEnv);
        return typeEnv;
    }
}
