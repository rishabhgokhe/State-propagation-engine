package engine.event;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EventLog<T> {

    private final List<StateEvent<T>> events = new ArrayList<>();

    public void append(StateEvent<T> event) {
        events.add(event);
    }

    public List<StateEvent<T>> snapshot() {
        return Collections.unmodifiableList(events);
    }

    public int size() {
        return events.size();
    }
}