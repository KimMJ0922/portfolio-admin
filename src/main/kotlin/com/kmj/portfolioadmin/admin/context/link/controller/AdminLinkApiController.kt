package com.kmj.portfolioadmin.admin.context.link.controller

import com.kmj.portfolioadmin.admin.context.link.form.LinkForm
import com.kmj.portfolioadmin.admin.context.link.service.AdminLinkService
import com.kmj.portfolioadmin.admin.data.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/admin/api/link")
class AdminLinkApiController(
    private val adminLinkService: AdminLinkService
){
    @PostMapping
    fun postLink(@RequestBody @Validated form: LinkForm) : ResponseEntity<Any>{
        adminLinkService.save(form)

        return ApiResponse.successCreate()
    }

    @PutMapping("/{id}")
    fun putLink(@PathVariable id: Long, @RequestBody @Validated form: LinkForm) : ResponseEntity<Any>{
        adminLinkService.update(id, form)

        return ApiResponse.successUpdate()
    }
}