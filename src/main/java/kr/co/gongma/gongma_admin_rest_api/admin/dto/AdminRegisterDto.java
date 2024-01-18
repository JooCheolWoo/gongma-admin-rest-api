package kr.co.gongma.gongma_admin_rest_api.admin.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import kr.co.gongma.gongma_admin_rest_api.admin.entity.Admin;
import kr.co.gongma.gongma_admin_rest_api.common.util.CommonUtil;

public record AdminRegisterDto(
        @Email(message = "올바른 형식의 이메일을 입력하세요.")
        String email,
        @NotBlank(message = "비밀번호를 입력하세요.")
        String password
) {
    public Admin toEntity() {
        return Admin.builder()
                .email(email)
                .password(CommonUtil.encryptPassword(password))
                .build();
    }
}
