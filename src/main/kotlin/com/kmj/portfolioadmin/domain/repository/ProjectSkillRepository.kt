package com.kmj.portfolioadmin.domain.repository

import com.kmj.portfolioadmin.domain.entity.ProjectSkill
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ProjectSkillRepository: JpaRepository<ProjectSkill, Long> {

    fun findByProjectIdAndSkillId(projectId: Long, skillId: Long): Optional<ProjectSkill>

}