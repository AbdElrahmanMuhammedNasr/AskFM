package com.example.demo.KReposotiry;


import com.example.demo.Model.Friends;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendsRepo extends JpaRepository<Friends, Long> {
}
