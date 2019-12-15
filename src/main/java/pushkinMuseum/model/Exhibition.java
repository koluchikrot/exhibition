package pushkinMuseum.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class Exhibition<T> {
    final private StringProperty name;
    private ObservableList<T> list;
    private StringProperty description;


    public Exhibition(String name, ObservableList<T> list, String description) {
        this.name = new SimpleStringProperty(name);
        this.list = list;
        this.description = new SimpleStringProperty(description);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public ObservableList getList() {
        return list;
    }

    public void setList(ObservableList<T> list) {
        this.list = list;
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void searchByPicture(String path){
        //DoGSIFTEngine engine = new DoGSIFTEngine();
    }
}
