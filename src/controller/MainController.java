package controller;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
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
	private Button btnDatBan,btnLapHoaDon,btnThanhToan,btnQuanLyMon,btnCongThucMon,btnQuanLyNguyenLieu,btnPhieuNhap,
				   btnNhanVien,btnTaoTaiKhoan,btnPhanCongCa,btnQuanLyCa,btnHoaDon,btnBaoCaoBanHang,btnBaoCaoNguyenLieu,
				   btnDanhSachKhuyenMai,btnGanMonKhuyenMai,btnDanhSachKhachHang,btnDatMonOnline;
	@FXML
	private MenuItem thongTinCaNhanItem,dangXuatItem;
	private Button nutDangChon=null;
	private Map<ToggleButton, VBox> nutSupVaTenFile=new HashMap<ToggleButton, VBox>();
	private Map<Button, String> nutSubVaTenFile=new HashMap<Button, String>();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		hideAllSubMenu();
		nutSupVaTenFile.put(supBanHang, subBanHang);
		nutSupVaTenFile.put(supMon, subMon);
		nutSupVaTenFile.put(supNhanSu, subNhanSu);
		nutSupVaTenFile.put(supDoanhThu, subDoanhThu);
		nutSupVaTenFile.put(supKhuyenMai, subKhuyenMai);
		nutSupVaTenFile.put(supKhachHang, subKhachHang);
		for(ToggleButton toggle:nutSupVaTenFile.keySet()) {
			toggle.setOnAction(event1->{
				handleSup(toggle, nutSupVaTenFile.get(toggle));
			});
		}
		
		nutSubVaTenFile.put(btnDatBan, "DatBan");
		nutSubVaTenFile.put(btnLapHoaDon, "LapHoaDon");
		nutSubVaTenFile.put(btnThanhToan, "ThanhToan");
		nutSubVaTenFile.put(btnQuanLyMon, "QuanLyMon");
		nutSubVaTenFile.put(btnCongThucMon, "CongThucMon");
		nutSubVaTenFile.put(btnQuanLyNguyenLieu, "QuanLyNguyenLieu");
		nutSubVaTenFile.put(btnPhieuNhap, "PhieuNhap");
		nutSubVaTenFile.put(btnNhanVien, "NhanVien");
		nutSubVaTenFile.put(btnTaoTaiKhoan, "TaoTaiKhoan");
		nutSubVaTenFile.put(btnPhanCongCa, "PhanCongCa");
		nutSubVaTenFile.put(btnQuanLyCa, "QuanLyCa");
		nutSubVaTenFile.put(btnHoaDon, "HoaDon");
		nutSubVaTenFile.put(btnBaoCaoBanHang, "BaoCaoBanHang");
		nutSubVaTenFile.put(btnBaoCaoNguyenLieu, "BaoCaoNguyenLieu");
		nutSubVaTenFile.put(btnDanhSachKhuyenMai, "DanhSachKhuyenMai");
		nutSubVaTenFile.put(btnGanMonKhuyenMai, "GanMonKhuyenMai");
		nutSubVaTenFile.put(btnDanhSachKhachHang, "DanhSachKhachHang");
		nutSubVaTenFile.put(btnDatMonOnline, "DatMonOnline");
		for(Button button:nutSubVaTenFile.keySet()) {
			button.setOnAction(event2->{
				setNoiDung(nutSubVaTenFile.get(button), button);
			});
		}
		
		setNoiDung("DatBan", btnDatBan);
	}
	
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
	
	//đóng mở sup
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
}
