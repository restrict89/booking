package com.test.spring.boot.conf;

import com.test.spring.boot.model.UserType;
import com.test.spring.boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
//@EnableGlobalMethodSecurity(securedEnabled = true)
class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

    @Autowired
    UserRepository accountRepository;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Bean
    UserDetailsService userDetailsService() {
        return new UserDetailsService() {

            @Override
            public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
                com.test.spring.boot.model.User account = accountRepository.findByLogin(login);
                if(account != null) {
                    String role = null;
                    if(account.getType().equals(UserType.LIBRARIAN)){
                        role = "LIBRARIAN";
                    } else {
                        role = "READER";
                    }
                    return new User(account.getLogin(), account.getPassword(), true, true, true, true,
                            AuthorityUtils.createAuthorityList(role));
                } else {
                    throw new UsernameNotFoundException("could not find the user '"
                            + login + "'");
                }
            }
        };
    }
}
