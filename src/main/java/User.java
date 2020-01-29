import java.util.ArrayList;
import java.util.List;

public class User {

    private final String name;
    private FriendList friendList = new FriendList();
    private TimeLine timeLine = new TimeLine();

    public User(String name) {
        this.name = name;
    }

    public void addFriend(User friendName) {
        this.friendList.addFriend(friendName);
    }

    public FriendList getFriends() {
        return friendList;
    }

    public void addMessage(Message message) {
        timeLine.newMessage(message);
    }

    public TimeLine getTimeLine() {
        return timeLine;
    }

    @Override
    public String toString() {
        return name;
    }

    public Wall getWall() {
        List<TimeLine> timeLines = new ArrayList<TimeLine>();
        timeLines.add(timeLine);
        for (User user : friendList) timeLines.add(user.getTimeLine());

        Wall wallie = new Wall();
        return wallie.aggregateTimeLines(timeLines);
    }
}