import java.util.ArrayList;
import java.util.Scanner;

public class KhoMayTinhBang extends MayTinhBang {

    public static ArrayList<String> H = new ArrayList<>();
    public static ArrayList<String> C = new ArrayList<>();
    public static ArrayList<String> Ra = new ArrayList<>();
    public static ArrayList<String> Ro = new ArrayList<>();
    public static ArrayList<String> Tam = new ArrayList<>();

    public static String Luu;

    public ArrayList<String> getH(){
        return H;
    }

    public ArrayList<String> getC(){
        return C;
    }

    public ArrayList<String> getRa(){
        return Ra;
    }

    public ArrayList<String> getRo(){
        return Ro;
    }

    public ArrayList<String> getTam(){
        return Tam;
    }

    public String getLuu(String L){
        if(Luu != null){
            return Luu += L;
        }else{
           return Luu = L; 
        }
    }

    public static void ToanKhoMayTinhBang() {
        System.out.print("----------Kho May Tinh Bang----------\n");
        MayTinhBang.KhoConMTB("MayTinhBang");
    }

    public static void Loc() {
        Scanner s = new Scanner(System.in);
        System.out.print(
                "-----------Loc May Tinh Bang----------\n1 Loc Theo Hang San Xuat\n2 Loc Theo CPU\n3 Loc Theo RAM\n4 Loc Theo ROM\n5 Ve Menu\nChon 1 -5: ");
        int Chon = s.nextInt();
        while (Chon > 4 || Chon < 1) {
            System.out.print("So Khong Co Trong Menu\nNhap Lai:");
            Chon = s.nextInt();
        }
        switch (Chon) {
            case 1 : ChonHangSX(Chon);break;
            case 2 : ChonCpu(Chon);break;
            case 3 : ChonRam(Chon);break;
            case 4 : ChonRom(Chon);break;
        }
    }

    public static void ChonRom(int Chon){
        KhoMayTinhBang KMTB = new KhoMayTinhBang();
        Scanner s = new Scanner(System.in);
        System.out.print("\n1 32 GB\n2 64 GB\n3 128 GB\n4 256GB\n5 2TB\nChon 1 - 5: ");
        Chon = s.nextInt();
        while (Chon > 5 || Chon < 1) {
            System.out.print("So Khong Co Trong Menu\nNhap Lai:");
            Chon = s.nextInt();
        }
        switch(Chon){
            case 1 : KMTB.DanhSachLoc(null, null, null, "32 GB");TuyChonLocRo();break;
            case 2 : KMTB.DanhSachLoc(null, null, null, "64 GB");TuyChonLocRo();break;
            case 3 : KMTB.DanhSachLoc(null, null, null, "128 GB,128GB");TuyChonLocRo();break;
            case 4 : KMTB.DanhSachLoc(null, null, null, "256GB");TuyChonLocRo();break;
            case 5 : KMTB.DanhSachLoc(null, null, null, "2TB");TuyChonLocRo();break;
        }
    }

    public static void ChonRam(int Chon){
        KhoMayTinhBang KMTB = new KhoMayTinhBang();
        Scanner s = new Scanner(System.in);
        System.out.print("\n1 3 GB\n2 4 GB\n3 6 GB\n4 8 GB\n5 16 GB\nChon 1 - 5: ");
        Chon = s.nextInt();
        while (Chon > 5 || Chon < 1) {
            System.out.print("So Khong Co Trong Menu\nNhap Lai:");
            Chon = s.nextInt();
        }
        switch(Chon){
            case 1 : KMTB.DanhSachLoc(null, null, "3 GB,3GB", null);TuyChonLocRa();break;
            case 2 : KMTB.DanhSachLoc(null, null, "4 GB", null);TuyChonLocRa();break;
            case 3 : KMTB.DanhSachLoc(null, null, "6 GB", null);TuyChonLocRa();break;
            case 4 : KMTB.DanhSachLoc(null, null, "8 GB", null);TuyChonLocRa();break;
            case 5 : KMTB.DanhSachLoc(null, null, "16 GB", null);TuyChonLocRa();break;
        }
    }

