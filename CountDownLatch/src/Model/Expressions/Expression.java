package Model.Expressions;

import Model.ADT.MyIDictionary;
import Model.ADT.MyIHeap;
import Model.DataTypes.Type;
import Model.Exceptions.MyException;
import Model.Values.Value;

public interface Expression {
    Value eval(MyIDictionary<String, Value> symTable, MyIHeap<Integer, Value> heap) throws MyException;

    Type typecheck(MyIDictionary<String, Type> typeEnv) throws MyException;
}
