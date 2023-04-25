import java.util.Scanner;

public class MayTinhBang {

    public static void KhoConMTB(String MaSql){
        Scanner s = new Scanner(System.in);
        Data.XemKhoMTB("SELECT * FROM " + MaSql, 12, 1);
    }

    public static void Menu(){
        Scanner s = new Scanner(System.in);
        System.out.print("----------Kho May Tinh Bang----------\n1 Xem Toan Kho\n2 Loc\n3 Tim Kim\n4 Them May Tinh Bang\n5 Xoa May Tinh Bang\n6 Ve Menu\nChon 1 - 6: ");
        int Chon = s.nextInt();
        while(Chon > 6 || Chon < 1){
            System.out.print("So Khong Co Trong Menu\nNhap Lai:");
            Chon = s.nextInt();
        }
        switch(Chon){
            case 1 : KhoMayTinhBang.ToanKhoMayTinhBang();break;
            case 2 : 
        }
    }

    public static void main(String[] args) {
        Menu();
    }
}
