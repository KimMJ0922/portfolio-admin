package com.kmj.portfolioadmin.admin.context.project.controller

import com.kmj.portfolioadmin.admin.context.project.service.AdminProjectService
import com.kmj.portfolioadmin.admin.data.FormElementDTO
import com.kmj.portfolioadmin.admin.data.SelectFormElementDTO
import com.kmj.portfolioadmin.admin.data.TextFormElementDTO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.time.LocalDateTime

@Controller
@RequestMapping("/admin/project")
class AdminProjectViewController(
    private val adminProjectService: AdminProjectService
){
    @GetMapping("/")
    fun project(model: Model): String {
        val nowYear = LocalDateTime.now().year - 1
        val formElement = listOf<FormElementDTO>(
            TextFormElementDTO("name", 4),
            TextFormElementDTO("description", 8),
            SelectFormElementDTO("startYear", 3, (2020..nowYear).toList()),
            SelectFormElementDTO("startMonth", 2, (1..12).toList()),
            SelectFormElementDTO("endYear", 3, (2020..nowYear).toList()),
            SelectFormElementDTO("endMonth", 2, (1..12).toList()),
            SelectFormElementDTO("isActive", 2, listOf(true.toString(), false.toString()))
        )

        model.addAttribute("formElement", formElement)

        val detailFormElement = listOf<FormElementDTO>(
            TextFormElementDTO("content", 4),
            TextFormElementDTO("url", 6),
            SelectFormElementDTO("isActive", 2, listOf(true.toString(), false.toString())),
        )
        model.addAttribute("detailFormElement", detailFormElement)

        val table = adminProjectService.getProjectTable()
        model.addAttribute("table", table)

        val detailTable = adminProjectService.getProjectTable(null)

        model.addAttribute("detailTable", detailTable)

        val pageAttributes = mutableMapOf<String, Any>(
            Pair("menuName", "Project"),
            Pair("pageName", table.name),
            Pair("editable", true),
            Pair("deletable", false),
            Pair("hasDetails", true),
        )

        model.addAllAttributes(pageAttributes)

        return "admin/page"
    }
}