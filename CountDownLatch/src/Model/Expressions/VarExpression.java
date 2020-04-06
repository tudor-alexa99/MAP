package Model.Expressions;

import Model.ADT.MyIDictionary;
import Model.ADT.MyIHeap;
import Model.DataTypes.Type;
import Model.Exceptions.MyException;
import Model.Values.Value;

public class VarExpression implements Expression {
    String id;

    public VarExpression(String _id){
        this.id = _id;
    }

    @Override
    public Value eval(MyIDictionary<String, Value> symTable, MyIHeap<Integer, Value> heap) throws MyException {
         return symTable.getValue(this.id);
    }
    @Override
    public String toString() {
        return this.id;
    }

    @Override
    public Type typecheck(MyIDictionary<String, Type> typeEnv) throws MyException {
        if(! typeEnv.isDefined(this.id))
            throw new MyException("Variable " + this.id + " is not defined! ");
        return typeEnv.getValue(this.id);
    }
}
