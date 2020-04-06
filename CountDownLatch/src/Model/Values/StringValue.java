package Model.Values;

import Model.DataTypes.StringType;
import Model.DataTypes.Type;

public class StringValue implements Value{
    private String val;

    public StringValue(String _val) {
        this.val = _val;
    }

    public String getVal(){ return this.val; }

    @Override
    public String toString(){ return this.val; }

    @Override
    public Type getType() { return new StringType();}
}
