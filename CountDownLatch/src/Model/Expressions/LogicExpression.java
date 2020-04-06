package Model.Expressions;

import Model.ADT.MyIDictionary;
import Model.ADT.MyIHeap;
import Model.DataTypes.BoolType;
import Model.DataTypes.Type;
import Model.Exceptions.MyException;
import Model.Values.BoolValue;
import Model.Values.Value;

public class LogicExpression implements Expression {
    private Expression e1;
    private Expression e2;
    private char op;

    public LogicExpression(Expression _e1, Expression _e2, char _op) {
        this.e1 = _e1;
        this.e2 = _e2;
        this.op = _op;
    }

    @Override
    public Value eval(MyIDictionary<String, Value> symTable, MyIHeap<Integer, Value> heap) throws MyException {
        Value b1, b2;

        b1 = this.e1.eval(symTable, heap);
        if (b1.getType().equals(new BoolType())) {
            b2 = this.e2.eval(symTable, heap);
            if (b2.getType().equals(new BoolType())) {
                BoolValue _b1 = (BoolValue) b1;
                BoolValue _b2 = (BoolValue) b2;
                boolean n1, n2;
                n1 = _b1.getVal();
                n2 = _b2.getVal();
                if (this.op == '&') return new BoolValue(n1 && n2);
                if (this.op == '|') return new BoolValue(n1 || n2);
                else
                    throw new MyException("Invalid operand!");
            }
            else throw new MyException("Second operand not a boolean");
        }
        else throw new MyException("First operand not a boolean");
        //return b1;
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

        if(tp1.equals(new BoolType())){
            if(tp2.equals(new BoolType()))
                return new BoolType();
            else
                throw new MyException("Second operator not a boolean!");
        }
        else
            throw new MyException("First operand not a boolean!");
    }
}
