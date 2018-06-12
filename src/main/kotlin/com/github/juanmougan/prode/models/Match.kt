package com.github.juanmougan.prode.models

import javax.persistence.*

@Entity
data class Match(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long = 0,
                 @ManyToOne
                 var homeTeam: Team? = null,
                 @ManyToOne
                 var awayTeam: Team? = null,
                 var result: Result? = null,
                 var round: Round? = null)
