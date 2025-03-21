package com.kmj.portfolioadmin.admin.context.link.controller

import com.kmj.portfolioadmin.admin.context.link.service.AdminLinkService
import com.kmj.portfolioadmin.admin.data.FormElementDTO
import com.kmj.portfolioadmin.admin.data.SelectFormElementDTO
import com.kmj.portfolioadmin.admin.data.TextFormElementDTO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/link")
class AdminLinkViewController(
    private val linkService: AdminLinkService
){
    @GetMapping("/")
    fun link(model: Model): String {
        val formElement = listOf<FormElementDTO>(
            TextFormElementDTO("name", 2),
            TextFormElementDTO("content", 8),
            SelectFormElementDTO("isActive", 2, listOf(true.toString(), false.toString()))
        )

        model.addAttribute("formElement", formElement)

        val table = linkService.getLinkTable()
        model.addAttribute("table", table)
        model.addAttribute("detailTable", null)

        val pageAttributes = mutableMapOf<String, Any>(
            Pair("menuName", "Link"),
            Pair("pageName", table.name),
            Pair("editable", true),
            Pair("deletable", false),
            Pair("hasDetails", false),
        )

        model.addAllAttributes(pageAttributes)

        return "admin/page"
    }
}