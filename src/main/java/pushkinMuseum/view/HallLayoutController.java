package pushkinMuseum.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pushkinMuseum.Main;
import pushkinMuseum.model.Exhibit;
import pushkinMuseum.model.Exhibition;

public class HallLayoutController<T> {

    @FXML
    private Label exhibitNameLabel;

    @FXML
    private TableView<T> exhibitList;

    @FXML
    private TableColumn<T, String> exhibitNameColumn;

    @FXML
    private ImageView imageView;

    private Main<T> mainClass;
    private Exhibition<T> exhibition;

    @FXML
    private void initialize(){
        exhibitList.setRowFactory(tableView -> {
            final TableRow<T> row = new TableRow<>();

            row.hoverProperty().addListener((observable) -> {
                final T exhibit = row.getItem();
                //final Exhibit exhibit = row.getItem();

                if (row.isHover() && exhibit != null) {
                    //if (exhibit.getClass().isInstance(new Exhibit()))
                    Exhibit exhibit1 = (Exhibit) exhibit;
                    exhibitNameLabel.setText(exhibit1.getName());
                    if (!exhibit1.getImagePath().equals("-")){
                        Image image = new Image(exhibit1.getImagePath());
                        imageView.setImage(image);
                    }

                } else {
                    exhibitNameLabel.setText("");
                    imageView.setImage(null);
                }
            });

            return row;
        });

        showExhibitDetails(null);
        exhibitNameColumn.setCellValueFactory(cellData -> {
            Exhibit exhibit = (Exhibit) cellData.getValue();
            return exhibit.nameProperty();
        });
        //exhibitNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        exhibitList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showExhibit(newValue));
    }

    public void setMainApp(Main<T> mainClass, Exhibition<T> exhibition){
        this.mainClass = mainClass;
        this.exhibition = exhibition;
        exhibitNameColumn.setText(exhibition.getName());
        exhibitList.setItems(exhibition.getList());
    }

    private void showExhibitDetails(Exhibit exhibit){
        if (exhibit != null){
            exhibitNameLabel.setWrapText(true);
            exhibitNameLabel.setText(exhibit.getDescription());
        } else {
            exhibitNameLabel.setText("");
        }
    }

    private void showExhibit(T exhibit){
        //still not null
        mainClass.initExhibitLayout(exhibit, exhibition);
    }

    @FXML
    void backToExhibitionsButton(ActionEvent event) {
        mainClass.initExhibitionLayout();
    }

}

