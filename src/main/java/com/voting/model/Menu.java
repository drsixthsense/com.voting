package com.voting.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Access(AccessType.FIELD)
@Entity
@Table(name = "menus")
public class Menu {
    public static final int START_SEQ = 100000;

    @Id
    @SequenceGenerator(name = "menu_seq", sequenceName = "menu_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu_seq")
    private Integer id;

    @Column(name = "registered", columnDefinition = "timestamp default now()")
    @NotNull
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime registered;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "menu")
    @OrderBy("registered DESC ")
    private List<MenuDetail> menuDetails;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @NotNull
    private Restaurant restaurant;

    public Menu() {
    }


    public Menu(@NotNull LocalDateTime registered, List<MenuDetail> menuDetails, @NotNull User user, @NotNull Restaurant restaurant) {
        this.registered = registered;
        this.menuDetails = menuDetails;
        this.user = user;
        this.restaurant = restaurant;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getRegistered() {
        return registered;
    }

    public void setRegistered(LocalDateTime registered) {
        this.registered = registered;
    }

    public List<MenuDetail> getMenuDetails() {
        return menuDetails;
    }

    public void setMenuDetails(List<MenuDetail> menuDetails) {
        this.menuDetails = menuDetails;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !getClass().equals(Hibernate.getClass(o))) {
            return false;
        }
        Menu that = (Menu) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id;
    }
}