This project is to automate the process of reserving a projector given a set of time slots by a particular team.
It can be used to view team details, projector details, add reservation, cancel reservation, check availability. 
In future we can also add a feature to show suggested time slot available if there is no current availability of projector.
All time entries are in UTC at the server side to maintain unity, which can be converted as per requirement in the front end.

Installation process

Run the database scripts in /database/ in mySQL.

Configure src/main/resources/application.propeties:
spring.datasource.url=<Schema-URL>
spring.datasource.username=<username>
spring.datasource.password=<password>

Run ProjectMgmtApplication as Java application.

REST API:

PROJECTOR: 
1. Get all projectors:

```
GET http://localhost:8080/projectors/
```
Response: 

```json
[
    {
        "id": 1,
        "name": "projector1"
    }
]
```

2. Get projector by Id:

```
GET http://localhost:8080/projectors/{id}
```
Response: (id = 1)

```json
{
    "id": 1,
    "name": "projector1"
}
```

TEAM:
1. Get all teams

```
GET http://localhost:8080/teams/
```

Response

```json
[
    {
        "id": 1,
        "name": "team1"
    }
]
```

2. Get team by id:

```
GET http://localhost:8080/teams/{id}
```

Response: (id = 1)

```json
{
    "id": 1,
    "name": "team1"
}
```

RESERVATIONS:

1. Get all reservations:

```
GET http://localhost:8080/reservations/
```

```json
[
    {
        "id": 2,
        "startTime": 1501515000000,
        "endTime": 1501518600000,
        "createdTime": 1501537855000,
        "updatedTime": 1501537855000,
        "team": {
            "id": 2,
            "name": "team2"
        },
        "projector": {
            "id": 2,
            "name": "projector2"
        },
        "active": true
    }
 ]
```

2. Get reservations made by particular team:

```
GET http://localhost:8080/reservations/team/{id}
```
Response: (id = 2)

```json
[
    {
        "id": 2,
        "startTime": 1501515000000,
        "endTime": 1501518600000,
        "createdTime": 1501537855000,
        "updatedTime": 1501537855000,
        "team": {
            "id": 2,
            "name": "team2"
        },
        "projector": {
            "id": 2,
            "name": "projector2"
        },
        "active": true
    }
]
```

3. ADD RESERVATION:

```
POST http://localhost:8080/reservations/
```
REQUEST:

```json
{
	"startTime":"2012-04-23T18:25:43.511Z",
	"endTime":"2012-04-23T18:55:00.511Z",
	"team":{
		"id":1,
		"name":"team1"
	}
}
```

RESPOSE:

```json
{
    "id": 5,
    "startTime": 1335205543511,
    "endTime": 1335207300511,
    "createdTime": 1501530780688,
    "updatedTime": 1501530780688,
    "team": {
        "id": 3,
        "name": "team3"
    },
    "projector": {
        "id": 1,
        "name": "projector1"
    },
    "active": true
}
```

4. CHECK AVAILABILITY:

```
GET http://localhost:8080/reservations/availability/{startDate}/{endDate}
```

RESPONSE: (startTime: 2012-04-23T10:00:00Z endTime: 2012-04-23T13:00:00Z)

```json
{
    "startTime": 1335175200000,
    "endTime": 1335175200000,
    "projector": {
        "id": 1,
        "name": "projector1"
    },
    "available": true
}
```

CANCEL REQUEST:

```
PATCH http://localhost:8080/resrevations/cancel/1
```
REQUEST BODY IS EMPTY

RESPONSE: (active false represents the request is cancelled)

```json
{
    "id": 1,
    "startTime": 1501531200000,
    "endTime": 1501538400000,
    "createdTime": 1501554799000,
    "updatedTime": 1501538058000,
    "team": {
        "id": 1,
        "name": "team1"
    },
    "projector": {
        "id": 1,
        "name": "projector1"
    },
    "active": false
}
```




