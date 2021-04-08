package com.wyd.controller;

import com.wyd.pojo.UserInfo;
import com.wyd.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;

    @GetMapping("/selectById/{id}")
    public UserInfo selectById(@PathVariable("id") Integer id) {
        return userInfoService.selectById(id);
    }

    @PostMapping("/saveData")
    public void saveData(@RequestBody UserInfo userInfo) {
        userInfoService.saveData(userInfo);
    }

    @GetMapping("/selectList")
    @ResponseBody
    public List<UserInfo> selectList() {
        return userInfoService.selectList();
    }
}