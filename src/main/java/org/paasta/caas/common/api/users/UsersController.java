package org.paasta.caas.common.api.users;

import org.paasta.caas.common.api.common.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * User Controller 클래스
 *
 * @author REX
 * @version 1.0
 * @since 2018.08.02
 */
@RestController
public class UsersController {

    private final UsersService userService;

    /**
     * Instantiates a new User controller.
     *
     * @param userService the user service
     */
    @Autowired
    public UsersController(UsersService userService) {this.userService = userService;}

    /**
     * User 목록을 조회한다.
     *
     * @return the user list
     */
    @GetMapping(value = Constants.URI_API_USERS)
    List<Users> getUserList() {
        return userService.getUserList();
    }

    /**
     * User 상세 정보를 조회한다.
     *
     * @param id the id
     * @return the user
     */
    @GetMapping(value = Constants.URI_API_USERS_DETAIL)
    Users getUser(@PathVariable("id") int id) {
        return userService.getUser(id);
    }

    /**
     * Service Instance Id 와 spaceGuid 로 User 목록을 조회한다.
     *
     * @param serviceInstanceId the serviceInstanceId
     * @param spaceGuid the spaceGuid
     * @return the user
     */
    @GetMapping(value = Constants.URI_API_USERS_BY_SUID_AND_SPACE_GUID)
    UsersList getUsersByServiceInstanceIdAndSpaceGuid(@PathVariable("serviceInstanceId") String serviceInstanceId, @PathVariable("spaceGuid") String spaceGuid) {
        return userService.getUsersByServiceInstanceIdAndSpaceGuid(serviceInstanceId, spaceGuid);
    }


    /**
     * Service Instance Id 와 spaceGuid, userId 로 User 상세 정보를 조회한다.
     *
     * @param serviceInstanceId the serviceInstanceId
     * @param spaceGuid the spaceGuid
     * @param userId the userId
     * @return the user
     */
    @GetMapping(value = Constants.URI_API_USERS_BY_SUID_AND_SPACE_GUID_AND_USER_ID)
    Users getUserByServiceInstanceIdAndSpaceGuid(@PathVariable("serviceInstanceId") String serviceInstanceId,
                                                        @PathVariable("spaceGuid") String spaceGuid,
                                                        @PathVariable("userId") String userId){
        return userService.getUserByServiceInstanceIdAndSpaceGuid(serviceInstanceId, spaceGuid, userId);
    }

    /**
     * Service Instance Id 와 spaceGuid, userId 로 User 권한을 업데이트한다.
     *
     * @param serviceInstanceId the serviceInstanceId
     * @param spaceGuid the spaceGuid
     * @param user the user
     * @return the user
     */
    @PostMapping(value = Constants.URI_API_USERS_BY_SUID_AND_SPACE_GUID_AND_USER_ID)
    Users updateUserRoleByServiceInstanceIdAndSpaceGuid(@PathVariable("serviceInstanceId") String serviceInstanceId,
                                                           @PathVariable("spaceGuid") String spaceGuid,
                                                           @RequestBody Users user){
        return userService.updateUserRoleByServiceInstanceIdAndSpaceGuid(user);
    }

    /**
     * User 를 생성한다.
     *
     * @param user the user
     * @return the user
     */
    @PostMapping(value = Constants.URI_API_USERS)
    Users createUser(@RequestBody Users user) {
        return userService.createUser(user);
    }

    /**
     * User 를 수정한다.
     *
     * @param user the user
     * @return the user
     */
    @PutMapping(value = Constants.URI_API_USERS)
    Users updateUser(@RequestBody Users user) {
        return userService.updateUser(user);
    }


    /**
     * service instance id 를 통해 User 를 삭제한다.
     *
     * @param serviceInstanceId the serviceInstanceId
     */
    @DeleteMapping(value = Constants.URI_API_USERS_BY_SERVICE_INSTANCE_ID)
    void deleteByServiceInstanceId(@PathVariable("serviceInstanceId") String serviceInstanceId) {
        userService.deleteByServiceInstanceId(serviceInstanceId);
    }


    /**
     * User 를 삭제한다.
     *
     * @param serviceInstanceId the serviceInstanceId
     * @param spaceGuid the spaceGuid
     * @param userId the userId
     * @return the user
     */
    @DeleteMapping(value = Constants.URI_API_USERS_BY_SUID_AND_SPACE_GUID_AND_USER_ID)
    Users deleteUserByServiceInstanceIdAndSpaceGuid(@PathVariable("serviceInstanceId") String serviceInstanceId,
                                                               @PathVariable("spaceGuid") String spaceGuid,
                                                               @PathVariable("userId") String userId){
        return userService.deleteByServiceInstanceIdAndSpaceGuid(serviceInstanceId, spaceGuid, userId);
    }

    /**
     * service instance id 를 통해 User Update한다.
     *
     * @param serviceInstanceId the serviceInstanceId
     */
    @PutMapping(value = Constants.URI_API_USERS_BY_SERVICE_INSTANCE_ID)
    void updateByServiceInstanceId(@PathVariable("serviceInstanceId") String serviceInstanceId, @RequestBody Users user) {
        userService.updateByServiceInstanceId(serviceInstanceId, user);
    }

    /**
     * Caas namespace 를 통해 유저 정보를 가져온다.
     *
     * @param namespace the namespace
     */
    @GetMapping(value = Constants.URI_API_USERS_VALID_EXIST_NAMESPACE)
    boolean isUserCountByCaasNamespace(@PathVariable("userId") String userId, @PathVariable("namespace") String namespace) {
        return userService.isUserByCaasNamespace(userId, namespace);
    }

}























