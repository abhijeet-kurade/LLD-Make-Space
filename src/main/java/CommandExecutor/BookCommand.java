package CommandExecutor;

public class BookCommand extends Command{
    public final static String COMMAND = "BOOK";
    public BookCommand(String command) {
        super(COMMAND);
        setParams(command);
    }

    @Override
    public void setParams(String command) {
        this.params = command.split(" ");
    }

    @Override
    public String[] getParams() {
        return this.params;
    }
}
