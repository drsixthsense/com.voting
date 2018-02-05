package com.voting.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@org.springframework.data.annotation.AccessType(value = org.springframework.data.annotation.AccessType.Type.FIELD)
@Entity
@Table(name = "restaurants")
public class Restaurant implements Serializable{
    public static final int START_SEQ = 500000;

    @Id
    @SequenceGenerator(name = "restaurant_seq", sequenceName = "restaurant_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurant_seq")
    private Integer id;

    @NotBlank
    @Size(min = 2, max = 100)
    @Column(name = "restaurant_name", nullable = false)
    private String name;

    @NotBlank
    @Size(min = 2, max = 100)
    @Column(name = "restaurant_address", nullable = false)
    private String address;

    @Column(name = "restaurant_registered", columnDefinition = "timestamp default now()")
    @NotNull
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime registered;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id")
    private Menu menu;


    public Restaurant() {
    }

    public Restaurant(@NotBlank @Size(min = 2, max = 100) String name, @NotBlank @Size(min = 2, max = 100) String address, @NotNull LocalDateTime registered) {
        this.name = name;
        this.address = address;
        this.registered = registered;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getRegistered() {
        return registered;
    }

    public void setRegistered(LocalDateTime registered) {
        this.registered = registered;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !getClass().equals(Hibernate.getClass(o))) {
            return false;
        }
        Restaurant that = (Restaurant) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id;
    }
}
