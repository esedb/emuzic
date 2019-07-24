package com.emuzic.muzic;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.emuzic.muzic.entitybeans.Music;

@Qualifier("musicrating")
public class MusicRating implements RatingInterface<Music, Integer> {
	@Autowired
	EntityManager em;

	@Override
	public Integer getAverageRating(Music music) {
		String sql = "select avg(rating) from Ratings r where r.music.id = :id";
		Query query = em.createQuery(sql);
		query.setParameter("id", music.getId());
		Double average = (Double) query.getSingleResult();
		
		return new Integer(average.intValue());
	}

}
