package entity;

import java.time.LocalDate;

public class PhieuNhap {
	private String maPhieuNhap;
	private LocalDate ngayNhap;
	private NhanVien nhanVien;
	private String nhaCungCap;
	private String ghiChu;
	
	public PhieuNhap() {
		this("", LocalDate.now(), null, "", "");
	}

	public PhieuNhap(String maPhieuNhap, LocalDate ngayNhap, NhanVien nhanVien, String nhaCungCap, String ghiChu) {
		super();
		this.maPhieuNhap = maPhieuNhap;
		this.ngayNhap = ngayNhap;
		this.nhanVien = nhanVien;
		this.nhaCungCap = nhaCungCap;
		this.ghiChu = ghiChu;
	}

	public String getMaPhieuNhap() {
		return maPhieuNhap;
	}

	public void setMaPhieuNhap(String maPhieuNhap) {
		this.maPhieuNhap = maPhieuNhap;
	}

	public LocalDate getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(LocalDate ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public String getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(String nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	@Override
	public String toString() {
		return "PhieuNhap [maPhieuNhap=" + maPhieuNhap + ", ngayNhap=" + ngayNhap + ", nhanVien=" + nhanVien
				+ ", nhaCungCap=" + nhaCungCap + ", ghiChu=" + ghiChu + "]";
	}
	
}
