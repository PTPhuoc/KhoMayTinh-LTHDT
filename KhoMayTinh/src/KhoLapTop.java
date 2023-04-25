
import java.util.Scanner;

public class KhoLapTop{

    public static void KhoCon(String MaSql){
        Scanner s = new Scanner(System.in);
        Data.XuatData("SELECT * FROM " + MaSql,8, 3);
        System.out.print("\n1 De Xem Them Ngay Nhap Xuat\n"
        + "2 De Them San Pham\n"
        + "3 De Xoa San Pham\n"
        + "4 De Tim San Pham\n"
        + "5 De Ve Menu Chinh\n"
        + "6 De Thoat Chuong Trinh\n"
        + "Chon So Tu 1 - 6: ");
        int Chon = s.nextInt();
        while(Chon > 6 || Chon < 1){
            System.out.print("So Khong Co Trong Menu\nNhap Lai:");
            Chon = s.nextInt();
        }
        switch(Chon){
            case 1 : System.out.println("----------Thoi Gian Nhap Xuat----------");
            Data.XuatData("SELECT * FROM " + MaSql,12,9);Menu();break;
            case 2 : ThemSanPham(MaSql);break;
            case 3 : XoaSanPham(MaSql);break;
            case 4 : TimKiemSanPham(MaSql);break;
            case 5 : Menu();break;
            case 6 : System.exit(Chon);break;
        }
    }

    public static void ThemSanPham(String MaSql){
        Scanner s = new Scanner(System.in);
        System.out.print("----------Them San Pham----------\n" 
        + "Nhap STT: ");
        int STT = s.nextInt();
        STT = SOSANH.SetAm(STT);

        System.out.print("Nhap Ma San Pham: ");
        String MASP = s.next();MASP += s.nextLine();
        MASP = SOSANH.SetNull(MASP);

        System.out.print("Nhap Ten San Pham: ");
        String TEN = s.next();
        TEN += s.nextLine();
        TEN = SOSANH.SetNull(TEN);

        System.out.print("Nhap CPU: ");
        String CPU = s.next();
        CPU += s.nextLine();
        CPU = SOSANH.SetNull(CPU);

        System.out.print("Nhap DDR4: ");
        String DDR4 = s.next();
        DDR4 = SOSANH.SetNull(DDR4);

        System.out.print("Nhap VGA: ");
        String VGA = s.next();
        VGA += s.nextLine();
        VGA = SOSANH.SetNull(VGA);

        System.out.print("Nhap SSD: ");
        String SSD = s.next();
        SSD = SOSANH.SetNull(SSD);

        System.out.print("Nhap So Luong: ");
        int SOLUONG = s.nextInt();
        SOLUONG = SOSANH.SetAm(SOLUONG);

        System.out.print("Nhap Ngay Nhap: ");
        int NGAYNHAP = s.nextInt();
        NGAYNHAP = SOSANH.SoSanhNgay(NGAYNHAP);

        System.out.print("Nhap Thang Nhap: ");
        int THANGNHAP = s.nextInt();
        THANGNHAP = SOSANH.SoSanhThang(THANGNHAP);

        System.out.print("Nhap Nam Nhap: ");
        int NAMNHAP = s.nextInt();
        NAMNHAP = SOSANH.SoSanhNam(NAMNHAP);

        System.out.print("Nhap So Luong Nhap: ");
        int SOLUONGNHAP = s.nextInt();
        SOLUONGNHAP = SOSANH.SetAm(SOLUONGNHAP);

        System.out.print("Nhap Ngay Ban: ");
        int NGAYBAN = s.nextInt();
        SOSANH.SoSanhNgay(NGAYBAN);

        System.out.print("Nhap Thang Ban: ");
        int THANGBAN = s.nextInt();
        SOSANH.SoSanhThang(THANGBAN);

        System.out.print("Nhap Nam Ban: ");
        int NAMBAN = s.nextInt();
        SOSANH.SoSanhNam(NAMBAN);

        System.out.print("Nhap So Luong Ban: ");
        int SOLUONGBAN = s.nextInt();
        SOLUONGBAN = SOSANH.SetAm(SOLUONGBAN);

        Data.ThemHang(MaSql, STT, MASP, TEN, CPU, DDR4, VGA, SSD, SOLUONG, NGAYNHAP, THANGNHAP, NAMNHAP, SOLUONGNHAP, NGAYBAN, THANGBAN, NAMBAN, SOLUONGBAN);
    }

