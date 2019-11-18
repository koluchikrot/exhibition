package pushkinMuseum;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pushkinMuseum.model.Exhibit;
import pushkinMuseum.model.Exhibition;
import pushkinMuseum.model.Painting;
import pushkinMuseum.view.ExhibitionLayoutController;
import pushkinMuseum.view.HallLayoutController;
import pushkinMuseum.view.ItemLayoutController;

import java.io.IOException;

public class Main<T> extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;

    private ObservableList<Exhibition<T>> exhibitionData = FXCollections.observableArrayList();

    public ObservableList<Exhibition<T>> getExhibitionData() {
        return exhibitionData;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public Main() {
        //test data
        ObservableList<Painting> hall1 = FXCollections.observableArrayList();
        hall1.add(new Painting("Рождение Венеры", "hall1", "An incredible painting", true, "-",
                "Боттичелли", "1486", 2785, 1725, new String[2]));
        hall1.add(new Painting("Бичевание Христа", "hall1", "An incredible painting 2", true, "file:/Users/koluchikrot/IdeaProjects/Exhibition/src/pushkinMuseum/resources/test1.JpG",
                "Иоганн Кербеке", "1457", 930, 650, new String[2]));

        exhibitionData.add(new Exhibition("Картины", hall1, "Выставка картин эпохи Возрождения"));
    }

    @Override
    public void start(Stage primaryStage){
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");

        initRootLayout();

        initExhibitionLayout();
    }

    private void initRootLayout() {
        try {
            // Загружаем корневой макет из fxml файла.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = loader.load();

            // Отображаем сцену, содержащую корневой макет.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initExhibitionLayout(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/exhibitionLayout.fxml"));
            AnchorPane pane = loader.load();

            rootLayout.setCenter(pane);
            ExhibitionLayoutController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void initHallLayout(Exhibition exhibition){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/hallLayout.fxml"));
            AnchorPane pane = loader.load();

            rootLayout.setCenter(pane);
            HallLayoutController controller = loader.getController();
            controller.setMainApp(this, exhibition);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initExhibitLayout(T exhibit, Exhibition<T> exhibition){
        //still not null
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/itemLayout.fxml"));
            BorderPane pane = loader.load();

            rootLayout.setCenter(pane);
            ItemLayoutController<T> controller = loader.getController();
            controller.setMainApp(this, exhibit, exhibition);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
