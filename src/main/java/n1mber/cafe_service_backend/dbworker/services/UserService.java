package n1mber.cafe_service_backend.dbworker.services;

import n1mber.cafe_service_backend.dbworker.repositories.AdministratorRepository;
import n1mber.cafe_service_backend.dbworker.repositories.UserRepository;
import n1mber.cafe_service_backend.entities.Administrator;
import n1mber.cafe_service_backend.entities.AuthorizedUser;
import n1mber.cafe_service_backend.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdministratorRepository administratorRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthorizedUser save_new_user(AuthorizedUser authorizedUser){
        authorizedUser.setPassword(bCryptPasswordEncoder.encode(authorizedUser.getPassword()));
        return userRepository.save(authorizedUser);
    }

    public Administrator save_new_administrator(Administrator administrator){
        administrator.setPassword(bCryptPasswordEncoder.encode(administrator.getPassword()));
        return administratorRepository.save(administrator);
    }

    public boolean get_match_password(String password, User user){
        return bCryptPasswordEncoder.matches(password, user.getPassword());
    }

    public AuthorizedUser findAuthorizedUserByLogin(String login){
        return userRepository.findAuthorizedUserByLogin(login);
    }

    public Administrator findAdministratorUserByLogin(String login){
        return administratorRepository.findAdministratorsByLogin(login);
    }
}
