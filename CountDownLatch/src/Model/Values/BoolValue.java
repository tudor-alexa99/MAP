package Model.Values;

import Model.DataTypes.BoolType;
import Model.DataTypes.Type;

public class BoolValue implements Value{
    private boolean val;

    public BoolValue(boolean v) {
        this.val = v;
    }
    public boolean getVal() { return this.val; }
    @Override
    public String toString() {
        return Boolean.toString(this.val);
    }

    @Override
    public Type getType() {
        return new BoolType();
    }
}
