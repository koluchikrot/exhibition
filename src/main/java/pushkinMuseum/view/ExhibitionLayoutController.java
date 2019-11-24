package pushkinMuseum.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import pushkinMuseum.Main;
import pushkinMuseum.model.Exhibition;

public class ExhibitionLayoutController {

    @FXML
    private TableView<Exhibition> hallList;
    @FXML
    private TableColumn<Exhibition, String> hallNameColumn;
    @FXML
    private Label hallDescriptionLabel;

    private Main mainClass;

    public ExhibitionLayoutController() {
    }


    @FXML
    private void initialize(){
        hallList.setRowFactory(exhibitionTableView -> {
            final TableRow<Exhibition> row = new TableRow<>();
            row.hoverProperty().addListener((observable) -> {
                final Exhibition exhibition = row.getItem();
                if (row.isHover()){
                    showHallDetails(exhibition);
                }
            });
            return row;
        });

        hallNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        showHallDetails(null);

        hallList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showHall(newValue));
    }

    public void setMainApp(Main mainClass) {
        this.mainClass = mainClass;

        // Добавление в таблицу данных из наблюдаемого списка
        hallList.setItems(mainClass.getExhibitionData());
    }

    private void showHallDetails(Exhibition exhibition){
        if (exhibition != null){
            hallDescriptionLabel.setWrapText(true);
            hallDescriptionLabel.setText(exhibition.getDescription());
        } else {
            hallDescriptionLabel.setText("");
        }
    }

    private void showHall(Exhibition exhibition){
        mainClass.initHallLayout(exhibition);
    }
}
