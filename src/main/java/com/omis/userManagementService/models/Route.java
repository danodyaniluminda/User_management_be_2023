package com.omis.userManagementService.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
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

    @Column(name = "icon")
    private String icon;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category")
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