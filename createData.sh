#!/usr/bin/env bash
# Create people
curl -X POST 'localhost:8080/api/people' -d '{"name":"Juan Manuel"}' -H "Content-Type: application/json" | jq . ;
curl -X POST 'localhost:8080/api/people' -d '{"name":"Pepito"}' -H "Content-Type: application/json" | jq . ;

# Create teams
curl -X POST 'localhost:8080/api/teams' -d '{"name":"Argentina"}' -H "Content-Type: application/json" | jq . ;
curl -X POST 'localhost:8080/api/teams' -d '{"name":"Islandia"}' -H "Content-Type: application/json" | jq . ;
curl -X POST 'localhost:8080/api/teams' -d '{"name":"Nigeria"}' -H "Content-Type: application/json" | jq . ;
curl -X POST 'localhost:8080/api/teams' -d '{"name":"Croacia"}' -H "Content-Type: application/json" | jq . ;

# Create Matches
curl -X POST 'localhost:8080/api/matches' -d '{"homeTeam":{"id":3,"name":"Argentina"}, "awayTeam":{"id":4,"name":"Islandia"}, "round": "FIRST_ROUND"}' -H "Content-Type: application/json" | jq . ;
curl -X POST 'localhost:8080/api/matches' -d '{"homeTeam":{"id":6,"name":"Croacia"}, "awayTeam":{"id":5,"name":"Nigeria"}, "round": "FIRST_ROUND"}' -H "Content-Type: application/json" | jq . ;
curl -X POST 'localhost:8080/api/matches' -d '{"homeTeam":{"id":3,"name":"Argentina"}, "awayTeam":{"id":6,"name":"Croacia"}, "round": "FIRST_ROUND"}' -H "Content-Type: application/json" | jq . ;
