package org.xrave.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.xrave.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u join fetch u.roles where u.name = ?1")
    User findByName(String username);
    @Query("select u from User u join fetch u.roles where u.email = ?1")
    UserDetails findByEmail(String email);
}
