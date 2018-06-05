package com.github.juanmougan.prode.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Bet(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long, val match: Match, val result: Result, val player: Person,
               val played: Boolean, val counted: Boolean)