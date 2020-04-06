package View;

public abstract class Command {
    private String key, description;

    public Command(String _key, String _desc) { this.key = _key; this.description = _desc; }
    public abstract void execute();
    public String getKey(){ return this.key; }
    public String getDescription() { return this.description; }
}
