import java.util.Scanner;

public class PhuKien {

    public static void TimKiemPhuKien(String MaSql){
        Scanner s = new Scanner(System.in);
        System.out.print("----------Tim Kiem Phu Kien----------\n1 Tim Kiem Theo Ma Phu Kien\n2 Tim Kiem Theo Ten Phu Kien\n3 Ve Menu\nChon 1 - 3: ");
        int Chon = s.nextInt();
        while(Chon > 3 || Chon < 1){
            System.out.print("So Khong Co Trong Menu\nNhap Lai:");
            Chon = s.nextInt();
        }
        switch(Chon){
            case 1 : System.out.print("Nhap Ma Phu Kien: ");
            String MaPK = s.next();MaPK += s.nextLine();
            Data.TimKiemPhuKienPC(MaSql, MaPK, null);
            System.out.print("\n1 De Cap Nhat Phu Kien\n2 Tim Kiem Lai\n3 Ve Menu\nChon 1 - 3: ");
            Chon = s.nextInt();
            while(Chon > 3 || Chon < 1){
                System.out.print("So Khong Co Trong Menu\nNhap Lai:");
                Chon = s.nextInt();
            }
            switch(Chon){
                case 1 : CapNhatPhuKien(MaSql, MaPK, null);break;
                case 2 : TimKiemPhuKien(MaSql);break;
                case 3 : Menu();break;
            }
            break;
            case 2 : System.out.print("Nhap Ma Phu Kien: ");
            String Ten = s.next();Ten += s.nextLine();
            Data.TimKiemPhuKienPC(MaSql, null, Ten);
            System.out.print("\n1 De Cap Nhat Phu Kien\n2 Tim Kiem Lai\n3 Ve Menu\nChon 1 - 3: ");
            Chon = s.nextInt();
            while(Chon > 3 || Chon < 1){
                System.out.print("So Khong Co Trong Menu\nNhap Lai:");
                Chon = s.nextInt();
            }
            switch(Chon){
                case 1 : CapNhatPhuKien(MaSql, null, Ten);break;
                case 2 : TimKiemPhuKien(MaSql);break;
                case 3 : Menu();break;
            }
            break; 
        }
    }

