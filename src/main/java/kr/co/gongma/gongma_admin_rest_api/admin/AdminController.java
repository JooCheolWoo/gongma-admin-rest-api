package kr.co.gongma.gongma_admin_rest_api.admin;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import kr.co.gongma.gongma_admin_rest_api.admin.dto.AdminRegisterDto;
import kr.co.gongma.gongma_admin_rest_api.admin.dto.AdminResponseDto;
import kr.co.gongma.gongma_admin_rest_api.admin.service.AdminReadService;
import kr.co.gongma.gongma_admin_rest_api.admin.service.AdminWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "관리자", description = "관리자 정보 CRUD")
@RestController
@RequestMapping("/admins")
@RequiredArgsConstructor
public class AdminController {

    private final AdminWriteService adminWriteService;
    private final AdminReadService adminReadService;


    @Operation(summary = "관리자 등록")
    @PostMapping
    public AdminResponseDto register(@Valid @RequestBody AdminRegisterDto request) {
        return adminWriteService.create(request);
    }
}
