package entity;

public enum TrangThaiBan {
	TRONG("Bàn trống"),
    DA_DAT("Đã đặt"),
    DANG_PHUC_VU("Đang phục vụ"),
    TAM_KHOA("Tạm khóa"),
	AN("Ẩn");
	
	private final String moTa;
	
	private TrangThaiBan(String moTa) {
		this.moTa = moTa;
		
	}

	public String getMoTa() {
		return moTa;
	}
	
}
