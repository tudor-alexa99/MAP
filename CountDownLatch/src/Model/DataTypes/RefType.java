package Model.DataTypes;

import Model.Values.RefValue;
import Model.Values.Value;

public class RefType implements Type {
    private Type inner;

    public RefType() { super();}
    public RefType(Type _inn) { this.inner = _inn; }
    public Type getInner() { return this.inner; }

    @Override
    public boolean equals(Object another){
        if (another instanceof RefType)
            return inner.equals(((RefType) another).getInner());
        else
            return false;
    }
    @Override
    public String toString() { return "Ref(" + inner.toString()+")"; }
    @Override
    public Value defaultValue() {
        return new RefValue(0, inner);
    }
}
