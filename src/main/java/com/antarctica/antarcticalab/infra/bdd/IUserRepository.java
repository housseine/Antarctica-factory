package com.antarctica.antarcticalab.infra.bdd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.antarctica.antarcticalab.entity.UserEntity;
@Repository
public interface IUserRepository  extends JpaRepository<UserEntity, Long>{
	UserEntity findByUsername(String username);
}
