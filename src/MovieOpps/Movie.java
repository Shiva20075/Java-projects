package MovieOpps;

public class Movie {
    private String title;
    private int releasedYear;
    private String director;
    private double rating;

    public Movie(String title, int releasedYear,String director, double rating)
    {
        this.title = title;
        this.releasedYear = releasedYear;
        this.director = director;
        this.rating = rating;
    }
    public int getReleasedYear() {
        return releasedYear;
    }

    public void setReleasedYear(int releasedYear) {
        this.releasedYear = releasedYear;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }


    public void displeyInfo(){

        System.out.println("MOVIE TITLE = " + title);
        System.out.println("MOVIE RELEASED IN = " + releasedYear);
        System.out.println("MOVIE DIRECTOR = " + director);
        System.out.println("MOVIE RATING = " + rating);
    }
}
