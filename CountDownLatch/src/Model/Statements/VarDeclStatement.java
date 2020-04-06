package Model.Statements;

import Model.ADT.MyDictionary;
import Model.ADT.MyIDictionary;
import Model.DataTypes.*;
import Model.Exceptions.MyException;
import Model.ProgramState;
import Model.Values.*;

import java.util.Map;

public class VarDeclStatement implements IStatement{
    private String name;
    private Type type;

    public VarDeclStatement(String _name, Type _type) {
        this.name = _name;
        this.type = _type;
    }

    @Override
//    public ProgramState execute(ProgramState state) throws MyException {
//        MyIDictionary<String, Value> symTable = state.getSymTable();
//        if(symTable.isDefined(this.name))
//            throw new MyException("Variable already declared");
//        else{
//            if(this.type instanceof IntType)
//                symTable.update(this.name, new IntValue(0));
//            else if (this.type instanceof BoolType)
//                symTable.update(this.name, new BoolValue(false));
//            else if (this.type instanceof StringType)
//                symTable.update(this.name, new StringValue(""));
//            else if(this.type instanceof RefType)
//                symTable.update(this.name, new RefValue(0, null));
//        }
//        return state;
//    }
    public ProgramState execute(ProgramState state) throws MyException {
        MyIDictionary<String, Value> symTable = state.getSymTable();
        if (!symTable.isDefined(this.name)) {
            Value defaultValue = this.type.defaultValue();
            symTable.update(this.name, defaultValue);
//            return state;
            return null;
        } else {
            throw new MyException("Variable is already declared");
        }
    }
    @Override
    public String toString() {
        return this.type.toString() + ' ' + this.name;
    }

    @Override
    public MyIDictionary<String, Type> typecheck(MyIDictionary<String, Type> typeEnv) throws MyException {
        MyIDictionary<String, Type> newEnv = new MyDictionary<>();

        for(Map.Entry<String, Type> entry : typeEnv.getContent().entrySet())
            newEnv.update(entry.getKey(), entry.getValue());
        newEnv.update(this.name, this.type);

        return newEnv;
    }
}
