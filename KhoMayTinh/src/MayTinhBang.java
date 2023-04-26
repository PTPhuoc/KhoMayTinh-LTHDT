import java.util.ArrayList;
import java.util.Scanner;

public class MayTinhBang extends Main{

    public static String Nhan;
    public String getNhan(String S){
        return Nhan = S;
    }
    public static void Loc(String MaSql, ArrayList<String> A){
        MayTinhBang MTB = new MayTinhBang();
        String Lenh = "SELECT * FROM MayTinhBang WHERE ";
        for(int i = 0; i < A.size(); i++){
            if(i == 0 && A.size() == 1){
                Lenh += A.get(i);
                MTB.getNhan(Lenh);
            }else if(i == 0){
                Lenh += A.get(i);
            }else if(i == A.size() - 1){
                MTB.getNhan(Lenh);
            }else{
                Lenh += " OR " + A.get(i);
            }
        }
        Data.XemKhoMTB(Nhan, 12, 1);
    }

    public static void KhoConMTB(String MaSql){
        Scanner s = new Scanner(System.in);
        Data.XemKhoMTB("SELECT * FROM " + MaSql, 12, 1);
    }

    public static void Menu(){
        Scanner s = new Scanner(System.in);
        System.out.print("----------Kho May Tinh Bang----------\n1 Xem Toan Kho\n2 Loc\n3 Tim Kiem\n4 Them May Tinh Bang\n5 Xoa May Tinh Bang\n6 Ve Menu\nChon 1 - 6: ");
        int Chon = s.nextInt();
        while(Chon > 6 || Chon < 1){
            System.out.print("So Khong Co Trong Menu\nNhap Lai:");
            Chon = s.nextInt();
        }
        switch(Chon){
            case 1 : KhoMayTinhBang.ToanKhoMayTinhBang();break;
            case 2 : KhoMayTinhBang.Loc();break;
            case 3 : TimKiem("MayTinhBang");break;
            case 4 : ThemMTB("MayTinhBang");break;
        }
    }

    public static void ThemMTB(String MaSql){
        Scanner s = new Scanner(System.in);
        System.out.print("----------Them May Tinh Bang----------\nNhap Ma May Tinh Bang: ");
        String Ma = s.next();Ma += s.nextLine();
        Ma = SOSANH.SetNull(Ma);

        System.out.print("\nNhap Ten May Tinh Bang: ");
        String Ten = s.next();Ten += s.nextLine();
        Ten = SOSANH.SetNull(Ten);

        System.out.print("\nNhap Hang San Xuat May Tinh Bang: ");
        String Hang = s.next();Hang += s.nextLine();
        Hang = SOSANH.SetNull(Hang);

        System.out.print("\nNhap Thong Tin Man Hinh May Tinh Bang: ");
        String ManHinh = s.next();ManHinh += s.nextLine();
        ManHinh = SOSANH.SetNull(ManHinh);

        System.out.print("\nNhap CPU May Tinh Bang: ");
        String Cpu = s.next();Cpu += s.nextLine();
        Cpu = SOSANH.SetNull(Cpu);

        System.out.print("\nNhap Ram May Tinh Bang: ");
        String Ram = s.next();Ram += s.nextLine();
        Ram = SOSANH.SetNull(Ram);

        System.out.print("\nNhap Rom May Tinh Bang: ");
        String Rom = s.next();Rom += s.nextLine();
        Rom = SOSANH.SetNull(Rom);

        System.out.print("\nNhap So Luong Nhap May Tinh Bang: ");
        int SoLuongN = s.nextInt();
        SoLuongN = SOSANH.SetAm(SoLuongN);

        System.out.print("Nhap Ngay Nhap Moi: ");
        int NgayN = s.nextInt();
        NgayN = SOSANH.SoSanhNgay(NgayN);   
        System.out.print("Nhap Thang Nhap Moi: ");
        int ThangN = s.nextInt();
        ThangN = SOSANH.SoSanhThang(ThangN);
        System.out.print("Nhap Nam Nhap Moi: ");
        int NamN = s.nextInt();
        NamN = SOSANH.SoSanhNam(NamN);

        System.out.print("\nNhap So Luong Xuat May Tinh Bang: ");
        int SoLuongX = s.nextInt();
        SoLuongX = SOSANH.SetAm(SoLuongX);

        System.out.print("Nhap Ngay Nhap Moi: ");
        int NgayX = s.nextInt();
        NgayX = SOSANH.SoSanhNgay(NgayX);   
        System.out.print("Nhap Thang Nhap Moi: ");
        int ThangX = s.nextInt();
        ThangX = SOSANH.SoSanhThang(ThangX);
        System.out.print("Nhap Nam Nhap Moi: ");
        int NamX = s.nextInt();
        NamX = SOSANH.SoSanhNam(NamX);

        Data.ThemMTB(MaSql, Ma, Ten, Hang, ManHinh, Cpu, Ram, Rom, SoLuongN, NgayN, ThangN, NamN, SoLuongX, NgayX, ThangX, NamX);
    }