    public static void XoaSanPham(String MaSql){
        Scanner s = new Scanner(System.in);
        System.out.print("\n----------Xoa San Pham----------\n"
        + "1 Xoa Theo Ma San Pham\n"
        + "2 Xoa Theo Ten San Pham\n"
        + "3 De Ve Menu Chinh\n"
        + "\nChon 1 - 3 De Chon: ");
        int Chon = s.nextInt();
        while(Chon > 3 || Chon < 1){
            System.out.print("So Khong Co Trong Menu\nNhap Lai:");
            Chon = s.nextInt();
        }
        switch(Chon){
            case 1 : 
            System.out.print("Nhap Ma San Pham: ");
            String MaSP = s.next();
            Data.XoaHangTheoMa(MaSql, MaSP);
            break;
            case 2 : 
            System.out.print("Nhap Ten San Pham: ");
            String Ten = s.next();
            Ten += s.nextLine();
            Data.XoaHangTheoTenSp(MaSql, Ten);
            break;
            case 3 : Menu();break;
        }
    }

    public static void TimKiemSanPham(String MaSql){
        Scanner s = new Scanner(System.in);
        System.out.print("\n----------Tim kiem----------\n"
        + "1 De Tim Theo Ten San Pham\n"
        + "2 De Tim Theo Ma San Pham\n"
        + "3 de Ve Menu Chinh\n"
        + "Chon 1 - 3 De Chon: ");
        int Chon = s.nextInt();
        while(Chon > 3 || Chon < 1){
            System.out.print("So Khong Co Trong Menu\nNhap Lai:");
            Chon = s.nextInt();
        }
        switch(Chon){
            case 1 : 
            System.out.print("\nNhap Ten San Pham: ");
            String Ten = s.next();
            Ten += s.nextLine();
            Data.TimKiem(MaSql, 8, 1, Ten, null);
            System.out.print("\n1 Xem Them Thong Tin Nhap Xuat\n2 Cap Nhat San Pham\n3 Ve Menu Chinh\nChon 1 - 3: ");
            Chon = s.nextInt();
            switch(Chon){
                case 1 : Data.TimKiem(MaSql, 12, 9, Ten, null);break;
                case 2 : CapNhatSanPham(MaSql, null, Ten);break;
                case 3 : Menu();break;
                default : break;
            }break;
            case 2 : 
            System.out.print("\nNhap Ma San Pham: ");
            String MaSp = s.next();
            Data.TimKiem(MaSql, 8, 1, null, MaSp);
            System.out.print("\n1 Xem Them Thong Tin Nhap Xuat\n2 Cap Nhat San Pham\n3 Ve Menu Chinh\nChon 1 - 3: ");
            Chon = s.nextInt();
            switch(Chon){
                case 1 : Data.TimKiem(MaSql, 12, 9, null, MaSp);break;
                case 2 : CapNhatSanPham(MaSql, MaSp, null);break;
                case 3 : Menu();break;
                default : break;
            }break;
            case 3 : Menu();break;
        }
    }

