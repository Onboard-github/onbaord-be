package com.yapp.bol.admin.api.admin

import com.yapp.bol.admin.AdminService
import com.yapp.bol.admin.api.admin.dto.AdminPermissionListResponse
import com.yapp.bol.auth.getSecurityUserIdOrThrow
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AdminController(
    private val adminService: AdminService,
) {
    @GetMapping("/admin/v1/admin/permission")
    @PreAuthorize("isAuthenticated()")
    fun getAdminPermission(): AdminPermissionListResponse {
        val userId = getSecurityUserIdOrThrow()
        return AdminPermissionListResponse(adminService.getRoleList(userId))
    }
}
