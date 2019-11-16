package pushkinMuseum.model;

public class Sculpture extends ArtWork {
    private String material;
    private String height;

    public Sculpture(String name, String exhibitionHall, String description, boolean originality, String imagePath, String artist, int year, int length, int width, String material, String height) {
        super(name, exhibitionHall, description, originality, imagePath, artist, year, length, width);
        this.material = material;
        this.height = height;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

}
