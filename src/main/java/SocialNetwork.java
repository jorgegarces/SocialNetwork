import java.util.Date;

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

        if (parsedInput.length == 1) {
            System.out.println("This is a name");
        } else if (parsedInput.length == 2) System.out.println("This is a command");

        else {

            User user = checkUser(userName);
            if (user != null) {

                String userMessage = parsedInput[2].trim();

                Message message = new Message(user, userMessage, new Date());
                user.addMessage(message);

                System.out.println(user.getTimeLine() + " new User");
            } else {

                String userMessage = parsedInput[2].trim();
                user = new User(userName);
                this.addUser(user);
                Message message = new Message(user, userMessage, new Date());
                user.addMessage(message);

                System.out.println(user.getTimeLine() + " new User");
            }
        }
    }

    private User checkUser(String userName) {
        for (User user : userList) {
            if (user.toString().equals(userName)) return user;
        }
        return null;
    }
}
