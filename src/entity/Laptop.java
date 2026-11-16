package entity;

import enums.PhanKhuc;
import enums.XuatXu;

public class Laptop extends ThietBi {
	private PhanKhuc phanKhuc;
	
	public Laptop() {
		this("", "", XuatXu.NOI_DIA, 0.0, 0, PhanKhuc.VAN_PHONG);
	}

	public Laptop(String maThietBi, String tenThietBi, XuatXu xuatXu, double donGia, int soLuongTon,
			PhanKhuc phanKhuc) {
		super(maThietBi, tenThietBi, xuatXu, donGia, soLuongTon);
		this.phanKhuc = phanKhuc;
	}

	public PhanKhuc getPhanKhuc() {
		return phanKhuc;
	}

	public void setPhanKhuc(PhanKhuc phanKhuc) {
		if (phanKhuc != PhanKhuc.VAN_PHONG && phanKhuc != PhanKhuc.DO_HOA && phanKhuc != PhanKhuc.GAMING) {
			throw new RuntimeException("Phan khuc dong may khong hop le.");
		}
		this.phanKhuc = phanKhuc;
	}

	@Override
	public double tinhGiaBanLe() {
		double thueTieuThu = 0.0;
		if (phanKhuc.equals(PhanKhuc.GAMING)) {
			thueTieuThu = getDonGia() * 0.25;
		} else {
			thueTieuThu = getDonGia() * 0.15;
		}
		
		return getDonGia() + thueTieuThu;
	}

	@Override
	public String toString() {
		return super.toString() + String.format("%15s | ", phanKhuc);
	}

}
