package com.kmj.portfolioadmin.admin.interceptor

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView

@Component
class AdminInterceptor : HandlerInterceptor {
    override fun postHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        modelAndView: ModelAndView?
    ) {
        val menu = listOf<MenuDTO>(
            MenuDTO(
                name = "Index",
                page = listOf<PageDTO>(
                    PageDTO(name = "Introduction", url = "/admin/introduction"),
                    PageDTO(name = "Link", url = "/admin/link")
                )
            ),
            MenuDTO(
                name = "Resume",
                page = listOf<PageDTO>(
                    PageDTO(name = "Experience", url = "/admin/experience"),
                    PageDTO(name = "Achievement", url = "/admin/achievement"),
                    PageDTO(name = "Skill", url = "/admin/skill")
                )
            ),
            MenuDTO(
                name = "Project",
                page = listOf<PageDTO>(
                    PageDTO(name = "Project", url = "/admin/project"),
                    PageDTO(name = "ProjectSkill", url = "/admin/project/skill"),
                )
            )
        )

        modelAndView?.model?.put("menu", menu)
    }
}