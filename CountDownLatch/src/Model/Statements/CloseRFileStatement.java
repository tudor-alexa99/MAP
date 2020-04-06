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
import java.io.IOException;

public class CloseRFileStatement implements IStatement {
    Expression exp;

    public CloseRFileStatement(Expression _exp) { this.exp = _exp; }

    @Override
    public String toString() { return "Closing " + this.exp; }

    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        MyIDictionary<String, Value> symTable = state.getSymTable();
        MyIDictionary<StringValue, BufferedReader> fileTable = state.getFileTable();
        MyIHeap<Integer, Value> heap = state.getHeap();

        Value fileName = this.exp.eval(symTable, heap);
        if(fileName.getType().equals(new StringType())){
            if(fileTable.isDefined((StringValue)fileName)){
                BufferedReader reader = new BufferedReader(fileTable.getValue((StringValue)fileName));
                if (reader != null){
                    try{
                        reader.close();
                        fileTable.remove((StringValue)fileName);
                    }
                    catch (IOException ioe){
                        throw new MyException(ioe.getMessage());
                    }
                }
                else
                    throw new MyException("File" + fileTable.getValue((StringValue)fileName) + " not opened! ");
            }
            else
                throw new MyException("FileName not defined! ");
        }
        else
            throw new MyException("File name is required to be a StringType! ");
//        return state;
        return null;
    }

    @Override
    public MyIDictionary<String, Type> typecheck(MyIDictionary<String, Type> typeEnv) throws MyException {
        Type typeExp = this.exp.typecheck(typeEnv);

        if(! typeExp.equals(new StringType()))
            throw new MyException("File name is not of String type!");

        return typeEnv;
    }
}
