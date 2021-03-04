package com.netcare.mapper;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaveDeveloperDTO {
    private String jobTitle;
    private String phone;
    private String imageUrl;
    private String name;
    private String email;
    private String developerCode;
}
