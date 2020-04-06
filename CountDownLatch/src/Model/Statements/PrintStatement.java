package Model.Statements;

import Model.ADT.MyIDictionary;
import Model.ADT.MyIHeap;
import Model.ADT.MyIList;
import Model.DataTypes.Type;
import Model.Exceptions.MyException;
import Model.Expressions.Expression;
import Model.ProgramState;
import Model.Values.Value;

public class PrintStatement implements IStatement {
    private Expression exp;

    public PrintStatement(Expression e) { this.exp = e; }

    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        MyIList<Value> out = state.getOut();
        MyIDictionary<String, Value> symTable = state.getSymTable();
        MyIHeap<Integer, Value> heap = state.getHeap();

        out.add(this.exp.eval(symTable, heap));
//        return state;
        return null;
    }
    @Override
    public String toString() {
        return "print(" + exp.toString() + ")";
    }

    @Override
    public MyIDictionary<String, Type> typecheck(MyIDictionary<String, Type> typeEnv) throws MyException {
        this.exp.typecheck(typeEnv);
        return typeEnv;
    }
}
