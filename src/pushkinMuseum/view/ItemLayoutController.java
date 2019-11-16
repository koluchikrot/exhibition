package pushkinMuseum.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pushkinMuseum.Main;
import pushkinMuseum.model.Exhibit;
import pushkinMuseum.model.Exhibition;

public class ItemLayoutController<T> {

    @FXML
    private ImageView imageView;

    @FXML
    private Label nameField;

    @FXML
    private TextArea descriptionField;

    @FXML
    private Button backButton;

    @FXML
    private Button nextButton;

    private Main<T> mainClass;

    private Exhibition<T> exhibition;

    private T exhibit;


    @FXML
    private void initialize(){

    }

    public void setMainApp(Main<T> mainClass, T exhibit, Exhibition<T> exhibition){
        this.mainClass = mainClass;
        this.exhibit = exhibit;
        this.exhibition = exhibition;
        Exhibit exhibit1 = (Exhibit) this.exhibit;
        if (exhibit1 != null){
            if (!exhibit1.getImagePath().equals("-")){
                Image image = new Image(exhibit1.getImagePath());
                imageView.setImage(image);
            }
            nameField.setText(exhibit1.getName());
            descriptionField.setText(exhibit1.getDescription());
        }
    }
    @FXML
    void backToHallButton(ActionEvent event) {
        mainClass.initHallLayout(exhibition);
    }

    @FXML
    void backButtonAction(ActionEvent event) {
        if (exhibition.getList().indexOf(exhibit) != 0){
            mainClass.initExhibitLayout((T) exhibition.getList().get(exhibition.getList().indexOf(exhibit) - 1), exhibition);
        } else {
            mainClass.initExhibitLayout((T) exhibition.getList().get(exhibition.getList().size() - 1), exhibition);
        }
    }

    @FXML
    void nextButtonAction(ActionEvent event) {
        if (exhibition.getList().indexOf(exhibit) != exhibition.getList().size() - 1){
            mainClass.initExhibitLayout((T) exhibition.getList().get(exhibition.getList().indexOf(exhibit) + 1), exhibition);
        } else {
            mainClass.initExhibitLayout((T) exhibition.getList().get(0), exhibition);
        }
    }

}