    public static void CapNhatSanPham(String MaSql, String MaSp, String Ten){
        Scanner s = new Scanner(System.in);
        System.out.print("----------Cap Nhat San Pham----------\n1 Cap Nhat STT\n2 Cap Nhat Ma San Pham\n3 Cap Nhat Ten San Pham\n4 Cap Nhat CPU\n5 Cap Nhat DDR4\n6 cap Nhat VGA\n7 Cap Nhat SSD\n8 Cap Nhat So Luong\n9 Cap Nhat Ngay Nhap\n10 Cap Nhat So Luong Nhap\n11 Cap Nhat Ngay Ban\n12 Cap Nhat So Luong Ban\n13 Ve Menu Chinh\nChon 1 - 13: ");
        int Chon = s.nextInt();
        while(Chon < 0 || Chon > 13){
            System.out.print("Nhap Sai\nNhap Lai: ");
            Chon = s.nextInt();
        }
        switch(Chon){
            case 1 : 
            System.out.print("Cap Nhat STT Thanh: ");
            String STT = s.next();
            STT = SOSANH.SetNull(STT);
            String Cot = "STT";
            Data.CapNhat(MaSql, Ten, MaSp, Cot, STT,0,0,0);
            MenuForCapNhat(MaSql, MaSp, Ten);
            break;
            case 2 : 
            System.out.print("Cap Nhat Ma San Pham Thanh: ");
            String MASP = s.next();
            MASP = SOSANH.SetNull(MASP);
            Cot = "MA-SP";
            Data.CapNhat(MaSql, Ten, MaSp, Cot, MASP,0,0,0);
            MenuForCapNhat(MaSql, MaSp, Ten);
            break;
            case 3 : 
            System.out.print("Cap Nhat Ten San Pham Thanh: ");
            String TEN = s.next();TEN += s.nextLine();
            TEN = SOSANH.SetNull(TEN);
            Cot = "TEN";
            Data.CapNhat(MaSql, Ten, MaSp, Cot, TEN,0,0,0);
            MenuForCapNhat(MaSql, MaSp, Ten);
            break;
            case 4 : 
            System.out.print("Cap Nhat CPU San Pham Thanh: ");
            String CPU = s.next();
            CPU = SOSANH.SetNull(CPU);
            Cot = "CPU";
            Data.CapNhat(MaSql, Ten, MaSp, Cot, CPU,0,0,0);
            MenuForCapNhat(MaSql, MaSp, Ten);
            break;
            case 5 : 
            System.out.print("Cap Nhat DDR4 San Pham Thanh: ");
            String DDR4 = s.next();
            DDR4 = SOSANH.SetNull(DDR4);
            Cot = "DDR4";
            Data.CapNhat(MaSql, Ten, MaSp, Cot, DDR4,0,0,0);
            MenuForCapNhat(MaSql, MaSp, Ten);
            break;
            case 6 : 
            System.out.print("Cap Nhat VGA San Pham Thanh: ");
            String VGA = s.next();
            VGA = SOSANH.SetNull(VGA);
            Cot = "VGA";
            Data.CapNhat(MaSql, Ten, MaSp, Cot, VGA,0,0,0);
            MenuForCapNhat(MaSql, MaSp, Ten);
            break;
            case 7 : 
            System.out.print("Cap Nhat SSD San Pham Thanh: ");
            String SSD = s.next();
            SSD = SOSANH.SetNull(SSD);
            Cot = "SSD";
            Data.CapNhat(MaSql, Ten, MaSp, Cot, SSD,0,0,0);
            MenuForCapNhat(MaSql, MaSp, Ten);
            break;
            case 8 : 
            System.out.print("Cap Nhat So Luong San Pham Thanh: ");
            String SoLuong = s.next();
            SoLuong = SOSANH.SetNull(SoLuong);
            Cot = "SO-LUONG";
            Data.CapNhat(MaSql, Ten, MaSp, Cot, SoLuong,0,0,0);
            MenuForCapNhat(MaSql, MaSp, Ten);
            break;
            case 9 : 
            System.out.print("Cap Nhat Ngay Nhap San Pham Thanh\nNhap Ngay: ");
            int Ngay = s.nextInt();
            Ngay = SOSANH.SoSanhNgay(Ngay);
            System.out.print("\nNhap Thang: ");
            int Thang = s.nextInt();
            Thang = SOSANH.SoSanhThang(Thang);
            System.out.print("\nNhap Nam: ");
            int Nam = s.nextInt();
            Nam = SOSANH.SoSanhNam(Nam);
            Cot = "NGAY-NHAP";
            Data.CapNhat(MaSql, Ten, MaSp, Cot, null,Ngay,Thang,Nam);
            MenuForCapNhat(MaSql, MaSp, Ten);
            break;
            case 10 : 
            System.out.print("Cap Nhat So Luong Nhap San Pham Thanh: ");
            SoLuong = s.next();
            SoLuong = SOSANH.SetNull(SoLuong);
            Cot = "SOLUONG-NHAP";
            Data.CapNhat(MaSql, Ten, MaSp, Cot, SoLuong,0,0,0);
            MenuForCapNhat(MaSql, MaSp, Ten);
            break;
            case 11 : System.out.print("Cap Nhat Ngay Ban San Pham Thanh\nNhap Ngay: ");
            Ngay = s.nextInt();
            Ngay = SOSANH.SoSanhNgay(Ngay);
            System.out.print("\nNhap Thang: ");
            Thang = s.nextInt();
            Thang = SOSANH.SoSanhThang(Thang);
            System.out.print("\nNhap Nam: ");
            Nam = s.nextInt();
            Nam = SOSANH.SoSanhNam(Nam);
            Cot = "NGAY-BAN";
            Data.CapNhat(MaSql, Ten, MaSp, Cot, null,Ngay,Thang,Nam);
            MenuForCapNhat(MaSql, MaSp, Ten);
            break;
            case 12 :
            System.out.print("Cap Nhat So Luong Ban San Pham Thanh: ");
            SoLuong = s.next();
            SoLuong = SOSANH.SetNull(SoLuong);
            Cot = "SOLUONGBANTRONG-NGAY";
            Data.CapNhat(MaSql, Ten, MaSp, Cot, SoLuong,0,0,0);
            MenuForCapNhat(MaSql, MaSp, Ten);
            break;
            default : break;
        }
    }

