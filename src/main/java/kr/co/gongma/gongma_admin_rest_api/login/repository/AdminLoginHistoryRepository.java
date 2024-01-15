package kr.co.gongma.gongma_admin_rest_api.login.repository;

import kr.co.gongma.gongma_admin_rest_api.login.entity.AdminLoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminLoginHistoryRepository extends JpaRepository<AdminLoginHistory, Long> {
    List<AdminLoginHistory> findAllByAdminId(Long adminId);
}
