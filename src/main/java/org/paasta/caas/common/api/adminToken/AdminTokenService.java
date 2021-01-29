package org.paasta.caas.common.api.adminToken;

import org.paasta.caas.common.api.common.CommonService;
import org.paasta.caas.common.api.common.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AdminToken Service 클래스
 *
 * @author dojjang
 * @version 1.0
 * @since 2018.08.27
 */
@Service
public class AdminTokenService {

    private final CommonService commonService;
    private final AdminTokenRepository adminTokenRepository;

    /**
     * Instantiates a new User service.
     *
     * @param commonService        the common service
     * @param adminTokenRepository the adminToken repository
     */
    @Autowired
    public AdminTokenService(CommonService commonService, AdminTokenRepository adminTokenRepository) {
        this.commonService = commonService;
        this.adminTokenRepository = adminTokenRepository;
    }


    /**
     * Admin token 상세 정보를 조회한다.
     *
     * @param tokenName the tokenName
     * @return the AdminToken
     */
    AdminToken getTokenValue(String tokenName) {
        AdminToken token = adminTokenRepository.findByTokenName(tokenName);
        AdminToken nullObject = new AdminToken();

        if(token == null) {
            return (AdminToken) commonService.setResultModel(nullObject, Constants.RESULT_STATUS_FAIL);
        }

        return (AdminToken) commonService.setResultModel(token, Constants.RESULT_STATUS_SUCCESS);
    }


    /**
     * Admin token 정보를 등록한다.
     *
     * @param adminToken the admin token
     * @return the admin token
     */
    AdminToken createAdminToken(AdminToken adminToken) {
        String result = commonService.procValidator(adminToken);

        if (result.equals(Constants.RESULT_STATUS_SUCCESS)) {
            return adminTokenRepository.save(adminToken);
        } else {
            return (AdminToken) commonService.setResultModel(AdminToken.class, Constants.RESULT_STATUS_FAIL);
        }
    }

}
