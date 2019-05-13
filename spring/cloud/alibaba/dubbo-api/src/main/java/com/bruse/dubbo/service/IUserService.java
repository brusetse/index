package com.bruse.dubbo.service;

import java.util.Collection;

public interface IUserService {

    boolean save(User user);

    boolean delete(Long id);

    Collection<User> findAll();
}
