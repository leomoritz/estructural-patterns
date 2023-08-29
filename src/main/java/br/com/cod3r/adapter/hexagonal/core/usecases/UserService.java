package br.com.cod3r.adapter.hexagonal.core.usecases;

import br.com.cod3r.adapter.hexagonal.core.model.User;
import br.com.cod3r.adapter.hexagonal.core.ports.UserRepository;

import java.util.List;

public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        boolean alreadyUsedEmail = userRepository.getAll().stream()
                .anyMatch(userSaved -> userSaved.getEmail().equals(user.getEmail()));
        if (alreadyUsedEmail) {
            throw new RuntimeException("The e-mail informed to this user already exists!");
        }
        userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.getAll();
    }
}
