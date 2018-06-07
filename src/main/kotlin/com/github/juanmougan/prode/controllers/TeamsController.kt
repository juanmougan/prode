package com.github.juanmougan.prode.controllers

import com.github.juanmougan.prode.models.Person
import com.github.juanmougan.prode.models.Team
import com.github.juanmougan.prode.repositories.TeamsRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class TeamsController(private val teamsRepository: TeamsRepository) {

    @GetMapping("/teams")
    fun getAll() : List<Team> = teamsRepository.findAll()

    @PostMapping("/teams")
    fun create(@Valid @RequestBody team: Team): Team = teamsRepository.save(team)

    @GetMapping("/teams/{id}")
    fun getById(@PathVariable(value = "id") teamId: Long): ResponseEntity<Team> {
        return teamsRepository.findById(teamId).map { team ->
            ResponseEntity.ok(team)
        }.orElse(ResponseEntity.notFound().build())
    }

}