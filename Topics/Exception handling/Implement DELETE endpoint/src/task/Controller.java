package task;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.*;

import java.util.*;
import java.util.concurrent.*;

@RestController
public class Controller {
    final Map<Long, String> users = new ConcurrentHashMap<>(Map.of(
            2234L, "Kate",
            234234234L, "Alice",
            2134L, "Jessica",
            3456L, "Olivia",
            98684L, "Emma",
            85L, "Liam",
            8495L, "James",
            48438L, "Henry"
    ));

    // add your code below this line
    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable long userId) {
        if (!users.containsKey(userId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            users.remove(userId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }

}
