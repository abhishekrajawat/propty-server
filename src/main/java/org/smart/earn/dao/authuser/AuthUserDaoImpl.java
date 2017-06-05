package org.smart.earn.dao.authuser;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.smart.earn.model.AuthUser;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class AuthUserDaoImpl implements AuthUserDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public AuthUser findById(long id) {
		TypedQuery<AuthUser> query = entityManager.createQuery("SELECT a FROM AuthUser a WHERE a.userId = :id",
				AuthUser.class);
		return query.setParameter("id", id).getSingleResult();
	}

	@Override
	public AuthUser findByUsername(String username) {

		// CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		// CriteriaQuery<AuthUser> query = builder.createQuery(AuthUser.class);
		//
		// Root<AuthUser> user = query.from(AuthUser.class);
		// TypedQuery<AuthUser> typedQuery = entityManager.createQuery(query
		// .select(user)
		// .where(builder.and(
		// builder.equal(user.get("username"), username)
		// ))
		// .orderBy(builder.desc(user.get("regDate")))
		// );
		//
		// return typedQuery.getResultList();

		TypedQuery<AuthUser> query = entityManager.createQuery(
				"SELECT a FROM AuthUser a WHERE a.username = :username and a.isactive = :isActive", AuthUser.class);
		return query.setParameter("username", username).setParameter("isActive", "Y").getSingleResult();
	}

	@Override
	public List<AuthUser> findByEmailMobileNo(String mobileNo, String email) {
		if ((mobileNo != null && mobileNo.length() > 4) && (email != null && email.length() > 4)) {
			TypedQuery<AuthUser> query = entityManager.createQuery(
					"SELECT a FROM AuthUser a WHERE (a.email like :email or a.mobileNo like :mobileNo) and a.isactive = :isActive",
					AuthUser.class);
			return (List<AuthUser>) query.setParameter("email", "%" + email + "%")
					.setParameter("mobileNo", "%" + mobileNo + "%").setParameter("isActive", "Y").getResultList();
		} else if (mobileNo != null && mobileNo.length() > 4) {
			TypedQuery<AuthUser> query = entityManager.createQuery(
					"SELECT a FROM AuthUser a WHERE a.mobileNo like :mobileNo and a.isactive = :isActive",
					AuthUser.class);
			return (List<AuthUser>) query.setParameter("mobileNo", "%" + mobileNo + "%").setParameter("isActive", "Y")
					.getResultList();
		} else if (email != null && email.length() > 4) {
			TypedQuery<AuthUser> query = entityManager.createQuery(
					"SELECT a FROM AuthUser a WHERE a.email like :email and a.isactive = :isActive", AuthUser.class);
			return (List<AuthUser>) query.setParameter("email", "%" + email + "%").setParameter("isActive", "Y")
					.getResultList();
		} else {
			return null;
		}
	}

	@Override
	public boolean saveUser(AuthUser user) {
		try {
			entityManager.merge(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public void updateUser(AuthUser user) {
		AuthUser userFind = findById(user.getUserId());

		if (user.getFirstName() != null) {
			userFind.setFirstName(user.getFirstName());
		}

		if (user.getMiddleName() != null) {
			userFind.setMiddleName(user.getMiddleName());
		}

		if (user.getLastName() != null) {
			userFind.setLastName(user.getLastName());
		}

		if (user.getDateOfBirth() != null) {
			userFind.setDateOfBirth(user.getDateOfBirth());
		}
		
		if (user.getGender() != null) {
			userFind.setGender(user.getGender());
		}

		if (user.getEmail() != null) {
			userFind.setEmail(user.getEmail());
		}

		if (user.getUserImage() != null || ("").equalsIgnoreCase(user.getUserImage())) {
			userFind.setUserImage(user.getUserImage());
		} 

		if (user.getPhoneNo() != null) {
			userFind.setPhoneNo(user.getPhoneNo());
		}

		if (user.getMobileNo() != null) {
			userFind.setMobileNo(user.getMobileNo());
		}

		if (user.getAddressLine1() != null) {
			userFind.setAddressLine1(user.getAddressLine1());
		}

		if (user.getAddressLine2() != null) {
			userFind.setAddressLine2(user.getAddressLine2());
		}

		if (user.getCity() != null) {
			userFind.setCity(user.getCity());
		}

		if (user.getCity() != null) {
			userFind.setState(user.getState());
		}

		if (user.getCountry() != null) {
			userFind.setCountry(user.getCountry());
		}

		if (user.getPostCode() != null) {
			userFind.setPostCode(user.getPostCode());
		}

		if (user.getFaxNo() != null) {
			userFind.setFaxNo(user.getFaxNo());
		}

		if (user.getAlternateContact() != null) {
			userFind.setAlternateContact(user.getAlternateContact());
		}
		entityManager.flush();
	}

	@Override
	public void deleteUserById(long id) {
		AuthUser userFind = findById(id);
		userFind.setIsactive("N");
		entityManager.flush();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AuthUser> findAllUsers() {
		String hql = "FROM AuthUser as a where a.isactive = :isActive ORDER BY a.reg_date";
		return (List<AuthUser>) entityManager.createQuery(hql).setParameter("isActive", "Y").getResultList();
	}

	public boolean isUserExist(AuthUser user) {
		TypedQuery<AuthUser> query = entityManager.createQuery(
				"SELECT a FROM AuthUser a WHERE a.username =:username or a.mobileNo = :mobileNo or a.email = :email",
				AuthUser.class);

		return query.setParameter("username", user.getUsername()).setParameter("mobileNo", user.getMobileNo().trim())
				.setParameter("email", user.getEmail().trim()).getResultList().isEmpty() ? false : true;
	}

}
