package CommandExecutor;

public class VacancyCommand extends Command{
    public final static String COMMAND = "VACANCY";
    public VacancyCommand(String command) {
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
