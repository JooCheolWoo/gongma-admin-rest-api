package kr.co.gongma.gongma_admin_rest_api.login.dto;

import kr.co.gongma.gongma_admin_rest_api.login.entity.AdminLoginHistory;

import java.time.LocalDateTime;

public record AdminLoginHistoryDto(
        Long id,
        Long adminId,
        LocalDateTime loginAt,
        String ipAddress

) {
    public static AdminLoginHistoryDto fromEntity(AdminLoginHistory adminLoginHistory) {
        return new AdminLoginHistoryDto(
                adminLoginHistory.getId(),
                adminLoginHistory.getAdminId(),
                adminLoginHistory.getLoginAt(),
                adminLoginHistory.getIpAddress()
        );
    }
}
