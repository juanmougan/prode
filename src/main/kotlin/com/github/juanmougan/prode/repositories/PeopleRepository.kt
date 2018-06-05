package com.github.juanmougan.prode.repositories

import com.github.juanmougan.prode.models.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PeopleRepository : JpaRepository<Person, Long>
