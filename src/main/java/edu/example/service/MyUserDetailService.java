package edu.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.example.dto.User;
import edu.example.entity.UserEntity;
import edu.example.model.UserPrinciple;
import edu.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Primary
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    public   UserRepository repository;

    @Autowired
    public ObjectMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity byUserName = repository.findByUserName(username);
        User user = mapper.convertValue(byUserName, User.class);
        if (byUserName==null){
            throw new UsernameNotFoundException("User Not Found !!");
        }
        return  new UserPrinciple(user);
    }
}


