package View;

public class ExitCommand extends Command {
    public ExitCommand(String _key, String _desc) {
        super(_key, _desc);
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}
