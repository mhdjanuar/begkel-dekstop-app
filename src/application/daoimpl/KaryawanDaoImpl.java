/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.daoimpl;

import application.dao.KaryawanDao;
import application.models.KaryawanModel;
import application.utils.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mhdja
 */
public class KaryawanDaoImpl implements KaryawanDao {
    private Connection dbConnection = null;
    private PreparedStatement pstmt = null;
    private ResultSet resultSet = null;
    private String query;
    
    public KaryawanDaoImpl() {
        dbConnection = DatabaseUtil.getInstance().getConnection();
    }

    @Override
    public List<KaryawanModel> findAll() {
        List<KaryawanModel> karyawanList = new ArrayList<>();
        
        try {
            query = "SELECT * FROM karyawan";
            pstmt = dbConnection.prepareStatement(query);
            resultSet = pstmt.executeQuery();
            
            while (resultSet.next()) {
                KaryawanModel karyawan = new KaryawanModel();
                karyawan.setKode(resultSet.getString("kode_karyawan"));
                karyawan.setName(resultSet.getString("name"));
                karyawan.setJabatan(resultSet.getString("jabatan"));
                karyawan.setAddress(resultSet.getString("address"));
                karyawan.setGaji(resultSet.getInt("gaji"));
                // Set other attributes accordingly
                karyawanList.add(karyawan);
            }
	} catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeStatement();
        }
        
        return karyawanList;
    }

    @Override
    public int create(KaryawanModel karyawan) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int upsert(KaryawanModel karyawan) {
        try {
            query = "INSERT INTO karyawan(kode_karyawan, name, jabatan, address, gaji) " +
                    "VALUES(?, ?, ?, ?, ?)" +
                    "ON DUPLICATE KEY UPDATE kode_karyawan=VALUES(kode_karyawan), name=VALUES(name)," +
                    "jabatan=VALUES(jabatan), address=VALUES(address), gaji=VALUES(gaji)";
            
            pstmt = dbConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, karyawan.getKode());
            pstmt.setString(2, karyawan.getName());
            pstmt.setString(3, karyawan.getJabatan());
            pstmt.setString(4, karyawan.getAddress());
            pstmt.setInt(5, karyawan.getGaji());
            
            int result = pstmt.executeUpdate();
            resultSet = pstmt.getGeneratedKeys();
            return result;
	} catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeStatement();
        }
    }

    @Override
    public int update(KaryawanModel karyawan) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(KaryawanModel karyawan) {
        try {
            query = "DELETE FROM karyawan WHERE kode_karyawan = ?";

            pstmt = dbConnection.prepareStatement(query);
            pstmt.setString(1, karyawan.getKode());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeStatement();
        }
    }
    
    private void closeStatement() {
        try {
            if(pstmt != null){
                pstmt.close();
                pstmt = null;
            }
            if(resultSet != null){
                resultSet.close();
                resultSet = null;
            }   
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