    public static void CapNhatPhuKien(String MaSql, String MaPK, String Ten){
        Scanner s = new Scanner(System.in);
        System.out.print("----------Cap Nhat Phu Kien----------\n1 Cap Nhat Ma Phu Kien\n2 Cap Nhat Ten Phu Kien\n3 Cap Nhat Nha San Xuat\n4 Cap Nhat So Luong Nhap\n5 Cap Nhat Thoi Gian Nhap\n6 Cap Nhat So Luong Xuat\n7 Cap Nhat Thoi Gian Xuat\n8 Ve Menu\nChon 1 - 8: ");
        String ThayDoi;
        int Chon = s.nextInt();
        while(Chon > 8 || Chon < 1){
            System.out.print("So Khong Co Trong Menu\nNhap Lai:");
            Chon = s.nextInt();
        }
        switch(Chon){
            case 1 : System.out.print("Nhap Ma Phu Kien Moi: ");
            ThayDoi = s.next();ThayDoi += s.nextLine();
            Data.CapNhatPhuKienPC(MaSql, MaPK, Ten, "Ma", ThayDoi,0,0,0);
            Menu();
            break;
            case 2 : System.out.print("Nhap Ten Phu Kien Moi: ");
            ThayDoi = s.next();ThayDoi += s.nextLine();
            Data.CapNhatPhuKienPC(MaSql, MaPK, Ten, "Ten", ThayDoi,0,0,0);
            Menu();
            break;
            case 3 : System.out.print("Nhap Nha San Xuat Moi: ");
            ThayDoi = s.next();ThayDoi += s.nextLine();
            Data.CapNhatPhuKienPC(MaSql, MaPK, Ten, "Nhasanxuat", ThayDoi,0,0,0);
            Menu();
            break;
            case 4 : System.out.print("Nhap So Luong Nhap Moi: ");
            ThayDoi = s.next();ThayDoi += s.nextLine();
            Data.CapNhatPhuKienPC(MaSql, MaPK, Ten, "Soluongnhap", ThayDoi,0,0,0);
            Menu();
            break;
            case 5 :
            System.out.print("Nhap Ngay Nhap Moi: ");
            int Ngay = s.nextInt();
            Ngay = SOSANH.SoSanhNgay(Ngay);   
            System.out.print("Nhap Thang Nhap Moi: ");
            int Thang = s.nextInt();
            Thang = SOSANH.SoSanhThang(Thang);
            System.out.print("Nhap Nam Nhap Moi: ");
            int Nam = s.nextInt();
            Nam = SOSANH.SoSanhNam(Nam); 
            Data.CapNhatPhuKienPC(MaSql, MaPK, Ten, "Ma", null,Ngay,Thang,Nam);
            Menu();
            break;
            case 6 : System.out.print("Nhap So Luong Xuat Moi: ");
            ThayDoi = s.next();ThayDoi += s.nextLine();
            Data.CapNhatPhuKienPC(MaSql, MaPK, Ten, "Soluongxuat", ThayDoi,0,0,0);
            Menu();
            break;
            case 7 :
            System.out.print("Nhap Ngay Xuat Moi: ");
            Ngay = s.nextInt();
            Ngay = SOSANH.SoSanhNgay(Ngay);   
            System.out.print("Nhap Thang Xuat Moi: ");
            Thang = s.nextInt();
            Thang = SOSANH.SoSanhThang(Thang);
            System.out.print("Nhap Nam Xuat Moi: ");
            Nam = s.nextInt();
            Nam = SOSANH.SoSanhNam(Nam); 
            Data.CapNhatPhuKienPC(MaSql, MaPK, Ten, "Ma", null,Ngay,Thang,Nam);
            Menu();
            break;
            case 8 : Menu();
        }
    }

    public static void XoaPhuKien(String MaSql){
        Scanner s = new Scanner(System.in);
        System.out.print("\n----------Xoa Phu Kien----------\n"
        + "1 Xoa Theo Ma Phu Kien\n"
        + "2 Xoa Theo Ten Phu Kien\n"
        + "3 De Ve Menu Chinh\n"
        + "\nChon 1 - 3 De Chon: ");
        int Chon = s.nextInt();
        while(Chon > 3 || Chon < 1){
            System.out.print("So Khong Co Trong Menu\nNhap Lai:");
            Chon = s.nextInt();
        }
        switch(Chon){
            case 1 : 
            System.out.print("Nhap Ma Phu Kien: ");
            String MaPK = s.next();
            Data.XoaPhuKienPC(MaSql, MaPK, null);
            break;
            case 2 : 
            System.out.print("Nhap Ten Ten Phu Kien: ");
            String Ten = s.next();
            Ten += s.nextLine();
            Data.XoaPhuKienPC(MaSql, null, Ten);
            break;
            case 3 : Menu();break;
        }
    }
    
