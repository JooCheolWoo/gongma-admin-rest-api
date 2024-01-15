package kr.co.gongma.gongma_admin_rest_api.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    OK("성공", "Success", 0, "정상 처리되었습니다."),

    /**
     * 회원정보 (1000)
     */

    EMAIL_ALREADY_EXIST("회원가입 오류", "DuplicateException", 1001, "이미 가입된 이메일입니다."),
    NICKNAME_ALREADY_EXIST("회원가입 오류", "DuplicateException", 1002, "이미 사용중인 닉네임입니다."),
    NOT_EXIST_EMAIL("로그인 오류", "NotFoundException", 1003, "등록되지 않은 이메일입니다."),
    NOT_EXIST_NICKNAME("로그인 오류", "NotMatchException", 1004, "비밀번호가 틀렸습니다.");


    private final String title;
    private final String type;
    private final int code;
    private final String message;
}
