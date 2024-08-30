package com.studentsmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentsmanagementsystem.entity.User_Pass;

@Repository
public interface user_repo extends JpaRepository<User_Pass , Integer >{

}
