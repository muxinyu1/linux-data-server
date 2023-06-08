package work.oldust.dataserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import work.oldust.dataserver.entity.Response;
import work.oldust.dataserver.entity.Review;
import work.oldust.dataserver.service.ReviewService;

@RestController
@RequestMapping("/review")
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/{id}")
    public Response<Review> findById(@PathVariable("id") String id) {
        final var review = reviewService.findById(id);
        if (review == null) {
            return new Response<>(1, "Review does not exist", null);
        }
        return new Response<>(0, "success", review);
    }

    @PostMapping("/save")
    public Response<Review> save(Review review) {
        if (reviewService.findById(review.getId()) != null) {
            // 评论已存在
            return new Response<>(1, "Review has already existed", null);
        }
        return new Response<>(0, "success", reviewService.save(review));
    }
}
