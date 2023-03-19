import java.beans.JavaBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

public class Data extends KhoLapTop{

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
            case 8 : System.out.print("So Luong: ");break;
            case 9 : System.out.print("Ngay Nhap: ");break;
            case 10 : System.out.print("So Luong Nhap: ");break;
            case 11 : System.out.print("Ngay Ban: ");break;
            case 12 : System.out.print("So Luong Ban: ");break;
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
            Logger.getLogger(JavaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void ThemHang(String MaSql, int STT, String MASP, String TEN, String CPU, int DDR4, String VGA, int SSD, int SOLUONG, int NGAYNHAP, int THANGNHAP, int NAMNHAP, int SOLUONGNHAP, int NGAYBAN, int THANGBAN, int NAMBAN, int SOLUONGBAN){
        Scanner s = new Scanner(System.in);
        Data Dt = new Data();
        try(Connection conn = DriverManager.getConnection(Dt.URL());Statement stat = conn.createStatement() ){
            String Them = " INSERT INTO " + MaSql + " VALUES(" + STT + ", N'" + MASP + "', N'"+ TEN + "', N'" + CPU + "', N'" + DDR4 + "gb', N'"+ VGA + "', N'"+ SSD + "gb', "+ SOLUONG + ",convert(datetime,'" + NGAYNHAP + "-" + THANGNHAP + "-" + NAMNHAP + "',103), " + SOLUONGNHAP + ", convert(datetime,'" + NGAYBAN + "-" + THANGBAN + "-" + NAMBAN + "',103), " + SOLUONGBAN +" )";
            stat.executeUpdate(Them);
            System.out.println("\nThem Thanh Cong!\n");
            KhoLapTop.KhoCon(MaSql);
        } catch (SQLException ex) {
            System.out.println("Them Khong Thanh Cong!\nThem Lai? (Y Hoac N): ");
            String YorN = s.nextLine();
            if(YorN.equals("Y") || YorN.equals("Y")){
                KhoLapTop.ThemSanPham(MaSql);
            }else{
                Menu();
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
                Menu();
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
                Menu();
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
                    System.out.print(resultSet.getString(i) + "     ");;
                }
            }
            } catch (SQLException ex) {
            System.out.println("Tim Khong Thanh Cong!");
            }
        }
    }
}
