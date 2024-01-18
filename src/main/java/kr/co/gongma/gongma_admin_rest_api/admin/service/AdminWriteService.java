package kr.co.gongma.gongma_admin_rest_api.admin.service;

import kr.co.gongma.gongma_admin_rest_api.admin.dto.AdminRegisterDto;
import kr.co.gongma.gongma_admin_rest_api.admin.dto.AdminResponseDto;
import kr.co.gongma.gongma_admin_rest_api.admin.entity.Admin;
import kr.co.gongma.gongma_admin_rest_api.admin.repository.AdminRepository;
import kr.co.gongma.gongma_admin_rest_api.common.code.StateCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdminWriteService {

    private final AdminRepository adminRepository;

    /**
     * 회원가입
     * @param request 이메일 / 비밀번호
     * @return 회원정보
     */
    @Transactional
    public AdminResponseDto create(AdminRegisterDto request) {
        Admin admin = request.toEntity();

        // 최초 가입시 승인대기 상태
        admin.updateState(StateCode.PENDING);

        adminRepository.save(admin);

        return AdminResponseDto.fromEntity(admin);
    }
}
