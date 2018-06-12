package com.github.juanmougan.prode.repositories

import com.github.juanmougan.prode.models.Bet
import com.github.juanmougan.prode.models.Match
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

/*
id: Long,
               @ManyToOne
               val match: Match,
               val result: Result,
               @ManyToOne
               val player: Person,
               var played: Boolean,
               var counted: Boolean,
               var pointsWon: Int = 0
* */
interface BetsRepository : JpaRepository<Bet, Long> {
    @Query("SELECT b.id, b.match, b.result, b.player, b.played, b.counted, b.pointsWon " +
            "FROM Bet b where b.match = :match and b.played = false")
    fun findAllByMatchWhereBetHasNotBeenPlayed(@Param("match") match: Match): List<Bet>
}
