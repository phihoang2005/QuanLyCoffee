package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainController implements Initializable {
	@FXML
	private ToggleButton supBanHang,supMon,supNhanSu,supDoanhThu,supKhuyenMai,supKhachHang;
	@FXML
	private VBox subBanHang,subMon,subNhanSu,subDoanhThu,subKhuyenMai,subKhachHang;
	@FXML
	private StackPane noiDung;
	@FXML
	private Button btnDatBan;
	
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
	private void dangXuat() {
		try {
			Parent root=FXMLLoader.load(getClass().getResource("/view/DangNhap.fxml"));
			Scene scene =new Scene(root);
			scene.setFill(Color.TRANSPARENT);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.initStyle(StageStyle.TRANSPARENT);
			stage.show();
			
			Stage stageNow=(Stage) noiDung.getScene().getWindow();
			stageNow.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@FXML
	private void thongTinCaNhan() {
		
	}
	
	//Ẩn toàn bộ submenu
	private void hideAllSubMenu() {
		subBanHang.setVisible(false);
		subBanHang.setManaged(false);
		subMon.setVisible(false);
		subMon.setManaged(false);
		subNhanSu.setVisible(false);
		subNhanSu.setManaged(false);
		subDoanhThu.setVisible(false);
		subDoanhThu.setManaged(false);
		subKhuyenMai.setVisible(false);
		subKhuyenMai.setManaged(false);
		subKhachHang.setVisible(false);
		subKhachHang.setManaged(false);
	}
	//Bỏ chọn toàn bộ sup
	private void boChonAllSup() {
		supBanHang.setSelected(false);
		supMon.setSelected(false);
		supNhanSu.setSelected(false);
		supDoanhThu.setSelected(false);
		supKhuyenMai.setSelected(false);
		supKhachHang.setSelected(false);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		hideAllSubMenu();
		handleDatBan();
	}
	
	//đóng mở btn
	private void handleSup(ToggleButton toggle,VBox vbox) {
		hideAllSubMenu();
		boolean isSelected=toggle.isSelected();
		boChonAllSup();
		if(isSelected) {
			toggle.setSelected(true);
			vbox.setVisible(toggle.isSelected());
			vbox.setManaged(toggle.isSelected());
		}
		
		
	}
	@FXML
	private void handleSupBanHang() {
		handleSup(supBanHang, subBanHang);
	}
	@FXML
	private void handleSupMon() {
		handleSup(supMon, subMon);
	}
	@FXML
	private void handleSupNhanSu() {
		handleSup(supNhanSu, subNhanSu);
	}
	@FXML
	private void handleSupDoanhThu() {
		handleSup(supDoanhThu, subDoanhThu);
	}
	@FXML
	private void handleSupKhuyenMai() {
		handleSup(supKhuyenMai, subKhuyenMai);
	}
	@FXML
	private void handleSupKhachHang() {
		handleSup(supKhachHang, subKhachHang);
	}
	
	@FXML
	private void handleDatBan() {
		setNoiDung("DatBan", btnDatBan);
	}
	
}
