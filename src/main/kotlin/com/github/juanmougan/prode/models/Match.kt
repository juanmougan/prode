package com.github.juanmougan.prode.models

import javax.persistence.*

@Entity
data class Match(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long,
                 @ManyToOne
                 val homeTeam: Team,
                 @ManyToOne
                 val awayTeam: Team,
                 val result: Result,
                 val round: Round)
