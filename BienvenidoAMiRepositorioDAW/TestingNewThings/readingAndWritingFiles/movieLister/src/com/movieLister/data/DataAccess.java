package movieLister.src.com.movieLister.data;

import java.util.List;

import movieLister.src.com.movieLister.domain.Movie;
import movieLister.src.com.movieLister.exceptions.DataAccessException;
import movieLister.src.com.movieLister.exceptions.DataReaderException;
import movieLister.src.com.movieLister.exceptions.DataWriterException;

public interface DataAccess {
    
    // Creating necessary methods to execute operations on the file
    public boolean fileExistenceCheck(String resourceName) throws DataAccessException;
    public List<Movie> listMovies(String resourceName) throws DataReaderException;
    public void writeMovie(Movie movie, String resourceName, boolean append) throws DataWriterException;
    public String searchMovies(String resourceName, String searchResource) throws DataReaderException;
    public void createFile(String resourceName) throws DataAccessException;
    public void deleteMovie(String resourceName) throws DataAccessException;
}
