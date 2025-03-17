package com.kmj.portfolioadmin.admin.context.project.service

import com.kmj.portfolioadmin.admin.data.TableDTO
import com.kmj.portfolioadmin.admin.exception.AdminBadRequestException
import com.kmj.portfolioadmin.domain.entity.ExperienceDetail
import com.kmj.portfolioadmin.domain.entity.Project
import com.kmj.portfolioadmin.domain.repository.ProjectRepository
import org.springframework.stereotype.Service

@Service
class AdminProjectService(
    private val projectRepository: ProjectRepository
) {
    fun getProjectTable(): TableDTO{
        val classInfo = Project::class
        val entities = projectRepository.findAll()

        return TableDTO.from(classInfo, entities, "details")
    }

    fun getProjectTable(id: Long?): TableDTO{
        val classInfo = ExperienceDetail::class
        val entities = if(id != null) projectRepository.findById(id)
            .orElseThrow{ throw AdminBadRequestException("ID ${id}에 해당하는 데이터가 없습니다.") }
            .details else emptyList()

        return TableDTO.from(classInfo, entities)
    }
}