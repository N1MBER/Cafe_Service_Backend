package n1mber.cafe_service_backend.controllers;

import n1mber.cafe_service_backend.dbworker.services.UserService;
import n1mber.cafe_service_backend.entities.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController("/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<?> admin_login(@RequestBody Administrator administrator) {
        if(userService.get_match_password(administrator.getPassword(),
                userService.findAdministratorUserByLogin(administrator.getLogin()))){
            return new ResponseEntity<>("Succes", HttpStatus.ACCEPTED);
        }else
            return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @CrossOrigin
    @PostMapping("/add_new_admin")
    public ResponseEntity<?> add_admin(@RequestBody Administrator administrator){
        if(userService.findAdministratorUserByLogin(administrator.getLogin()) == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }else {
            return new ResponseEntity<>(userService.save_new_administrator(administrator), HttpStatus.CREATED);
        }
    }

}
