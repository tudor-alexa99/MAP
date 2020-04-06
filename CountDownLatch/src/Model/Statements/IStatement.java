package Model.Statements;

import Model.ADT.MyIDictionary;
import Model.DataTypes.Type;
import Model.Exceptions.MyException;
import Model.ProgramState;

public interface IStatement{
    ProgramState execute(ProgramState state) throws MyException;
    MyIDictionary<String, Type> typecheck (MyIDictionary<String, Type> typeEnv) throws MyException;
}
