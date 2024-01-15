package kr.co.gongma.gongma_admin_rest_api.login.service;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.gongma.gongma_admin_rest_api.login.dto.AdminLoginDto;
import kr.co.gongma.gongma_admin_rest_api.admin.dto.AdminResponseDto;
import kr.co.gongma.gongma_admin_rest_api.admin.entity.Admin;
import kr.co.gongma.gongma_admin_rest_api.login.entity.AdminLoginHistory;
import kr.co.gongma.gongma_admin_rest_api.login.repository.AdminLoginHistoryRepository;
import kr.co.gongma.gongma_admin_rest_api.admin.repository.AdminRepository;
import kr.co.gongma.gongma_admin_rest_api.exception.ApiException;
import kr.co.gongma.gongma_admin_rest_api.exception.ErrorCode;
import kr.co.gongma.gongma_admin_rest_api.common.util.CommonUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminLoginWriteService {

    private final AdminRepository adminRepository;
    private final AdminLoginHistoryRepository adminLoginHistoryRepository;

    public AdminResponseDto login(AdminLoginDto request, HttpServletRequest httpServletRequest) throws ApiException {

        Admin admin = adminRepository.findByEmail(request.email())
                .orElseThrow(() -> new ApiException(ErrorCode.NOT_EXIST_EMAIL));

        AdminLoginHistory adminLoginHistory = AdminLoginHistory.builder()
                .adminId(admin.getId())
                .ipAddress(CommonUtil.getClientIP(httpServletRequest))
                .build();

        adminLoginHistoryRepository.save(adminLoginHistory);

        return AdminResponseDto.fromEntity(admin);
    }
}
