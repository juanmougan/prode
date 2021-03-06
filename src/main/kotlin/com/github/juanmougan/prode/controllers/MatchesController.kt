package com.github.juanmougan.prode.controllers

import com.github.juanmougan.prode.models.Match
import com.github.juanmougan.prode.repositories.MatchesRepository
import com.github.juanmougan.prode.services.MatchesService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class MatchesController(private val matchesRepository: MatchesRepository, 
                        private val matchesService: MatchesService) {

    @GetMapping("/matches")
    fun getAll() : List<Match> = matchesRepository.findAll()

    @PostMapping("/matches")
    fun create(@Valid @RequestBody match: Match): Match = matchesRepository.save(match)

    @GetMapping("/matches/{id}")
    fun getById(@PathVariable(value = "id") matchId: Long): ResponseEntity<Match> {
        return matchesRepository.findById(matchId).map { match ->
            ResponseEntity.ok(match)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/matches/{id}")
    fun updateById(@PathVariable(value = "id") matchId: Long,
                   @Valid @RequestBody newMatch: Match): ResponseEntity<Match> {
        return matchesRepository.findById(matchId).map { existingMatch ->
            val updatedMatch: Match = existingMatch
                    .copy(result = newMatch.result)
            matchesService.processBetsForMatch(updatedMatch)
            ResponseEntity.ok().body(matchesRepository.save(updatedMatch))
        }.orElse(ResponseEntity.notFound().build())
    }

}