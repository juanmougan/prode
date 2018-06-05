package com.github.juanmougan.prode.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Match(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long, val homeTeam: Team, val awayTeam: Team, val result: Result,
                 val round: Round)
