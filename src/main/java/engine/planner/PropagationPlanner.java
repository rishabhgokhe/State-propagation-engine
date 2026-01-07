package engine.planner;

import mesh.graph.StateNode;
import java.util.*;

public class PropagationPlanner<T> {

    public List<StateNode<T>> buildPlan(StateNode<T> start) {
        List<StateNode<T>> ordered = new ArrayList<>();
        Set<StateNode<T>> visited = new HashSet<>();

        dfs(start, visited, ordered);
        return ordered;
    }

    private void dfs(StateNode<T> node,
                     Set<StateNode<T>> visited,
                     List<StateNode<T>> ordered) {
        if (visited.contains(node)) return;
        visited.add(node);

        for (StateNode<T> dep : node.dependents()) {
            dfs(dep, visited, ordered);
        }
        ordered.add(node);
    }
}