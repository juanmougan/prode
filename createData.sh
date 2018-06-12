# Create people
curl -X POST 'localhost:8080/api/people' -d '{"name":"Juan Manuel"}' -H "Content-Type: application/json" | jq . ;
curl -X POST 'localhost:8080/api/people' -d '{"name":"Pepito"}' -H "Content-Type: application/json" | jq . ;

# Create teams
curl -X POST 'localhost:8080/api/teams' -d '{"name":"Argentina"}' -H "Content-Type: application/json" | jq . ;
curl -X POST 'localhost:8080/api/teams' -d '{"name":"Islandia"}' -H "Content-Type: application/json" | jq . ;
curl -X POST 'localhost:8080/api/teams' -d '{"name":"Nigeria"}' -H "Content-Type: application/json" | jq . ;
curl -X POST 'localhost:8080/api/teams' -d '{"name":"Croacia"}' -H "Content-Type: application/json" | jq . ;
