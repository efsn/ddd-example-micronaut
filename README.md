# ddd-example-micronaut
## Project initialize
- docker-compose
-  

## Micronaut CLI
```bash
mn create-app cn-elmi-app -l kotlin
    --features postgres-reactive,security-jwt,redis-lettuce

mn create-message-app cn-elmi-message-app -l kotlin

mn create-grpc-app cn-elmi-grpc-app -l kotlin
```

## Build
```bash
docker build -t micronaut-ddd-example:latest
```