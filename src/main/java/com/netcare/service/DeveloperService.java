package com.netcare.service;

import com.netcare.customexception.CustomException;
import com.netcare.entity.Developer;

import java.util.List;

public interface DeveloperService {

    void deleteDeveloperByID(Long id);

    List<Developer> findAllDevelopers();

    Developer findDeveloperByID(Long id) throws CustomException;

    Developer addDeveloper(Developer developer);

    Developer updateDeveloper(Developer developer, Long id) throws CustomException;
}
