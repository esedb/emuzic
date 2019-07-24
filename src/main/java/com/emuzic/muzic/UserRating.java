package com.emuzic.muzic;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.emuzic.muzic.entitybeans.Users;

@Qualifier("userrating")
public class UserRating implements RatingInterface<Users, Integer> {
	@Autowired
	private EntityManager em;

	@Override
	public Integer getAverageRating(Users u) {
		String sql = "select avg(rating) from Ratings r where r.user.username = :username";
		Query query = em.createQuery(sql);
		query.setParameter("username", u.getUsername());
		Double average = (Double) query.getSingleResult();		
		
		return new Integer(average.intValue());
	}
	

}
