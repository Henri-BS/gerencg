package com.altercode.gerencg.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.altercode.gerencg.entity.Authority;

@Service
@Transactional
public class AuthorityService {

	public Authority createAuthority(String roleCode, String roleDescription) {
		Authority authority = new Authority();
		authority.setRoleCode(roleCode);
		authority.setRoleDescription(roleDescription);
		return authority;
	}
}
