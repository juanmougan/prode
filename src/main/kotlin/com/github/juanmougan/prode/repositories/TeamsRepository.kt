package com.github.juanmougan.prode.repositories

import com.github.juanmougan.prode.models.Team
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TeamsRepository : JpaRepository<Team, Long>
