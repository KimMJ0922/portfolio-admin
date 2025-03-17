package com.kmj.portfolioadmin.admin.context.achievement.service

import com.kmj.portfolioadmin.admin.context.achievement.form.AchievementForm
import com.kmj.portfolioadmin.admin.data.TableDTO
import com.kmj.portfolioadmin.domain.entity.Achievement
import com.kmj.portfolioadmin.domain.repository.AchievementRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminAchievementService(
    private val achievementRepository: AchievementRepository
) {
    fun getAchievementTable(): TableDTO{
        val classInfo = Achievement::class
        val entities = achievementRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }

    @Transactional
    fun save(form: AchievementForm){
        val achievement = form.toEntity()
        achievementRepository.save(achievement)
    }

    @Transactional
    fun update(id: Long, form: AchievementForm){
        val achievement = form.toEntity(id)
        achievementRepository.save(achievement)
    }
}