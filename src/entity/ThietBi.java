package entity;

import java.text.DecimalFormat;
import java.util.Objects;

import enums.XuatXu;

public abstract class ThietBi {
	protected String maThietBi;
	protected String tenThietBi;
	protected XuatXu xuatXu;
	protected double donGia;
	protected int soLuongTon;
	
	public ThietBi() {
		this("", "", XuatXu.NOI_DIA, 0.0, 0);
	}
	
	public ThietBi(String maThietBi, String tenThietBi, XuatXu xuatXu, double donGia, int soLuongTon) {
		setMaThietBi(maThietBi);
		setTenThietBi(tenThietBi);
		setXuatXu(xuatXu);
		setDonGia(donGia);
		setSoLuongTon(soLuongTon);
	}
	
	// getter
	public String getMaThietBi() {
		return maThietBi;
	}

	public String getTenThietBi() {
		return tenThietBi;
	}

	public XuatXu getXuatXu() {
		return xuatXu;
	}

	public double getDonGia() {
		return donGia;
	}

	public int getSoLuongTon() {
		return soLuongTon;
	}

	// setter
	public void setMaThietBi(String maThietBi) {
		if (maThietBi == null || maThietBi.isBlank()) {
			throw new RuntimeException("Ma thiet bi khong duoc rong");
		}
		this.maThietBi = maThietBi;
	}

	public void setTenThietBi(String tenThietBi) {
		if (tenThietBi == null || tenThietBi.isBlank()) {
			throw new RuntimeException("Ten thiet bi khong duoc rong");
		}
		this.tenThietBi = tenThietBi;
	}

	public void setXuatXu(XuatXu xuatXu) {
		if (xuatXu != XuatXu.NHAP_KHAU && xuatXu != XuatXu.NOI_DIA) {
			throw new RuntimeException("Xuat xu khong hop le. Chi nhan NHAP_KHAU hoac NOI_DIA");
		}
		this.xuatXu = xuatXu;
	}

	public void setDonGia(double donGia) {
		if (donGia <= 0) {
			throw new RuntimeException("Don gia phai lon hon 0");
		}
		this.donGia = donGia;
	}

	public void setSoLuongTon(int soLuongTon) {
		if (soLuongTon <= 0) {
			throw new RuntimeException("So luong ton phai lon hon 0");
		}
		this.soLuongTon = soLuongTon;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(maThietBi);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ThietBi other = (ThietBi) obj;
		return Objects.equals(maThietBi, other.maThietBi);
	}

	public abstract double tinhGiaBanLe();

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0");
		return String.format("| %15s | %15s | %15s | %15s | %15s | %15s | ", 
				maThietBi, tenThietBi, xuatXu, df.format(donGia), soLuongTon, df.format(tinhGiaBanLe()));
	}
	
	
}
