package com.kmj.portfolioadmin.admin.context.experience.service

import com.kmj.portfolioadmin.admin.data.TableDTO
import com.kmj.portfolioadmin.admin.exception.AdminBadRequestException
import com.kmj.portfolioadmin.domain.entity.Experience
import com.kmj.portfolioadmin.domain.entity.ExperienceDetail
import com.kmj.portfolioadmin.domain.repository.ExperienceRepository
import org.springframework.stereotype.Service

@Service
class AdminExperienceService(
    private val experienceRepository: ExperienceRepository
) {
    fun getExperienceTable(): TableDTO{
        val classInfo = Experience::class
        val entities = experienceRepository.findAll()

        return TableDTO.from(classInfo, entities, "details")
    }

    fun getExperienceTable(id: Long?): TableDTO{
        val classInfo = ExperienceDetail::class
        val entities = if(id != null) experienceRepository.findById(id)
            .orElseThrow{ throw AdminBadRequestException("ID ${id}에 해당하는 데이터가 없습니다.") }
            .details else emptyList()

        return TableDTO.from(classInfo, entities)
    }
}