package kr.co.gongma.gongma_admin_rest_api.admin.entity;

import jakarta.persistence.*;
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

    @Comment("이름")
    @Column(nullable = false, columnDefinition = "VARCHAR(10)")
    private String name;

    @Comment("전화번호")
    @Column(nullable = false, columnDefinition = "VARCHAR(11)")
    private String phoneNum;

    @Comment("직위")
    @Column(nullable = false, columnDefinition = "VARCHAR(10)")
    private String position;

    @Comment("소셜 제공자")
    @Column(columnDefinition = "VARCHAR(20)")
    private String provider;

    @Comment("소셜 제공자 ID")
    @Column(columnDefinition = "VARCHAR(100)")
    private String providerId;

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
}