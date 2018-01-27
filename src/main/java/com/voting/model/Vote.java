package com.voting.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.Hibernate;
import org.springframework.data.annotation.AccessType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@AccessType(value = AccessType.Type.FIELD)
@Entity
@Table(name = "votes")
public class Vote {
    public static final int START_SEQ = 300000;


    @Id
    @SequenceGenerator(name = "vote_seq", sequenceName = "vote_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vote_seq")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @NotNull
    private Restaurant restaurant;

    @Column(name = "vote_ts", columnDefinition = "timestamp default now()")
    @NotNull
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime vote_ts;

    @Column(name = "comment")
    @NotBlank
    private String comment;

    public Vote() {
    }

    public Vote(@NotNull User user, @NotNull Restaurant restaurant, @NotNull LocalDateTime vote_ts, @NotBlank String comment) {
        this.user = user;
        this.restaurant = restaurant;
        this.vote_ts = vote_ts;
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !getClass().equals(Hibernate.getClass(o))) {
            return false;
        }
        Vote that = (Vote) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id;
    }
}
