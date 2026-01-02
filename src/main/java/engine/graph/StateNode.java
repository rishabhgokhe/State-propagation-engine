package engine.graph;

import engine.signal.Signal;
import java.util.HashSet;
import java.util.Set;

public class StateNode<T> {

    private final String id;
    private T state;
    private final Set<StateNode<T>> dependents;

    public StateNode(String id, T initialState) {
        this.id = id;
        this.state = initialState;
        this.dependents = new HashSet<>();
    }

    public String getId() {
        return id;
    }

    public T getState() {
        return state;
    }

    public void update(Signal<T> signal) {
        this.state = signal.getValue();
    }

    public void addDependent(StateNode<T> node) {
        dependents.add(node);
    }

    public Set<StateNode<T>> getDependents() {
        return dependents;
    }
}