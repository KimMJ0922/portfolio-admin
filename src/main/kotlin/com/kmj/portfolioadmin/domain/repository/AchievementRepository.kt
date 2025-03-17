package com.kmj.portfolioadmin.domain.repository

import com.kmj.portfolioadmin.domain.entity.Achievement
import org.springframework.data.jpa.repository.JpaRepository

interface AchievementRepository: JpaRepository<Achievement, Long> {

    fun findAllByIsActive(isActive: Boolean): List<Achievement>

}