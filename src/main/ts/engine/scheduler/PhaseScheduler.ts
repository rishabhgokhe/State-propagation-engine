import { StateNode } from "../graph/StateNode"
import { StateEvent } from "../event/StateEvent"

export class PhaseScheduler<T> {
  execute(plan: StateNode<T>[], event: StateEvent<T>) {
    for (const node of plan) {
      node.apply(event)
    }
  }
}