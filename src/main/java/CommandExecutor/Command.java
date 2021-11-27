package CommandExecutor;

public abstract class Command {
    protected String command;
    protected String[] params;

    public Command(String command) {
        this.command = command;
    }
    public abstract void setParams(String command);
    public abstract String[] getParams();

}