    public static void ThemPhuKien(String MaSql){
        Scanner s = new Scanner(System.in);
        System.out.print("\n----------Them Phu Kien----------\nNhap Ma Phu Kien: ");
        String MAPK = s.next();MAPK += s.nextLine();
        MAPK = SOSANH.SetNull(MAPK);

        System.out.print("Nhap Ten Phu Kien: ");
        String TEN = s.next();TEN += s.nextLine();
        TEN = SOSANH.SetNull(TEN);

        System.out.print("Nhap Ten Hang San Xuat: ");
        String NSX = s.next();NSX += s.nextLine();
        NSX = SOSANH.SetNull(NSX);

        System.out.print("Nhap So Luong Nhap: ");
        int SOLUONGNHAP = s.nextInt();
        SOLUONGNHAP = SOSANH.SetAm(SOLUONGNHAP);

        System.out.print("Nhap Ngay Nhap: ");
        int NGAYNHAP = s.nextInt();
        NGAYNHAP = SOSANH.SoSanhNgay(NGAYNHAP);

        System.out.print("Nhap Thang Nhap: ");
        int THANGNHAP = s.nextInt();
        THANGNHAP = SOSANH.SoSanhThang(THANGNHAP);

        System.out.print("Nhap Nam Nhap: ");
        int NAMNHAP = s.nextInt();
        NAMNHAP = SOSANH.SoSanhNam(NAMNHAP);

        System.out.print("Nhap So Luong Xuat: ");
        int SOLUONGXUAT = s.nextInt();
        SOLUONGXUAT = SOSANH.SetAm(SOLUONGXUAT);

        System.out.print("Nhap Ngay Xuat: ");
        int NGAYXUAT = s.nextInt();
        SOSANH.SoSanhNgay(NGAYXUAT);

        System.out.print("Nhap Thang Xuat: ");
        int THANGXUAT = s.nextInt();
        SOSANH.SoSanhThang(THANGXUAT);

        System.out.print("Nhap Nam Xuat: ");
        int NAMXUAT = s.nextInt();
        SOSANH.SoSanhNam(NAMXUAT);

        Data.ThemPhuKienPC(MaSql, MAPK, TEN, NSX, SOLUONGNHAP, NGAYNHAP, THANGNHAP, NAMNHAP, SOLUONGXUAT, NGAYXUAT, THANGXUAT, NAMXUAT);
    }

    public static void KhoConPK(String MaSql){
        Scanner s = new Scanner(System.in);
        Data.XemPhuKienPC("SELECT * FROM " + MaSql,8, 1);
        System.out.print("\n1 De Them Phu Kien May Tinh\n"
        + "2 De Xoa Phu Kien May tinh\n"
        + "3 De Tim Phu Kien May Tinh\n"
        + "4 De Ve Menu Chinh\n"
        + "5 De Thoat Chuong Trinh\n"
        + "Chon So Tu 1 - 5: ");
        int Chon = s.nextInt();
        while(Chon > 5 || Chon < 1){
            System.out.print("So Khong Co Trong Menu\nNhap Lai:");
            Chon = s.nextInt();
        }
        switch(Chon){
            case 1 : ThemPhuKien(MaSql);break;
            case 2 : XoaPhuKien(MaSql);break;
            case 3 : TimKiemPhuKien(MaSql);;break;
            case 4 : Menu();break;
            case 5 : System.exit(Chon);break;
        }
    }
    public static void Menu(){
        Scanner s = new Scanner(System.in);
        System.out.print("----------Kho Phu Kien May Tinh----------\n1 Xem Kho CASE\n2 Xem Kho Cooler\n3 Xem Kho Fan\n4 Xem Kho Main\n5 Xem Kho RAM\n6 Xem Kho SPU\n7 Xem Kho SSD\n8 Xem Kho VGA\n9 Xem Kho CPU\n10 Ve Menu Chinh\nChon 1 - 10: ");
        int Chon = s.nextInt();
        while(Chon > 10 || Chon < 1){
            System.out.print("Nhap Sai\nNhap Lai: ");
            Chon = s.nextInt();
        }
        switch(Chon){
            case 1 : KhoCase.KhoCASE();break;
            case 2 : KhoCooler.KhoCooler();break;
            case 3 : KhoFan.KhoFan();break;
            case 4 : KhoMain.KhoMain();break;
            case 5 : KhoRam.KhoRAM();break;
            case 6 : KhoSpu.KhoSPU();break;
            case 7 : KhoSsd.KhoSSD();break;
            case 8 : KhoVga.KhoVGA();break;
            case 9 : KhoCpu.KhoCPU();break;
            case 10 : Main.MenuChinh(); break;
        }
    }
    public static void main(String[] args) {
        Menu();
    }
}
