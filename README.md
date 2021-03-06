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

* The project is created by using power of Spring Boot (Dependency Injection (IoC) as weel following some SOLID principles
* For Software Design, Rest API design, Database Design tried to followed the best practises
* For database data preparation mostly used the power from DbRider for Controller Integration and Repository tests
* There are two entities: Game (id, name) and Gamer with fields (id, name, level, Geography (city, country)).
* There is a OneToMany relations: (Game could have many Gamers: i.e. many gamers could be linked to many games)

## Software API specification
* API Specification could be found from: http://localhost:8080/v1/api-docs/swagger-ui

## Software Behaviour
System designed as a Spring Boot Web Application. Provides Rest API with following endpoints:

* Link Gamer to Game

`REQUEST BODY`
```
POST /api/v1/game/gamers
{
    gameId: 1
    gamerId: 1
}
```

`RESPONSE BODY`
```
{
  "gameId": 1,
  "gameName": "FIFA22",
  "gamers": [
    {
      "id": 1,
      "name": "Hayk Hovhannisyan 1",
      "level": "PRO",
      "country": "Armenia",
      "city": "Yerevan"
    }
  ]
}
```

* UnLink Gamer from Game

`REQUEST BODY`
```
DELETE /api/v1/game/gamers
{
    gameId: 1
    gamerId: 1
}
```

`RESPONSE BODY`
```
{
  "gameId": 1,
  "gameName": "FIFA22",
  "gamers": []
}
```

* Search all Gamers: `GET /api/v1/game/gamers`

`RESPONSE BODY `
```
[
  {
    "gameId": 1,
    "gameName": "FIFA22",
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

* Search API based on level, game and geography for auto-matching gamers.

`REQUEST BODY`
```
POST /api/v1/games/gamers
{
    gameId: 1,
    level: "PRO",
    country: "Armenia",
    city: "Yerevan"
}
```

* Search Gamers by Specific Level per Game: `GET /api/v1/game/gamers/INVINCIBLE`

`RESPONSE BODY `
```
[
  {
    "gameId": 1,
    "gameName": "FIFA22",
    "level": "PRO",
    "country": "Armenia",
    "city": "Yerevan"
  },
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
    "level": "PRO",
    "country": "Armenia",
    "city": "Yerevan"
  }
]
```

* Search Gamers by Specific Level and Specific Game: `GET /api/v1/game/gamers/PRO/1`

`RESPONSE BODY `
```
[
  {
    "gameId": 1,
    "gameName": "FIFA22",
    "level": "PRO",
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

# Nice to have
* More scenarios for unit and integration tests 
