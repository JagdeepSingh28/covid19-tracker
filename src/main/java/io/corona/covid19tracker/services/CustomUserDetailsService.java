package io.corona.covid19tracker.services;

import io.corona.covid19tracker.models.CustomUserDetails;
import io.corona.covid19tracker.models.Users;
import io.corona.covid19tracker.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Users> optionalUsers = usersRepository.findByName(userName);

        optionalUsers.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));

        return optionalUsers
                .map(CustomUserDetails::new).get();
    }
}
