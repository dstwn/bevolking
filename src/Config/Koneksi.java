/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author macbookpro
 */
public class Koneksi {
    private static Connection mysqlconfig;
    public static Connection configDB()throws SQLException{
        if(mysqlconfig == null) {
             try {
                String url="jdbc:mysql://localhost:3306/basis_data_penduduk?useTimezone=true&serverTimezone=UTC"; //url database
                String user="root"; //user database
                String pass="-3Llysa8"; //password database
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                mysqlconfig=DriverManager.getConnection(url, user, pass);            
            } catch (Exception e) {
                System.err.println("koneksi gagal "+e.getMessage()); //perintah menampilkan error pada koneksi
            }
        }
        return mysqlconfig;
    }    
}
