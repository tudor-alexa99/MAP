package Model.Expressions;

import Model.ADT.MyIDictionary;
import Model.ADT.MyIHeap;
import Model.DataTypes.BoolType;
import Model.DataTypes.Type;
import Model.Exceptions.MyException;
import Model.Values.BoolValue;
import Model.Values.Value;

public class NotExpression implements Expression{
    private Expression exp;

    public NotExpression(Expression _e) {this.exp = _e;}

    @Override
    public Value eval(MyIDictionary<String, Value> symTable, MyIHeap<Integer, Value> heap) throws MyException {
        BoolValue value = (BoolValue) this.exp.eval(symTable,heap);
        boolean b = value.getVal();
        return new BoolValue(! b);
    }

    @Override
    public Type typecheck(MyIDictionary<String, Type> typeEnv) throws MyException {
        Type t =  this.exp.typecheck(typeEnv);
        if(t.equals(new BoolType()))
            throw new MyException("Incompatible data types!");
        return new BoolType();
    }

    @Override
    public String toString() {return "not (" + this.exp.toString()+")";}
}
