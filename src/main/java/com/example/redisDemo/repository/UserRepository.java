package com.example.redisDemo.repository;

import com.example.redisDemo.model.RedisUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<RedisUser, UUID> {

    Optional<RedisUser> findByEmailIdAndPassword(String emailId, String password);
}
