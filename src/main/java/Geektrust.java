import CommandExecutor.CommandExecutor;

import java.io.*;

public class Geektrust {
    public static void main(String[] args) throws IOException {
        CommandExecutor commandExecutor = new CommandExecutor();
        String fileName = args[0];
        final File file = new File(fileName);
        final BufferedReader reader = new BufferedReader(new FileReader(file));
        String input = reader.readLine();
        while (input != null) {
            commandExecutor.runCommand(input);
            input = reader.readLine();
        }
    }
}
