import java.util.Scanner;

public class BuilderPatternTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter CPU:");
        String cpu = scanner.nextLine();

        System.out.println("Enter RAM:");
        String ram = scanner.nextLine();

        System.out.println("Enter Storage (leave empty if not needed):");
        String storage = scanner.nextLine();

        System.out.println("Enter Graphics Card (leave empty if not needed):");
        String graphicsCard = scanner.nextLine();

        System.out.println("Is the computer gaming ready? (true/false):");
        boolean isGamingReady = scanner.nextBoolean();

        Computer.Builder builder = new Computer.Builder(cpu, ram);

        if (!storage.isEmpty()) {
            builder.setStorage(storage);
        }

        if (!graphicsCard.isEmpty()) {
            builder.setGraphicsCard(graphicsCard);
        }

        builder.setGamingReady(isGamingReady);

        Computer computer = builder.build();
        System.out.println("Computer Configuration: ");
        System.out.println(computer);
    }
}
