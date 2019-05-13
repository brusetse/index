package com.bruse.mybatis.repository;

import com.bruse.mybatis.entity.User;

import java.util.List;
import java.util.Map;

public interface UserRepository {

    List<User> selectUser();

    List<Map> selectUserMap();
}
