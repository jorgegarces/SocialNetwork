import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class FriendList implements Iterable<User> {

    Set<User> friendList = new HashSet<User>();

    public void addFriend(User user) {
        friendList.add(user);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FriendList that = (FriendList) o;
        return Objects.equals(friendList, that.friendList);
    }

    @Override
    public Iterator<User> iterator() {
        return friendList.iterator();
    }
}