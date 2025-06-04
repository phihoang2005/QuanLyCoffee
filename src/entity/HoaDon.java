package entity;

import java.time.LocalDateTime;

public class HoaDon {
	private String HoaDon;
	private Ban ban;
	private NhanVien nhanVien;
	private LocalDateTime thoiGianTao;
	private LocalDateTime thoiGianThanhToan;
	private double tongTien;
	private double giamGia;
	private String hinhThucThanhToan;
	private String trangThai;
	
	public HoaDon() {
		this("", null, null, LocalDateTime.now(), LocalDateTime.now(), 0.0, 0.0,"", "");
	}

	public HoaDon(String hoaDon, Ban ban, NhanVien nhanVien, LocalDateTime thoiGianTao, LocalDateTime thoiGianThanhToan,
			double tongTien, double giamGia, String hinhThucThanhToan, String trangThai) {
		super();
		HoaDon = hoaDon;
		this.ban = ban;
		this.nhanVien = nhanVien;
		this.thoiGianTao = thoiGianTao;
		this.thoiGianThanhToan = thoiGianThanhToan;
		this.tongTien = tongTien;
		this.giamGia = giamGia;
		this.hinhThucThanhToan = hinhThucThanhToan;
		this.trangThai = trangThai;
	}

	public String getHoaDon() {
		return HoaDon;
	}

	public void setHoaDon(String hoaDon) {
		HoaDon = hoaDon;
	}

	public Ban getBan() {
		return ban;
	}

	public void setBan(Ban ban) {
		this.ban = ban;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public LocalDateTime getThoiGianTao() {
		return thoiGianTao;
	}

	public void setThoiGianTao(LocalDateTime thoiGianTao) {
		this.thoiGianTao = thoiGianTao;
	}

	public LocalDateTime getThoiGianThanhToan() {
		return thoiGianThanhToan;
	}

	public void setThoiGianThanhToan(LocalDateTime thoiGianThanhToan) {
		this.thoiGianThanhToan = thoiGianThanhToan;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public double getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(double giamGia) {
		this.giamGia = giamGia;
	}

	public String getHinhThucThanhToan() {
		return hinhThucThanhToan;
	}

	public void setHinhThucThanhToan(String hinhThucThanhToan) {
		this.hinhThucThanhToan = hinhThucThanhToan;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return "HoaDon [HoaDon=" + HoaDon + ", ban=" + ban + ", nhanVien=" + nhanVien + ", thoiGianTao=" + thoiGianTao
				+ ", thoiGianThanhToan=" + thoiGianThanhToan + ", tongTien=" + tongTien + ", giamGia=" + giamGia
				+ ", hinhThucThanhToan=" + hinhThucThanhToan + ", trangThai=" + trangThai + "]";
	}
	
}
