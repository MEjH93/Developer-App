package com.netcare.mapper;

import com.netcare.customexception.CustomException;
import com.netcare.entity.Developer;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DeveloperMapper {

        public Developer toDeveloper(DeveloperDTO developerDTO) {
            return Developer.builder()
                    .developerCode(developerDTO.getDeveloperCode())
                    .email(developerDTO.getEmail())
                    .imageUrl(developerDTO.getImageUrl())
                    .jobTitle(developerDTO.getJobTitle())
                    .name(developerDTO.getName())
                    .phone(developerDTO.getPhone())
                    .build();
        }

        public List<Developer> toDeveloper(List<DeveloperDTO> e) {
            return e.stream().map(this::toDeveloper).collect(Collectors.toList());
        }

    public Developer fromSaveOrUpdate(SaveDeveloperDTO save) throws CustomException {
            //If below just to show what could happen if field must not be empty
        if (save.getName() == null || save.getName().isEmpty())
            throw new CustomException("Developer name cannot be null or empty", HttpStatus.NOT_ACCEPTABLE);
        return Developer.builder()
                .phone(save.getPhone())
                .name(save.getName())
                .jobTitle(save.getJobTitle())
                .imageUrl(save.getImageUrl())
                .email(save.getEmail())
                .developerCode(save.getDeveloperCode())
                .build();
    }

    public DeveloperDTO toDeveloper(Developer addDeveloper) {
        return DeveloperDTO.builder()
                .developerCode(addDeveloper.getDeveloperCode())
                .email(addDeveloper.getEmail())
                .imageUrl(addDeveloper.getImageUrl())
                .jobTitle(addDeveloper.getJobTitle())
                .name(addDeveloper.getName())
                .phone(addDeveloper.getPhone())
                .build();
    }
}

