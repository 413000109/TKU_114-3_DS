public class Q06_CommandValidator {
    public static void main(String[] args) {
        String[] commands = {"START", "stop", "Pause", "RUN", " ", "", null};
        for (String command : commands) {
            System.out.println(command + " -> " + isValidCommand(command));
        }
    }

    public static boolean isValidCommand(String command) {
        if (command == null) return false;
        String cmd = command.trim();
        return "START".equalsIgnoreCase(cmd) || "STOP".equalsIgnoreCase(cmd) || "PAUSE".equalsIgnoreCase(cmd);
    }
}