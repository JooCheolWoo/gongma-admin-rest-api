package kr.co.gongma.gongma_admin_rest_api.admin.service;

import kr.co.gongma.gongma_admin_rest_api.admin.dto.AdminRegisterDto;
import kr.co.gongma.gongma_admin_rest_api.admin.dto.AdminResponseDto;
import kr.co.gongma.gongma_admin_rest_api.admin.entity.Admin;
import kr.co.gongma.gongma_admin_rest_api.admin.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdminWriteService {

    private final AdminRepository adminRepository;

    @Transactional
    public AdminResponseDto create(AdminRegisterDto request) {
        Admin admin = request.toEntity();
        adminRepository.save(admin);
        return AdminResponseDto.fromEntity(admin);
    }
}
