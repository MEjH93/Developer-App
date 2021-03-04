package com.netcare.entity;

import lombok.*;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="developer")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Developer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String jobTitle;
    private String phone;
    private String imageUrl;
    private String name;
    private String email;
    @Column(updatable = false)
    private String developerCode;

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", jobTitle=" + jobTitle + ", phone="
                + phone + ", imageUrl=" + imageUrl + ", developerCode=" + developerCode + "]";
    }





}