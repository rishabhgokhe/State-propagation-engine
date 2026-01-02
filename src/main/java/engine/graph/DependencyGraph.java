package engine.graph;

import java.util.HashMap;
import java.util.Map;

public class DependencyGraph<T> {

    private final Map<String, StateNode<T>> nodes;

    public DependencyGraph() {
        this.nodes = new HashMap<>();
    }

    public void register(StateNode<T> node) {
        nodes.put(node.getId(), node);
    }

    public void connect(String sourceId, String targetId) {
        StateNode<T> source = nodes.get(sourceId);
        StateNode<T> target = nodes.get(targetId);

        if (source == null || target == null) {
            throw new IllegalArgumentException("Invalid node reference");
        }

        source.addDependent(target);
    }

    public StateNode<T> getNode(String id) {
        return nodes.get(id);
    }
}