package com.github.juanmougan.prode.services

import org.springframework.stereotype.Service;

@Service("messageService")
class MatchesServiceImpl {
    // Fetch Bets unfulfilled (played = false) for this Match
    // for each Bet
    //  Mark as match played true
    //  Mark as counted
    //  If are points won
    //      Set points won for this Bet (need to add the attribute)
    // fun processBetsForMatch(match: Match)
}