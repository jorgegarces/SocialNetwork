import java.util.Date;

public class Message implements Comparable<Message>{
    private final User user;
    private final Date date;
    private String message = "";

    public Message(User user, String message, Date date) {
        this.user = user;
        this.message = message;
        this.date = date;
    }

    @Override
    public String
    toString() {
        return user.toString() + " - " + message + " (" + date.getTime() +")";
    }

    @Override
    public int compareTo(Message message) {
        if (this.date.getTime() > message.date.getTime()) return 1;
        if (this.date.getTime() == message.date.getTime()) return 0;
        return -1;
    }
}