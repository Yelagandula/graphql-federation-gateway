# GraphQL Federation Gateway

Apollo Federation 2 gateway built with Kotlin and Spring Boot.

## Stack
- Apollo Router (Rust-based)
- Apollo Federation 2
- OpenTelemetry + Jaeger
- Kotlin + Spring Boot

## Architecture
Stitches together Users, Products, and Orders subgraphs into a unified supergraph.

## Running locally
```bash
docker-compose up
```
Gateway available at `http://localhost:4000/graphql`
