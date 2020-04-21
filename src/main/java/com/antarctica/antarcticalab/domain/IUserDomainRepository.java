package com.antarctica.antarcticalab.domain;

import com.antarctica.antarcticalab.entity.UserEntity;

public interface IUserDomainRepository {
	UserEntity findByUsername (String userName);
	UserEntity save(UserEntity userEntity);

}
