package com.voting.model;

import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@org.springframework.data.annotation.AccessType(value = org.springframework.data.annotation.AccessType.Type.FIELD)
@Entity
@Table(name = "menu_details")
public class MenuDetail {

    @Id
    @Column(name = "menu_details_id")
    @GeneratedValue
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_id", nullable = false)
    @NotNull
    private Menu menu;

    @NotBlank
    @Size(min = 2, max = 100)
    @Column(name = "dish", nullable = false)
    private String dish;

    @NotBlank
    @Column(name = "price")
    private Float price;

    public MenuDetail() {
    }

    public MenuDetail(@NotNull Menu menu, @NotBlank @Size(min = 2, max = 100) String dish, @NotBlank Float price) {
        this.menu = menu;
        this.dish = dish;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !getClass().equals(Hibernate.getClass(o))) {
            return false;
        }
        MenuDetail that = (MenuDetail) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id;
    }
}
