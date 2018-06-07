package com.github.juanmougan.prode.repositories

import com.github.juanmougan.prode.models.Match
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MatchesRepository : JpaRepository<Match, Long>
