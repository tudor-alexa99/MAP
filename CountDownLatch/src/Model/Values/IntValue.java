package Model.Values;

import Model.DataTypes.IntType;
import Model.DataTypes.Type;

public class IntValue implements Value{
    private int val;

    public IntValue(int v) { this.val = v; }

    public int getVal(){ return val; }
    public String toString(){
        return Integer.toString(val);
    }

    @Override
    public Type getType() {
        return new IntType();
    }
}
