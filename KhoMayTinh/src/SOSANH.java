import java.util.Scanner;

public class SOSANH extends KhoLapTop{
    public static int SoSanhNgay(int NGAY){
        Scanner s = new Scanner(System.in);
        if(NGAY > 31 || NGAY < 0){
            System.out.print("\nNgay Khong Ton Tai!\nNhap Lai: ");
            int Ngay = s.nextInt();
            SoSanhNgay(Ngay);
        }
        return NGAY;
    }

    public static int SoSanhThang(int THANG){
        Scanner s = new Scanner(System.in);
        if(THANG > 12 || THANG < 0){
            System.out.print("\nThang Khong Ton Tai!\nNhap Lai: ");
            int Thang = s.nextInt();
            SoSanhThang(Thang);
        }
        return THANG;
    }

    public static int SoSanhNam(int NAM){
        Scanner s = new Scanner(System.in);
        if(NAM > 2023 || NAM < 1000){
            System.out.print("\nNam Khong Ton Tai!\nNhap Lai: ");
            int Nam = s.nextInt();
            SoSanhNam(Nam);
        }
        return NAM;
    }

    public static String SetNull(String Key){
        Scanner s = new Scanner(System.in);
        if(Key == null){
            System.out.print("\nKhong Duoc De Trong!\nNhap Lai: ");
            String Khoa = s.next();
            SetNull(Khoa);
        }
        return Key;
    }

    public static int SetAm(int Key){
        Scanner s = new Scanner(System.in);
        if(Key < 0){
            System.out.print("\nKhong Duoc De Trong!\nNhap Lai: ");
            int Khoa = s.nextInt();
            SetAm(Khoa);
        }
        return Key;
    }
}


