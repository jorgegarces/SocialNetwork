import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class TimeLine implements Iterable<Message>{
    private List<Message> timeline = new ArrayList<Message>();

    public void newMessage(Message message) {
        timeline.add(message);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeLine timeLine = (TimeLine) o;
        return Objects.equals(timeline, timeLine.timeline);
    }

    @Override
    public String toString() {
        return "TimeLine= " + timeline;
    }

    @Override
    public Iterator<Message> iterator() {
        return timeline.iterator();
    }
}