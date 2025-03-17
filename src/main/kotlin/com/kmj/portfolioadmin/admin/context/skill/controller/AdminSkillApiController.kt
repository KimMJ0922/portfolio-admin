package com.kmj.portfolioadmin.admin.context.skill.controller

import com.kmj.portfolioadmin.admin.context.skill.form.SkillForm
import com.kmj.portfolioadmin.admin.context.skill.service.AdminSkillService
import com.kmj.portfolioadmin.admin.data.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/admin/api/skill")
class AdminSkillApiController(
    private val adminSkillService: AdminSkillService
){
    @PostMapping
    fun postLink(@RequestBody @Validated form: SkillForm) : ResponseEntity<Any>{
        adminSkillService.save(form)

        return ApiResponse.successCreate()
    }

    @PutMapping("/{id}")
    fun putLink(@PathVariable id: Long, @RequestBody @Validated form: SkillForm) : ResponseEntity<Any>{
        adminSkillService.update(id, form)

        return ApiResponse.successUpdate()
    }
}