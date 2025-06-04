package entity;

public class TaiKhoan {
	private String maTaiKhoan;
	private String tenDangNhap;
	private String matKhau;
	private String vaiTro;
	private boolean trangThai;
	
	public TaiKhoan() {
		this("", "", "", "", true);
	}

	public TaiKhoan(String maTaiKhoan, String tenDangNhap, String matKhau, String vaiTro, boolean trangThai) {
		super();
		this.maTaiKhoan = maTaiKhoan;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.vaiTro = vaiTro;
		this.trangThai = trangThai;
	}

	public String getMaTaiKhoan() {
		return maTaiKhoan;
	}

	public void setMaTaiKhoan(String maTaiKhoan) {
		this.maTaiKhoan = maTaiKhoan;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getVaiTro() {
		return vaiTro;
	}

	public void setVaiTro(String vaiTro) {
		this.vaiTro = vaiTro;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return "TaiKhoan [maTaiKhoan=" + maTaiKhoan + ", tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau
				+ ", vaiTro=" + vaiTro + ", trangThai=" + trangThai + "]";
	}
	
}
