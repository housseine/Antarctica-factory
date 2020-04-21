package com.antarctica.antarcticalab.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.antarctica.antarcticalab.common.RegisterUserInit;
import com.antarctica.antarcticalab.entity.UserEntity;


public interface IUserService extends UserDetailsService {
	UserEntity registerUser(RegisterUserInit init);
}
