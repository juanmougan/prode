package com.github.juanmougan.prode.models

import javax.persistence.*

@Entity
data class Bet(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long,
               @ManyToOne
               val match: Match,
               val result: Result,
               @ManyToOne
               val player: Person,
               var played: Boolean,
               var counted: Boolean,
               var pointsWon: Int = 0)
