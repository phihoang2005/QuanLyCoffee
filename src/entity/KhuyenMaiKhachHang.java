package entity;

import java.time.LocalDate;

public class KhuyenMaiKhachHang {
	private KhuyenMai khuyenMai;
	private KhachHang khachHang;
	private LocalDate ngayApDung;
	private LocalDate ngayHetHan;
	
	public KhuyenMaiKhachHang() {
		this(null, null, LocalDate.now(), LocalDate.now());
	}

	public KhuyenMaiKhachHang(KhuyenMai khuyenMai, KhachHang khachHang, LocalDate ngayApDung, LocalDate ngayHetHan) {
		super();
		this.khuyenMai = khuyenMai;
		this.khachHang = khachHang;
		this.ngayApDung = ngayApDung;
		this.ngayHetHan = ngayHetHan;
	}

	public KhuyenMai getKhuyenMai() {
		return khuyenMai;
	}

	public void setKhuyenMai(KhuyenMai khuyenMai) {
		this.khuyenMai = khuyenMai;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public LocalDate getNgayApDung() {
		return ngayApDung;
	}

	public void setNgayApDung(LocalDate ngayApDung) {
		this.ngayApDung = ngayApDung;
	}

	public LocalDate getNgayHetHan() {
		return ngayHetHan;
	}

	public void setNgayHetHan(LocalDate ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}

	@Override
	public String toString() {
		return "KhuyenMaiKhachHang [khuyenMai=" + khuyenMai + ", khachHang=" + khachHang + ", ngayApDung=" + ngayApDung
				+ ", ngayHetHan=" + ngayHetHan + "]";
	}
	
}
