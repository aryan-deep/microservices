package com.demo.example.iratechnology.repository;

import com.demo.example.iratechnology.usersmanagement.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

  public UserEntity findByEmail(String email);

  UserEntity findByfname(String fname);

  public UserEntity findByEmployeecode(String employeecode);
  // public UserEntity checkManagerCodeExists(String );

}
