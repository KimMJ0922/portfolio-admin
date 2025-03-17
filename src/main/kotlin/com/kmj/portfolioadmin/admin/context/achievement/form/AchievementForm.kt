package com.kmj.portfolioadmin.admin.context.achievement.form

import com.kmj.portfolioadmin.domain.entity.Achievement
import jakarta.validation.constraints.NotBlank
import java.time.LocalDate

data class AchievementForm(
    @field:NotBlank(message = "필수값입니다.")
    val title: String,
    val description: String,
    val host: String,
    val achievementDate: String,
    val isActive: Boolean
) {
    fun toEntity(): Achievement {
        return Achievement(
            title = this.title,
            description = this.description,
            host = this.host,
            achievedDate = LocalDate.parse(this.achievementDate),
            isActive = this.isActive
        )
    }

    fun toEntity(id: Long): Achievement{
        val achievement = this.toEntity()
        achievement.id = id
        return achievement
    }
}