package com.github.juanmougan.prode.controllers

import com.github.juanmougan.prode.models.Person
import com.github.juanmougan.prode.repositories.PeopleRepository
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class PeopleController(val peopleRepository: PeopleRepository) {

    @GetMapping("/people")
    fun getAll() : List<Person> = peopleRepository.findAll()

    @PostMapping("/people")
    fun create(@Valid @RequestBody person: Person): Person = peopleRepository.save(person)

}
