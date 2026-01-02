# State Propagation Engine

An experimental engine exploring how state transitions propagate across dependent systems under real-time constraints.

This project is not a framework.  
It is a research-driven implementation focused on understanding propagation order, dependency resolution, and update determinism in reactive architectures.

## Motivation

As applications grow, state flow becomes implicit, fragmented, and difficult to reason about.
Most systems hide propagation behind abstractions, making update behavior hard to inspect or verify.

This project exists to **make state propagation explicit**.

## Problem Space

- Implicit dependency chains
- Non-deterministic update order
- Hidden cascades triggered by state mutation
- Performance degradation caused by uncontrolled propagation

## Approach

State is modeled as a directed dependency graph.

Each mutation emits a signal.
Signals propagate through dependent nodes following a deterministic resolution strategy.
Propagation paths are recorded and exposed for inspection.

The engine prioritizes **correctness and observability** over convenience.

## Core Concepts (work in progress)

- Signal-based state mutation
- Directed dependency graphs
- Deterministic propagation order
- Real-time update constraints
- Propagation trace recording

## Current Status

This repository is under active development.

The implementation is intentionally minimal and evolving.
APIs are unstable.
Several design decisions are still being evaluated.

## Open Questions

- Optimal scheduling strategies for propagation
- Batching vs immediate updates
- Cyclic dependency handling
- Cost modeling for propagation depth

## Non-Goals

- Production readiness
- Framework-level abstractions
- Opinionated developer ergonomics

## Notes

This project is primarily an exploration of reactive system internals.
It may change direction as findings emerge.
Further documentation will be added once the propagation model stabilizes.
