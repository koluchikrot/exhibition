package pushkinMuseum.model;

import java.util.ArrayList;

public class Painting extends ArtWork {
    private ArrayList<String> materials;

    public Painting(String name, String exhibitionHall, String description, boolean originality, String imagePath, String artist, String year, int length, int width, ArrayList<String> materials) {
        super(name, exhibitionHall, description, originality, imagePath, artist, year, length, width);
        this.materials = materials;
    }

    public ArrayList<String> getMaterials() {
        return materials;
    }

    public void setMaterials(ArrayList<String> materials) {
        this.materials = materials;
    }
}
