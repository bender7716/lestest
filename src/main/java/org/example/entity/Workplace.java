package org.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "workplace")
@Getter
@Setter
@NoArgsConstructor
public class Workplace {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "name_workplace")
    private String nameWorkplace;

    @OneToMany(mappedBy = "workplace", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private Set<TechnologicalProcess> technologicalProcesses = new HashSet<>();

}