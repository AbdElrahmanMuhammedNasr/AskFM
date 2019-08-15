package com.example.demo.HServiceIntercaceImpl;

import com.example.demo.HServiceIntercace.FriendsOper;
import com.example.demo.KReposotiry.FriendsRepo;
import com.example.demo.Model.Friends;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendsOperImpl implements FriendsOper {

    @Autowired
    private FriendsRepo friendsRepo;

    @Override
    public void saveFriend(Friends f) {
         friendsRepo.save(f);
    }

    @Override
    public List<Friends> findAllFriends() {
        return friendsRepo.findAll();
    }
}
