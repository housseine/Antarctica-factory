package com.antarctica.antarcticalab.domain;

import com.antarctica.antarcticalab.entity.RoleEntity;

public interface IRoleDomaineRepository {
	RoleEntity findByAuthority(String authority);
}
