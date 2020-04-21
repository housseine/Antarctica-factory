package com.antarctica.antarcticalab.infra.bdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.antarctica.antarcticalab.domain.IRoleDomaineRepository;
import com.antarctica.antarcticalab.entity.RoleEntity;

@Component
public class RoleRepository implements IRoleDomaineRepository {

	@Autowired
	IRoleRepository iRoleRepository;

	@Override
	public RoleEntity findByAuthority(String authority) {
		return iRoleRepository.findByAuthority(authority);
	}

}
