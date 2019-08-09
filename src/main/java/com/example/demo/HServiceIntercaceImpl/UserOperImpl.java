package com.example.demo.HServiceIntercaceImpl;

import com.example.demo.HServiceIntercace.UserOper;
import com.example.demo.KReposotiry.UserData;
import com.example.demo.Model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserOperImpl implements UserOper {
    @Autowired
    private UserData userData;

    @Override
    public UserInfo findOneUser(Long id) {

        return userData.findById(id).get();
    }

    @Override
    public void SaveUserInfo(UserInfo userInfo) {
        userData.save(userInfo);

    }

    @Override
    public UserInfo getDataByUsername(String username) {
        return userData.findByUsername(username);
    }


}
