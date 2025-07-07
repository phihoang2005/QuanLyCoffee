package controller;


import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

import dao.BanDAO;
import dao.DatBanDAO;
import dao.KhachHangDAO;
import entity.Ban;
import entity.DatBan;
import entity.KhachHang;
import entity.TrangThaiBan;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import util.ThongBaoUtil;

public class DatBanController implements Initializable {
	@FXML
	private GridPane dsBan;
	@FXML
	private Button btnGopBan,btnTachBan,btnThemBan,btnSuaBan,btnXoaBan,btnHuyBan,btnDatBan;
	@FXML
	private ComboBox<String> cbLocTheoTrangThai;
	@FXML
	private TextField txtTenKhachHang,txtSoDienThoai,txtEmail,txtTenBan,txtGhiChu;
	@FXML
	private DatePicker dateThoiGianDat;
	@FXML
	private ComboBox<Integer> cbGio,cbPhut;
	
	private BanDAO bandao=new BanDAO();
	private KhachHangDAO khdao=new KhachHangDAO();
	private DatBanDAO dbdao=new DatBanDAO();
	
	private int soCot=5;
	private String tenBanDangChon=null;
	private Ban banDangChon=null;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		capNhatDanhSachBan();
		for (int i = 0; i < 24; i++) {
	        cbGio.getItems().add(i);
	    }
	    for (int i = 0; i < 60; i += 5) {
	        cbPhut.getItems().add(i);
	    }
	    cbLocTheoTrangThai.setValue("Lọc theo trạng thái bàn");
	    cbLocTheoTrangThai.getItems().addAll("Tất cả bàn","Bàn trống","Bàn đã đặt","Bàn đang phục vụ","Bàn tạm khóa");
	}
	private StackPane taoBan(String tenBan,TrangThaiBan trangThai) {
		StackPane ban=new StackPane();
		if(trangThai.equals(TrangThaiBan.TRONG)) {
			ban.getStyleClass().add("ban-trong");
		}else if(trangThai.equals(TrangThaiBan.DA_DAT)) {
			ban.getStyleClass().add("ban-da-dat");
		}else if(trangThai.equals(TrangThaiBan.DANG_PHUC_VU)) {
			ban.getStyleClass().add("ban-dang-phuc-vu");
		}else if(trangThai.equals(TrangThaiBan.TAM_KHOA)) {
			ban.getStyleClass().add("ban-tam-khoa");
		}
		
		ban.setPrefSize(100, 100);
		ban.setMinSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
		ban.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
		
		VBox noiDung=new VBox();
		noiDung.setAlignment(Pos.CENTER);
        noiDung.setSpacing(5);
		
		ImageView anh=new ImageView(new Image(getClass().getResource("/image/ban.png").toExternalForm()));
		anh.setFitWidth(50);
		anh.setFitHeight(50);
		anh.setPreserveRatio(true);
		
		Label lblTen=new Label(tenBan);
		lblTen.getStyleClass().add("tenBan");
		
		noiDung.getChildren().addAll(anh,lblTen);
		ban.getChildren().add(noiDung);
		
		
		ban.setOnMouseClicked(event -> {
			for(Node n:dsBan.getChildren()) {
				n.getStyleClass().remove("ban-selected");
			}
			resetform();
			ban.getStyleClass().add("ban-selected");
			hienThiThongTinBan(tenBan);
			tenBanDangChon=tenBan;
		});
		return ban;
	}
	
	private void hienThiThongTinBan(String tenBan) {
		txtTenBan.setText(tenBan);
		for(Ban temp:bandao.layTatCaBan()) {
			if(temp.getTenBan().equals(tenBan)) {
				banDangChon=temp;
			}
		}
		if(banDangChon!=null&& banDangChon.getTrangThai()==TrangThaiBan.DA_DAT) {
			DatBan datBan=dbdao.layDatBanTheoTenBan(tenBan);
			txtSoDienThoai.setText(datBan.getKhachHang().getSoDienThoai());
			txtTenKhachHang.setText(datBan.getKhachHang().getHoTen());
			txtEmail.setText(datBan.getKhachHang().getEmail());
			dateThoiGianDat.setValue(datBan.getThoiGianDat().toLocalDate());
			cbGio.setValue(datBan.getThoiGianDat().getHour());
			cbPhut.setValue(datBan.getThoiGianDat().getMinute());
			txtGhiChu.setText(datBan.getGhiChu());
		}
		
		
	}	

	@FXML
	private void handleThemBan() {
		ArrayList<Ban> dsBanDB=new ArrayList<Ban>();
		dsBanDB=bandao.layTatCaBan();
		for(int i=0;i<dsBanDB.size();i++) {
			Ban temp=dsBanDB.get(i);
			if(temp.getTrangThai().equals(TrangThaiBan.AN)) {
				temp.setTrangThai(TrangThaiBan.TRONG);
				bandao.capNhatTrangThaiTheoBan(temp);
				capNhatDanhSachBan();
				return;
			}
		}
		ThongBaoUtil.showLoi("Số lượng bàn đạt giới hạn!");
		return;
	}
	@FXML
	private void handleXoaBan() {
		ArrayList<Ban> dsBanDB=new ArrayList<Ban>();
		dsBanDB=bandao.layTatCaBan();
		for(int i=dsBanDB.size()-1;i>=0;i--) {
			Ban temp=dsBanDB.get(i);
			if(temp.getTrangThai().equals(TrangThaiBan.TRONG)) {
				temp.setTrangThai(TrangThaiBan.AN);
				bandao.capNhatTrangThaiTheoBan(temp);
				capNhatDanhSachBan();
				return;
			}
		}
		ThongBaoUtil.showLoi("Không có bàn trống để xóa!");
		return;
	}
	@FXML
	private void handleSuaBan() {
		
	}
	@FXML
	private void handleGopBan() {
		
	}
	@FXML
	private void handleTachBan() {
		
	}
	@FXML
	private void handleLocTheoTrangThai() {
		dsBan.getChildren().clear();
		String trangThaiDuocChon=cbLocTheoTrangThai.getValue();
		int index=0;
		for(Ban temp:bandao.layTatCaBan()) {
			boolean hienthi=false;
			switch (trangThaiDuocChon) {
			case "Tất cả bàn": {
				hienthi=true;
				break;
			}
			case "Bàn trống": {
				hienthi=temp.getTrangThai()==TrangThaiBan.TRONG;
				break;
			}
			case "Bàn đã đặt": {
				hienthi=temp.getTrangThai()==TrangThaiBan.DA_DAT;
				break;
			}
			case "Bàn đang phục vụ": {
				hienthi=temp.getTrangThai()==TrangThaiBan.DANG_PHUC_VU;
				break;
			}
			case "Bàn tạm khóa": {
				hienthi=temp.getTrangThai()==TrangThaiBan.TAM_KHOA;
				break;
			}
			default:
				hienthi=true;
			}
			
			if(hienthi) {
				StackPane node=taoBan(temp.getTenBan(), temp.getTrangThai());
				int row=index/soCot;
				int col=index%soCot;
				dsBan.add(node, col, row);
				GridPane.setHgrow(node, Priority.ALWAYS);
	            GridPane.setVgrow(node, Priority.ALWAYS);
	            index++;
			}
		}
		if(index==0) {
			dsBan.add(new Label("Không có bàn !"), 0, 0);
		}
	}
	@FXML
	private void handleHuyBan() {
		ThongBaoUtil.showXacNhan("Ban có chắc chắn muốn hủy bàn đã đặt ?",()->{
			bandao.capNhatTrangThaiTheoTen(tenBanDangChon, TrangThaiBan.TRONG);
			capNhatDanhSachBan();
		});
	}
	@FXML
	private void handleDatBan() {
		if(tenBanDangChon==null) {
			ThongBaoUtil.showLoi("Vui lòng chọn bàn cần đặt!");
			return;
		}
		txtSoDienThoai.getStyleClass().remove("loi");
		txtTenKhachHang.getStyleClass().remove("loi");
		txtEmail.getStyleClass().remove("loi");
		txtTenBan.getStyleClass().remove("loi");
		dateThoiGianDat.getStyleClass().remove("loi");
		txtGhiChu.getStyleClass().remove("loi");
		String sodienthoai=txtSoDienThoai.getText();
		String tenKhachHang=txtTenKhachHang.getText();
		String email=txtEmail.getText();
		String tenBan=txtTenBan.getText();
		LocalDate thoiGianDat=dateThoiGianDat.getValue();
		Integer gio=cbGio.getValue();
		Integer phut=cbPhut.getValue();
		String ghiChu=txtGhiChu.getText();
		if(sodienthoai.trim().isEmpty()) {
			ThongBaoUtil.showLoi("Vui lòng nhập số điện thoại!");
			txtSoDienThoai.getStyleClass().add("loi");
			return;
		}else if(!sodienthoai.matches("^[0-9]{10,}$")) {
			ThongBaoUtil.showLoi("Só điện thoại không hợp lệ! \n Ví dụ:0123456789");
			txtSoDienThoai.getStyleClass().add("loi");
			return;
		}
		if(tenKhachHang.trim().isEmpty()) {
			ThongBaoUtil.showLoi("Vui lòng nhập tên khách hàng!");
			txtTenKhachHang.getStyleClass().add("loi");
			return;
		}
		if(email.trim().isEmpty()) {
			ThongBaoUtil.showLoi("Vui lòng nhập email!");
			txtEmail.getStyleClass().add("loi");
			return;
		}else if(!email.matches("^[\\w]+@gmail.com$")) {
			ThongBaoUtil.showLoi("Email không hợp lệ! \n Ví dụ:abc@gmail.com");
			txtEmail.getStyleClass().add("loi");
			return;
		}
		if(tenBan.trim().isEmpty()) {
			ThongBaoUtil.showLoi("Vui lòng nhập tên bàn!");
			txtTenBan.getStyleClass().add("loi");
			return;
		}
		if(thoiGianDat==null) {
			ThongBaoUtil.showLoi("Vui lòng chọn thời gian đặt!");
			dateThoiGianDat.getStyleClass().add("loi");
			return;
		}
		if (gio == null || phut == null) {
		    ThongBaoUtil.showLoi("Vui lòng chọn giờ và phút!");
		    if (gio == null) cbGio.getStyleClass().add("loi");
		    if (phut == null) cbPhut.getStyleClass().add("loi");
		    return;
		}
		KhachHang khachHangDaTonTai=null;
		for(KhachHang temp:khdao.layTatCaKhachHang()) {
			if(temp.getSoDienThoai().equals(sodienthoai)) {
				khachHangDaTonTai=temp;
				break;
			}
		}
		if(khachHangDaTonTai==null) {
			khachHangDaTonTai=new KhachHang(khdao.taoMaKhachHang(), tenKhachHang, sodienthoai, email, 0, LocalDate.now());
			khdao.themKhachHang(khachHangDaTonTai);
		}
				Ban ban=new Ban();
				for(Ban temp1:bandao.layTatCaBan()) {
					if(temp1.getTenBan().equals(tenBan)) {
						ban=temp1;
						DatBan datBan=new DatBan(khachHangDaTonTai, ban, LocalDateTime.of(thoiGianDat, LocalTime.of(gio, phut)), ghiChu);
						if(dbdao.themDatBan(datBan)) { 
							ThongBaoUtil.showThongBao("Thông báo", "Đã đặt bàn thành công!");
							bandao.capNhatTrangThaiTheoTen(tenBan,TrangThaiBan.DA_DAT);
							capNhatDanhSachBan();
							resetform();
							tenBanDangChon=null;
							break;
						}
					}
				}
	}
	
	private void resetform() {
		txtTenKhachHang.clear();
		txtSoDienThoai.clear();
		txtEmail.clear();
		txtTenBan.clear();
		dateThoiGianDat.setValue(null);
		cbGio.setValue(null);
		cbPhut.setValue(null);
		
	}
	public void capNhatDanhSachBan() {
		dsBan.getChildren().clear();
		ArrayList<Ban> dsBanDB=new ArrayList<Ban>();
		dsBanDB=bandao.layTatCaBan();
		int soLuongBan=0;
		for(Ban temp:dsBanDB) {
			if(!temp.getTrangThai().equals(TrangThaiBan.AN)) {
				String tenBan=temp.getTenBan();
				TrangThaiBan trangThai=temp.getTrangThai();
				soLuongBan++;
				int hang=(soLuongBan-1)/soCot;
				int cot=(soLuongBan-1)%soCot;			
				StackPane ban=taoBan(tenBan,trangThai);
				dsBan.add(ban, cot, hang);
				GridPane.setHgrow(ban, Priority.ALWAYS);
				GridPane.setVgrow(ban, Priority.ALWAYS);
			}
		}
	}
	@FXML
	private void pressSoDienThoai(KeyEvent event) {
		if(event.getCode()==KeyCode.ENTER) {
			txtSoDienThoai.getStyleClass().remove("loi");
			String sodienthoai=txtSoDienThoai.getText();
			if(sodienthoai.trim().isEmpty()) {
				ThongBaoUtil.showLoi("Vui lòng nhập số điện thoại!");
				txtSoDienThoai.getStyleClass().add("loi");
				return;
			}else if(!sodienthoai.matches("^[0-9]{10,}$")) {
				ThongBaoUtil.showLoi("Só điện thoại không hợp lệ! \n Ví dụ:0123456789");
				txtSoDienThoai.getStyleClass().add("loi");
				return;
			}
				
			for(KhachHang temp:khdao.layTatCaKhachHang()) {
				if(temp.getSoDienThoai().equals(sodienthoai)) {
					txtTenKhachHang.setText(temp.getHoTen());
					txtEmail.setText(temp.getEmail());
					return;
				}
			}
			ThongBaoUtil.showThongBao("Không tìm thấy", "Khách hàng chưa có trong hệ thống. Vui lòng nhập tên và email.");
			
		}
	}
	
}
