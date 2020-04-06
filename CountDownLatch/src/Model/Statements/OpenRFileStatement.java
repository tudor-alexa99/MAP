package Model.Statements;

import Model.ADT.MyIDictionary;
import Model.ADT.MyIHeap;
import Model.DataTypes.StringType;
import Model.DataTypes.Type;
import Model.Exceptions.MyException;
import Model.Expressions.Expression;
import Model.ProgramState;
import Model.Values.StringValue;
import Model.Values.Value;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OpenRFileStatement implements IStatement{
    private Expression exp;

    public OpenRFileStatement(Expression _exp) { this.exp = _exp; }

    @Override
    public String toString() { return "Opening " + this.exp;}

    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        MyIDictionary<String, Value> symTable = state.getSymTable();
        MyIDictionary<StringValue, BufferedReader> fileTable = state.getFileTable();
        MyIHeap<Integer, Value> heap = state.getHeap();

        Value fileName = this.exp.eval(symTable, heap);
        if (fileName.getType().equals(new StringType())){
            if(!fileTable.isDefined((StringValue)fileName)){
                try{
                    String filenameStringValue = ((StringValue) fileName).getVal();
                    BufferedReader bufRead = new BufferedReader(
                            new FileReader(filenameStringValue)
                    );
                    fileTable.update((StringValue)fileName, bufRead);
                }
                catch (IOException fnfe){
                    throw new MyException(fnfe.getMessage());
                }
            }
            else {
                throw new MyException("FileName already defined! ");
            }
        }
        else
            throw new MyException("File name is required to be a StringType! ");
    return null;
//    return state;
    }

    @Override
    public MyIDictionary<String, Type> typecheck(MyIDictionary<String, Type> typeEnv) throws MyException {
        Type fileName = this.exp.typecheck(typeEnv);

        if(! fileName.equals(new StringType()))
            throw new MyException("File name is not of string type! ");
        return typeEnv;
    }
}
