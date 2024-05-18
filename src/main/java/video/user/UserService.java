package video.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void register(User user) {
        user.setStatus("online");
        userRepository.save(user);
    }

    public User login(User user) {
        User cUser = userRepository.findByEmail(user.getEmail());
        if (cUser == null) {
            throw new RuntimeException("User not found");
        }
        if (!cUser.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Password incorrect");
        }
        cUser.setStatus("online");
        return userRepository.save(cUser);
    }

    public void logout(String email) {
        User cUser = userRepository.findByEmail(email);
        if (cUser == null) {
            throw new RuntimeException("User not found");
        }
        cUser.setStatus("offline");
        userRepository.save(cUser);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
