package work.oldust.dataserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import work.oldust.dataserver.entity.Response;
import work.oldust.dataserver.entity.User;
import work.oldust.dataserver.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public Response<User> save(@RequestBody User user) {
        if (userService.findByUsername(user.getUsername()) != null) {
            // 用户已存在
            return new Response<>(1, "User has already existed", null);
        }
        return new Response<>(0, "success", userService.save(user));
    }

    @GetMapping("/{username}")
    public Response<User> findByUsername(@PathVariable("username") String username) {
        final var user = userService.findByUsername(username);
        if (user == null) {
            return new Response<>(1, "User dost not exists", null);
        }
        return new Response<>(0, "success", user);
    }
}
