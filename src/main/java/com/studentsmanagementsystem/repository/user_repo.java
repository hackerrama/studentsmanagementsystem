package com.studentsmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentsmanagementsystem.entity.User_Pass;

public interface user_repo extends JpaRepository<User_Pass , Integer >{

}
