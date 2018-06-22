package com.github.juanmougan.prode.services

import com.github.juanmougan.prode.models.Bet
import com.github.juanmougan.prode.models.Match
import com.github.juanmougan.prode.repositories.BetsRepository
import org.springframework.stereotype.Service

@Service
class MatchesServiceImpl(
                        val betsRepository: BetsRepository
                        ) : MatchesService {
    override fun processBetsForMatch(match: Match) {
        val unfulfilledBets: List<Bet> = betsRepository.findAllByMatchWhereBetHasNotBeenPlayed(match)
        unfulfilledBets.forEach { b ->
            b.played = true
            b.counted = true
            if (match.result?.equals(b.result)!!) {
                b.pointsWon = 1
            }
        }
    }
}
