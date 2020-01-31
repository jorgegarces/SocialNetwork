public class SocialNetwork {

    private UserList userList;

    public SocialNetwork() {
        this.userList = new UserList();
    }

    public void addUser(User user) {
        userList.newUser(user);
    }

    public UserList getUsers() {
        return userList;
    }

    public void parseInput(String input) {
        String[] parsedInput = input.split(" ");
        String userName = parsedInput[0].trim();
        User user = checkUser(userName);

        if (input.contains("wall")) user.getWall().forEach(System.out::println);
        else if (input.contains("follows")) {
            user.addFriend(userList.retrieveUser(parsedInput[2]));
            System.out.println("User added to followeds.");
        } else if (input.contains("->")) {
            parsedInput = input.split("->");
            user.addMessage(new Message(user, parsedInput[1].trim()));
            System.out.println(user.toString() + " posted a new message!");
        } else user.getTimeLine().forEach(System.out::println);
    }

    private User checkUser(String userName) {
        User user = userList.retrieveUser(userName);
        if (user == null) {
            user = new User(userName);
            this.addUser(user);
        }
        return user;
    }
}
