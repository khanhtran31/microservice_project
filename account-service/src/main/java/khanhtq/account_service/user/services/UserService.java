package khanhtq.account_service.user.services;

import khanhtq.account_service.user.model.User;
import khanhtq.account_service.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
