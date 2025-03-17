package com.kmj.portfolioadmin.domain.repository

import com.kmj.portfolioadmin.domain.entity.HttpInterface
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

interface HttpInterfaceRepository: JpaRepository<HttpInterface, Long> {

    fun countAllByRegDateBetween(start: LocalDateTime, end: LocalDateTime): Long
}