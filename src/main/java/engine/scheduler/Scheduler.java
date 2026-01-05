import engine.scheduler.PropagationTrace;

public PropagationTrace propagate(StateNode<T> startNode, Signal<T> signal) {
    Queue<StateNode<T>> queue = new ArrayDeque<>();
    PropagationTrace trace = new PropagationTrace();

    queue.add(startNode);

    while (!queue.isEmpty()) {
        StateNode<T> current = queue.poll();
        trace.record(current.getId());
        current.update(signal);

        for (StateNode<T> dependent : current.getDependents()) {
            queue.add(dependent);
        }
    }

    return trace;
}