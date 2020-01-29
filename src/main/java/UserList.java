import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class UserList {

    private Set<User> userList = new HashSet<User>();

    public void newUser(User user) {
        userList.add(user);
    }


    public User retrieveUser(String input){
        for (User user: userList) {
            if (input.equals(user.toString())) return user;
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserList userList1 = (UserList) o;
        return Objects.equals(userList, userList1.userList);
    }
}
