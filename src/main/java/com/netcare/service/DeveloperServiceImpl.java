package com.netcare.service;

import com.netcare.customexception.CustomException;
import com.netcare.entity.Developer;
import com.netcare.repository.DeveloperRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DeveloperServiceImpl implements DeveloperService {

    @Autowired
    private final DeveloperRepository developerRepository;

    @Transactional
    @Override
    public void deleteDeveloperByID(Long id) {
        developerRepository.deleteById(id);
    }

    @Override
    public List<Developer> findAllDevelopers() {
        return developerRepository.findAll();
    }

    @Override
    public Developer findDeveloperByID(Long id) throws CustomException {
        return developerRepository.findById(id).orElseThrow(()-> new CustomException("Developer with id"+id+"wasn't found", HttpStatus.NOT_FOUND));
    }

    @Transactional
    @Override
    public Developer addDeveloper(Developer developer) {
        developer.setDeveloperCode(UUID.randomUUID().toString());
        return developerRepository.save(developer);
    }

    @Transactional
    @Override
    public Developer updateDeveloper(Developer developer, Long id) throws CustomException {
        Developer updatedDeveloper = findDeveloperByID(id);
        updatedDeveloper.setPhone(developer.getPhone());
        updatedDeveloper.setEmail(developer.getEmail());
        updatedDeveloper.setName(developer.getName());
        updatedDeveloper.setJobTitle(developer.getJobTitle());
        updatedDeveloper.setImageUrl(developer.getImageUrl());
        //Not updateable updatedDeveloper.setDeveloperCode(developer.getDeveloperCode());
        return developerRepository.save(updatedDeveloper);

    }
}

