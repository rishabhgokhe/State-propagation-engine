import { StateEvent } from "../event/StateEvent"

export class StateNode<T> {
  readonly id: string
  private state: T
  readonly dependents = new Set<StateNode<T>>()

  constructor(id: string, initialState: T) {
    this.id = id
    this.state = initialState
  }

  apply(event: StateEvent<T>) {
    this.state = event.payload
  }

  getState(): T {
    return this.state
  }
}