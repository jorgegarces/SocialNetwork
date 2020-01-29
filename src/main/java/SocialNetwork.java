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
}
