package com.bruse.dubbo.service;

import org.apache.dubbo.config.annotation.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service(protocol = "dubbo")
public class UserSerivceImpl implements IUserService {

    private Map<Long, User> usersRepository = new HashMap<>();

    @Override
    public boolean save(User user) {
        return usersRepository.put(user.getId(), user) == null;
    }

    @Override
    public boolean delete(Long id) {
        return usersRepository.remove(id) == null;
    }

    @Override
    public Collection<User> findAll() {
        return usersRepository.values();
    }
}
