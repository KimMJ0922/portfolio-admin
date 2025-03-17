package com.kmj.portfolioadmin.admin.context.skill.controller

import com.kmj.portfolioadmin.admin.context.skill.service.AdminSkillService
import com.kmj.portfolioadmin.admin.data.FormElementDTO
import com.kmj.portfolioadmin.admin.data.SelectFormElementDTO
import com.kmj.portfolioadmin.admin.data.TextFormElementDTO
import com.kmj.portfolioadmin.domain.constant.SkillType
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/skill")
class AdminSkillViewController(
    private val skillService: AdminSkillService
){
    @GetMapping("/")
    fun link(model: Model): String {
        val formElement = listOf<FormElementDTO>(
            TextFormElementDTO("name", 2),
            SelectFormElementDTO("type", 2, SkillType.entries.map { it.name }.toList()),
            SelectFormElementDTO("isActive", 2, listOf(true.toString(), false.toString()))
        )

        model.addAttribute("formElement", formElement)

        val table = skillService.getSkillTable()
        model.addAttribute("table", table)
        model.addAttribute("detailTable", null)

        val pageAttributes = mutableMapOf<String, Any>(
            Pair("menuName", "Resume"),
            Pair("pageName", table.name),
            Pair("editable", true),
            Pair("deletable", false),
            Pair("hasDetails", false),
        )

        model.addAllAttributes(pageAttributes)

        return "admin/page"
    }
}