    public static void ChonCpu(int Chon){
        KhoMayTinhBang KMTB = new KhoMayTinhBang();
        Scanner s = new Scanner(System.in);
        System.out.print("\n1 Snapdragon\n2 MediaTek\n3 iPadOS\n4 Apple M\n5 Unisoc\n6 SC9832e\n7 Kirin\n8 Core i5\nChon 1 - 8: ");
        Chon = s.nextInt();
        while (Chon > 8 || Chon < 1) {
            System.out.print("So Khong Co Trong Menu\nNhap Lai:");
            Chon = s.nextInt();
        }
        switch(Chon){
            case 1 : KMTB.DanhSachLoc(null, "Snapdragon 860 8 nhân,Snapdragon 8 Gen 1 8 nhân", null, null);TuyChonLocC();break;
            case 2 : KMTB.DanhSachLoc(null, "MediaTek MT8768T", null, null);TuyChonLocC();break;
            case 3 : KMTB.DanhSachLoc(null, "iPadOS 15,iPadOS 16", null, null);TuyChonLocC();break;
            case 4 : KMTB.DanhSachLoc(null, "Apple M1", null, null);TuyChonLocC();break;
            case 5 : KMTB.DanhSachLoc(null, "UniSOC T618,Unisoc T610 8 nhân", null, null);TuyChonLocC();break;
            case 6 : KMTB.DanhSachLoc(null, "SC9832e", null, null);TuyChonLocC();break;
            case 7 : KMTB.DanhSachLoc(null, "Kirin 710A", null, null);TuyChonLocC();break;
            case 8 : KMTB.DanhSachLoc(null, "Core i5", null, null);TuyChonLocC();break;
        }
    }

    public static void ChonHangSX(int Chon) {
        KhoMayTinhBang KMTB = new KhoMayTinhBang();
        Scanner s = new Scanner(System.in);
        System.out.print("\n1 SamSung\n2 Apple\n3 Yuho\n4 Huawei\n5 Nokia\n6 Microsoft\n7 Xiaomi\nChon 1 - 7: ");
        Chon = s.nextInt();
        while (Chon > 7 || Chon < 1) {
            System.out.print("So Khong Co Trong Menu\nNhap Lai:");
            Chon = s.nextInt();
        }
        switch (Chon) {
            case 1:KMTB.DanhSachLoc("Samsung", null, null, null);TuyChonLocH();break;
            case 2:KMTB.DanhSachLoc("Apple", null, null, null);TuyChonLocH();break;
            case 3:KMTB.DanhSachLoc("Yuho", null, null, null);TuyChonLocH();break;
            case 4:KMTB.DanhSachLoc("Huawei", null, null, null);TuyChonLocH();break;
            case 5:KMTB.DanhSachLoc("Nokia", null, null, null);TuyChonLocH();break;
            case 6:KMTB.DanhSachLoc("Microsoft", null, null, null);TuyChonLocH();break;
            case 7:KMTB.DanhSachLoc("Xiaomi", null, null, null);TuyChonLocH();break;
        }
    }

    public static void TuyChonLocRo() {
        KhoMayTinhBang KMTB = new KhoMayTinhBang();
        Scanner s = new Scanner(System.in);
        System.out.print("\n1 Tiep Tuc Chon\n2 Chon Khac\n3 Tien Thanh Loc\n4 Ve Menu\nChon 1 - 4: ");
        int Chon = s.nextInt();
        while (Chon > 4 || Chon < 1) {
            System.out.print("So Khong Co Trong Menu\nNhap Lai:");
            Chon = s.nextInt();
        }
        switch (Chon) {
            case 1:ChonRom(Chon);break;
            case 2:Loc();break;
            case 3:KMTB.TienThanhLoc("MayTinhBang");break;
            case 4:MayTinhBang.Menu();break;
        }
    }

    public static void TuyChonLocRa() {
        KhoMayTinhBang KMTB = new KhoMayTinhBang();
        Scanner s = new Scanner(System.in);
        System.out.print("\n1 Tiep Tuc Chon\n2 Chon Khac\n3 Tien Thanh Loc\n4 Ve Menu\nChon 1 - 4: ");
        int Chon = s.nextInt();
        while (Chon > 4 || Chon < 1) {
            System.out.print("So Khong Co Trong Menu\nNhap Lai:");
            Chon = s.nextInt();
        }
        switch (Chon) {
            case 1:ChonRam(Chon);break;
            case 2:Loc();break;
            case 3:KMTB.TienThanhLoc("MayTinhBang");break;
            case 4:MayTinhBang.Menu();break;
        }
    }

