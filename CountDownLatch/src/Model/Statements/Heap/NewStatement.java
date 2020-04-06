package Model.Statements.Heap;

import Model.ADT.MyIDictionary;
import Model.ADT.MyIHeap;
import Model.ADT.MyIStack;
import Model.DataTypes.RefType;
import Model.DataTypes.Type;
import Model.Exceptions.MyException;
import Model.Expressions.Expression;
import Model.ProgramState;
import Model.Statements.IStatement;
import Model.Values.RefValue;
import Model.Values.Value;

public class NewStatement implements IStatement {
    private String varName;
    private Expression expr;

    public NewStatement(String _vn, Expression _exp) {this.varName = _vn; this.expr = _exp; }

    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        MyIDictionary<String, Value> symTable = state.getSymTable();
        MyIHeap<Integer, Value> heap = state.getHeap();

        if (symTable.isDefined(this.varName)) {
            Value varNameValue = symTable.getValue(this.varName);

            if (varNameValue.getType() instanceof RefType) {
                Value exprVal = this.expr.eval(symTable, heap);

                if (exprVal.getType().equals(((RefValue) varNameValue).getLocationType())) {
                    int pos = heap.add(exprVal);
                    symTable.update(this.varName, new RefValue(pos, ((RefValue) varNameValue).getLocationType()));
//                    symTable.update(this.varName, new RefValue(((RefValue) varNameValue).getLocationType(), pos));

                } else {
                    throw new MyException("Types not compatible " + exprVal.getType() + " vs " + ((RefValue) varNameValue).getLocationType());
                }
            } else {
                throw new MyException("Variable " + this.varName +  " not of RefType.");
            }
        } else {
            throw new MyException("Variable " + this.varName +  " not declared.");
        }
//        return state;
        return null;
    }

    @Override
    public String toString() {
        return "New (" + this.varName+ ":" + this.expr.toString() + ")";
    }

    @Override
    public MyIDictionary<String, Type> typecheck(MyIDictionary<String, Type> typeEnv) throws MyException {
        Type typeVar = typeEnv.getValue(this.varName);
        Type typeExp = this.expr.typecheck(typeEnv);

        if(typeVar.equals(new RefType(typeExp)))
            return typeEnv;
        else
            throw new MyException("NEW Statement error: rhs and lhs have different types!");
    }
}

