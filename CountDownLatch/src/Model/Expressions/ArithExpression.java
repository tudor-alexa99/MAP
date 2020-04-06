package Model.Expressions;

import Model.ADT.MyIDictionary;
import Model.ADT.MyIHeap;
import Model.DataTypes.IntType;
import Model.DataTypes.Type;
import Model.Exceptions.MyException;
import Model.Values.IntValue;
import Model.Values.Value;

public class ArithExpression implements Expression {
    private Expression e1;
    private Expression e2;
    private char op;

    public ArithExpression(Expression _e1, Expression _e2, char _op){
        this.e1 = _e1;
        this.e2 = _e2;
        this.op = _op;
    }

    @Override
    public Value eval(MyIDictionary<String, Value> symTable, MyIHeap<Integer, Value> heap) throws MyException {
        Value v1, v2;

        v1 = e1.eval(symTable, heap);
        if(v1.getType().equals(new IntType())){
            v2 = e2.eval(symTable, heap);
            if(v2.getType().equals(new IntType())){
                IntValue i1 = (IntValue)v1;
                IntValue i2 = (IntValue)v2;
                int n1, n2;
                n1 = i1.getVal();
                n2 = i2.getVal();
                if(this.op == '+') return new IntValue(n1 + n2 );
                if(this.op == '-') return new IntValue(n1 - n2);
                if(this.op == '*') return new IntValue(n1 * n2 );
                if(this.op == '/' && n2 != 0) return new IntValue(n1 / n2);
                else
                    throw new MyException("Division by 0");
            }
            else
                throw new MyException("Second operand is not an integer!");
        }
        else throw new MyException("First operand is not an integer!");
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

        if (tp1.equals(new IntType())){
            if (tp2.equals(new IntType()))
                return new IntType();
            else
                throw new MyException("Second operand not an integer!");
        }
        else{
            throw new MyException("First operand not an integer! ");
        }
    }
}
