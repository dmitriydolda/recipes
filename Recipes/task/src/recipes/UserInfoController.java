package recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@Controller
@Validated
public class UserInfoController {

    @Autowired
    private UserDetailsServiceImpl userInfoService;

    @PostMapping("/api/register")
    public ResponseEntity<User> register(@RequestBody @Valid User userInfo) {

        if (userInfoService.getUserByEmail(userInfo.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        userInfo.setRoles("ROLE_" + WebSecurityConfigurerImpl.ROLE_USER);
        User newUserInfo = userInfoService.saveUserInfo(userInfo);

        return newUserInfo != null ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }


}
