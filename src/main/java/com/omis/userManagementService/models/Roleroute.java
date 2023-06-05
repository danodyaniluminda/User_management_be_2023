package com.omis.userManagementService.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "roleroute")
public class Roleroute implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roleid")
    private Role roleId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "routeid")
    private Route routeId;

    @JsonManagedReference
    @OneToMany(mappedBy = "parent")
    private Set<Roleroute> children;

    @ManyToOne
    @JsonBackReference
    private Roleroute parent;

    @Column(name = "active")
    private Boolean active;

}