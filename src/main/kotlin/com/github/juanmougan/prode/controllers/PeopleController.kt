package com.github.juanmougan.prode.controllers

import com.github.juanmougan.prode.models.Person
import com.github.juanmougan.prode.repositories.PeopleRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/people")
class PeopleController(val peopleRepository: PeopleRepository) {

    @GetMapping("/")
    fun getAll() : List<Person> = peopleRepository.findAll()

    @PostMapping("/")
    fun create(@RequestBody person: Person): Person {
        return peopleRepository.save(person)
    }

}
