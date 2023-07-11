package com.omis.userManagementService.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "route")
public class Route {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "label")
    private String label;

    @Column(name = "routename")
    private String routeLink;

    @Column(name = "add")
    private Boolean Add;

    @Column(name = "edit")
    private Boolean Edit;


    @Column(name = "delete")
    private Boolean Delete;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category categoryId;


    @JsonIgnore
    @Column(name = "active", nullable = false)
    private Boolean active = false;

    @JsonManagedReference
    @OneToMany(mappedBy = "parent")
    private Set<Route> items;

    @ManyToOne
    @JsonBackReference
    private Route parent;


}