package entity;

import java.time.LocalDate;

public class KhachHang {
	private String maKhachHang;
	private String hoTen;
	private String soDienThoai;
	private String email;
	private int diemTichLuy;
	private LocalDate ngayDangKy;
	
	public KhachHang() {
		this("", "", "", "", 0, LocalDate.now());
	}

	public KhachHang(String maKhachHang, String hoTen, String soDienThoai, String email, int diemTichLuy,
			LocalDate ngayDangKy) {
		super();
		this.maKhachHang = maKhachHang;
		this.hoTen = hoTen;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.diemTichLuy = diemTichLuy;
		this.ngayDangKy = ngayDangKy;
	}
	

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getDiemTichLuy() {
		return diemTichLuy;
	}

	public void setDiemTichLuy(int diemTichLuy) {
		this.diemTichLuy = diemTichLuy;
	}

	public LocalDate getNgayDangKy() {
		return ngayDangKy;
	}

	public void setNgayDangKy(LocalDate ngayDangKy) {
		this.ngayDangKy = ngayDangKy;
	}

	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", hoTen=" + hoTen + ", soDienThoai=" + soDienThoai
				+ ", email=" + email + ", diemTichLuy=" + diemTichLuy + ", ngayDangKy=" + ngayDangKy + "]";
	}
	
}
