package kr.co.gongma.gongma_admin_rest_api.admin.dto;

import kr.co.gongma.gongma_admin_rest_api.admin.entity.Admin;

import java.time.LocalDateTime;

public record AdminResponseDto(
        Long id,
        String email,
        String name,
        String position,
        String phoneNum,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static AdminResponseDto fromEntity(Admin admin) {
        return new AdminResponseDto(
                admin.getId(),
                admin.getEmail(),
                admin.getName(),
                admin.getPosition(),
                admin.getPhoneNum(),
                admin.getCreatedAt(),
                admin.getUpdatedAt()
        );
    }
}
