package com.github.juanmougan.prode.services

import com.github.juanmougan.prode.models.Match
import com.github.juanmougan.prode.repositories.BetsRepository
import org.springframework.stereotype.Service;

@Service("messageService")
class MatchesServiceImpl(
                        val betsRepository: BetsRepository
                        ) : MatchesService {
    // Fetch Bets unfulfilled (played = false) for this Match
    // for each Bet
    //  Mark as match played true
    //  Mark as counted
    //  If are points won
    //      Set points won for this Bet (need to add the attribute)
    // fun processBetsForMatch(match: Match)
    override fun processBetsForMatch(match: Match) {
        val unfulfilledBets = betsRepository.findAllByMatchWhereBetHasNotBeenPlayed(match)
        unfulfilledBets.forEach { b ->
            b.played = true
            b.counted = true
            if (match.result?.equals(b.result)!!) {
                b.pointsWon = 1
            }
        }
    }
}
