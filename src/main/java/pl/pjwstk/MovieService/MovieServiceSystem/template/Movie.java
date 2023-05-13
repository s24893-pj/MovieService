package pl.pjwstk.MovieService.MovieServiceSystem.template;

public class Movie {
    private static int count = 0;
    int id;
    String name;
    String category;
    int year;

    public Movie(String name, String category, int year) {
        this.id = ++count;;
        this.name = name;
        this.category = category;
        this.year = year;
    }

    public Movie() {
        this.id = 0;
        this.name = "";
        this.category = "";
        this.year = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
