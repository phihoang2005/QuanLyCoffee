package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class DatBanController implements Initializable {
	@FXML
	private GridPane dsBan;
	
	private int soLuongBan;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		soLuongBan=25;
		int soCot=5;
		for(int i=0;i<soLuongBan;i++) {
			int hang=i/soCot;
			int cot=i%soCot;
			
			StackPane ban=taoBan("Bàn "+ (i+1));
			dsBan.add(ban, cot, hang);
			GridPane.setHgrow(ban, Priority.ALWAYS);
			GridPane.setVgrow(ban, Priority.ALWAYS);
		}
	}
	private StackPane taoBan(String tenBan) {
		StackPane ban=new StackPane();
		ban.getStyleClass().add("ban");
		ban.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		
		VBox noiDung=new VBox();
		noiDung.setAlignment(Pos.CENTER);
        noiDung.setSpacing(5);
		
		ImageView anh=new ImageView(new Image(getClass().getResource("/image/ban.png").toExternalForm()));
		anh.setFitWidth(50);
		anh.setFitHeight(50);
		anh.setPreserveRatio(true);
		
		Label label=new Label(tenBan);
		label.getStyleClass().add("tenBan");
		
		noiDung.getChildren().addAll(anh,label);
		ban.getChildren().add(noiDung);
		
		ban.setOnMouseClicked(event -> {
			for(Node n:dsBan.getChildren()) {
				n.getStyleClass().remove("ban-selected");
			}
			ban.getStyleClass().add("ban-selected");
			hienThiThongTinBan(tenBan);
		});
		
		return ban;
	}
	private void hienThiThongTinBan(String tenBan) {
		
	}
	
	
}
