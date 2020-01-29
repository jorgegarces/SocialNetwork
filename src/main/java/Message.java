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

    private String elapsedTime() {
        long elapsed = (new Date().getTime() - date.getTime()) / 1000;

        if (elapsed < 60) return elapsed + " seconds ago)";
        return Math.abs(elapsed / 60) + " min ago)";
    }

    @Override
    public String
    toString() {
        return user.toString() + " - " + message + " (" + elapsedTime();
    }

    @Override
    public int compareTo(Message message) {
        return Long.compare(this.date.getTime(), message.date.getTime());
    }
}