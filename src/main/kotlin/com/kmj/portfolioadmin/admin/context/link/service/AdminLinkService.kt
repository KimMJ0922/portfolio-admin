package com.kmj.portfolioadmin.admin.context.link.service

import com.kmj.portfolioadmin.admin.context.link.form.LinkForm
import com.kmj.portfolioadmin.admin.data.TableDTO
import com.kmj.portfolioadmin.domain.entity.Introduction
import com.kmj.portfolioadmin.domain.repository.LinkRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminLinkService (
    private val linkRepository: LinkRepository
) {
    fun getLinkTable(): TableDTO {
        val classInfo = Introduction::class
        val entities = linkRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }

    @Transactional
    fun save(form: LinkForm){
        val link = form.toEntity()
        linkRepository.save(link)
    }

    @Transactional
    fun update(id: Long, form: LinkForm){
        val link = form.toEntity(id)
        linkRepository.save(link)
    }
}