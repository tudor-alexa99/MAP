package Model.Statements;

import Model.ADT.MyIDictionary;
import Model.ADT.MyIHeap;
import Model.DataTypes.IntType;
import Model.DataTypes.StringType;
import Model.DataTypes.Type;
import Model.Exceptions.MyException;
import Model.Expressions.Expression;
import Model.ProgramState;
import Model.Values.IntValue;
import Model.Values.StringValue;
import Model.Values.Value;

import java.io.BufferedReader;
import java.io.IOException;

public class ReadFileStatement implements IStatement {
    private Expression exp;
    private String var_name;

    public ReadFileStatement(Expression _exp, String _vn) {
        this.exp = _exp;
        this.var_name = _vn;
    }

    @Override
    public String toString() {
        return "Reading " + this.exp.toString()+ "-->" + this.var_name;
    }

    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        MyIDictionary<String, Value> symTable = state.getSymTable();
        MyIDictionary<StringValue, BufferedReader> fileTable = state.getFileTable();
        MyIHeap<Integer, Value> heap = state.getHeap();

        if(symTable.isDefined(this.var_name) && symTable.getValue(this.var_name).getType().equals(new IntType())){
            Value fileName = this.exp.eval(symTable, heap);
            if(fileName.getType().equals(new StringType())){
                BufferedReader reader = fileTable.getValue((StringValue)fileName);
                if(reader != null){
                    try {
                        String line = reader.readLine();
                        IntValue readInt;
                        if (line == null) {
                            readInt = new IntValue(0);
                        } else
                            readInt = new IntValue(Integer.parseInt(line));
                        symTable.update(this.var_name, readInt);
                    }
                    catch (IOException ioe){
                        throw new MyException(ioe.getMessage());
                    }
                }
                else
                    throw new MyException("File " + ((StringValue) fileName).getVal() + "could not be opened! " );
            }
            else
                throw new MyException("File name expected to be of StringType! ");
        }
        else
            throw new MyException("Variable not defined or not an IntType! ");
//        return state;
            return null;
    }

    @Override
    public MyIDictionary<String, Type> typecheck(MyIDictionary<String, Type> typeEnv) throws MyException {
        Type typeExp = this.exp.typecheck(typeEnv);
        Type typeVar = typeEnv.getValue(this.var_name);

        if(! typeVar.equals(new StringType()))
            throw new MyException("Opened file is not a string type! ");
        return typeEnv;
    }
}
