package com.antarctica.antarcticalab.ressources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.antarctica.antarcticalab.entity.User;
import com.antarctica.antarcticalab.exception.ResourceNotFoundException;
import com.antarctica.antarcticalab.infra.bdd.UserRepository;
import com.antarctica.antarcticalab.security.CurrentUser;
import com.antarctica.antarcticalab.security.UserPrincipal;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}
