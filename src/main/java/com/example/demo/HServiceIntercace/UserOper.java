package com.example.demo.HServiceIntercace;

import com.example.demo.Model.UserInfo;

import java.util.Optional;

public interface UserOper {

     UserInfo findOneUser(Long id);

    void SaveUserInfo(UserInfo userInfo);

    UserInfo getDataByUsername(String username);



}
