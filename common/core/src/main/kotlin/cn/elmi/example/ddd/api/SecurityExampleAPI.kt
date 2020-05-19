package cn.elmi.example.ddd.api

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import io.micronaut.security.annotation.Secured
import io.micronaut.security.authentication.Authentication
import io.micronaut.security.rules.SecurityRule

@Controller("security")
@Secured(SecurityRule.IS_AUTHENTICATED)
class SecurityExampleAPI {

    @Secured("ROLE_ADMIN", "ROLE_X")
    @Produces(MediaType.TEXT_PLAIN)
    @Get("/admin")
    fun withRoles() = "you have ROLE_ADMIN or ROLE_X roles"

    @Secured(SecurityRule.IS_ANONYMOUS)
    @Produces(MediaType.TEXT_PLAIN)
    @Get("/anonymous")
    fun anonymous() = "you are anonymous"

    @Produces(MediaType.TEXT_PLAIN)
    @Get("/authenticated")
    fun authenticated(authentication: Authentication) = "${authentication.name} is authenticated"
}