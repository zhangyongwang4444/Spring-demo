package user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    // user  -- > User 对象
    private final HashMap<String, User> users = new HashMap<>();

    @GetMapping("/users")
    List<User> listUsers() {
        return new ArrayList<>(users.values());
    }

    @GetMapping("/users/{name}")
    User getUser(@PathVariable String name) {
        return users.get(name);
    }

    @PostMapping("/users")
    ResponseEntity<User> newUser(@RequestBody User user) {
        users.put(user.getName(), user);
        return new ResponseEntity<>(users.get(user.getName()), HttpStatus.CREATED);
    }

    @PutMapping("/users/{name}")
    User updateUser(@PathVariable String name, @RequestBody User updatedUser) {
        User user = users.get(name);
        user.setContent(updatedUser.getContent());
        return user;
    }

    @DeleteMapping("/users/{name}")
    void deleteUser(@PathVariable String name) {
        users.remove(name);
    }


}
