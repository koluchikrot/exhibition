package pushkinMuseum.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AncientPiece extends Exhibit {
    private StringProperty period;
    private StringProperty location;

    public AncientPiece(String name, String exhibitionHall, String description, boolean originality, String imagePath, String period, String location) {
        super(name, exhibitionHall, description, originality, imagePath);
        this.period = new SimpleStringProperty(period);
        this.location = new SimpleStringProperty(location);
    }

    public String getPeriod() {
        return period.get();
    }

    public StringProperty periodProperty() {
        return period;
    }

    public void setPeriod(String period) {
        this.period.set(period);
    }

    public String getLocation() {
        return location.get();
    }

    public StringProperty locationProperty() {
        return location;
    }

    public void setLocation(String location) {
        this.location.set(location);
    }
}
