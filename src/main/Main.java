package main;

import dao.ConnectDB;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
    	ConnectDB.getInstance().connect();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/MainLayout.fxml"));
            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);
            Stage loginStage = new Stage(); // Mở stage mới cho login
            loginStage.setTitle("Màn Hình Đăng Nhập");
            loginStage.setScene(scene);
            
            loginStage.setResizable(false);
            loginStage.initStyle(StageStyle.TRANSPARENT);
            loginStage.show();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
