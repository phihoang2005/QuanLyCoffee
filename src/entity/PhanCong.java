package entity;

import java.time.LocalDate;

public class PhanCong {
	private NhanVien nhanVien;
	private CaLamViec caLamViec;
	private LocalDate ngayLam;
	
	public PhanCong() {
		this(null, null, LocalDate.now());
	}

	public PhanCong(NhanVien nhanVien, CaLamViec caLamViec, LocalDate ngayLam) {
		super();
		this.nhanVien = nhanVien;
		this.caLamViec = caLamViec;
		this.ngayLam = ngayLam;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public CaLamViec getCaLamViec() {
		return caLamViec;
	}

	public void setCaLamViec(CaLamViec caLamViec) {
		this.caLamViec = caLamViec;
	}

	public LocalDate getNgayLam() {
		return ngayLam;
	}

	public void setNgayLam(LocalDate ngayLam) {
		this.ngayLam = ngayLam;
	}

	@Override
	public String toString() {
		return "PhanCong [nhanVien=" + nhanVien + ", caLamViec=" + caLamViec + ", ngayLam=" + ngayLam + "]";
	}
	
}
