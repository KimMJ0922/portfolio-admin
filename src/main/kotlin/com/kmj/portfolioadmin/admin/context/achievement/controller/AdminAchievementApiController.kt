package com.kmj.portfolioadmin.admin.context.achievement.controller

import com.kmj.portfolioadmin.admin.context.achievement.form.AchievementForm
import com.kmj.portfolioadmin.admin.context.achievement.service.AdminAchievementService
import com.kmj.portfolioadmin.admin.data.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/admin/api/achievements")
class AdminAchievementApiController(
    private val adminAchievementService: AdminAchievementService
){
    @PostMapping
    fun postAchievement(@RequestBody @Validated form: AchievementForm) : ResponseEntity<Any>{
        adminAchievementService.save(form)

        return ApiResponse.successCreate()
    }

    @PutMapping("/{id}")
    fun putAchievement(@PathVariable id: Long, @RequestBody @Validated form: AchievementForm) : ResponseEntity<Any>{
        adminAchievementService.update(id, form)

        return ApiResponse.successUpdate()
    }
}