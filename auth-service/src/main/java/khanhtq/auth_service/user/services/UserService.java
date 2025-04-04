package khanhtq.auth_service.user.services;

import khanhtq.auth_service.model.User;
import khanhtq.auth_service.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
