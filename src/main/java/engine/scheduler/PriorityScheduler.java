package engine.scheduler;

import engine.event.StateEvent;
import engine.graph.StateNode;
import engine.planner.PropagationPlan;

import java.util.Comparator;
import java.util.List;

public class PriorityScheduler<T> {

    public void execute(PropagationPlan<T> plan, StateEvent<T> event) {
        List<StateNode<T>> steps = plan.steps();

        steps.stream()
             .sorted(Comparator.comparingInt(StateNode::priority))
             .forEach(node -> node.apply(event));
    }
}