
import java.util.Scanner;

public class KhoLapTop{

    public static void KhoAcer(){
        System.out.println("-----Kho Acer-----");
        KhoCon("ACER");
    }

    public static void KhoAsus(){
        System.out.println("-----Kho Asus-----");
        KhoCon("ASUS");
    }

    public static void KhoDell(){
        System.out.println("-----Kho Dell-----");
        KhoCon("DELL");
    }

    public static void KhoHp(){
        System.out.println("-----Kho Hp-----");
        KhoCon("HP");
    }

    public static void KhoLenovo(){
        System.out.println("-----Kho Lenovo-----\n");
        KhoCon("LENOVO");
    }

    public static void KhoMsi(){
        System.out.println("-----Kho MSI-----");
        KhoCon("MSI");
    }

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

        System.out.print("Nhap Ma San Pham: ");
        String MASP = s.next();

        System.out.print("Nhap Ten San Pham: ");
        String TEN = s.next();
        TEN += s.nextLine();

        System.out.print("Nhap CPU: ");
        String CPU = s.nextLine();

        System.out.print("Nhap DDR4: ");
        int DDR4 = s.nextInt();

        System.out.print("Nhap VGA: ");
        String VGA = s.next();
        VGA += s.nextLine();

        System.out.print("Nhap SSD: ");
        int SSD = s.nextInt();

        System.out.print("Nhap So Luong: ");
        int SOLUONG = s.nextInt();

        System.out.print("Nhap Ngay Nhap: ");
        int NGAYNHAP = s.nextInt();
        SOSANH.SoSanhNgay(NGAYNHAP);

        System.out.print("Nhap Thang Nhap: ");
        int THANGNHAP = s.nextInt();
        SOSANH.SoSanhThang(THANGNHAP);

        System.out.print("Nhap Nam Nhap: ");
        int NAMNHAP = s.nextInt();
        SOSANH.SoSanhNam(NAMNHAP);

        System.out.print("Nhap So Luong Nhap: ");
        int SOLUONGNHAP = s.nextInt();

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

        Data.ThemHang(MaSql, STT, MASP, TEN, CPU, DDR4, VGA, SSD, SOLUONG, NGAYNHAP, THANGNHAP, NAMNHAP, SOLUONGNHAP, NGAYBAN, THANGBAN, NAMBAN, SOLUONGBAN);
    }

    public static void XoaSanPham(String MaSql){
        Scanner s = new Scanner(System.in);
        System.out.println("----------Xoa San Pham----------\n"
        + "1 Xoa Theo Ma San Pham\n"
        + "2 Xoa Theo Ten San Pham\n"
        + "\nChon 1 - 2 De Chon\n");
        int Chon = s.nextInt();
        while(Chon > 2 || Chon < 1){
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
            System.out.print("\nXem Them Thong Tin Nhap Xuat (Y Hoac N):");
            String YorN = s.next();
            if(YorN.equals("Y") || YorN.equals("y")){
                Data.TimKiem(MaSql, 12, 9, Ten, null);
                Menu();
            }else{
                Menu();
            }
            break;
            case 2 : 
            System.out.print("\nNhap Ma San Pham: ");
            String MaSp = s.next();
            Data.TimKiem(MaSql, 8, 1, null, MaSp);
            System.out.print("\nXem Them Thong Tin Nhap Xuat (Y Hoac N):");
            YorN = s.next();
            if(YorN.equals("Y") || YorN.equals("y")){
                Data.TimKiem(MaSql, 12, 9, null, MaSp);
                Menu();
            }else{
                Menu();
            }
            break;
            case 3 : Menu();break;
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
            case 1 : KhoAcer();break;
            case 2 : KhoAsus();break;
            case 3 : KhoDell();break;
            case 4 : KhoHp();break;
            case 5 : KhoLenovo();break;
            case 6 : KhoMsi();break;
            case 7 : System.exit(Chon);
        }
    }
}

class Main{
    public static void main(String[] args) throws Exception{
        KhoLapTop.Menu();
    }
}
