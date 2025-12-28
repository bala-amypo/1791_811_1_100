package com.example.demo.security;

    import com.example.demo.model.User;
    import com.example.demo.service.UserService;
    import com.example.demo.exception.ResourceNotFoundException;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.security.core.userdetails.UserDetails;
    import org.springframework.security.core.userdetails.UserDetailsService;
    import org.springframework.security.core.userdetails.UsernameNotFoundException;
    import org.springframework.stereotype.Service;

    @Service
    public class CustomerUserDetailsService implements UserDetailsService {

        @Autowired
        private UserService userService;

        @Override
        public UserDetails loadUserByUsername(String email)
                throws UsernameNotFoundException {

            User user;
            try {
                user = userService.findByEmail(email);
            } catch (ResourceNotFoundException ex) {
                throw new UsernameNotFoundException(
                        "User not found with email: " + email
                );
            }

            return org.springframework.security.core.userdetails.User
                    .withUsername(user.getEmail())
                    .password(user.getPassword())
                    .authorities("ROLE_" + user.getRole())
                    .build();
        }
    }