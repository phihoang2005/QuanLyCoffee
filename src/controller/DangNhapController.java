package controller;



import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import dao.TaiKhoanDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DangNhapController {
	@FXML
	private TextField tenDangNhap,matKhau,soDienThoai,tenDangNhap2,matKhau2,xacNhanMatKhau;
	@FXML
	private Button btnDangNhap,btnGoogle,btnFaceBook;
	@FXML 
	private Hyperlink hplQuenMatKhau;
	@FXML
	private VBox formDangNhap,formQuenMatKhau;
	private TaiKhoanDAO tkdao=new TaiKhoanDAO();

	//Nhấn nút đăng nhập
	@FXML 
	public void chonDangNhap(ActionEvent event) throws IOException {
		String tendangnhap=tenDangNhap.getText();
		String matkhau=matKhau.getText();
		
		if(tendangnhap.trim().isEmpty()||matkhau.trim().isEmpty()) {
			showAlert("Lỗi", "Vui lòng nhập đầy đủ!");
			return;
		}
		int ketQua=tkdao.kiemTraTaiKhoan(tendangnhap, matkhau);
		if(ketQua==1) {
			
			try {
				Parent root = FXMLLoader.load(getClass().getResource("/view/MainLayout.fxml"));
				Scene scene=new Scene(root);
				scene.setFill(Color.TRANSPARENT);
			    Stage stage = new Stage();
			    stage.setScene(scene);
			    stage.initStyle(StageStyle.TRANSPARENT);
			    stage.show();
	
			    ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(ketQua==2) {
			showAlert("Thông báo", "Mật khẩu sai!");
			matKhau.requestFocus();
		}else {
			showAlert("Thông báo", "Tài khoản không tồn tại!");
			tenDangNhap.requestFocus();
		}
	}
	
	//Chọn quên mật khẩu
	@FXML
	public void chonQuenMatKhau() {
		formDangNhap.setVisible(false);
		formQuenMatKhau.setVisible(true);
		lamMoi();
	}
	
	//Quay lại đăng nhập
	@FXML 
	public void quayLaiDangNhap() {
		formDangNhap.setVisible(true);
		formQuenMatKhau.setVisible(false);
		lamMoi();
	}
	
	//Chọn đổi mật khẩu
	@FXML
	public void chonDoiMatKhau() {
		String sodienthoai=soDienThoai.getText();
		String tendangnhap=tenDangNhap2.getText();
		String matkhau=matKhau2.getText();
		String xacnhanmatkhau=xacNhanMatKhau.getText();
		
		if(sodienthoai.trim().isEmpty()||tendangnhap.trim().isEmpty()||matkhau.trim().isEmpty()||xacnhanmatkhau.trim().isEmpty()) {
			showAlert("Lỗi", "Vui lòng nhập đầy đủ!");
			return;
		}
		if(!matkhau.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[\\W_]).{8,}$")) {
			showAlert("Lỗi", "Mật khẩu phải chứa ít nhất:\n1 ký tự chữ thường\n1 ký tự chữ hoa\n1 ký tự số \n1 ký tự đặc biệt! ");
			matKhau.requestFocus();
			return;
		}
		if(!matkhau.equals(xacnhanmatkhau)) {
			showAlert("Lỗi", "Mật khẩu nhập lại không khớp!");
			xacNhanMatKhau.requestFocus();
			return;
		}
		if(tkdao.doiMatKhau(sodienthoai, matkhau)) {
			showAlert("Thông báo", "Đổi mật khẩu thành công!");
			lamMoi();
			return;
		}else {
			showAlert("Lỗi", "Só điện thoại không tồn tại!");
			soDienThoai.requestFocus();
			return;
		}
	}
	
	//Hàm hỗ trợ thông báo
	public void showAlert(String tieuDe,String noiDung) {
		Alert alert=new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle(tieuDe);
		alert.setHeaderText(null);
		alert.setContentText(noiDung);
		alert.showAndWait();
	}
	
	//Làm mới form
	public void lamMoi() {
		tenDangNhap.setText("");
		matKhau.setText("");
		soDienThoai.setText("");
		tenDangNhap2.setText("");
		matKhau2.setText("");
		xacNhanMatKhau.setText("");
	}
	
	//Mỏ đăng nhập google
	@FXML
	public void dangNhapGoogle() {
		try {
			String url="https://accounts.google.com/signin";
			Desktop.getDesktop().browse(new URI(url));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Mỏ đăng nhập facebook
	@FXML
	public void dangNhapFacebook() {
		try {
			String url="https://www.facebook.com/login";
			Desktop.getDesktop().browse(new URI(url));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
