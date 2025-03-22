package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true) // Только для чтения
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true) // Только для чтения
    public User getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Transactional // Для операций записи
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Transactional // Для операций записи
    public void updateUser(User user) {
        userRepository.update(user);
    }

    public void addUser(User user) {
        // Вызов через прокси
        ((UserService) AopContext.currentProxy()).saveUser(user);
    }

    @Transactional // Для операций записи
    public void deleteUser(Long id) {
        userRepository.delete(id);
    }
}