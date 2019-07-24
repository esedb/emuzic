package com.emuzic.muzic;

import org.springframework.stereotype.Component;

@Component
public interface RatingInterface<T, R> {
	R getAverageRating(T t);
}
