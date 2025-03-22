package movieLister.src.com.movieLister.domain;

public class Movie {
    private String title;

    public Movie() {

    }

    public Movie(String title) {
        this.title = title;
    }

    public String gettitle() {
        return title;
    }

    public void settitle(String title) {
        this.title = title;
    }

    @Override
    public String toString(){
        return "Movie: "+ title + "\n";
    }
}