    public static void MenuForCapNhat(String MaSql, String MaSp, String Ten){
        Scanner s = new Scanner(System.in);
        System.out.print("\n1 Tiep Tuc Cap Nhat\n2 Ve Menu Chinh\nChon 1 - 3: ");
        int Chon = s.nextInt();
        while(Chon < 0 || Chon > 3){
            System.out.print("Nhap Sai\nNhap Lai: ");
            Chon = s.nextInt();
        }
        switch(Chon){
            case 1 : CapNhatSanPham(MaSql, MaSp, Ten);break;
            case 2 : Menu();break;
            default : break;
        }
    }
    
    public static void Menu(){
        Scanner s = new Scanner(System.in);
        System.out.print("\n\n-----Kho LapTop-----\n\n" 
        + "1 De Kiem Tra Kho ACER\n"
        + "2 De Kiem Tra Kho ASUS\n"
        + "3 De Kiem Tra Kho DELL\n"
        + "4 De Kiem Tra Kho HP\n"
        + "5 De Kiem Tra Kho LENOVO\n"
        + "6 De Kiem Tra Kho MSI\n"
        + "7 De Thoat Chuong Trinh\n\n"
        + "Chon 1 - 7 De Kiem Tra Kho: ");

        int Chon = s.nextInt();
        while(Chon > 7 || Chon < 1){
            System.out.print("So Khong Co Trong Menu\nNhap Lai:");
            Chon = s.nextInt();
        }
        switch(Chon){
            case 1 : KhoAcer.KhoAcer();break;
            case 2 : KhoAsus.KhoAsus();break;
            case 3 : KhoDell.KhoDell();break;
            case 4 : KhoHp.KhoHp();break;
            case 5 : KhoLenovo.KhoLenovo();break;
            case 6 : KhoMsi.KhoMsi();break;
            case 7 : System.exit(Chon);
        }
    }

    public static void main(String[] args) {
        Menu();
    }
}