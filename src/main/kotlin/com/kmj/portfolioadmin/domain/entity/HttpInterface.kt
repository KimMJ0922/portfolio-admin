package com.kmj.portfolioadmin.domain.entity

import jakarta.persistence.*
import jakarta.servlet.http.HttpServletRequest

@Entity
class HttpInterface(
    httpServletRequest: HttpServletRequest
): BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "http_interface_id")
    var id: Long? = null

    var cookies: String? = httpServletRequest.cookies?.map{ "${it.name}:${it.value}"}?.toString()

    var referer: String? = httpServletRequest.getHeader("referer")

    var localAddress: String? = httpServletRequest.localAddr

    var remoteAddress: String? = httpServletRequest.remoteAddr

    var remoteHost: String? = httpServletRequest.remoteHost

    var requestUri: String? = httpServletRequest.requestURI

    var userAgent: String? = httpServletRequest.getHeader("user-agent")
}