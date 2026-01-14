package engine.planner;

import engine.graph.StateNode;
import java.util.*;

public PropagationPlan<T> buildPlan(StateNode<T> start) {
    List<StateNode<T>> ordered = new ArrayList<>();
    Set<StateNode<T>> visited = new HashSet<>();

    dfs(start, visited, ordered);
    return new PropagationPlan<>(ordered);
}