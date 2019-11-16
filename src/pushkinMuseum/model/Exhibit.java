package pushkinMuseum.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Exhibit {
    private StringProperty name;
    private String exhibitionHall;
    private String description;
    private boolean originality;
    private String imagePath;

    public Exhibit(String name, String exhibitionHall, String description, boolean originality, String imagePath) {
        this.name = new SimpleStringProperty(name);
        this.exhibitionHall = exhibitionHall;
        this.description = description;
        this.originality = originality;
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getExhibitionHall() {
        return exhibitionHall;
    }

    public void setExhibitionHall(String exhibitionHall) {
        this.exhibitionHall = exhibitionHall;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isOriginality() {
        return originality;
    }

    public void setOriginality(boolean originality) {
        this.originality = originality;
    }

    public StringProperty nameProperty() {
        return name;
    }
}
