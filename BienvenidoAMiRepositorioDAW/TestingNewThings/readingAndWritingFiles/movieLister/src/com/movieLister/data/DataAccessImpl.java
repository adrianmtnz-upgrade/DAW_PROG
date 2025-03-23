package TestingNewThings.readingAndWritingFiles.movieLister.src.com.movieLister.data;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

import TestingNewThings.readingAndWritingFiles.movieLister.src.com.movieLister.domain.Movie;
import TestingNewThings.readingAndWritingFiles.movieLister.src.com.movieLister.exceptions.DataAccessException;
import TestingNewThings.readingAndWritingFiles.movieLister.src.com.movieLister.exceptions.DataReaderException;
import TestingNewThings.readingAndWritingFiles.movieLister.src.com.movieLister.exceptions.DataWriterException;

public class DataAccessImpl implements DataAccessible{

    @Override
    public boolean fileExistenceCheck(String resourceName) throws DataAccessException {
        // Check if the file exists
        File file = new File(resourceName);
        return file.exists();
    }

    @Override
    public List<Movie> listMovies(String resourceName) throws DataReaderException {
        // List all movies from the file
        File file = new File(resourceName);
        List<Movie> movies = new ArrayList<>();
        try {
            BufferedReader BR = new BufferedReader(new FileReader(file));
            String content = null;
            content = BR.readLine();
                
            while (content != null) {
                // Create a new movie object and add it to the list
                Movie movie = new Movie(content);
                movies.add(movie);
                content = BR.readLine();
            }
            BR.close();

        } catch (IOException exception) {
            exception.printStackTrace(System.out);
            throw new DataReaderException("Exception on movie listing: " + exception.getMessage());
        } 
        return movies;
    }

    @Override
    public void writeMovie(Movie movie, String resourceName, boolean append) throws DataWriterException {
        // Write a movie to the file
        File file = new File(resourceName);
        try {
            PrintWriter out = new PrintWriter(new FileWriter(file, append));
            out.println(movie.toString());
            out.close();
        } catch (IOException exception) {
            exception.printStackTrace(System.out);
            throw new DataWriterException("Exception on writing file: " + exception.getMessage());
        }
    }

    @Override
    public String searchMovies(String resourceName, String searchResource) throws DataReaderException {
        // Search for a movie in the file
        File file = new File(resourceName);
        String result = null;
        try {
            BufferedReader BR = new BufferedReader(new FileReader(file));
            String line = null;
            line = BR.readLine();
            
            for(int index= 1; line != null; index++) {
                if(searchResource != null && searchResource.equalsIgnoreCase(line)){
                    // Movie found
                    result = "Movie: " + line + " found on index " + index;
                    break;
                }
                line = BR.readLine();    
            }
            BR.close();
            return result;
        } catch (IOException exception) {
            exception.printStackTrace(System.out);
            throw new DataReaderException("Exception on movie searching: " + exception.getMessage());
        }
        
    }

    @Override
    public void createFile(String resourceName) throws DataAccessException {
        // Create a new file
        File file = new File(resourceName);
        try {
            PrintWriter out = new PrintWriter(new FileWriter(file));
            out.close();
            System.out.println("File has been created");
        } catch (IOException exception) {
            exception.printStackTrace(System.out);
            throw new DataAccessException("Exception on creating file: "+ exception.getMessage());        
        }
    }

    @Override
    public void deleteFile(String resourceName) throws DataAccessException {
        // Delete the file
        File file = new File(resourceName);
        if(file.exists()) file.delete();
        System.out.println("File has been deleted");
    }
}
