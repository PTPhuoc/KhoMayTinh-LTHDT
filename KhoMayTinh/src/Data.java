
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Scanner;

public class Data{

    public String URL(){
        return "jdbc:sqlserver://localhost:1433;"
        + "databaseName=khomaytinh;"
        + "user=sa;"
        + "password=012345;"
        + "encrypt=true;"
        + "trustServerCertificate=true;"
        + "loginTimeout=30;";
    }

    public static void Tieude(int T){
        switch(T){
            case 1 : System.out.print("STT: ");break;
            case 2 : System.out.print("Ma: ");break;
            case 3 : System.out.print("Ten: ");break;
            case 4 : System.out.print("Chip: ");break;
            case 5 : System.out.print("DDR4: ");break;
            case 6 : System.out.print("VGA: ");break;
            case 7 : System.out.print("SSD: ");break;
            case 8 : System.out.print("So Luong Con Lai: ");break;
            case 9 : System.out.print("Ngay Nhap: ");break;
            case 10 : System.out.print("So Luong Nhap: ");break;
            case 11 : System.out.print("Ngay Ban: ");break;
            case 12 : System.out.print("So Luong Ban: ");break;
        }
    }

    public static void TieuDePK(int T){
        switch(T){
            case 1 : System.out.print("Ma: ");break;
            case 2 : System.out.print("Ten: ");break;
            case 3 : System.out.print("Nha San Xuat: ");break;
            case 4 : System.out.print("So Luong Nhap: ");break;
            case 5 : System.out.print("Ngay Nhap: ");break;
            case 6 : System.out.print("So Luong Ban: ");break;
            case 7 : System.out.print("Ngay Ban: ");break;
            case 8 : System.out.print("So Luong Con Lai: ");break;
        }
    }

    public static void TieuDeMTB(int T){
        switch(T){
            case 1 : System.out.print("Ma: ");break;
            case 2 : System.out.print("Ten: ");break;
            case 3 : System.out.print("Hang: ");break;
            case 4 : System.out.print("Mang Hinh: ");break;
            case 5 : System.out.print("CPU: ");break;
            case 6 : System.out.print("RAM: ");break;
            case 7 : System.out.print("ROM: ");break;
            case 8 : System.out.print("So Luong Nhap: ");break;
            case 9 : System.out.print("Thoi Gian Nhap: ");break;
            case 10 : System.out.print("So Luon Xuat: ");break;
            case 11 : System.out.print("Thoi Gian Xuat: ");break;
            case 12 : System.out.print("So Luong Con Loai: ");break;
        }
    }

    public static void XuatData(String MaSql,int n, int m){
        Data Dt = new Data();
        ResultSet resultSet = null;
        try(Connection conn = DriverManager.getConnection(Dt.URL());Statement stat = conn.createStatement() ){
            resultSet = stat.executeQuery(MaSql);
            while (resultSet.next()) {
                System.out.print("\n");
                Tieude(1);
                System.out.print(resultSet.getString(1) + "      ");
                Tieude(2);
                System.out.print(resultSet.getString(2) + "      ");
                for(int i = m; i <= n ; i++){  
                    Tieude(i); 
                    System.out.print(resultSet.getString(i) + "      ");
                    if(i == n){
                        System.out.print("\n");
                    }
                }
            }

        } catch (SQLException ex) {
            System.out.println("Khong co du lieu!");
        }
    }

