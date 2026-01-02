package engine.signal;

public final class Signal<T> {

    private final T value;
    private final long timestamp;

    public Signal(T value) {
        this.value = value;
        this.timestamp = System.currentTimeMillis();
    }

    public T getValue() {
        return value;
    }

    public long getTimestamp() {
        return timestamp;
    }
}