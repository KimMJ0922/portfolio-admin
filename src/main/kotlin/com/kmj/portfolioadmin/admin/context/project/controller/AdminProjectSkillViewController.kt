package com.kmj.portfolioadmin.admin.context.project.controller

import com.kmj.portfolioadmin.admin.context.project.service.AdminProjectSkillService
import com.kmj.portfolioadmin.admin.data.FormElementDTO
import com.kmj.portfolioadmin.admin.data.SelectFormElementDTO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/project/skill")
class AdminProjectSkillViewController(
    private val adminProjectSkillService: AdminProjectSkillService
){
    @GetMapping("/")
    fun project(model: Model): String {
        val projectList = adminProjectSkillService.getProjectList()
        val skillList = adminProjectSkillService.getSkillList()

        val formElement = listOf<FormElementDTO>(
            SelectFormElementDTO("project", 8, projectList),
            SelectFormElementDTO("skill", 8, skillList)
        )

        model.addAttribute("formElement", formElement)

        val table = adminProjectSkillService.getProjectSkillTable()
        model.addAttribute("table", table)
        model.addAttribute("detailTable", null)

        val pageAttributes = mutableMapOf<String, Any>(
            Pair("menuName", "Projects"),
            Pair("pageName", table.name),
            Pair("editable", false),
            Pair("deletable", true),
            Pair("hasDetails", false),
        )

        model.addAllAttributes(pageAttributes)

        return "admin/page"
    }
}