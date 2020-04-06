package Model.Expressions;

import Model.ADT.MyIDictionary;
import Model.ADT.MyIHeap;
import Model.DataTypes.Type;
import Model.Exceptions.MyException;
import Model.Values.Value;

public class ValueExpression implements Expression {
    private Value e;

    public ValueExpression(Value value) {
        this.e = value;
    }

    @Override
    public String toString() {
        return this.e.toString();
    }

    @Override
    public Value eval(MyIDictionary<String, Value> table, MyIHeap<Integer, Value> heap) throws MyException {
        return this.e;
    }

    @Override
    public Type typecheck(MyIDictionary<String, Type> typeEnv) throws MyException {
        return this.e.getType();
    }
}
