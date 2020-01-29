import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        SocialNetwork socialNetwork = new SocialNetwork();
        while (true) {
            System.out.println("Social Network, awaiting command:");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            socialNetwork.parseInput(input);
        }
    }
}