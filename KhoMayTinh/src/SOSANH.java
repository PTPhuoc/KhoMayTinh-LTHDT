import java.util.Scanner;

public class SOSANH {
    public static void SoSanhNgay(int NGAY){
        Scanner s = new Scanner(System.in);
        if(NGAY > 31 || NGAY < 0){
            System.out.print("\nNgay Khong Ton Tai!\nNhap Lai: ");
            int Ngay = s.nextInt();
            SoSanhNgay(Ngay);
        }
    }

    public static void SoSanhThang(int THANG){
        Scanner s = new Scanner(System.in);
        if(THANG > 12 || THANG < 0){
            System.out.print("\nThang Khong Ton Tai!\nNhap Lai: ");
            int Thang = s.nextInt();
            SoSanhThang(Thang);
        }
    }

    public static void SoSanhNam(int NAM){
        Scanner s = new Scanner(System.in);
        if(NAM > 2023 || NAM < 1000){
            System.out.print("\nThang Khong Ton Tai!\nNhap Lai: ");
            int Thang = s.nextInt();
            SoSanhThang(Thang);
        }
    }
}


