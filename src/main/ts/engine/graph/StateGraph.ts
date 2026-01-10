import { StateNode } from "./StateNode"

export class StateGraph<T> {
  private nodes = new Map<string, StateNode<T>>()

  register(node: StateNode<T>) {
    this.nodes.set(node.id, node)
  }

  connect(sourceId: string, targetId: string) {
    const source = this.nodes.get(sourceId)
    const target = this.nodes.get(targetId)

    if (!source || !target) {
      throw new Error("Invalid graph connection")
    }

    source.dependents.add(target)
  }

  node(id: string): StateNode<T> {
    const node = this.nodes.get(id)
    if (!node) {
      throw new Error(`Node not found: ${id}`)
    }
    return node
  }
}