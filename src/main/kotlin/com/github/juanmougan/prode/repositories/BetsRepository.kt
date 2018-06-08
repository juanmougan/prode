package com.github.juanmougan.prode.repositories

import com.github.juanmougan.prode.models.Bet
import com.github.juanmougan.prode.models.Match
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface BetsRepository : JpaRepository<Bet, Long> {
    @Query("SELECT b.* FROM bet b where b.match = :match and b.played = false")
    fun findAllByMatchWhereBetHasNotBeenPlayed(@Param("match") match: Match): List<Bet>
}
