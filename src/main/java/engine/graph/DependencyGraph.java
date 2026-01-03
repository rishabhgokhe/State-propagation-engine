import engine.graph.CycleDetector;

public void connect(String sourceId, String targetId) {
    StateNode<T> source = nodes.get(sourceId);
    StateNode<T> target = nodes.get(targetId);

    if (source == null || target == null) {
        throw new IllegalArgumentException("Invalid node reference");
    }

    source.addDependent(target);

    CycleDetector<T> detector = new CycleDetector<>();
    if (detector.hasCycle(source)) {
        throw new IllegalStateException("Cycle detected in dependency graph");
    }
}