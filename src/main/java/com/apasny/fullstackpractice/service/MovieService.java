package com.apasny.fullstackpractice.service;

import com.apasny.fullstackpractice.entity.Movie;
import com.apasny.fullstackpractice.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.InvalidMongoDbApiUsageException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(String imdbId) {
        return movieRepository.findByImdbId(imdbId).orElseThrow(() -> new InvalidMongoDbApiUsageException("MOVIE NOT FOUND"));
    }
}
