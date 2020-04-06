package Model.Expressions;

import Model.ADT.MyIDictionary;
import Model.ADT.MyIHeap;
import Model.DataTypes.BoolType;
import Model.DataTypes.IntType;
import Model.DataTypes.Type;
import Model.Exceptions.MyException;
import Model.Values.BoolValue;
import Model.Values.IntValue;
import Model.Values.Value;

import java.util.HashMap;
import java.util.Map;

public class RelationalExpression implements Expression{
    private Expression e1;
    private Expression e2;
    private String op;
//    private Map<String, Operation> operationMap = new HashMap<>();

    public RelationalExpression(Expression _e1, Expression _e2, String _op) {
        this.e1 = _e1;
        this.e2 = _e2;
        this.op = _op;
    }

    @Override
    public Value eval(MyIDictionary<String, Value> symTable, MyIHeap<Integer, Value> heap) throws MyException {
        Value v1, v2;
        v1 = this.e1.eval(symTable, heap);
        v2 = this.e2.eval(symTable, heap);

        if (!(v1.getType() instanceof IntType))
            throw new MyException("The first operand is not an Int Type! ");

        else if (!(v2.getType() instanceof IntType))
            throw new MyException("The second operand is not an Int Type! ");

        try {
            int i1 = ((IntValue)v1).getVal();
            int i2 = ((IntValue)v2).getVal();
            Comparator comp = new Comparator(i1, this.op, i2);
            return new BoolValue(comp.compare());
        }
        catch (MyException e){
            //rethrows any exception found in the Compare function
            throw new MyException(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return this.e1.toString() + this.op + this.e2.toString();
    }

    @Override
    public Type typecheck(MyIDictionary<String, Type> typeEnv) throws MyException {
        Type tp1;
        Type tp2;

        tp1 = this.e1.typecheck(typeEnv);
        tp2 = this.e2.typecheck(typeEnv);

        if(tp1.equals(new IntType())){
            if(tp2.equals(new IntType()))
                return new BoolType();
            else
                throw new MyException("Second operand not an integer!");
        }
        else
            throw new MyException("First operand not an integer!");
    }
}
