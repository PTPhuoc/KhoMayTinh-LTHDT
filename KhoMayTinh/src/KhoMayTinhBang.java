import java.util.ArrayList;
import java.util.Scanner;

public class KhoMayTinhBang {

    ArrayList<String> H = new ArrayList<>();
    ArrayList<String> C = new ArrayList<>();
    ArrayList<String> Ra = new ArrayList<>();
    ArrayList<String> Ro = new ArrayList<>();
    public static void ToanKhoMayTinhBang(){
        System.out.print("----------Kho May Tinh Bang----------\n");
        MayTinhBang.KhoConMTB("MayTinhBang");
    }

    public static void Loc(){
        Scanner s = new Scanner(System.in);
        System.out.print("-----------Loc May Tinh Bang----------\n1 Loc Theo Hang San Xuat\n2 Loc Theo CPU\n3 Loc Theo RAM\n4 Loc Theo ROM\n5 Ve Menu\nChon 1 -5: ");
        int Chon = s.nextInt();
        while(Chon > 4 || Chon < 1){
            System.out.print("So Khong Co Trong Menu\nNhap Lai:");
            Chon = s.nextInt();
        }
    }

    public static void ChonHangSX(int Chon){
        KhoMayTinhBang KMTB = new KhoMayTinhBang();
        Scanner s = new Scanner(System.in);
        switch(Chon){
            case 1 : System.out.print("\n1 SamSung\n2 Apple\n3 Yuho\n4 Huawei\n5 Nokia\n6 Microsoft\n7 Xiaomi ");
            Chon = s.nextInt();
            while(Chon > 4 || Chon < 1){
                System.out.print("So Khong Co Trong Menu\nNhap Lai:");
                Chon = s.nextInt();
                switch(Chon){
                    case 1 : KMTB.DanhSachLoc("Samsung", null, null, null);
                    System.out.print("\n1 Tiep Tuc Chon\n2 Chon Khac\n3 Tien Thanh Loc\n4 Ve Menu\nChon 1 - 4: ");
                    Chon = s.nextInt();
                    while(Chon > 4 || Chon < 1){
                        System.out.print("So Khong Co Trong Menu\nNhap Lai:");
                        Chon = s.nextInt();
                    }
                    switch(Chon){
                        case 1 : ChonHangSX(Chon);break;
                        case 2 : Loc();break;
                        case 3 : KMTB.TienThanhLoc();break;
                        case 4 : 
                    }
                    break;
                    case 2 : KMTB.DanhSachLoc("Apple", null, null, null);break;
                    case 3 : KMTB.DanhSachLoc("Yuho", null, null, null);break;
                    case 4 : KMTB.DanhSachLoc("Huawei", null, null, null);break;
                    case 5 : KMTB.DanhSachLoc("Nokia", null, null, null);break;
                    case 6 : KMTB.DanhSachLoc("Microsoft", null, null, null);break;
                    case 7 : KMTB.DanhSachLoc("Xiaomi", null, null, null);break;
                }
            }
        }
    }

    public void DanhSachLoc(String Hang,String Cpu, String Ram,String Rom){
        if(Hang != null){
            this.H.add(Hang);
        }else if(Cpu != null){
            this.C.add(Cpu);
        }else if(Ram != null){
            this.Ra.add(Ram);
        }else if(Rom != null){
            this.Ro.add(Rom);
        }
    }

    public void TienThanhLoc(){
        if(this.H.size() >= 0){
            for(int i = 0; i <= this.H.size(); i++){
                Data.XemKhoMTB("SELECT * FROM MayTinhBang WHERE [Hangsanxuay] = " + H.get(i), 12, 1);
            }
        }else if(this.C.size() >= 0){
            for(int i = 0; i <= this.C.size(); i++){
                Data.XemKhoMTB("SELECT * FROM MayTinhBang WHERE [Hangsanxuay] = " + C.get(i), 12, 1);
            }
        }else if(this.Ra.size() >= 0){
            for(int i = 0; i <= this.H.size(); i++){
                Data.XemKhoMTB("SELECT * FROM MayTinhBang WHERE [Hangsanxuay] = " + Ra.get(i), 12, 1);
            }
        }else if(this.Ro.size() >= 0){
            for(int i = 0; i <= this.Ro.size(); i++){
                Data.XemKhoMTB("SELECT * FROM MayTinhBang WHERE [Hangsanxuay] = " + Ro.get(i), 12, 1);
            }
        }
    }
}
