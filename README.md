### Some examples

- To list all the people

    `curl -X POST 'localhost:8080/api/people' -d '{"name":"Juan Manuel"}' -H "Content-Type: application/json" | jq .`

- To create a new Person

    `curl 'localhost:8080/api/people' | jq .`

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
