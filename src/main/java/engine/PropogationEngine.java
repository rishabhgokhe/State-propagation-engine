package engine;

import engine.graph.DependencyGraph;
import engine.graph.StateNode;
import engine.scheduler.Scheduler;
import engine.signal.Signal;

public class PropagationEngine<T> {

    private final DependencyGraph<T> graph;
    private final Scheduler<T> scheduler;

    public PropagationEngine(DependencyGraph<T> graph) {
        this.graph = graph;
        this.scheduler = new Scheduler<>();
    }

    public void emit(String nodeId, T value) {
        StateNode<T> node = graph.getNode(nodeId);

        if (node == null) {
            throw new IllegalStateException("Node not found: " + nodeId);
        }

        Signal<T> signal = new Signal<>(value);
        scheduler.propagate(node, signal);
    }
}