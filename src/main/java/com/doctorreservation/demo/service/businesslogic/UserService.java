package com.doctorreservation.demo.service.businesslogic;

import com.doctorreservation.demo.adapter.database.AuthGroupRepository;
import com.doctorreservation.demo.adapter.database.UserRepository;
import com.doctorreservation.demo.adapter.entity.User;
import com.doctorreservation.demo.service.models.UserPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final AuthGroupRepository groupRepository;

    public UserService(UserRepository userRepository, AuthGroupRepository groupRepository) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (null == user)
            throw new UsernameNotFoundException("cannot find username: " + username);

        return new UserPrincipal(user, groupRepository.findByUsername(username));
    }


}
