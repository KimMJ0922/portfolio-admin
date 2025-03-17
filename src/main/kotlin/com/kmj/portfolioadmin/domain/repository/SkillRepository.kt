package com.kmj.portfolioadmin.domain.repository

import com.kmj.portfolioadmin.domain.constant.SkillType
import com.kmj.portfolioadmin.domain.entity.Skill
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface SkillRepository: JpaRepository<Skill, Long> {

    fun findAllByIsActive(isActive: Boolean): List<Skill>

    fun findByNameIgnoreCaseAndType(name: String, type: SkillType): Optional<Skill>


}