package com.antarctica.antarcticalab.service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.antarctica.antarcticalab.common.RegisterUserInit;
import com.antarctica.antarcticalab.common.Roles;
import com.antarctica.antarcticalab.domain.IRoleDomaineRepository;
import com.antarctica.antarcticalab.domain.IUserDomainRepository;
import com.antarctica.antarcticalab.entity.RoleEntity;
import com.antarctica.antarcticalab.entity.UserEntity;

@Service
public class UserService implements IUserService {
	@Autowired
	IUserDomainRepository iUserDomainRepository;

	@Autowired
	IRoleDomaineRepository iRoleDomaineRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails userDetails = iUserDomainRepository.findByUsername(username);
		if (userDetails == null) {
			return null;
		}
		return iUserDomainRepository.findByUsername(username);
	}

	@Override
	public UserEntity registerUser(RegisterUserInit init) {
		UserEntity userEntity = iUserDomainRepository.findByUsername(init.getUserName());
		if (userEntity == null) {
			userEntity= new UserEntity();
			//TODO check if the username and email and authorities are not null or invalid
			userEntity.setUsername(init.getUserName());
			userEntity.setEmail(init.getEmail());
			userEntity.setAuthorities(getImmutableUserRoles());
			userEntity.setPassword(UUID.randomUUID().toString());
			iUserDomainRepository.save(userEntity);
		}
		return userEntity;
	}

	private List<RoleEntity> getImmutableUserRoles() {
		RoleEntity roleEntity = iRoleDomaineRepository.findByAuthority(Roles.ROLE_USER.name());
		return Collections.singletonList(roleEntity);

	}

}
