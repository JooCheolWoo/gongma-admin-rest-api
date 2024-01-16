package kr.co.gongma.gongma_admin_rest_api.login;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import kr.co.gongma.gongma_admin_rest_api.admin.dto.AdminResponseDto;
import kr.co.gongma.gongma_admin_rest_api.exception.CustomException;
import kr.co.gongma.gongma_admin_rest_api.login.dto.AdminLoginDto;
import kr.co.gongma.gongma_admin_rest_api.login.dto.AdminLoginHistoryDto;
import kr.co.gongma.gongma_admin_rest_api.login.service.AdminLoginReadService;
import kr.co.gongma.gongma_admin_rest_api.login.service.AdminLoginWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "관리자", description = "관리자 로그인")
@RestController
@RequestMapping("/admins")
@RequiredArgsConstructor
public class AdminLoginController {

    private final AdminLoginWriteService adminLoginWriteService;
    private final AdminLoginReadService adminLoginReadService;

    @Operation(summary = "로그인")
    @PostMapping("/login")
    public AdminResponseDto login(@RequestBody AdminLoginDto request, HttpServletRequest httpServletRequest) throws CustomException {
        return adminLoginWriteService.login(request, httpServletRequest);
    }

    @Operation(summary = "로그인 기록 열람")
    @GetMapping("/login/history")
    public List<AdminLoginHistoryDto> getLoginHistory(@RequestParam Long adminId) throws CustomException {
        return adminLoginReadService.getLoginHistory(adminId);
    }
}