    public static void ThemHang(String MaSql, int STT,
                                String MASP, String TEN,
                                String CPU, String DDR4,
                                String VGA, String SSD,
                                int SOLUONG, int NGAYNHAP,
                                int THANGNHAP, int NAMNHAP,
                                int SOLUONGNHAP, int NGAYBAN,
                                int THANGBAN, int NAMBAN, int SOLUONGBAN){
        Scanner s = new Scanner(System.in);
        Data Dt = new Data();
        try(Connection conn = DriverManager.getConnection(Dt.URL());Statement stat = conn.createStatement() ){
            String Them = " INSERT INTO " + MaSql + " VALUES(" + STT 
            + ", N'" + MASP 
            + "', N'"+ TEN 
            + "', N'" + CPU 
            + "', N'" + DDR4 
            + "', N'"+ VGA 
            + "', N'"+ SSD 
            + "', "+ SOLUONG 
            + ",convert(datetime,'" + NGAYNHAP + "-" + THANGNHAP + "-" + NAMNHAP + "',103), " 
            + SOLUONGNHAP 
            + ", convert(datetime,'" + NGAYBAN + "-" + THANGBAN + "-" + NAMBAN + "',103), " 
            + SOLUONGBAN +" )";
            stat.executeUpdate(Them);
            System.out.println("\nThem Thanh Cong!\n");
            KhoLapTop.KhoCon(MaSql);
        } catch (SQLException ex) {
            System.out.println("Them Khong Thanh Cong!\nThem Lai? (Y Hoac N): ");
            String YorN = s.nextLine();
            if(YorN.equals("Y") || YorN.equals("Y")){
                KhoLapTop.ThemSanPham(MaSql);
            }else{
                KhoLapTop.Menu();
            }
        }
    }

    public static void XoaHangTheoMa(String MaSql, String MaSP){
        Scanner s = new Scanner(System.in);
        Data Dt = new Data();
        try(Connection conn = DriverManager.getConnection(Dt.URL());Statement stat = conn.createStatement() ){
            String Xoa = " DELETE FROM "+ MaSql + " WHERE [MA-SP] = '"+ MaSP + "'";
            stat.executeUpdate(Xoa);
            System.out.println("\nXoa Thanh Cong!\n");
            KhoLapTop.KhoCon(MaSql);
        } catch (SQLException ex) {
            System.out.println("Xoa Khong Thanh Cong!\nXoa Lai? (Y Hoac N): ");
            String YorN = s.nextLine();
            if(YorN.equals("Y") || YorN.equals("Y")){
                KhoLapTop.XoaSanPham(MaSql);
            }else{
                KhoLapTop.Menu();
            }
        }
    }

    public static void XoaHangTheoTenSp(String MaSql, String Ten){
        Scanner s = new Scanner(System.in);
        Data Dt = new Data();
        try(Connection conn = DriverManager.getConnection(Dt.URL());Statement stat = conn.createStatement() ){
            String Xoa = " DELETE FROM "+ MaSql+ " WHERE [TEN] = '"+ Ten + "'";
            stat.executeUpdate(Xoa);
            System.out.println("\nXoa Thanh Cong!\n");
            KhoLapTop.KhoCon(MaSql);
        } catch (SQLException ex) {
            System.out.println("Xoa Khong Thanh Cong!\nXoa Lai? (Y Hoac N): ");
            String YorN = s.nextLine();
            if(YorN.equals("Y") || YorN.equals("Y")){
                KhoLapTop.XoaSanPham(MaSql);
            }else{
                KhoLapTop.Menu();
            }
        }
    }

    public static void TimKiem(String MaSql,int n, int m, String Ten,String MaSP){
        Data Dt = new Data();
        ResultSet resultSet = null;
        if(Ten != null){
            try(Connection conn = DriverManager.getConnection(Dt.URL());Statement stat = conn.createStatement() ){
            resultSet = stat.executeQuery("SELECT * FROM " + MaSql + " WHERE [TEN] = '" + Ten + "'");
            while(resultSet.next()){
                for(int i = m; i <= n; i++){
                    Tieude(i);
                    System.out.print(resultSet.getString(i) + "     ");
                }
            }
            } catch (SQLException ex) {
                System.out.println("Tim Khong Thanh Cong!");
            }
        }else{
            try(Connection conn = DriverManager.getConnection(Dt.URL());Statement stat = conn.createStatement() ){
            resultSet = stat.executeQuery("SELECT * FROM " + MaSql + " WHERE [MA-SP] = '" + MaSP + "'");
            while(resultSet.next()){
                for(int i = m; i <= n; i++){
                    Tieude(i);
                    System.out.print(resultSet.getString(i) + "     ");
                }
            }
            } catch (SQLException ex) {
                System.out.println("Tim Khong Thanh Cong!");
            }
        }
    }

