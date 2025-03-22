package movieLister.src.com.movieLister.data;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

import movieLister.src.com.movieLister.domain.Movie;
import movieLister.src.com.movieLister.exceptions.DataAccessException;
import movieLister.src.com.movieLister.exceptions.DataReaderException;
import movieLister.src.com.movieLister.exceptions.DataWriterException;

public class DataAccessImpl implements DataAccess{

    @Override
    public boolean fileExistenceCheck(String resourceName) throws DataAccessException {
        File file = new File(resourceName);
        return file.exists();
    }

    @Override
    public List<Movie> listMovies(String resourceName) throws DataReaderException {
        File file = new File(resourceName);
        List<Movie> movies = new ArrayList<>();
        try {
            BufferedReader BR = new BufferedReader(new FileReader(file));
            String content = null;
            try {
                content = BR.readLine();
                while (content != null) {
                    Movie movie = new Movie(content);
                    movies.add(movie);
                    content = BR.readLine();
                }
                BR.close();
            } catch (IOException exception) {
                exception.printStackTrace(System.out);
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace(System.out);
            throw new DataReaderException("Exception on movie listing: " + exception.getMessage());
        } return movies;
    }

    @Override
    public void writeMovie(Movie movie, String resourceName, boolean append) throws DataWriterException {
        File file = new File(resourceName);
        try {
            PrintWriter out = new PrintWriter(new FileWriter(file, append));
            out.println(movie.toString());
            out.close();
            System.out.println("\n" + "Added movie: " + movie + "\n");
        } catch (IOException exception) {
            exception.printStackTrace(System.out);
            throw new DataWriterException("Exception on writting file: " + exception.getMessage());
        }
    }

    @Override
    public String searchMovies(String resourceName, String searchResource) throws DataReaderException {
        File file = new File(resourceName);
        String result = null;
        try {
            BufferedReader BR = new BufferedReader(new FileReader(file));
            String line = null;
            line = BR.readLine();
            int index = 1;
            
            while (line != null) {
                if(searchResource != null && searchResource.equalsIgnoreCase(line)){
                    System.out.println();
                    result = "Movie: " + line + "found on index " + index;
                    break;
                }
                BR.readLine();
                index++;    
            }
            BR.close();
        } catch (IOException exception) {
            exception.printStackTrace(System.out);
            throw new DataReaderException("Exception on movie searching: " + exception.getMessage());
        }
        return result;
    }

    @Override
    public void createFile(String resourceName) throws DataAccessException {
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
    public void deleteMovie(String resourceName) throws DataAccessException {
        File file = new File(resourceName);
        if(file.exists()) file.delete();
        System.out.println("File has been deleted");
    }
}
