package n1mber.cafe_service_backend.controllers;

//import n1mber.cafe_service_backend.dbworker.UserService;
import n1mber.cafe_service_backend.dbworker.services.UserService;
import n1mber.cafe_service_backend.entities.AuthorizedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserService userService;

    @CrossOrigin
    @PostMapping("/registration")
    public ResponseEntity<?> createUser(@RequestBody AuthorizedUser authorizedUser) {
        if (userService.findAuthorizedUserByLogin(authorizedUser.getLogin()) == null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        else {
            System.out.println("New user registred: " + authorizedUser.getLogin() + " id: " + authorizedUser.getID());
            return new ResponseEntity<>(userService.save_new_user(authorizedUser), HttpStatus.CREATED);
        }
    }

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<?> user_login(@RequestBody AuthorizedUser authorizedUser) {
        if(userService.get_match_password(authorizedUser.getPassword(),
                userService.findAuthorizedUserByLogin(authorizedUser.getLogin()))){
            return new ResponseEntity<>("Succes", HttpStatus.ACCEPTED);
        }else
            return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
}
