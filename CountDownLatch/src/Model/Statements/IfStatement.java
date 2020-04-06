package Model.Statements;

import Model.ADT.MyIDictionary;
import Model.ADT.MyIHeap;
import Model.ADT.MyIStack;
import Model.DataTypes.BoolType;
import Model.DataTypes.Type;
import Model.Exceptions.MyException;
import Model.Expressions.Expression;
import Model.ProgramState;
import Model.Values.BoolValue;
import Model.Values.Value;

public class IfStatement implements IStatement {
    private Expression exp;
    private IStatement thenS;
    private IStatement elseS;

    public IfStatement(Expression exp, IStatement thenS, IStatement elseS) {
        this.exp = exp;
        this.thenS = thenS;
        this.elseS = elseS;
    }

    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        MyIStack<IStatement> stack = state.getExeStack();
        MyIDictionary<String, Value> table = state.getSymTable();
        MyIHeap<Integer, Value> heap = state.getHeap();

        Value condition = this.exp.eval(table, heap);
        if (condition.getType().equals(new BoolType())) {
            if (((BoolValue) condition).getVal())
                stack.push(this.thenS);
            else
                stack.push(this.elseS);
        } else {
            throw new MyException("Condition not a...condition, boolean expected");
        }
//        return state;
        return null;
    }

    @Override
    public String toString() {
        return "if (" + this.exp.toString() +
                ") then (" + this.thenS.toString() +
                ") else (" + this.elseS.toString() +
                ")";
    }

    @Override
    public MyIDictionary<String, Type> typecheck(MyIDictionary<String, Type> typeEnv) throws MyException {
        Type typeExp = this.exp.typecheck(typeEnv);
        if(!typeExp.equals(new BoolType()))
            throw new MyException("IF-condition is not of BoolType! ");
        this.thenS.typecheck(typeEnv);
        this.elseS.typecheck(typeEnv);
        return typeEnv;
    }
}
