package com.example.demo.KReposotiry;

import com.example.demo.Model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserData extends JpaRepository<UserInfo ,Long> {

    UserInfo findByUsername(String username);
}
