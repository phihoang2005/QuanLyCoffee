package entity;

import java.time.LocalDate;

public class NhanVien {
	private String maNhanVien;
	private String tenNhanVien;
	private String gioiTinh;
	private LocalDate ngaySinh;
	private String soDienThoai;
	private String email;
	private String diaChi;
	private LocalDate ngayVaoLam;
	private String hinhAnh;
	private TaiKhoan taiKhoan;
	
	public NhanVien() {
		this("", "", "", LocalDate.now(), "", "", "", LocalDate.now(), "", null);
	}

	public NhanVien(String maNhanVien, String tenNhanVien, String gioiTinh, LocalDate ngaySinh, String soDienThoai,
			String email, String diaChi, LocalDate ngayVaoLam, String hinhAnh, TaiKhoan taiKhoan) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.diaChi = diaChi;
		this.ngayVaoLam = ngayVaoLam;
		this.hinhAnh = hinhAnh;
		this.taiKhoan = taiKhoan;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
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

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public LocalDate getNgayVaoLam() {
		return ngayVaoLam;
	}

	public void setNgayVaoLam(LocalDate ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", tenNhanVien=" + tenNhanVien + ", gioiTinh=" + gioiTinh
				+ ", ngaySinh=" + ngaySinh + ", soDienThoai=" + soDienThoai + ", email=" + email + ", diaChi=" + diaChi
				+ ", ngayVaoLam=" + ngayVaoLam + ", hinhAnh=" + hinhAnh + ", taiKhoan=" + taiKhoan + "]";
	}
	
}
