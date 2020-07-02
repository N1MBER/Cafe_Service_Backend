package n1mber.cafe_service_backend.controllers;

//import n1mber.cafe_service_backend.entities.Answer;
//import n1mber.cafe_service_backend.entities.AuthorizedUser;
import n1mber.cafe_service_backend.dbworker.services.UserService;
import n1mber.cafe_service_backend.entities.AuthorizedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
//import org.json.*;


@RestController("/reservation")
public class ReservationController {
    @Autowired
    private UserService userService;
//
//    @CrossOrigin
//    @PostMapping("/make")
//    public  sos(){
//        return "/WEB-INF/index.jsp";
//    }

    @CrossOrigin
    @PostMapping("/reservation_notification")
    public ResponseEntity<?> reservation_notification(@RequestBody AuthorizedUser authorizedUser){
        userService.findAuthorizedUserByLogin(authorizedUser.getLogin())
                .setReservation_notification(userService
                        .findAuthorizedUserByLogin(authorizedUser.getLogin())
                        .isReservation_notification());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @CrossOrigin
    @PostMapping("/new_reservation_notification")
    public ResponseEntity<?> new_reservation_notification(@RequestBody AuthorizedUser authorizedUser){
        userService.findAuthorizedUserByLogin(authorizedUser.getLogin())
                .setNew_position_notification(userService
                        .findAuthorizedUserByLogin(authorizedUser.getLogin())
                        .isNew_position_notification());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
