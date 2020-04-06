package Model.Statements.Heap;

import Model.ADT.MyIDictionary;
import Model.ADT.MyIHeap;
import Model.DataTypes.RefType;
import Model.DataTypes.Type;
import Model.Exceptions.MyException;
import Model.Expressions.Expression;
import Model.ProgramState;
import Model.Statements.IStatement;
import Model.Values.RefValue;
import Model.Values.Value;

public class HeapWritingStatement implements IStatement {
    private String var_name;
    private Expression exp;

    public HeapWritingStatement(String _vn, Expression _exp) { this.var_name = _vn; this.exp = _exp; }

    @Override
    public String toString() {
        return "WriteHeap(" + this.var_name + ", " + this.exp.toString() + ")";
    }

    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        MyIDictionary<String, Value> symTable = state.getSymTable();
        MyIHeap<Integer, Value> heap = state.getHeap();

        if(symTable.isDefined(this.var_name)){
            Value varValue = symTable.getValue(this.var_name);
            if(varValue.getType() instanceof RefType){
                int address = ((RefValue)varValue).getAddress();
                if (heap.isDefined(address)){
                    Value expValue = this.exp.eval(symTable, heap);
                    if (expValue.getType().equals(((RefValue)varValue).getLocationType())){
                        heap.update(address, expValue);
                    } else{
                        throw new MyException("Invalid type!");
                    }
                } else {
                    throw new MyException("Address not defined! ");
                }
            } else {
                throw new MyException("Invalid type! Expected RefType!");
            }
        } else {
            throw new MyException("Variable name is not defined in the symTable!");
        }
//        r1eturn state;
        return null;
    }

    @Override
    public MyIDictionary<String, Type> typecheck(MyIDictionary<String, Type> typeEnv) throws MyException {
        Type typeVar = typeEnv.getValue(this.var_name);
        Type typeExp = this.exp.typecheck(typeEnv);

        if(!typeVar.equals(new RefType(typeExp)))
            throw new MyException("Right hand side and left hand side have different types! ");
        return typeEnv;
    }
}
