package com.netcare.repository;


import com.netcare.entity.Developer;
import com.netcare.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Developer,Long> {


    //We should avoid native queries
    @Transactional
    @Query(value = "SELECT a FROM User WHERE a.username = :username and a.password = :password", nativeQuery = true)
    Optional<User> findUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
