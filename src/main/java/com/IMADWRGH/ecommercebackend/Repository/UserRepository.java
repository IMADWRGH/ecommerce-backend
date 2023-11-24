package com.IMADWRGH.ecommercebackend.Repository;

import com.IMADWRGH.ecommercebackend.model.LocalUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<LocalUser,Long> {
    Optional<LocalUser> findByUserNameIgnoreCase(String username);
    Optional<LocalUser> findByEmailIgnoreCase(String email);
}
