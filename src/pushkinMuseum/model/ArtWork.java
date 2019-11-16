package pushkinMuseum.model;

public class ArtWork extends Exhibit {
    private String artist;
    private int year;
    private int length;
    private int width;

    public ArtWork(String name, String exhibitionHall, String description, boolean originality, String imagePath, String artist, int year, int length, int width) {
        super(name, exhibitionHall, description, originality, imagePath);
        this.artist = artist;
        this.year = year;
        this.length = length;
        this.width = width;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getlength() {
        return length;
    }

    public void setlength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
