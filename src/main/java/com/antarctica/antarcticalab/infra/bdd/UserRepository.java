package com.antarctica.antarcticalab.infra.bdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.antarctica.antarcticalab.domain.IUserDomainRepository;
import com.antarctica.antarcticalab.entity.UserEntity;
@Component
public class UserRepository implements IUserDomainRepository {
	@Autowired
	IUserRepository iUserRepository;
	
	@Override
	public UserEntity findByUsername(String userName) {
		return iUserRepository.findByUsername(userName);
	}

	@Override
	public UserEntity save(UserEntity userEntity) {
		return iUserRepository.save(userEntity);
	}

}
