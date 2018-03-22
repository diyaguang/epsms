package com.dygstudio.epsms.repository;

import com.dygstudio.epsms.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author: diyaguang
 * @date: 2018/03/09 上午9:35
 * @description: com.dygstudio.epsms.repository
 */
public interface UsersRepository extends JpaRepository<Users,Long> {
    List<Users> findByAddress(String name);
    Users findByNameAndAddress(String name,String address);

    @Query("Select u from Users u where u.name=:name and u.address=:address")
    Users withNameAndAddressQuery(@Param("name")String name,@Param("address")String address);

    Users withNameAndAddressNamedQuery(String name,String address);

    Users findByNameStartsWith(String name);
    Users findByName(String name);
}
