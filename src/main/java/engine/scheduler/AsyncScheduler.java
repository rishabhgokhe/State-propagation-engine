package engine.scheduler;

import engine.event.StateEvent;
import engine.graph.StateNode;
import engine.planner.PropagationPlan;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncScheduler<T> {

    private final ExecutorService executor;

    public AsyncScheduler(int workers) {
        this.executor = Executors.newFixedThreadPool(workers);
    }

    public void execute(PropagationPlan<T> plan, StateEvent<T> event) {
        for (StateNode<T> node : plan.steps()) {
            executor.submit(() -> node.apply(event));
        }
    }

    public void shutdown() {
        executor.shutdown();
    }
}