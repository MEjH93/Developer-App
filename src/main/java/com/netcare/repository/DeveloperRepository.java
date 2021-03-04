package com.netcare.repository;


import com.netcare.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DeveloperRepository extends JpaRepository<Developer,Long> {

}
