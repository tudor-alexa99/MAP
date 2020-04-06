package Repository;

import Model.Exceptions.MyException;
import Model.ProgramState;

import java.util.List;

public interface IRepository {
    ProgramState getCurrentProgram();
    void logProgStateExec(ProgramState state) throws MyException;
    List<ProgramState> getPrgList();
    //List<ProgramState> getListProgram();
    void setPrgList(List<ProgramState> states);

    Integer noOfPrgStates();
}
