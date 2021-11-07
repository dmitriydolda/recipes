package task;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.*;

@RestController
public class Controller {
    
    @GetMapping("/test/{status}")
    public HttpStatus getResponse(@PathVariable int status) {

        HttpStatus httpStatus = null;

        switch (status) {
            case 200:
                httpStatus = HttpStatus.OK;
                break;
            case 300:
                throw new ResponseStatusException(HttpStatus.MULTIPLE_CHOICES);
            case 400:
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            default:
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return httpStatus;
    }

}
