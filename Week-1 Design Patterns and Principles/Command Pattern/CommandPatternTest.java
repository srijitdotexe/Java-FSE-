import java.util.Scanner;

public class CommandPatternTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Light light = new Light();
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);
        RemoteControl remoteControl = new RemoteControl();
        while (true) {
            System.out.println("Select command (1 for Light ON, 2 for Light OFF, 0 to Exit):");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    remoteControl.setCommand(lightOn);
                    remoteControl.pressButton();
                    break;
                case 2:
                    remoteControl.setCommand(lightOff);
                    remoteControl.pressButton();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}