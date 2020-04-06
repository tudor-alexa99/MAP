package View;

import Controller.Controller_;
import Model.Exceptions.MyException;

public class RunExample extends Command {
    private Controller_ ctrl;

    public RunExample(String _key, String _desc, Controller_ _ctrl) {
        super(_key, _desc);
        this.ctrl = _ctrl;
    }

    @Override
    public void execute() {
        try{
            this.ctrl.allSteps();
        }
        catch (MyException mEx) {
            System.out.println(mEx.getMessage());
        }
    }
}
