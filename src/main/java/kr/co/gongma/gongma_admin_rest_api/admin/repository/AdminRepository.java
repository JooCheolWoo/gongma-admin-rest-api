package kr.co.gongma.gongma_admin_rest_api.admin.repository;

import kr.co.gongma.gongma_admin_rest_api.admin.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Optional<Admin> findByEmail(String email);
}
