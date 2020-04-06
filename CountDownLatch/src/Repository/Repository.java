package Repository;

import Model.Exceptions.MyException;
import Model.ProgramState;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Repository implements IRepository{
    private List<ProgramState> programStateList;
    private String logFilePath;

    public Repository(ProgramState currentProgramState, String lfp) {
        this.programStateList = new ArrayList<ProgramState>();
        this.programStateList.add(currentProgramState);
        this.logFilePath = lfp;
    }

    @Override
    public ProgramState getCurrentProgram() {
        return this.programStateList.get(0);
    }

    @Override
    public void logProgStateExec(ProgramState state) throws MyException {
        try (PrintWriter logFile = new PrintWriter(new BufferedWriter(new FileWriter(this.logFilePath, true)))){
            logFile.println(state.toString() + '\n');
        }
        catch (IOException ioe){
            throw new MyException(ioe.getMessage());
        }
    }

    @Override
    public List<ProgramState> getPrgList() {
        return this.programStateList;
    }
//
    @Override
    public void setPrgList(List<ProgramState> states) {
        this.programStateList = states;
    }


    @Override
    public Integer noOfPrgStates() {
        return this.programStateList.size();
    }
}