    public static void CapNhat(String MaSql,String Ten, String MaSP, String Cot, String ThayDoi, int Ngay, int Thang, int Nam){
        Data Dt = new Data();
        if(Ten != null){
            if(Cot == "STT" || Cot == "SO-LUONG" || Cot == "SOLUONG-NHAP" || Cot == "SOLUONGBANTRONG-NGAY"){
                try(Connection conn = DriverManager.getConnection(Dt.URL());Statement stat = conn.createStatement() ){
                stat.executeUpdate("UPDATE " + MaSql + " SET [" + Cot + "] = " + ThayDoi + " WHERE [TEN] = '" + Ten + "';");
                System.out.println("\nCap Nhat Thanh Cong!\n");
                TimKiem(MaSql, 12, 1, Ten, null);
                } catch (SQLException ex) {
                    System.out.println("Cap Nhat Khong Thanh Cong!");
                }
            }else if(Ngay != 0 || Thang != 0 || Nam != 0){
                try(Connection conn = DriverManager.getConnection(Dt.URL());Statement stat = conn.createStatement() ){
                stat.executeUpdate("UPDATE " + MaSql + " SET [" + Cot + "] = convert(datetime,'" + Ngay + "-" + Thang + "-" + Nam + "',103) WHERE [TEN] = '" + Ten + "';");
                System.out.println("\nCap Nhat Thanh Cong!\n");
                TimKiem(MaSql, 12, 1, Ten, null);
                } catch (SQLException ex) {
                    System.out.println("Cap Nhat Khong Thanh Cong!");
                }
            }else{
                try(Connection conn = DriverManager.getConnection(Dt.URL());Statement stat = conn.createStatement() ){
                stat.executeUpdate("UPDATE " + MaSql + " SET [" + Cot + "] = '" + ThayDoi + "' WHERE [TEN] = '" + Ten + "';");
                System.out.println("\nCap Nhat Thanh Cong!\n");
                TimKiem(MaSql, 12, 1, Ten, null);
                } catch (SQLException ex) {
                    System.out.println("Cap Nhat Khong Thanh Cong!");
                }
            }
            
        }else{
            if(Cot == "STT" || Cot == "SO-LUONG" || Cot == "SOLUONG-NHAP" || Cot == "SOLUONGBANTRONG-NGAY"){
                try(Connection conn = DriverManager.getConnection(Dt.URL());Statement stat = conn.createStatement() ){
                stat.executeUpdate("UPDATE " + MaSql + " SET [" + Cot + "] = " + ThayDoi + " WHERE [MA-SP] = '" + MaSP + "';");
                System.out.println("\nCap Nhat Thanh Cong!\n");
                TimKiem(MaSql, 12, 1, Ten, null);
                } catch (SQLException ex) {
                    System.out.println("Cap Nhat Khong Thanh Cong!");
                }
            }else if(Ngay != 0 || Thang != 0 || Nam != 0){
                try(Connection conn = DriverManager.getConnection(Dt.URL());Statement stat = conn.createStatement() ){
                stat.executeUpdate("UPDATE " + MaSql + " SET [" + Cot + "] = convert(datetime,'" + Ngay + "-" + Thang + "-" + Nam + "',103) WHERE [MA-SP] = '" + MaSP + "';");
                System.out.println("\nCap Nhat Thanh Cong!\n");
                TimKiem(MaSql, 12, 1, Ten, null);
                } catch (SQLException ex) {
                    System.out.println("Cap Nhat Khong Thanh Cong!");
                }
            }else{
                try(Connection conn = DriverManager.getConnection(Dt.URL());Statement stat = conn.createStatement() ){
                stat.executeUpdate("UPDATE " + MaSql + " SET [" + Cot + "] = '" + ThayDoi + "' WHERE [MA-SP] = '" + MaSP + "';");
                System.out.println("\nCap Nhat Thanh Cong!\n");
                TimKiem(MaSql, 12, 1, Ten, null);
                } catch (SQLException ex) {
                    System.out.println("Cap Nhat Khong Thanh Cong!");
                }
            }
        }
    }

