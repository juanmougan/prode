package com.github.juanmougan.prode.services

import com.github.juanmougan.prode.models.Match

interface MatchesService {
    fun processBetsForMatch(match: Match)
}
