package kr.co.gongma.gongma_admin_rest_api.admin.entity;

import jakarta.persistence.*;
import kr.co.gongma.gongma_admin_rest_api.common.code.StateCode;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("관리자번호")
    @Column(updatable = false, columnDefinition = "BIGINT(20) UNSIGNED")
    private Long id;

    @Comment("이메일")
    @Column(nullable = false, unique = true, columnDefinition = "VARCHAR(30)")
    private String email;

    @Comment("비밀번호")
    @Column(nullable = false, columnDefinition = "VARCHAR(150)")
    private String password;

    @Comment("관리자 상태")
    @Column(nullable = false, columnDefinition = "VARCHAR(20)")
    private String State;

    @Comment("생성일")
    @Column(nullable = false, columnDefinition = "DATETIME")
    @CreatedDate
    private LocalDateTime createdAt;

    @Comment("수정일")
    @Column(nullable = false, columnDefinition = "DATETIME")
    @CreatedDate
    private LocalDateTime updatedAt;

    @Comment("탈퇴일")
    @Column(columnDefinition = "DATETIME")
    private LocalDateTime deletedAt;

    public void updateState(StateCode stateCode) {
        this.State = stateCode.getCode();
    }
}
