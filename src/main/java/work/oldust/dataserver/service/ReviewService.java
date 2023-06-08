package work.oldust.dataserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import work.oldust.dataserver.entity.Review;
import work.oldust.dataserver.repository.ReviewRepository;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review findById(String id) {
        return reviewRepository.findById(id).orElse(null);
    }

    public Review save(Review review) {
        return reviewRepository.save(review);
    }
}
