### Some examples

- To list all the people

    `curl 'localhost:8080/api/people' | jq .`

- To create a new Person

    `curl -X POST 'localhost:8080/api/people' -d '{"name":"Juan Manuel"}' -H "Content-Type: application/json" | jq .`

will return

    [
      {
        "id": 1,
        "name": "Juan Manuel"
      }
    ]

- To get a Person by id

    `curl 'localhost:8080/api/people/1' | jq .`

- To edit some information

    `curl -X PUT 'localhost:8080/api/people/1' -d '{"name" : "Juan Manuel Mougan"}' -H "Content-Type: application/json" | jq .`

- Finally, to delete it

    `curl -X DELETE 'localhost:8080/api/people/1' | jq .`

### Creating more test data

- Adding some teams

    `curl -X POST 'localhost:8080/api/teams' -d '{"name":"Argentina"}' -H "Content-Type: application/json" | jq .`
    
    `curl -X POST 'localhost:8080/api/teams' -d '{"name":"Islandia"}' -H "Content-Type: application/json" | jq .`
    
    `curl -X POST 'localhost:8080/api/teams' -d '{"name":"Nigeria"}' -H "Content-Type: application/json" | jq .`
    
    `curl -X POST 'localhost:8080/api/teams' -d '{"name":"Croacia"}' -H "Content-Type: application/json" | jq .`

- Adding some test Matches

    `curl -X POST 'localhost:8080/api/matches' -d '{"homeTeam":{"id":3,"name":"Argentina"}, "awayTeam":{"id":4,"name":"Islandia"}, "round": "FIRST_ROUND"}' -H "Content-Type: application/json" | jq .`
    
    `curl -X POST 'localhost:8080/api/matches' -d '{"homeTeam":{"id":6,"name":"Croacia"}, "awayTeam":{"id":5,"name":"Nigeria"}, "round": "FIRST_ROUND"}' -H "Content-Type: application/json" | jq .`
    
    `curl -X POST 'localhost:8080/api/matches' -d '{"homeTeam":{"id":3,"name":"Argentina"}, "awayTeam":{"id":6,"name":"Croacia"}, "round": "FIRST_ROUND"}' -H "Content-Type: application/json" | jq .`
