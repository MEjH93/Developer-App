package com.netcare.mapper;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeveloperDTO {
    private String jobTitle;
    private String phone;
    private String imageUrl;
    private String name;
    private String email;
    private String developerCode;
}
