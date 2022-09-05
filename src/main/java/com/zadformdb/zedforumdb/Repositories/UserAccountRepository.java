package com.zadformdb.zedforumdb.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zadformdb.zedforumdb.Models.UserAccount;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, String> {

    List<UserAccount> findAllByEmailContaining(String email);
}