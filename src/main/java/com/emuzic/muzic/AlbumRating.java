package com.emuzic.muzic;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.emuzic.muzic.entitybeans.Album;

public class AlbumRating implements RatingInterface<Album, Integer> {
	@Autowired
	EntityManager em;
	

	@Override
	public Integer getAverageRating(Album album) {
		String sql = "select avg(rating) from Ratings r where r.album.id = :id";
		Query query = em.createQuery(sql);
		query.setParameter("id", album.getId());
		Double average = (Double) query.getSingleResult();
		
		return new Integer(average.intValue());
	}

}
