package engine.event;

import java.time.Instant;
import java.util.UUID;

public final class StateEvent<T> {

    private final UUID id;
    private final String sourceNode;
    private final T payload;
    private final Instant timestamp;

    public StateEvent(String sourceNode, T payload) {
        this.id = UUID.randomUUID();
        this.sourceNode = sourceNode;
        this.payload = payload;
        this.timestamp = Instant.now();
    }

    public String source() { return sourceNode; }
    public T payload() { return payload; }
}