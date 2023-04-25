import java.util.Scanner;

public class Main {
    public static void MenuChinh(){
        Scanner s = new Scanner(System.in);
        System.out.print("----------Kho May Tinh----------\n1 De Vao Kho LapTop\n2 De Vao Kho Phu Kien May Tinh\n3 De Vao Kho May Tinh Bang\n4 De Thoat Chuong Trinh\nChon 1 - 4: ");
        int Chon = s.nextInt();
        while(Chon > 4 && Chon < 1){
            System.out.print("Nhap Sai\nNhap Lai: ");
            Chon = s.nextInt();
        }
        switch(Chon){
            case 1 : KhoLapTop.Menu();break;
            case 2 : PhuKien.Menu();break;
            case 3 : MayTinhBang.Menu();break;
            case 4 : System.exit(Chon);break;
        }
    }
    public static void main(String[] args) {
        MenuChinh();
    }
}
