package kr.co.gongma.gongma_admin_rest_api.common.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProviderCode {

    GOOGLE("GOOGLE", "구글"),
    KAKAO("KAKAO", "카카오"),
    GONGMA("GONGMA", "공마학원");

    private final String code;
    private final String name;
}

