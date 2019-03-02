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
    ResponseEntity<User> getUser(@PathVariable String name) {
        if (users.containsKey(name)) {
            return new ResponseEntity<>(users.get(name), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/users")
        // 自定义返回的状态码
    ResponseEntity<User> newUser(@RequestBody User user) {
        users.put(user.getName(), user);
        // 创建成功后返回 User对象 ，以及自定义的状态值 201
        return new ResponseEntity<>(users.get(user.getName()), HttpStatus.CREATED);
    }

    @PutMapping("/users/{name}")
    ResponseEntity<User> updateUser(@PathVariable String name, @RequestBody User updatedUser) {
        if (users.containsKey(name)) {
            User user = users.get(name);
            user.setContent(updatedUser.getContent());
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/users/{name}")
    ResponseEntity<Void> deleteUser(@PathVariable String name) {
        if (users.containsKey(name)) {
            users.remove(name);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
