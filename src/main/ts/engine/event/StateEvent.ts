export class StateEvent<T> {
  readonly id = crypto.randomUUID()
  readonly timestamp = Date.now()

  constructor(
    readonly sourceNode: string,
    readonly payload: T
  ) {}
}