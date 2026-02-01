package com.demo.interntracker.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="positions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Position {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=120)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false, length=20)
    private WorkType type;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="company_id", nullable=false)
    private Company company;
}
