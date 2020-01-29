import java.util.Scanner;

public class App {

    static SocialNetwork socialNetwork;
    public static void main(String[] args) {
        while (true) {
            System.out.println("Social Network, enter your command");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            socialNetwork = new SocialNetwork(input);
        }
    }
}