package Model.Expressions;

import Model.Exceptions.MyException;

public class Comparator{
    int v1;
    int v2;
    String op;

    public Comparator(int _v1, String _op, int _v2) {
        this.v1 = _v1;
        this.v2 = _v2;
        this.op = _op;
    }

    boolean compare() throws MyException {
        switch (this.op) {
            case "<":       return v1 < v2;
            case "<=":      return v1 <= v2;
            case "==":      return v1 == v2;
            case ">":       return v1 > v2;
            case ">=":      return v1 >= v2;
            case "!=":      return v1 != v2;
            default:        throw new MyException("Operator not available! ");
        }
    }
}