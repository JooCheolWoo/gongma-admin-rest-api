package kr.co.gongma.gongma_admin_rest_api.admin.dto;

import kr.co.gongma.gongma_admin_rest_api.admin.entity.Admin;
import kr.co.gongma.gongma_admin_rest_api.common.code.ProviderCode;
import kr.co.gongma.gongma_admin_rest_api.common.util.CommonUtil;

public record AdminRegisterDto(
        String email,
        String password,
        String name,
        String phoneNum,
        String position,
        String provider,
        String providerId
) {
    public Admin toEntity() {
        return Admin.builder()
                .email(email)
                .password(CommonUtil.encryptPassword(password))
                .name(name)
                .phoneNum(phoneNum)
                .position(position)
                .provider(ProviderCode.GONGMA.getCode())
                .build();
    }
}
