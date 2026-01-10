import { StateNode } from "../graph/StateNode"

export class PropagationPlanner<T> {
  buildPlan(start: StateNode<T>): StateNode<T>[] {
    const visited = new Set<StateNode<T>>()
    const ordered: StateNode<T>[] = []

    const dfs = (node: StateNode<T>) => {
      if (visited.has(node)) return
      visited.add(node)

      node.dependents.forEach(dep => dfs(dep))
      ordered.push(node)
    }

    dfs(start)
    return ordered
  }
}