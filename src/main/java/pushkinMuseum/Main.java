package pushkinMuseum;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pushkinMuseum.model.AncientPiece;
import pushkinMuseum.model.Exhibition;
import pushkinMuseum.model.Painting;
import pushkinMuseum.view.ExhibitionLayoutController;
import pushkinMuseum.view.HallLayoutController;
import pushkinMuseum.view.ItemLayoutController;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.prefs.Preferences;

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
        ArrayList<String> materials1 = new ArrayList<>();
        materials1.add("дерево");
        materials1.add("темпера");
        hall1.add(new Painting("Рождение Венеры", "hall1", "An incredible painting",
                true, "-",
                "Боттичелли", "1486", 2785, 1725, materials1));
        hall1.add(new Painting("Бичевание Христа", "hall1", "An incredible painting 2",
                true, "file:src/main/java/pushkinMuseum/resources/test1.JpG",
                "Иоганн Кербеке", "1457", 930, 650, materials1));

        exhibitionData.add(new Exhibition("Картины", hall1, "Выставка картин эпохи Возрождения"));

        ObservableList<AncientPiece> hall2 = FXCollections.observableArrayList();
        hall2.add(new AncientPiece("Гидрия чернофигурная с изображением петухов", "Античное искусство. Кипр. Древняя Греция. Древний Рим", "В число крупнейших центров восточно-греческой вазописи, существовавших в VI в. до н.э. на побережье Малой Азии, входят Клазомены, располагавшиеся в Северной Ионии. Здесь около середины VI столетия, под влиянием керамики Коринфа и Аттики, складывается своя школа чернофигурных росписей. Их отличает темно-коричневый, почти черный лак силуэтных изображений, обильное применение тонкой и аккуратной гравировки, а также накладных красок, белой и пурпурной, положенных непосредственно на глину. Гидрии – одна из наиболее распространенных форм сосудов у клазоменских мастеров. Четкие, немного жестковатые контуры ваз, рельефные валики и выступы указывают на возможные металлические прототипы.\n" +
                "\n" +
                "Московская гидрия целиком покрыта черным лаком, за исключением «корзины» лучей над ножкой и двух клейм с росписью – на плечиках и тулове. В первом, обрамленном сверху узкой полоской язычков, изображены четыре сирены, во втором - два петуха в геральдической композиции. Лица и грудь сирен окрашены белой краской, перья крыльев всех существ переданы тщательной гравировкой, детали оперения сирен и петухов, гребни, бородки и шеи последних дополнены пурпуром и полосками мелких белых точек.\n" +
                "\n" +
                "Изображения петухов и сирен нередки в клазоменской керамике, прежде всего в группе, получившей название группа Урла (по названию современного местечка близ Клазомен). Росписи входящих в нее амфор и гидрий отличает любовь к полихромии, хотя рисунок не всегда четкий и аккуратный. Большинство ваз и фрагментов датируется между 540 – 520 гг. до н.э. Примечательно, что гидрии этой группы представлены почти исключительно фрагментами, московский сосуд – единственный целый экземпляр. Его великолепная сохранность объясняется тем, что ваза была найдена в погребении, случайно открытом близ станицы Таманская в 1929 году. Первоначально сосуд хранился в музее г. Темрюка. Во время Великой Отечественной войны он пропал, как и многие памятники крымских и южнорусских музеев. В 1960-е годы гидрия «всплыла» в Германии и была приобретена у частного лица Государственным собранием скульптуры Дрездена. Благодаря ранней, еще довоенной публикации вазы в одном из немецких археологических журналов, было установлено ее происхождение, и в 1969 году гидрия поступила в ГМИИ им. А.С.Пушкина.",
                true, "file:src/main/java/pushkinMuseum/resources/AncientPiece1.jpg", "третья четверть VI века до н.э.", "Клазомен"));

        exhibitionData.add(new Exhibition("Античное искусство", hall2, "Экспонаты античности"));
        //saveExhibitionDataToFile((ObservableList<T>) hall1, new File("database/data.xml"));
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


    /**
     * Возвращает preference файла адресатов, то есть, последний открытый файл.
     * Этот preference считывается из реестра, специфичного для конкретной
     * операционной системы. Если preference не был найден, то возвращается null.
     *
     * @return
     */
    public File getPersonFilePath() {
        Preferences prefs = Preferences.userNodeForPackage(Main.class);
        String filePath = prefs.get("filePath", null);
        if (filePath != null) {
            return new File(filePath);
        } else {
            return null;
        }
    }

    /**
     * Задаёт путь текущему загруженному файлу. Этот путь сохраняется
     * в реестре, специфичном для конкретной операционной системы.
     *
     * @param file - файл или null, чтобы удалить путь
     */
    public void setPersonFilePath(File file) {
        Preferences prefs = Preferences.userNodeForPackage(Main.class);
        if (file != null) {
            prefs.put("filePath", file.getPath());

            // Обновление заглавия сцены.
            primaryStage.setTitle("AddressApp - " + file.getName());
        } else {
            prefs.remove("filePath");

            // Обновление заглавия сцены.
            primaryStage.setTitle("AddressApp");
        }
    }

//    /**
//     * Загружает информацию об адресатах из указанного файла.
//     * Текущая информация об адресатах будет заменена.
//     *
//     * @param file
//     */
//    public void loadexhibitionDataFromFile(File file) {
//        try {
//            JAXBContext context = JAXBContext
//                    .newInstance(ExhibitionDataWrapper.class);
//            Unmarshaller um = context.createUnmarshaller();
//
//            // Чтение XML из файла и демаршализация.
//            ExhibitionDataWrapper wrapper = (ExhibitionDataWrapper) um.unmarshal(file);
//
//            exhibitionData.clear();
//            exhibitionData.addAll((Exhibition<T>) wrapper.getExhibitions());
//
//            // Сохраняем путь к файлу в реестре.
//            setPersonFilePath(file);
//
//        } catch (Exception e) { // catches ANY exception
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Error");
//            alert.setHeaderText("Could not load data");
//            alert.setContentText("Could not load data from file:\n" + file.getPath());
//
//            alert.showAndWait();
//        }
//    }
//
//    /**
//     * Сохраняет текущую информацию об адресатах в указанном файле.
//     *
//     * @param file
////     */
//    public void saveExhibitionDataToFile(ObservableList<T> observableList, File file) {
//        try {
//            JAXBContext context = JAXBContext
//                    .newInstance(ExhibitListWrapper.class);
//            Marshaller m = context.createMarshaller();
//            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//            // Обёртываем наши данные об адресатах.
//            ExhibitionDataWrapper wrapper = new ExhibitionDataWrapper();
//            wrapper.setExhibitions(observableList);
//
//            // Маршаллируем и сохраняем XML в файл.
//            m.marshal(wrapper, file);
//
//            // Сохраняем путь к файлу в реестре.
//            setPersonFilePath(file);
//        } catch (Exception e) { // catches ANY exception
//            System.out.println(e);
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Error");
//            alert.setHeaderText("Could not save data");
//            alert.setContentText("Could not save data to file:\n" + file.getPath());
//
//            alert.showAndWait();
//        }
//    }

    public static void main(String[] args) {
        launch(args);
    }
}
