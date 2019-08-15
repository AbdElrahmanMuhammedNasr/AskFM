package com.example.demo.HServiceIntercace;

import com.example.demo.Model.Friends;

import java.util.List;

public interface FriendsOper {

    void saveFriend (Friends f);

    List<Friends> findAllFriends ();
}
