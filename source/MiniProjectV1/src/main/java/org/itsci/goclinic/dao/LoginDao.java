package org.itsci.goclinic.dao;

import org.springframework.security.core.userdetails.UserDetails;

public interface LoginDao {
    UserDetails loadUserByUsername(String email);
}
