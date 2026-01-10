import { StateEvent } from "./event/StateEvent"
import { PropagationPlanner } from "./planner/PropagationPlanner"
import { PhaseScheduler } from "./scheduler/PhaseScheduler"
import { StateGraph } from "./graph/StateGraph"

export class SignalMeshEngine<T> {
  private planner = new PropagationPlanner<T>()
  private scheduler = new PhaseScheduler<T>()

  constructor(private graph: StateGraph<T>) {}

  emit(nodeId: string, payload: T) {
    const node = this.graph.node(nodeId)
    const event = new StateEvent(nodeId, payload)
    const plan = this.planner.buildPlan(node)
    this.scheduler.execute(plan, event)
  }
}