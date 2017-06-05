package org.smart.earn.services.auth;

import java.util.List;

import org.smart.earn.model.AuthUser;

public interface AuthorizationService {

	AuthUser findById(long id);

	AuthUser findByUsername(String username);

	List<AuthUser> findByEmailMobileNo(String mobileNo, String email);

	boolean saveUser(AuthUser user);

	void updateUser(AuthUser user);

	void deleteUserById(long id);

	List<AuthUser> findAllUsers();

	boolean isUserExist(AuthUser user);
}
