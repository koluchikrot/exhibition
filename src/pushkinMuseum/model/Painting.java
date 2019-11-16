package pushkinMuseum.model;

public class Painting extends ArtWork {
    private String[] materials;

    public Painting(String name, String exhibitionHall, String description, boolean originality, String imagePath, String artist, int year, int length, int width, String[] materials) {
        super(name, exhibitionHall, description, originality, imagePath, artist, year, length, width);
        this.materials = materials;
    }

    public String[] getMaterials() {
        return materials;
    }

    public void setMaterials(String[] materials) {
        this.materials = materials;
    }
}
