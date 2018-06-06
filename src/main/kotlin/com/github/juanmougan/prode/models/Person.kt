package com.github.juanmougan.prode.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Person(
        // TODO is there any better way than using defaults?
        @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long = 0,
        val name: String = ""
)
