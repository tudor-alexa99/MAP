package Model.Expressions;

import Model.ADT.MyIDictionary;
import Model.ADT.MyIHeap;
import Model.DataTypes.RefType;
import Model.DataTypes.Type;
import Model.Exceptions.MyException;
import Model.Values.RefValue;
import Model.Values.Value;

public class ReadHeapExpression implements Expression {
    private Expression exp;

    public ReadHeapExpression(Expression _exp) { this.exp = _exp; }

    @Override
    public String toString() {return "Rh(" + this.exp.toString() + ")";}

    @Override
    public Value eval(MyIDictionary<String, Value> symTable, MyIHeap<Integer, Value> heap) throws MyException {
        Value evalExp = this.exp.eval(symTable, heap);
        if(evalExp.getType() instanceof RefType){
            int address = ((RefValue) evalExp).getAddress();
            if(heap.isDefined(address)) {
                return heap.getValue(address);
            } else {
                throw new MyException(address + "address is not defined in the heap!");
            }
        } else {
            throw new MyException("Expected expression of the type Ref, got " + evalExp.getType().toString() + "instead");
            }

    }

    @Override
    public Type typecheck(MyIDictionary<String, Type> typeEnv) throws MyException {
        Type typ = this.exp.typecheck(typeEnv);

        if(typ instanceof RefType){
            RefType refT = (RefType) typ;
            return refT.getInner();
        }
        else
            throw new MyException("The rH argument is not a Ref Type!");
    }
}


