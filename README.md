# Game Management Software
Game Management Demo project for Spring Boot

# Software Document

## Software Technical Stack
* Spring Boot 2.6.4
* Java 17 2021-09-14 LTS
* Maven 3.8.2
* OpenAPI UI 1.6.6
* DbRider Spring 1.32.2

## Software Design
* There are two entities: Game (id, name, level) and Gamer with fields (id, name, Geography (city, country)).
* There is a OneToMany relations: (Game could have many Gamers: i.e. many gamers could be linked to many games)

## Software API specification
* API Specification could be found from: http://localhost:8080/v1/api-docs/swagger-ui

## Software Behaviour
System designed as a Spring Boot Web Application. Provides Rest API with following endpoints:

* Link Gamer to Game
```
POST /api/v1/game/gamers
{
    gameId: {gameId}
    gamerId: {gamerId}
}

Example: POST /api/v1/game/gamers
{
    gameId: 1
    gamerId: 1
}
```

* UnLink Gamer from Game
```
DELETE /api/v1/game/gamers
{
    gameId: {gameId}
    gamerId: {gamerId}
}

Example: DELETE /api/v1/game/gamers
{
    gameId: 1
    gamerId: 1
}
```

* Search all Gamers: `GET /api/v1/game/gamers`

`RESPONSE BODY `
```
[
  {
    "gameId": null,
    "gameName": null,
    "level": "PRO",
    "country": "Armenia",
    "city": "Yerevan"
  },
  {
    "gameId": null,
    "gameName": null,
    "level": "INVINCIBLE",
    "country": "Armenia",
    "city": "Yerevan"
  }
]
```

* Search Gamers by Specific Level per Game: `GET /api/v1/game/gamers/INVINCIBLE`

`RESPONSE BODY `
```
[
  {
    "gameId": null,
    "gameName": null,
    "level": "INVINCIBLE",
    "country": "Armenia",
    "city": "Yerevan"
  },
  {
    "gameId": null,
    "gameName": null,
    "level": "INVINCIBLE",
    "country": "Armenia",
    "city": "Yerevan"
  }
]
```

## Software Tests Run
- Run application with bach command from project root `./scripts/run-tests.sh`
- Run the application from the IDEA itself

## Software Run
- Run application with bach command from project root `./scripts/run.sh`
- Run the application from the IDEA itself
