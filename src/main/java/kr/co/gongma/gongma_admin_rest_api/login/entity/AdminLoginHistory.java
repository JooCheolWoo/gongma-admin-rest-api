package kr.co.gongma.gongma_admin_rest_api.login.entity;

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
@Table(name = "admin_login_history")
public class AdminLoginHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("로그인 이력 번호")
    @Column(updatable = false, columnDefinition = "BIGINT(20) UNSIGNED")
    private Long id;

    @Comment("로그인 관리자 번호")
    @Column(updatable = false, nullable = false, columnDefinition = "BIGINT(20) UNSIGNED")
    private Long adminId;

    @Comment("로그인 일시")
    @CreatedDate
    @Column(updatable = false, nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime loginAt;

   @Comment("로그인 IP")
   @Column(updatable = false, nullable = false, columnDefinition = "VARCHAR(50)")
   private String ipAddress;
}