    public static void TuyChonLocC() {
        KhoMayTinhBang KMTB = new KhoMayTinhBang();
        Scanner s = new Scanner(System.in);
        System.out.print("\n1 Tiep Tuc Chon\n2 Chon Khac\n3 Tien Thanh Loc\n4 Ve Menu\nChon 1 - 4: ");
        int Chon = s.nextInt();
        while (Chon > 4 || Chon < 1) {
            System.out.print("So Khong Co Trong Menu\nNhap Lai:");
            Chon = s.nextInt();
        }
        switch (Chon) {
            case 1:ChonCpu(Chon);break;
            case 2:Loc();break;
            case 3:KMTB.TienThanhLoc("MayTinhBang");break;
            case 4:MayTinhBang.Menu();break;
        }
    }

    public static void TuyChonLocH() {
        KhoMayTinhBang KMTB = new KhoMayTinhBang();
        Scanner s = new Scanner(System.in);
        System.out.print("\n1 Tiep Tuc Chon\n2 Chon Khac\n3 Tien Thanh Loc\n4 Ve Menu\nChon 1 - 4: ");
        int Chon = s.nextInt();
        while (Chon > 4 || Chon < 1) {
            System.out.print("So Khong Co Trong Menu\nNhap Lai:");
            Chon = s.nextInt();
        }
        switch (Chon) {
            case 1:ChonHangSX(Chon);break;
            case 2:Loc();break;
            case 3:KMTB.TienThanhLoc("MayTinhBang");break;
            case 4:MayTinhBang.Menu();break;
        }
    }

    public void DanhSachLoc(String Hang, String Cpu, String Ram, String Rom) {
        KhoMayTinhBang KMTB = new KhoMayTinhBang();
        if (Hang != null) {
            KMTB.getH().add(Hang);
        } else if (Cpu != null) {
            KMTB.getC().add(Cpu);
        } else if (Ram != null) {
            KMTB.getRa().add(Ram);
        } else if (Rom != null) {
            KMTB.getRo().add(Rom);
        }
    }

    public static void LocHang(){
        KhoMayTinhBang KMTB = new KhoMayTinhBang();
        String L;
        if (KMTB.getH().size() >= 0) {
            KMTB.getLuu(null);
            for (int i = 0; i < KMTB.getH().size(); i++) {
                L = KMTB.getH().get(i);
                KMTB.getLuu("'"+ L +"'");
                if(i != KMTB.getH().size() - 1){
                    KMTB.getLuu(",");
                }else {
                    KMTB.getTam().add(" [Hang] IN (" + Luu + ")");
                } 
            }
        }
    }

    public static void LocCpu(){
        KhoMayTinhBang KMTB = new KhoMayTinhBang();
        String L;
        if (KMTB.getC().size() >= 0) {
            KMTB.getLuu(null);
            for (int i = 0; i < KMTB.getC().size(); i++) {
                L = KMTB.getC().get(i);
                KMTB.getLuu("'"+ L +"'");
                if(i != KMTB.getC().size() - 1){
                    KMTB.getLuu(",");
                }else {
                    KMTB.getTam().add(" [CPU] IN (" + Luu + ")");
                } 
            }
        }
    }

    public static void LocRam(){
        KhoMayTinhBang KMTB = new KhoMayTinhBang();
        String L;
        if (KMTB.getRa().size() >= 0) {
            KMTB.getLuu(null);
            for (int i = 0; i < KMTB.getRa().size(); i++) {
                L = KMTB.getRa().get(i);
                KMTB.getLuu("'"+ L +"'");
                if(i != KMTB.getRa().size() - 1){
                    KMTB.getLuu(",");
                }else {
                    KMTB.getTam().add(" [Ram] IN (" + Luu + ")");
                } 
            }
        }
    }

    public static void LocRom(){
        KhoMayTinhBang KMTB = new KhoMayTinhBang();
        String L;
        if (KMTB.getRo().size() >= 0) {
            KMTB.getLuu(null);
            for (int i = 0; i < KMTB.getRo().size(); i++) {
                L = KMTB.getRo().get(i);
                KMTB.getLuu("'"+ L +"'");
                if(i != KMTB.getRo().size() - 1){
                    KMTB.getLuu(",");
                }else {
                    KMTB.getTam().add(" [Rom] IN (" + Luu + ")");
                } 
            }
        }
    }

    public void TienThanhLoc(String MaSql) {
        KhoMayTinhBang KMTB = new KhoMayTinhBang();
        LocHang();
        LocCpu();
        LocRam();
        LocRom();
        MayTinhBang.Loc(MaSql, Tam);
        KMTB.getTam().clear();
    }
}
