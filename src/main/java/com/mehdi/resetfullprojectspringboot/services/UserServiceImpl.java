package com.mehdi.resetfullprojectspringboot.services;

import com.mehdi.resetfullprojectspringboot.models.User;
import com.mehdi.resetfullprojectspringboot.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    @Override
    public User createUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> optionalUser=userRepository.findById(userId);
        return optionalUser.get();
    }

    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User existingUser= userRepository.findById(user.getId()).get();
        existingUser.setEmail(user.getEmail());
         existingUser.setFirstName(user.getFirstName());
         existingUser.setLastName(user.getLastName());
         User updateUsr=userRepository.save(existingUser);
        return updateUsr;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);

    }
}
