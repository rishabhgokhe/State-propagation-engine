package engine.planner;

import engine.graph.StateNode;
import java.util.List;

public final class PropagationPlan<T> {

    private final List<StateNode<T>> executionOrder;

    public PropagationPlan(List<StateNode<T>> executionOrder) {
        this.executionOrder = executionOrder;
    }

    public List<StateNode<T>> steps() {
        return executionOrder;
    }

    public int size() {
        return executionOrder.size();
    }
}