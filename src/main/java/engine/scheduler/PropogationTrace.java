package engine.scheduler;

import java.util.ArrayList;
import java.util.List;

public class PropagationTrace {

    private final List<String> path = new ArrayList<>();

    public void record(String nodeId) {
        path.add(nodeId);
    }

    public List<String> getPath() {
        return path;
    }
}