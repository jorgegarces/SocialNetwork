import java.util.*;

public class Wall {

    public List<Message> messageList = new ArrayList<Message>();

    public Wall() {
    }

    public Wall aggregateTimeLines(List<TimeLine> timeLines) {
        sortMessagesByDate(timeLines);
        System.out.println(this);
        return this;
    }

    private void sortMessagesByDate(List<TimeLine> timeLines) {
        for (TimeLine timeline : timeLines) {
            for (Message message : timeline) {
                messageList.add(message);
            }
        }
        Collections.sort(messageList);
    }

    @Override
    public String toString() {
        return messageList.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wall wall = (Wall) o;
        return Objects.equals(messageList, wall.messageList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageList);
    }
}