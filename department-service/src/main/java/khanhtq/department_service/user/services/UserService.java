package khanhtq.department_service.user.services;

import khanhtq.department_service.user.model.User;
import khanhtq.department_service.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
