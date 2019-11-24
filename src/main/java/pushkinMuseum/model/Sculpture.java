package pushkinMuseum.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Sculpture extends ArtWork {
    private StringProperty material;
    private IntegerProperty height;

    public Sculpture(String name, String exhibitionHall, String description, boolean originality, String imagePath, String artist, String year, int length, int width, String material, int height) {
        super(name, exhibitionHall, description, originality, imagePath, artist, year, length, width);
        this.material = new SimpleStringProperty(material);
        this.height = new SimpleIntegerProperty(height);
    }

    public String getMaterial() {
        return material.get();
    }

    public void setMaterial(String material) {
        this.material.set(material);
    }

    public int getHeight() {
        return height.get();
    }

    public void setHeight(int height) { this.height.set(height); }

    public StringProperty materialProperty() { return material; }

    public IntegerProperty heightProperty() { return height; }
}
