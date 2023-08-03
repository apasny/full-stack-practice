package com.apasny.fullstackpractice.controller;

import com.apasny.fullstackpractice.entity.Review;
import com.apasny.fullstackpractice.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000/")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> create(@RequestBody Map<String, String> payload, UriComponentsBuilder ucb)  {
        Review savedReview = reviewService.createReview(
                payload.get("reviewBody"),
                payload.get("imdbId")
        );
        URI locationOfNewReview = ucb
                .path("/{id}")
                .buildAndExpand(savedReview.getId())
                .toUri();
        return ResponseEntity.created(locationOfNewReview).build();
    }

}
