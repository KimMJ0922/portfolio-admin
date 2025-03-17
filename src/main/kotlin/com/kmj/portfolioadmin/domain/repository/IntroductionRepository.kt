package com.kmj.portfolioadmin.domain.repository

import com.kmj.portfolioadmin.domain.entity.Introduction
import org.springframework.data.jpa.repository.JpaRepository

interface IntroductionRepository: JpaRepository<Introduction, Long> {

    fun findAllByIsActive(isActive: Boolean): List<Introduction>

}