    public static void TimKiem(String MaSql) {
        Scanner s = new Scanner(System.in);
        System.out.print("--------Tim Kiem May Tinh Bang--------\n1 Tim Tiem Theo Ma San Pham\n2 Tim Kiem Theo Ten San Pham\n3 Ve Menu\n Chon 1-3: ");
        int Chon = s.nextInt();
        while (Chon > 4 || Chon < 1) {
            System.out.print("Nhap Sai\nnhap lai: ");
            Chon = s.nextInt();
        }
        switch (Chon) {
            case 1:
                System.out.print("Nhap Ma San Pham: ");
                String MaPK = s.next();
                MaPK += s.nextLine();
                Data.TimkiemMTB(MaSql, MaPK, null);
                MenuChoCapNhat(MaSql, MaPK, null);
                break;
            case 2:
                System.out.print("Nhap Ten San Pham: ");
                String Ten = s.next();
                Ten += s.nextLine();
                Data.TimkiemMTB(MaSql, null, Ten);
                MenuChoCapNhat(MaSql, null, Ten);
                break;
            case 3:
                Menu();
                break;
        }
    }

    public static void CapNhat(String MaSql, String MaPK, String Ten) {
        Scanner s = new Scanner(System.in);
        System.out.print("-----------Cap Nhat San Pham----------\n" 
        + "\n1 Cap Nhat Ma Phu Kien"
        + "\n2 Cap Nhat Ten Phu Kien"
        + "\n3 Cap Nhat Hang Phu Kien"
        + "\n4 Cap Nhat Man Hinh Phu Kien"        
        + "\n5 Cap Nhat CPU Phu Kien"        
        + "\n6 Cap Nhat Ram Phu Kien"        
        + "\n7 Cap Nhat Rom Phu Kien"        
        + "\n8 Cap Nhat So Luong Nhap Phu Kien"        
        + "\n9 Cap Nhat Thoi Gian Nhap Phu Kien"        
        + "\n10 Cap Nhat So Luong Xuat Phu Kien"        
        + "\n11 Cap Nhat Thoi Gian Xuat Phu Kien"        
        + "\n12 Ve Menu"
        + "Chon 1 - 12: ");  
        int Chon = s.nextInt();
        while (Chon > 12 || Chon < 1) {
            System.out.print("Nhap Sai\nnhap lai: ");
            Chon = s.nextInt();
        }
        switch(Chon){
            case 1 : System.out.print("Nhap Ma San Pham Moi:  ");
            String ThayDoi = s.next();ThayDoi += s.nextLine();
            ThayDoi = SOSANH.SetNull(ThayDoi);
            Data.CapNhatMTB(MaSql, "Ma", ThayDoi, MaPK, Ten,0,0,0);       
            break; 
            case 2 : System.out.print("Nhap Ten San Pham Moi:  ");
            ThayDoi = s.next();ThayDoi += s.nextLine();
            ThayDoi = SOSANH.SetNull(ThayDoi);
            Data.CapNhatMTB(MaSql, "Ten", ThayDoi, MaPK, Ten,0,0,0);       
            break;
            case 3 : System.out.print("Nhap Hang San Pham Moi:  ");
            ThayDoi = s.next();ThayDoi += s.nextLine();
            ThayDoi = SOSANH.SetNull(ThayDoi);
            Data.CapNhatMTB(MaSql, "Hang", ThayDoi, MaPK, Ten,0,0,0);       
            break;
            case 4 : System.out.print("Nhap Man Hinh San Pham Moi:  ");
            ThayDoi = s.next();ThayDoi += s.nextLine();
            ThayDoi = SOSANH.SetNull(ThayDoi);
            Data.CapNhatMTB(MaSql, "Manhinh", ThayDoi, MaPK, Ten,0,0,0);       
            break;
            case 5 : System.out.print("Nhap CPU San Pham Moi:  ");
            ThayDoi = s.next();ThayDoi += s.nextLine();
            ThayDoi = SOSANH.SetNull(ThayDoi);
            Data.CapNhatMTB(MaSql, "CPU", ThayDoi, MaPK, Ten,0,0,0);       
            break;
            case 6 : System.out.print("Nhap Ram San Pham Moi:  ");
            ThayDoi = s.next();ThayDoi += s.nextLine();
            ThayDoi = SOSANH.SetNull(ThayDoi);
            Data.CapNhatMTB(MaSql, "Ram", ThayDoi, MaPK, Ten,0,0,0);       
            break;
            case 7 : System.out.print("Nhap Rom San Pham Moi:  ");
            ThayDoi = s.next();ThayDoi += s.nextLine();
            ThayDoi = SOSANH.SetNull(ThayDoi);
            Data.CapNhatMTB(MaSql, "Rom", ThayDoi, MaPK, Ten,0,0,0);       
            break;
            case 8 : System.out.print("Nhap So Luong Nhap San Pham Moi:  ");
            ThayDoi = s.next();ThayDoi += s.nextLine();
            ThayDoi = SOSANH.SetNull(ThayDoi);
            Data.CapNhatMTB(MaSql, "Soluongnhap", ThayDoi, MaPK, Ten,0,0,0);       
            break;
            case 9 : System.out.print("Nhap Ngay Nhap Moi: ");
            int Ngay = s.nextInt();
            Ngay = SOSANH.SoSanhNgay(Ngay);   
            System.out.print("Nhap Thang Nhap Moi: ");
            int Thang = s.nextInt();
            Thang = SOSANH.SoSanhThang(Thang);
            System.out.print("Nhap Nam Nhap Moi: ");
            int Nam = s.nextInt();
            Nam = SOSANH.SoSanhNam(Nam);
            Data.CapNhatMTB(MaSql, "Thoigiannhap", null, MaPK, Ten,Ngay,Thang,Nam);       
            break;
            case 10 : System.out.print("Nhap So Luong Xuat San Pham Moi:  ");
            ThayDoi = s.next();ThayDoi += s.nextLine();
            ThayDoi = SOSANH.SetNull(ThayDoi);
            Data.CapNhatMTB(MaSql, "Soluongxuat", ThayDoi, MaPK, Ten,0,0,0);       
            break;
            case 11 : System.out.print("Nhap Ngay Xuat Moi: ");
            Ngay = s.nextInt();
            Ngay = SOSANH.SoSanhNgay(Ngay);   
            System.out.print("Nhap Thang Xuat Moi: ");
            Thang = s.nextInt();
            Thang = SOSANH.SoSanhThang(Thang);
            System.out.print("Nhap Nam Xuat Moi: ");
            Nam = s.nextInt();
            Nam = SOSANH.SoSanhNam(Nam);
            Data.CapNhatMTB(MaSql, "Thoigianxuat", null, MaPK, Ten,Ngay,Thang,Nam);       
            break;
            case 12 : Menu();break;
        }

    }
    
    public static void MenuChoCapNhat(String MaSql, String MaPK,String Ten){
        Scanner s = new Scanner(System.in);
        System.out.print("\n1 De Cap Nhat San Pham\n2 Tim Kiem Lai\n3 Ve Menu\nChon 1 - 3: ");
        int Chon = s.nextInt();
        while (Chon > 3 || Chon < 1) {
            System.out.print("Nhap Sai\nnhap lai: ");
            Chon = s.nextInt();
        }
        switch(Chon){
            case 1 : CapNhat(MaSql,MaPK,Ten);break;
            case 2 : TimKiem(MaSql);break;
            case 3 : Menu();break;
        }
    }
}
