package engine.graph;

import java.util.HashSet;
import java.util.Set;

public class CycleDetector<T> {

    private final Set<StateNode<T>> visiting = new HashSet<>();
    private final Set<StateNode<T>> visited = new HashSet<>();

    public boolean hasCycle(StateNode<T> node) {
        if (visiting.contains(node)) return true;
        if (visited.contains(node)) return false;

        visiting.add(node);

        for (StateNode<T> dependent : node.getDependents()) {
            if (hasCycle(dependent)) {
                return true;
            }
        }

        visiting.remove(node);
        visited.add(node);
        return false;
    }
}