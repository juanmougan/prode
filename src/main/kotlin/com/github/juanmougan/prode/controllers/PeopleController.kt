package com.github.juanmougan.prode.controllers

import com.github.juanmougan.prode.models.Person
import com.github.juanmougan.prode.repositories.PeopleRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class PeopleController(val peopleRepository: PeopleRepository) {

    @GetMapping("/people")
    fun getAll() : List<Person> = peopleRepository.findAll()

    @PostMapping("/people")
    fun create(@Valid @RequestBody person: Person): Person = peopleRepository.save(person)

    @GetMapping("/people/{id}")
    fun getById(@PathVariable(value = "id") personId: Long): ResponseEntity<Person> {
        return peopleRepository.findById(personId).map { person ->
            ResponseEntity.ok(person)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/people/{id}")
    fun updateById(@PathVariable(value = "id") personId: Long,
                   @Valid @RequestBody newPerson: Person): ResponseEntity<Person> {
        return peopleRepository.findById(personId).map { existingPerson ->
            val updatedPerson: Person = existingPerson
                    .copy(name = newPerson.name)
            ResponseEntity.ok().body(peopleRepository.save(updatedPerson))
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/people/{id}")
    fun deleteById(@PathVariable(value = "id") personId: Long): ResponseEntity<Void> {

        return peopleRepository.findById(personId).map { person  ->
            peopleRepository.delete(person)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())

    }

}
