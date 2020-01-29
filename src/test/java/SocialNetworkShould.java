import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SocialNetworkShould {
    @Test
    public void add_new_user_to_user_registry() {

        SocialNetwork socialNetwork = new SocialNetwork("");

        User testUser = new User("Felipe");
        socialNetwork.addUser(testUser);

        UserList expected = new UserList();
        expected.newUser(testUser);

        Assert.assertEquals(expected, socialNetwork.getUsers());
    }

    @Test
    public void add_friend_to_user_friends_list() {

        SocialNetwork socialNetwork = new SocialNetwork("");

        User testUser = new User("Felipe");
        socialNetwork.addUser(testUser);

        User testFriend = new User("Lolo");
        socialNetwork.addUser(testFriend);

        testUser.addFriend(testFriend);

        FriendList expected = new FriendList();
        expected.addFriend(testFriend);

        Assert.assertEquals(expected, testUser.getFriends());
    }


    @Test
    public void add_message_to_user_timeline() {

        SocialNetwork socialNetwork = new SocialNetwork("");

        User testUser = new User("Felipe");
        socialNetwork.addUser(testUser);

        Date testDate = new Date();

        Message testMessage = new Message(testUser, "Buenas tardes", testDate);
        testUser.addMessage(testMessage);

        TimeLine expected = new TimeLine();
        expected.newMessage(testMessage);


        Assert.assertEquals(expected, testUser.getTimeLine());
    }

    @Test
    public void aggregate_friends_timeline_to_own() {
        SocialNetwork socialNetwork = new SocialNetwork("");

        Date testDate;


        User testUser = new User("Felipe");
        socialNetwork.addUser(testUser);
        testDate = new Date();
        Message testMessage = new Message(testUser, "Buenas tardes", testDate);
        testUser.addMessage(testMessage);

        User testFriend = new User("Lolo");
        socialNetwork.addUser(testFriend);

        testDate = new Date();
        testDate.setTime(testDate.getTime() + 2);
        Message friendTestMessage = new Message(testFriend, "Buenos días", testDate);
        testFriend.addMessage(friendTestMessage);
        testUser.addFriend(testFriend);

        TimeLine timeLine1 = new TimeLine();
        TimeLine timeLine2 = new TimeLine();

        timeLine1.newMessage(testMessage);
        timeLine2.newMessage(friendTestMessage);

        List<TimeLine> testTimeLines = new ArrayList<TimeLine>();
        testTimeLines.add(timeLine1);
        testTimeLines.add(timeLine2);

        Wall expected = new Wall();
        expected.aggregateTimeLines(testTimeLines);

        Assert.assertEquals(expected, testUser.getWall());
    }
}