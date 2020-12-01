package sample.gui;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.models.Bush;
import sample.models.Flowers;
import sample.models.Plants;
import sample.models.Trees;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainFormController implements Initializable {
    public TableView mainTable;

    ObservableList<Plants> plantList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // заполнили список данными
        plantList.add(new Flowers("Роза",40,7, "красный", Flowers.Type.perennials));
        plantList.add(new Bush("Барбарис",200, true, 234));
        plantList.add(new Trees("Берёза", 1200, Trees.Type.leaf, 6));

        // подключили к таблице
        mainTable.setItems(plantList);

        TableColumn<Plants, String> titleColumn = new TableColumn<>("Название");
        // указываем какое поле брать у модели plants
        // в данном случае title, кстати именно в этих целях необходимо было создать getter и setter для поля title
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        // тоже самое для калорийности
        TableColumn<Plants, String> heightColumn = new TableColumn<>("Высота, см");
        heightColumn.setCellValueFactory(new PropertyValueFactory<>("height"));
        TableColumn<Plants, String> descriptionColumn = new TableColumn<>("Описание");
        // если хотим что-то более хитрое выводить, то используем лямбда выражение
        descriptionColumn.setCellValueFactory(cellData -> {
            // плюс надо обернуть возвращаемое значение в обертку свойство
            return new SimpleStringProperty(cellData.getValue().getDescription());
        });
        // подцепляем столбцы к таблице
        mainTable.getColumns().addAll(titleColumn, heightColumn, descriptionColumn);






    }


    public void onAddClick(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FoodForm.fxml"));
        Parent root = loader.load();

        // ну а тут создаем новое окно
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        // указываем что оно модальное
        stage.initModality(Modality.WINDOW_MODAL);
        // указываем что оно должно блокировать главное окно
        // ну если точнее, то окно, на котором мы нажали на кнопку
        stage.initOwner(this.mainTable.getScene().getWindow());

        // открываем окно и ждем пока его закроют
        stage.showAndWait();

    }
}
