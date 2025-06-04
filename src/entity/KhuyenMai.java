package entity;

import java.time.LocalDate;

public class KhuyenMai {
	private String maKhuyenMai;
	private String tenKhuyenMai;
	private int phanTramGiam;
	private LocalDate ngayBatDau;
	private LocalDate ngayKetThuc;
	private String dieuKienApDung;
	
	public KhuyenMai() {
		this("", "", 0, LocalDate.now(), LocalDate.now(), "");
	}
	

	public KhuyenMai(String maKhuyenMai, String tenKhuyenMai, int phanTramGiam, LocalDate ngayBatDau,
			LocalDate ngayKetThuc, String dieuKienApDung) {
		super();
		this.maKhuyenMai = maKhuyenMai;
		this.tenKhuyenMai = tenKhuyenMai;
		this.phanTramGiam = phanTramGiam;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.dieuKienApDung = dieuKienApDung;
	}


	public String getMaKhuyenMai() {
		return maKhuyenMai;
	}

	public void setMaKhuyenMai(String maKhuyenMai) {
		this.maKhuyenMai = maKhuyenMai;
	}

	public String getTenKhuyenMai() {
		return tenKhuyenMai;
	}

	public void setTenKhuyenMai(String tenKhuyenMai) {
		this.tenKhuyenMai = tenKhuyenMai;
	}

	public int getPhanTramGiam() {
		return phanTramGiam;
	}

	public void setPhanTramGiam(int phanTramGiam) {
		this.phanTramGiam = phanTramGiam;
	}

	public LocalDate getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(LocalDate ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public LocalDate getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(LocalDate ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	public String getDieuKienApDung() {
		return dieuKienApDung;
	}

	public void setDieuKienApDung(String dieuKienApDung) {
		this.dieuKienApDung = dieuKienApDung;
	}


	@Override
	public String toString() {
		return "KhuyenMai [maKhuyenMai=" + maKhuyenMai + ", tenKhuyenMai=" + tenKhuyenMai + ", phanTramGiam="
				+ phanTramGiam + ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc=" + ngayKetThuc + ", dieuKienApDung="
				+ dieuKienApDung + "]";
	}
	
}
