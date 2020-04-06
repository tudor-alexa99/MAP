package Model.Values;

import Model.DataTypes.RefType;
import Model.DataTypes.Type;

public class RefValue implements Value {
    private int address;
    private Type locationType;

    public RefValue(int _address, Type _lt) { this.address = _address; this.locationType = _lt; }

    public int getAddress() {return this.address; }

    public Type getLocationType() { return this.locationType; }
    @Override
    public Type getType() { return new RefType(locationType); }

    @Override
    public boolean equals(Object obj){
        if( obj instanceof RefValue)
            return this.locationType == ((RefValue) obj).locationType;
        else
            return false;
    }
    @Override
    public String toString(){
        return "(" + this.address + ": " + this.locationType + ")";
    }
}
