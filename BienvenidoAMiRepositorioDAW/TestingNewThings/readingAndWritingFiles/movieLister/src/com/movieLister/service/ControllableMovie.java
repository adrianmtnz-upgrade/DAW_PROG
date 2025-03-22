package movieLister.src.com.movieLister.service;

public interface ControllableMovie {

    String RESOURCE_NAME = "";

    public void addMovie(String movieTitle);

    public void listMovies();

    public void searchMovie(String movieToSearch);

    public void initiateNewMovieController();
}
