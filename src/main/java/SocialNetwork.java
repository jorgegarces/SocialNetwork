import java.util.Scanner;

public class SocialNetwork {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        parseInput(input);
    }

    private static void parseInput(String input) {
        String[] temp = input.split(" ");
        if (temp.length == 1) System.out.println("This is a name");
        if (temp.length == 2) System.out.println("This is a command");
        if (temp.length > 2) temp = input.split("->");

        for (String s : temp) System.out.println(s.trim());
    }
}