package com.github.juanmougan.prode.controllers

import com.github.juanmougan.prode.models.Bet
import com.github.juanmougan.prode.repositories.BetsRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class BetsController(private val betsRepository: BetsRepository) {

    @GetMapping("/bets")
    fun getAll() : List<Bet> = betsRepository.findAll()

    @PostMapping("/bets")
    fun create(@Valid @RequestBody bet: Bet): Bet = betsRepository.save(bet)

    @GetMapping("/bets/{id}")
    fun getById(@PathVariable(value = "id") betId: Long): ResponseEntity<Bet> {
        return betsRepository.findById(betId).map { bet ->
            ResponseEntity.ok(bet)
        }.orElse(ResponseEntity.notFound().build())
    }

}