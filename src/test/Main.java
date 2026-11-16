package test;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import entity.DanhSachThietBi;
import entity.DienThoai;
import entity.Laptop;
import enums.HeDieuHanh;
import enums.PhanKhuc;
import enums.XuatXu;

public class Main {
	public static void main(String[] args) {
		DanhSachThietBi danhSachThietBi = new DanhSachThietBi(List.of(
				new DienThoai("DT01", "Nokia", XuatXu.NOI_DIA, 10000000.0, 10, LocalDate.of(2026, 10, 1), HeDieuHanh.HARMONYOS),
				new DienThoai("DT02", "Samsung", XuatXu.NHAP_KHAU, 20000000.0, 10, LocalDate.of(2026, 9, 1), HeDieuHanh.ANDROID),
				new Laptop("LT01", "Asus", XuatXu.NHAP_KHAU, 30000000.0, 20, PhanKhuc.GAMING),
				new Laptop("LT02", "Acer", XuatXu.NOI_DIA, 25000000.0, 15, PhanKhuc.VAN_PHONG),
				new Laptop("LT03", "Thinkbook", XuatXu.NHAP_KHAU, 40000000.0, 5, PhanKhuc.DO_HOA)
				));
		
		System.out.println(" Danh sach cac thiet bi ban dau");
		System.out.println(danhSachThietBi);
		
		System.out.println();
		
		// Kiem thu: them thiet bi
		try {
			// Du lieu hop le
			if (danhSachThietBi.themThietBi(new Laptop("LT04", "Asus", XuatXu.NHAP_KHAU, 30000000.0, 20, PhanKhuc.GAMING))) {
				System.out.println("Them thanh cong.");
			} else {
				System.out.println("Them that bai.");
			}
			
			// Du lieu khong hop le de nem ngoai le 
			// (trung ma)
			danhSachThietBi.themThietBi(new Laptop("LT01", "Vivo", XuatXu.NHAP_KHAU, 30000000.0, 20, PhanKhuc.GAMING));
		} catch (Exception e) {
			System.out.println("Loi: " + e.getMessage());
		}
		
		System.out.println();
		
		// Kiem thu: sap xep
		System.out.println(" Danh sach sau khi sap xep tang dan theo don gia");
		danhSachThietBi.sapTangDanTheoDonGia();
		System.out.println(danhSachThietBi);
		
		System.out.println();
		
		// Kiem thu: xuat danh sach laptop gaming
		System.out.println(" Danh sach laptop gaming");
		System.out.println(danhSachThietBi.xuatDSLaptopGaming());
		
		System.out.println();
		
		// Kiem thu: thong ke tong so luong ton kho cua tung loai thiet bi
		System.out.println(" Tong so luong ton kho cua tung loai thiet bi");
		Map<String, Integer> thongKe = danhSachThietBi.thongKeSoLuongTon();
		for (Map.Entry<String, Integer> entry : thongKe.entrySet()) {
			DecimalFormat df = new DecimalFormat("#,##0");
			System.out.println(String.format("Thiet bi: %-15s | Tong so luong ton kho: %-15s", entry.getKey(), df.format(entry.getValue())));
		}
		
		
	}
}
