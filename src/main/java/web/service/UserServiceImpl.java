package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;
import web.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsersList() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean isEmailUnique(String email, int userId) {
        User userWithSameEmail = userRepository.findByEmail(email);

        return userWithSameEmail == null || userWithSameEmail.getId() == userId;
    }

    @Override
    public User getUserByID(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void saveUser(User newUser) {
        userRepository.save(newUser);
    }

    @Transactional
    @Override
    public void updateUser(int id, User updateUser) {
        updateUser.setId(id);
        userRepository.save(updateUser);
    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
