package kr.co.gongma.gongma_admin_rest_api.login.service;

import kr.co.gongma.gongma_admin_rest_api.exception.ApiException;
import kr.co.gongma.gongma_admin_rest_api.exception.ErrorCode;
import kr.co.gongma.gongma_admin_rest_api.login.dto.AdminLoginHistoryDto;
import kr.co.gongma.gongma_admin_rest_api.login.entity.AdminLoginHistory;
import kr.co.gongma.gongma_admin_rest_api.login.repository.AdminLoginHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminLoginReadService {

    private final AdminLoginHistoryRepository adminLoginHistoryRepository;

    public List<AdminLoginHistoryDto> getLoginHistory(Long adminId) throws ApiException {
        List<AdminLoginHistory> loginHistoryList = adminLoginHistoryRepository.findAllByAdminId(adminId);

        return loginHistoryList.stream().map(AdminLoginHistoryDto::fromEntity).toList();
    }
}
