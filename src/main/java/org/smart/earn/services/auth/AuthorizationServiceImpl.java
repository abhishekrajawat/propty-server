package org.smart.earn.services.auth;

import java.util.List;

import org.smart.earn.dao.authuser.AuthUserDao;
import org.smart.earn.model.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {

	@Autowired
	private AuthUserDao authUserDao;

        @Override
	public AuthUser findById(long id) {

		return authUserDao.findById(id);
	}

        @Override
	public AuthUser findByUsername(String username) {
		return authUserDao.findByUsername(username);
	}

        @Override
	public List<AuthUser> findByEmailMobileNo(String mobileNo, String email) {

		return authUserDao.findByEmailMobileNo(mobileNo, email);
	}

        @Override
	public boolean saveUser(AuthUser user) {
		return authUserDao.saveUser(user);

	}

        @Override
	public void updateUser(AuthUser user) {
		authUserDao.updateUser(user);

	}

        @Override
	public void deleteUserById(long id) {
		authUserDao.deleteUserById(id);

	}

        @Override
	public List<AuthUser> findAllUsers() {

		return authUserDao.findAllUsers();
	}

        @Override
	public boolean isUserExist(AuthUser user) {

		return authUserDao.isUserExist(user);
	}
}
