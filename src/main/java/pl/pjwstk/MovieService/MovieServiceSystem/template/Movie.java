package pl.pjwstk.MovieService.MovieServiceSystem.template;

import jakarta.persistence.*;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   private String name;
    @Enumerated(EnumType.STRING)
   private Category category;
   private int year;

    @Column(name = "isAvailable", nullable = false)
    private boolean isAvailable;

    public Movie(int id, String name, Category category, int year, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.year = year;
        this.isAvailable = isAvailable;
    }

    public Movie() {

    }

    public enum Category{
        HORROR,
        SCIFI,
        FANTASY,
        THRILLER,
        ACTION
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
