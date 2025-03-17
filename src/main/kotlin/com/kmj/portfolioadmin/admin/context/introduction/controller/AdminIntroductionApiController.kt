package com.kmj.portfolioadmin.admin.context.introduction.controller

import com.kmj.portfolioadmin.admin.context.introduction.form.IntroductionForm
import com.kmj.portfolioadmin.admin.context.introduction.service.AdminIntroductionService
import com.kmj.portfolioadmin.admin.data.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/admin/api/introduction")
class AdminIntroductionApiController(
    private val adminIntroductionService: AdminIntroductionService
){
    @PostMapping
    fun postIntroduction(@RequestBody @Validated form: IntroductionForm) : ResponseEntity<Any>{
        adminIntroductionService.save(form)

        return ApiResponse.successCreate()
    }

    @PutMapping("/{id}")
    fun putIntroduction(@PathVariable id: Long, @RequestBody @Validated form: IntroductionForm) : ResponseEntity<Any>{
        adminIntroductionService.update(id, form)

        return ApiResponse.successUpdate()
    }
}