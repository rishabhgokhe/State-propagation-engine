public PropagationTrace emit(String nodeId, T value) {
    StateNode<T> node = graph.getNode(nodeId);

    if (node == null) {
        throw new IllegalStateException("Node not found: " + nodeId);
    }

    Signal<T> signal = new Signal<>(value);
    return scheduler.propagate(node, signal);
}