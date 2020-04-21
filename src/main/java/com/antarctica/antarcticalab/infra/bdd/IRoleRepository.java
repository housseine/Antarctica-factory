package com.antarctica.antarcticalab.infra.bdd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.antarctica.antarcticalab.entity.RoleEntity;

@Repository
public interface IRoleRepository extends JpaRepository<RoleEntity, Long> {
	RoleEntity findByAuthority(String authority);
}
