/**
 * 
 */
package com.hacorp.authen.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hacorp.authen.repository.entity.User;


@Repository
public interface UserDao extends JpaRepository<User, String> {

}
