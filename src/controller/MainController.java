package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainController {
	@FXML
	private Button btnTrangChu,btnBanHang,btnNhanVien,btnKhachHang,btnThucDon;
	@FXML
	private StackPane noiDung;
	private Button nutDangChon=null;
	
	private void setNoiDung(String tenFile,Button nutDuocChon) {
		try {
			Node newNoiDung=FXMLLoader.load(getClass().getResource("/view/"+tenFile+".fxml"));
			noiDung.getChildren().setAll(newNoiDung);
			
			if(nutDangChon!=null) {
				nutDangChon.getStyleClass().remove("button-selected");
			}
			nutDuocChon.getStyleClass().add("button-selected");
			nutDangChon=nutDuocChon;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void handleTrangChu() {
		setNoiDung("TrangChu",btnTrangChu);
	}
	
	@FXML
	private void handleBanHang() {
		setNoiDung("BanHang",btnBanHang);
	}
	
	@FXML
	private void handleNhanVien() {
		setNoiDung("NhanVien",btnNhanVien);
	}
	
	@FXML
	private void handleKhachHang() {
		setNoiDung("KhachHang",btnKhachHang);
	}
	
	@FXML
	private void handleThucDon() {
		setNoiDung("ThucDon",btnThucDon);
	}
	
	@FXML
	private void dangXuat() {
		try {
			Parent root=FXMLLoader.load(getClass().getResource("/view/DangNhap.fxml"));
			Scene scene =new Scene(root);
			scene.setFill(Color.TRANSPARENT);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.initStyle(StageStyle.TRANSPARENT);
			stage.show();
			
			Stage stageNow=(Stage) btnTrangChu.getScene().getWindow();
			stageNow.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@FXML
	private void thongTinCaNhan() {
		
	}
	
}
