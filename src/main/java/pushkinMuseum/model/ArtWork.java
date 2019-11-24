package pushkinMuseum.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ArtWork extends Exhibit {
    private StringProperty artist;
    private StringProperty year;
    private IntegerProperty length;
    private IntegerProperty width;

    public ArtWork(String name, String exhibitionHall, String description, boolean originality, String imagePath, String artist, String year, int length, int width) {
        super(name, exhibitionHall, description, originality, imagePath);
        this.artist = new SimpleStringProperty(artist);
        this.year = new SimpleStringProperty(year);
        this.length = new SimpleIntegerProperty(length);
        this.width = new SimpleIntegerProperty(width);
    }

    public String getArtist() {
        return artist.get();
    }

    public void setArtist(String artist) {
        this.artist.set(artist);
    }

    public String getYear() {
        return year.get();
    }

    public void setYear(String year) {
        this.year.set(year);
    }

    public int getlength() {
        return length.get();
    }

    public void setlength(int length) {
        this.length.set(length);
    }

    public int getWidth() {
        return width.get();
    }

    public void setWidth(int width) {
        this.width.set(width);
    }

    public StringProperty artistProperty(){ return artist; }

    public StringProperty yearProperty(){ return year; }

    public IntegerProperty lengthProperty(){ return length; }

    public IntegerProperty widthProperty(){ return width; }
}
