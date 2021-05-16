package pl.sztukakodu.springsecuritytoken;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
class SecureController {


    @GetMapping("/admin")
    public String adminOnly() {
        return "admin";
    }

    @GetMapping("/user")
    public String userOnly() {
        return "users";
    }

    @GetMapping("/all")
    public String anonymousOnly() {
        return "anonymous";
    }

}