    public static void XemPhuKienPC(String MaSql, int n, int m){
        Data Dt = new Data();
        ResultSet resultSet = null;
        try(Connection conn = DriverManager.getConnection(Dt.URL());Statement stat = conn.createStatement() ){
            resultSet = stat.executeQuery(MaSql);
            while (resultSet.next()) {
                for(int i = m; i <= n ; i++){  
                    if(i == n){
                        TieuDePK(i);
                        System.out.print(resultSet.getInt(4) - resultSet.getInt(6) + "\n\n");
                    }else{
                        TieuDePK(i); 
                        System.out.print(resultSet.getString(i) + "      ");
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Khong co du lieu!");
        }
    }

    public static void ThemPhuKienPC(String MaSql, String MAPK, String TEN, String NSX, int SOLUONGNHAP, int NGAYNHAP, int THANGNHAP, int NAMNHAP, int SOLUONGXUAT, int NGAYXUAT,int THANGXUAT, int NAMXUAT){
        Scanner s = new Scanner(System.in);
        Data Dt = new Data();
        try(Connection conn = DriverManager.getConnection(Dt.URL());Statement stat = conn.createStatement() ){
            String Them = " INSERT INTO " + MaSql + " VALUES(N'" 
            + MAPK 
            + "', N'" + TEN 
            + "', N'"+ NSX 
            + "'," + SOLUONGNHAP 
            + ",convert(datetime,'" + NGAYNHAP + "-" + THANGNHAP + "-" + NAMNHAP + "',103), " 
            + SOLUONGXUAT 
            + ", convert(datetime,'" + NGAYXUAT + "-" + THANGXUAT + "-" + NAMXUAT + "',103));";
            stat.executeUpdate(Them);
            System.out.println("\nThem Thanh Cong!\n");
            PhuKien.KhoConPK(MaSql);
        } catch (SQLException ex) {
            System.out.println("Them Khong Thanh Cong!\nThem Lai? (Y Hoac N): ");
            String YorN = s.nextLine();
            if(YorN.equals("Y") || YorN.equals("Y")){
                PhuKien.ThemPhuKien(MaSql);
            }else{
                PhuKien.Menu();
            }
        }
    }

    public static void XoaPhuKienPC(String MaSql,String MaPK, String Ten){
        Scanner s = new Scanner(System.in);
        Data Dt = new Data();
        if(MaPK == null){
            try(Connection conn = DriverManager.getConnection(Dt.URL());Statement stat = conn.createStatement() ){
            String Xoa = " DELETE FROM "+ MaSql+ " WHERE [Ten] = '"+ Ten + "'";
            stat.executeUpdate(Xoa);
            System.out.println("\nXoa Thanh Cong!\n");
            PhuKien.KhoConPK(MaSql);
        } catch (SQLException ex) {
            System.out.println("Xoa Khong Thanh Cong!\nXoa Lai? (Y Hoac N): ");
            String YorN = s.nextLine();
            if(YorN.equals("Y") || YorN.equals("Y")){
                PhuKien.XoaPhuKien(MaSql);
            }else{
                PhuKien.Menu();
            }
        }
        }else{
            try(Connection conn = DriverManager.getConnection(Dt.URL());Statement stat = conn.createStatement() ){
                String Xoa = " DELETE FROM "+ MaSql+ " WHERE [Ma] = '"+ MaPK + "'";
                stat.executeUpdate(Xoa);
                System.out.println("\nXoa Thanh Cong!\n");
                PhuKien.KhoConPK(MaSql);
            } catch (SQLException ex) {
                System.out.println("Xoa Khong Thanh Cong!\nXoa Lai? (Y Hoac N): ");
                String YorN = s.nextLine();
                if(YorN.equals("Y") || YorN.equals("Y")){
                    PhuKien.XoaPhuKien(MaSql);
                }else{
                    PhuKien.Menu();
                }
            }
        } 
    }

    public static void TimKiemPhuKienPC(String MaSql, String MaPK, String Ten){
        Data Dt = new Data();
        ResultSet resultSet = null;
        if(Ten != null){
            try(Connection conn = DriverManager.getConnection(Dt.URL());Statement stat = conn.createStatement() ){
            resultSet = stat.executeQuery("SELECT * FROM " + MaSql + " WHERE [Ten] = '" + Ten + "'");
            while(resultSet.next()){
                for(int i = 1; i <= 8 ; i++){  
                    if(i == 8){
                        TieuDePK(i);
                        System.out.print(resultSet.getInt(4) - resultSet.getInt(6) + "\n\n");
                    }else{
                        TieuDePK(i); 
                        System.out.print(resultSet.getString(i) + "      ");
                    }
                }
            }
            } catch (SQLException ex) {
                System.out.println("Tim Khong Thanh Cong!");
            }
        }else{
            try(Connection conn = DriverManager.getConnection(Dt.URL());Statement stat = conn.createStatement() ){
            resultSet = stat.executeQuery("SELECT * FROM " + MaSql + " WHERE [Ma] = '" + MaPK + "'");
            while(resultSet.next()){
                for(int i = 1; i <= 8 ; i++){  
                    if(i == 8){
                        TieuDePK(i);
                        System.out.print(resultSet.getInt(4) - resultSet.getInt(6) + "\n\n");
                    }else{
                        TieuDePK(i); 
                        System.out.print(resultSet.getString(i) + "      ");
                    }
                }
            }
            } catch (SQLException ex) {
                System.out.println("Tim Khong Thanh Cong!");
            }
        }
    }

    public static void CapNhatPhuKienPC(String MaSql,String MaPK, String Ten, String Cot, String ThayDoi,int Ngay,int Thang,int Nam){
        Data Dt = new Data();
        if(Ngay != 0 || Thang != 0 || Nam != 0){
            try(Connection conn = DriverManager.getConnection(Dt.URL());Statement stat = conn.createStatement() ){
            stat.executeUpdate("UPDATE " + MaSql + " SET [" + Cot + "] = convert(datetime,'" + Ngay + "-" + Thang + "-" + Nam + "',103) WHERE [TEN] = '" + Ten + "';");
            System.out.println("\nCap Nhat Thanh Cong!\n");
            TimKiemPhuKienPC(MaSql, MaPK, Ten);
            } catch (SQLException ex) {
                System.out.println("Cap Nhat Khong Thanh Cong!");
            }
        }else if(MaPK != null){
            try(Connection conn = DriverManager.getConnection(Dt.URL());Statement stat = conn.createStatement() ){
            stat.executeUpdate("UPDATE " + MaSql + " SET [" + Cot + "] = '" + ThayDoi + "' WHERE [Ma] = '" + MaPK + "';");
            System.out.println("\nCap Nhat Thanh Cong!\n");
            TimKiemPhuKienPC(MaSql, MaPK, Ten);
            } catch (SQLException ex) {
                System.out.println("Cap Nhat Khong Thanh Cong!");
            }
        }else{
            try(Connection conn = DriverManager.getConnection(Dt.URL());Statement stat = conn.createStatement() ){
            stat.executeUpdate("UPDATE " + MaSql + " SET [" + Cot + "] = '" + ThayDoi + "' WHERE [Ten] = '" + Ten + "';");
            System.out.println("\nCap Nhat Thanh Cong!\n");
            TimKiemPhuKienPC(MaSql, MaPK, Ten);
            } catch (SQLException ex) {
                System.out.println("Cap Nhat Khong Thanh Cong!");
            }
        }
    }

    public static void XemKhoMTB(String MaSql,int n, int m){
        Data Dt = new Data();
        ResultSet resultSet = null;
        try(Connection conn = DriverManager.getConnection(Dt.URL());Statement stat = conn.createStatement() ){
            resultSet = stat.executeQuery(MaSql);
            while (resultSet.next()) {
                for(int i = m; i <= n ; i++){  
                    if(i == n){
                        TieuDeMTB(i);
                        System.out.print(resultSet.getInt(8) - resultSet.getInt(10) + "\n\n");
                    }else{
                        TieuDeMTB(i); 
                        System.out.print(resultSet.getString(i) + "      ");
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Khong co du lieu!");
        }
    }
}
