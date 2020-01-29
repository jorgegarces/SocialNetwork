public class SocialNetwork {

    private UserList userList;

    public SocialNetwork(String input) {
        this.userList = new UserList();
        parseInput(input);
    }

    public void addUser(User user) {
        userList.newUser(user);
    }

    public UserList getUsers() {
        return userList;
    }

    public static String parseInput(String input) {
        String[] temp = input.split(" ");
        if (temp.length == 1) System.out.println("This is a name");
        if (temp.length == 2) System.out.println("This is a command");
        if (temp.length > 2) temp = input.split("->");

        for (String s : temp) System.out.println(s.trim());
        return temp.toString();
    }
}
