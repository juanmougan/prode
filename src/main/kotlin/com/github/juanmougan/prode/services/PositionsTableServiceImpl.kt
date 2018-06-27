package com.github.juanmougan.prode.services

import com.github.juanmougan.prode.models.Bet
import com.github.juanmougan.prode.models.Person
import com.github.juanmougan.prode.models.Position
import com.github.juanmougan.prode.repositories.BetsRepository
import com.github.juanmougan.prode.repositories.PeopleRepository
import org.springframework.stereotype.Service

@Service
class PositionsTableServiceImpl(private val betsRepository: BetsRepository,
                                private val peopleRepository: PeopleRepository) : PositionsTableService {
    override fun refreshPositionsTable(): List<Position> {
        // 1. Get all bets
        val allBets: List<Bet> = betsRepository.findAll()
        // 2. Count the points won by each player
        val betsByPlayer: Map<Person, List<Bet>> = allBets.groupBy { it.player }
        val positions: MutableList<Position> = mutableListOf()
        betsByPlayer.mapKeys { playerBet ->
            val player = playerBet.key
            val points = betsByPlayer[player]!!.sumBy { bet -> bet.pointsWon }
            val position = Position(player, points ?: 0)
            positions.add(position)
        }
        // 3. Return a list ordered by points desc
        positions.sortBy { it.points }
        return positions
    }
}
