package com.github.juanmougan.prode.models

import javax.persistence.*

@Entity
class Bet() {
    constructor(id: Long,
                match: Match,
                result: Result,
                player: Person,
                played: Boolean,
                counted: Boolean,
                pointsWon: Int
                ): this() {
        this.id = id
        this.match = match
        this.result = result
        this.player = player
        this.played = played
        this.counted = counted
        this.pointsWon = pointsWon
    }

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
    @ManyToOne
    lateinit var match: Match
    lateinit var result: Result
    @ManyToOne
    lateinit var player: Person
    var played: Boolean = false
    var counted: Boolean = false
    var pointsWon: Int = 0
}
