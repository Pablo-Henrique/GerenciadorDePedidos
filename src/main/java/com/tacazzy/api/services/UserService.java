package com.tacazzy.api.services;

import com.tacazzy.api.models.User;
import com.tacazzy.api.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User insert(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User update(Long id, User newUser) {
        User entity = userRepository.getReferenceById(id);
        BeanUtils.copyProperties(newUser, entity, "id");
        return userRepository.save(entity);
    }

}
