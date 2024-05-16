/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.daoimpl;

import application.models.SparepartModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import application.dao.SparepartDao;
import application.utils.DatabaseUtil;
import java.util.ArrayList;
/**
 *
 * @author mhdja
 */
public class SparepartDaoImpl implements SparepartDao {
    private Connection dbConnection = null;
    private PreparedStatement pstmt = null;
    private ResultSet resultSet = null;
    private String query;
    
    public SparepartDaoImpl () {
        dbConnection = DatabaseUtil.getInstance().getConnection();
    }

    @Override
    public List<SparepartModel> findAll() {
        List<SparepartModel> spareparts = new ArrayList<>();
        
        try {
            query = "SELECT * FROM sparepart";
            pstmt = dbConnection.prepareStatement(query);
            resultSet = pstmt.executeQuery();
            
            while (resultSet.next()) {
                SparepartModel sparepart = new SparepartModel();
                sparepart.setKode(resultSet.getString("kode_sparepart"));
                sparepart.setName(resultSet.getString("nama_sparepart"));
                sparepart.setPrice(resultSet.getInt("price"));
                sparepart.setStock(resultSet.getInt("stock"));
                // Set other attributes accordingly
                spareparts.add(sparepart);
            }
	} catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeStatement();
        }
        
        return spareparts;
    }

    @Override
    public int create(SparepartModel sparepart) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int upsert(SparepartModel sparepart) {
        try {
            query = "INSERT INTO sparepart(kode_sparepart, nama_sparepart, price, stock) " +
                    "VALUES(?, ?, ?, ?)" +
                    "ON DUPLICATE KEY UPDATE kode_sparepart=VALUES(kode_sparepart), nama_sparepart=VALUES(nama_sparepart)," +
                    "price=VALUES(price), stock=VALUES(stock)";
            
            pstmt = dbConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, sparepart.getKode());
            pstmt.setString(2, sparepart.getName());
            pstmt.setInt(3, sparepart.getPrice());
            pstmt.setInt(4, sparepart.getStock());
            
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
    public int update(SparepartModel sparepart) {
        try {
            query = "UPDATE sparepart" +
                    "SET nama_sparepart = ?, price = ?, stock ?" + 
                    "WHERE kode_sparepart = ?";
            
            pstmt = dbConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, sparepart.getName());
            pstmt.setInt(2, sparepart.getPrice());
            pstmt.setInt(3, sparepart.getStock());
            pstmt.setString(4, sparepart.getKode());
            
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
    public void delete(SparepartModel sparepart) {
        try {
            query = "DELETE FROM sparepart WHERE kode_sparepart = ?";

            pstmt = dbConnection.prepareStatement(query);
            pstmt.setString(1, sparepart.getKode());

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

    @Override
    public int updateStock(SparepartModel sparepart) {
        try {
            query = "UPDATE sparepart " +
                    "SET stock = stock - ? " + 
                    "WHERE kode_sparepart = ?";
            
            pstmt = dbConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, sparepart.getStock());
            pstmt.setString(2, sparepart.getKode());
            
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
    
}
