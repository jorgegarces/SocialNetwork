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
        User user = userList.retrieveUser(userName);

        if (parsedInput.length == 1) user.getTimeLine().forEach(System.out::println);
        else if (parsedInput.length == 2) user.getWall().forEach(System.out::println);
        else if (parsedInput[1].equals("follows")) {
            user.addFriend(userList.retrieveUser(parsedInput[2]));
            System.out.println("User added to followeds.");
        } else {
                if (user != null) {
                    user.addMessage(new Message(user, parsedInput[2].trim(), new Date()));
                    System.out.println(user.toString() + " posted a new message!");
                } else {
                    String userMessage = parsedInput[2].trim();
                    user = new User(userName);
                    this.addUser(user);
                    Message message = new Message(user, userMessage, new Date());
                    user.addMessage(message);
                    System.out.println(user.toString() + " posted a new message!");
                }
            }
        }
    }