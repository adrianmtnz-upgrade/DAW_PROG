package movieLister.src.com.movieLister.service;

import java.util.List;

import movieLister.src.com.movieLister.data.*;
import movieLister.src.com.movieLister.domain.Movie;
import movieLister.src.com.movieLister.exceptions.DataAccessException;

public class MovieControlImpl implements ControllableMovie {

    private final DataAccessible data = new DataAccessImpl();

    public MovieControlImpl(){
        // Empty constructor
    }

    @Override
    public void addMovie(String title) {
        // Create a new movie object
        Movie movie = new Movie(title);
        boolean append = false;

        try {
            // Check if the file exists and set append mode accordingly
            append = this.data.fileExistenceCheck(RESOURCE_NAME);
            // Write the movie to the file
            this.data.writeMovie(movie, RESOURCE_NAME, append);    
        } catch (DataAccessException exception) {
            // Handle data access exception
            System.out.println("Data access error");
            exception.printStackTrace(System.out);
        }
    }

    @Override
    public void list() {
        try {
            // Retrieve the list of movies from the file
            List<Movie> movies = this.data.listMovies(RESOURCE_NAME);
            // Print each movie
            for(Movie movie : movies){
                System.out.println(movie);
            }     
        } catch (DataAccessException exception) {
            // Handle data access exception
            System.out.println("Data access error");
            exception.printStackTrace(System.out);
        }
    }

    @Override
    public void search(String movieToSearch) {
        String result = null;
        
        try {
            // Search for the movie in the file
            result = this.data.searchMovies(RESOURCE_NAME, movieToSearch);
        } catch (DataAccessException exception) {
            // Handle data access exception
            System.out.println("Data access error");
            exception.printStackTrace(System.out);
        }

        // Print the search result
        if(result == null) {
            System.out.println("Couldn't found the movie: " + movieToSearch);
        } else {
            System.out.println(result);
        }
    }

    @Override
    public void initiateNewMovieController() {
        try {
            // Resets the file if exists
            if (this.data.fileExistenceCheck(RESOURCE_NAME)) {
                System.out.println();
                data.deleteFile(RESOURCE_NAME);
                data.createFile(RESOURCE_NAME);
            } else {
                // If it doesn't exist creates a new one
                System.out.println();
                data.createFile(RESOURCE_NAME);
            }
        } catch (DataAccessException exception) {
            // Handle data access exception
            System.out.println("Error while trying to initiate the movie controller");
            exception.printStackTrace(System.out);
        }
    }

}
