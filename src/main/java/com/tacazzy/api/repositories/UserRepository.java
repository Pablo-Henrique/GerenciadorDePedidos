package com.tacazzy.api.repositories;

import com.tacazzy.api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@SuppressWarnings("all")
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {


}