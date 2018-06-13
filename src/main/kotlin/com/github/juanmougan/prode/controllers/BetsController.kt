package com.github.juanmougan.prode.controllers

import com.github.juanmougan.prode.models.Bet
import com.github.juanmougan.prode.models.Match
import com.github.juanmougan.prode.models.Person
import com.github.juanmougan.prode.repositories.BetsRepository
import com.github.juanmougan.prode.repositories.MatchesRepository
import com.github.juanmougan.prode.repositories.PeopleRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class BetsController(private val betsRepository: BetsRepository,
                     private val matchesRepository: MatchesRepository,
                     private val peopleRepository: PeopleRepository) {

    @GetMapping("/bets")
    fun getAll() : List<Bet> = betsRepository.findAll()

    @PostMapping("/bets")
    fun create(@Valid @RequestBody bet: Bet): Bet {
        val match: Match? = matchesRepository.getOne(bet.match.id)
        val player: Person? = peopleRepository.getOne(bet.player.id)
        bet.match = match
        bet.player = player
        return betsRepository.save(bet)
    }

    @GetMapping("/bets/{id}")
    fun getById(@PathVariable(value = "id") betId: Long): ResponseEntity<Bet> {
        return betsRepository.findById(betId).map { bet ->
            ResponseEntity.ok(bet)
        }.orElse(ResponseEntity.notFound().build())
    }

}