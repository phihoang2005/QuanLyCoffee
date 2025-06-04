package entity;

import java.time.LocalDateTime;

public class NhatKyHoatDong {
	private String maNhatKy;
	private NhanVien nhanVien;
	private LocalDateTime thoiGian;
	private String hanhDong;
	
	public NhatKyHoatDong() {
		this("", null, LocalDateTime.now(), "");
	}

	public NhatKyHoatDong(String maNhatKy, NhanVien nhanVien, LocalDateTime thoiGian, String hanhDong) {
		super();
		this.maNhatKy = maNhatKy;
		this.nhanVien = nhanVien;
		this.thoiGian = thoiGian;
		this.hanhDong = hanhDong;
	}

	public String getMaNhatKy() {
		return maNhatKy;
	}

	public void setMaNhatKy(String maNhatKy) {
		this.maNhatKy = maNhatKy;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public LocalDateTime getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(LocalDateTime thoiGian) {
		this.thoiGian = thoiGian;
	}

	public String getHanhDong() {
		return hanhDong;
	}

	public void setHanhDong(String hanhDong) {
		this.hanhDong = hanhDong;
	}

	@Override
	public String toString() {
		return "NhatKyHoatDong [maNhatKy=" + maNhatKy + ", nhanVien=" + nhanVien + ", thoiGian=" + thoiGian
				+ ", hanhDong=" + hanhDong + "]";
	}
	
}
