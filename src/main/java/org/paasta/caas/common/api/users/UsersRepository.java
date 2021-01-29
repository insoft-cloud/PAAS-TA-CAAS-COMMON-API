package org.paasta.caas.common.api.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User Repository 인터페이스
 *
 * @author REX
 * @version 1.0
 * @since 2018.08.02
 */
@Repository
@Transactional
public interface UsersRepository extends JpaRepository<Users, Long> {

    /**
     * User 의 목록을 조회한다.
     *
     * @param serviceInstanceId the service instance id
     * @param spaceGuid the spaceGuid
     * @return the User List
     */
    List<Users> findByServiceInstanceIdAndSpaceGuid(String serviceInstanceId, String spaceGuid);

    /**
     * User 의 상세 정보를 조회한다.
     *
     * @param serviceInstanceId the service instance id
     * @param spaceGuid the spaceGuid
     * @param userId the user id
     * @return the user
     */
    Users findByServiceInstanceIdAndSpaceGuidAndUserId(String serviceInstanceId, String spaceGuid, String userId);

    /**
     * User 를 삭제한다.
     *
     * @param serviceInstanceId the service instance id
     * @return Integer
     */
    @Modifying
    @Query(value = "delete from user where service_instance_id = ?1", nativeQuery = true)
    Integer deleteByServiceInstanceId(String serviceInstanceId);

    /**
     * 해당 Namespace의 User 의 상세 정보를 조회한다.(By namespace)
     *
     * @param namespace the namespace
     * @return the user
     */
    Users findByUserIdAndCaasNamespace(String userId, String namespace);

    /**
     * User 의 상세 정보를 service Instance ID로 조회한다.
     *
     * @param serviceInstanceId serviceInstance ID
     * @return List<User>
     */
    List<Users> findByServiceInstanceId(String serviceInstanceId);


    /**
     * serviceInstanceId 와 organizationGuid 와 userId 로  User 를 삭제한다.
     *
     * @param serviceInstanceId the serviceInstanceId
     * @param organizationGuid the organizationGuid
     * @param userId the userId
     * @return int
     */
    Integer deleteByServiceInstanceIdAndSpaceGuidAndUserId(String serviceInstanceId, String organizationGuid, String userId);
}
