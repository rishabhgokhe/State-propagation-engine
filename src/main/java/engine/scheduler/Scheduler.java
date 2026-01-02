package engine.scheduler;

import engine.graph.StateNode;
import engine.signal.Signal;

import java.util.ArrayDeque;
import java.util.Queue;

public class Scheduler<T> {

    public void propagate(StateNode<T> startNode, Signal<T> signal) {
        Queue<StateNode<T>> queue = new ArrayDeque<>();
        queue.add(startNode);

        while (!queue.isEmpty()) {
            StateNode<T> current = queue.poll();
            current.update(signal);

            for (StateNode<T> dependent : current.getDependents()) {
                queue.add(dependent);
            }
        }
    }
}