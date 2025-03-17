package com.kmj.portfolioadmin.domain.repository

import com.kmj.portfolioadmin.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface ProjectRepository: JpaRepository<Project, Long> {

    @Query("select p from Project p left join fetch p.skills where p.isActive = :isActive")
    fun findAllByIsActive(isActive: Boolean): List<Project>

    @Query("select p from Project p left join fetch p.details where p.id = :id")
    override fun findById(id: Long): Optional<Project>

}