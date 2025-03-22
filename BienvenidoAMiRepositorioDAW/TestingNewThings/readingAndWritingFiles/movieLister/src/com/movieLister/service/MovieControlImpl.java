package movieLister.src.com.movieLister.service;

import java.util.List;

import movieLister.src.com.movieLister.data.*;
import movieLister.src.com.movieLister.domain.Movie;
import movieLister.src.com.movieLister.exceptions.DataAccessException;

public class MovieControlImpl implements ControllableMovie {

    private final DataAccessible data;

    public MovieControlImpl(DataAccessible data){
        this.data = new DataAccessImpl();
    }

    @Override
    public void addMovie(String movieTitle) {
        Movie movie = new Movie(movieTitle);
        boolean append;

        try {
            append = data.fileExistenceCheck(RESOURCE_NAME);
            data.writeMovie(movie, RESOURCE_NAME, append);    
        } catch (DataAccessException exception) {
            System.out.println("Data access error");
            exception.printStackTrace(System.out);
        }
    }

    @Override
    public void listMovies() {
       
        try {
            List<Movie> movies = this.data.listMovies(RESOURCE_NAME);
            for(Movie movie : movies){
                System.out.println("Movie: " + movie);
            }     
        } catch (DataAccessException exception) {
            System.out.println("Data access error");
            exception.printStackTrace(System.out);
        }
    }

    @Override
    public void searchMovie(String movieToSearch) {
        String result = null;
        
        try {
            result = this.data.searchMovies(RESOURCE_NAME, movieToSearch);
            System.out.println("Found movie: " + result);
            
        } catch (DataAccessException exception) {
            System.out.println(
                "Data access error" + "\n" +
                "Couldn't found the movie: " + movieToSearch
            );
            exception.printStackTrace(System.out);
        }
    }

    @Override
    public void initiateNewMovieController() {
       
        try {
                // Resets the file if exists
            if (this.data.fileExistenceCheck(RESOURCE_NAME)) {
                data.deleteFile(RESOURCE_NAME);
                data.createFile(RESOURCE_NAME);
            } else {
                // If it doesn't exist creates a new one
                data.createFile(RESOURCE_NAME);
            }
            
        } catch (DataAccessException exception) {
            System.out.println("Error while trying to initiate the movie controller");
            exception.printStackTrace(System.out);
        }
    }

}
