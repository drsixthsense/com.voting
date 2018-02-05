package com.voting.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import static java.util.Objects.requireNonNull;

public class AuthorizedUser extends User {

    private com.voting.model.User user;

    public AuthorizedUser(com.voting.model.User user){
        super(user.getEmail(), user.getPassword(), true, true, true, true, user.getRole());
        this.user = user;
    }


    public static AuthorizedUser safeGet() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }
        Object principal = auth.getPrincipal();
        return (principal instanceof AuthorizedUser) ? (AuthorizedUser) principal : null;
    }

    public static AuthorizedUser get() {
        AuthorizedUser user = safeGet();
        requireNonNull(user, "No authorized user found");
        return user;
    }

    public int getId(){
        return user.getId();
    }

    public static int id(){return get().user.getId();}

    public void update(com.voting.model.User newUser) {user = newUser;}

    public com.voting.model.User getUser(){return user;}

}
