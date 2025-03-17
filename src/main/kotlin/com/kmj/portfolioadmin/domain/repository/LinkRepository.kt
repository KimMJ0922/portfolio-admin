package com.kmj.portfolioadmin.domain.repository

import com.kmj.portfolioadmin.domain.entity.Link
import org.springframework.data.jpa.repository.JpaRepository

interface LinkRepository: JpaRepository<Link, Long> {

    fun findAllByIsActive(isActive: Boolean): List<Link>

}