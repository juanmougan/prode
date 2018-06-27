package com.github.juanmougan.prode.services

import com.github.juanmougan.prode.models.Position

interface PositionsTableService {
    fun refreshPositionsTable(): List<Position>
}
