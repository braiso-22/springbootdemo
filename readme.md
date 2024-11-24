# Spring Boot Demo

This is a project in kotlin with spring boot with only one feature "Students".

It has the basics of all spring boot projects with JPA.
```
Controller, Service, Repository, Entity
```
I separated them by interfaces to maintain the domain decoupled.

## API Entrypoints

The entry points are these:

- GET http://localhost:8080/student
- POST http://localhost:8080/student
- PUT http://localhost:8080/student
- DELETE http://localhost:8080/student/{id}

I created a postman collection with examples in the root folder of the project,
so you can import it and execute all of them.

## How to start the project

### With docker

- Build it with

```shell
./gradlew bootJar
```

- Execute the docker compose

```shell
docker compose up -d
```


### The old way

- Install postgresql
- Create a db called student
- Hit run on your favourite IDE

### Ready to go!! 😎

The project should be running in http://localhost:8080/