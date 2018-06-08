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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}