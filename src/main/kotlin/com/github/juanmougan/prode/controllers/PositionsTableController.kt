package com.github.juanmougan.prode.controllers

import com.github.juanmougan.prode.models.Position
import com.github.juanmougan.prode.services.PositionsTableService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PositionsTableController(private val positionsTableService: PositionsTableService) {
    @GetMapping("/positions")
    fun getAll() : List<Position> = positionsTableService.refreshPositionsTable()
}
