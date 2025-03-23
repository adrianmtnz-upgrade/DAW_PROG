package TestingNewThings.readingAndWritingFiles.movieLister.src.com.movieLister.service;

public interface ControllableMovie {

    // Path to the resource file containing the list of movies
    String RESOURCE_NAME = "BienvenidoAMiRepositorioDAW\\TestingNewThings\\readingAndWritingFiles\\movieLister\\movies.txt";

    public void addMovie(String movieTitle);

    public void list();

    public void search(String movieToSearch);

    public void initiateNewMovieController();
}
