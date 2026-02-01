package com.demo.interntracker.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="companies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=120)
    private String name;

    @Column(length=200)
    private String website;

    @Column(length=120)
    private String location;
}
