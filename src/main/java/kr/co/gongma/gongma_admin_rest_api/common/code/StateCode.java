package kr.co.gongma.gongma_admin_rest_api.common.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StateCode {

    PENDING("GSC000", "승인대기"),
    NORMAL("GSC001", "정상"),
    SUSPENDED("GSC002", "정지"),
    DELETED("GSC003", "탈퇴");

    private final String code;
    private final String name;
}
