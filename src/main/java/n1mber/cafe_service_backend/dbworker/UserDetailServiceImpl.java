package n1mber.cafe_service_backend.dbworker;

import n1mber.cafe_service_backend.entities.AuthorizedUser;
import n1mber.cafe_service_backend.dbworker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.User;

import java.util.HashSet;
import java.util.Set;

public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        AuthorizedUser authorizedUser = userRepository.findAuthorizedUserByLogin(login);
        if (authorizedUser == null){
            throw new UsernameNotFoundException(login);
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("user"));
        return new User(authorizedUser.getLogin(),authorizedUser.getPassword(), grantedAuthorities);
    }
}
