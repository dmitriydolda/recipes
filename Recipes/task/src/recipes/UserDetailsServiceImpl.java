package recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private PasswordEncoder encoder;

    public UserDetailsServiceImpl(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    public Optional<User> getUserInfoById(long id) {
        return userInfoRepository.findById(id);
    }

    public Optional<User> getUserByEmail(String email) {
        return userInfoRepository.getUserByEmail(email);
    }

    public boolean userExists(long id) {
        return userInfoRepository.existsUserById(id);
    }

    public User saveUserInfo(User userInfo) {
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        return userInfoRepository.save(userInfo);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<User> user = userInfoRepository.getUserByEmail(email);

        user.orElseThrow(() -> new UsernameNotFoundException(email + " not found!"));

        return user.map(UserDetailsImpl::new).get();

    }
}
