import engine.*;
import engine.graph.*;
import engine.scheduler.PropagationTrace;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PropagationEngineTest {

    @Test
    void propagatesStateDeterministically() {
        DependencyGraph<Integer> graph = new DependencyGraph<>();

        StateNode<Integer> A = new StateNode<>("A", 0);
        StateNode<Integer> B = new StateNode<>("B", 0);
        StateNode<Integer> C = new StateNode<>("C", 0);

        graph.register(A);
        graph.register(B);
        graph.register(C);

        graph.connect("A", "B");
        graph.connect("B", "C");

        PropagationEngine<Integer> engine = new PropagationEngine<>(graph);
        PropagationTrace trace = engine.emit("A", 10);

        assertEquals(10, C.getState());
        assertEquals(List.of("A", "B", "C"), trace.getPath());
    }

    @Test
    void detectsCycles() {
        DependencyGraph<Integer> graph = new DependencyGraph<>();

        StateNode<Integer> A = new StateNode<>("A", 0);
        StateNode<Integer> B = new StateNode<>("B", 0);

        graph.register(A);
        graph.register(B);

        graph.connect("A", "B");

        assertThrows(IllegalStateException.class, () -> {
            graph.connect("B", "A");
        });
    }
}