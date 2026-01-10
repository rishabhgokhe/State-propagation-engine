export class StateEvent<T> {
  readonly id: string
  readonly timestamp: number

  constructor(
    readonly sourceNode: string,
    readonly payload: T
  ) {
    this.id = crypto.randomUUID()
    this.timestamp = Date.now()
  }
}