/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.daoimpl;

import application.dao.CarInDao;
import application.models.CarInModel;
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
public class CarInDaoImpl implements CarInDao {
    private Connection dbConnection = null;
    private PreparedStatement pstmt = null;
    private ResultSet resultSet = null;
    private String query;
    
    public CarInDaoImpl() {
        dbConnection = DatabaseUtil.getInstance().getConnection();
    }

    @Override
    public List<CarInModel> findAll() {
        List<CarInModel> carInList = new ArrayList<>();
        
        try {
            query = "SELECT * FROM car_in";
            pstmt = dbConnection.prepareStatement(query);
            resultSet = pstmt.executeQuery();
            
            while (resultSet.next()) {
                CarInModel carIn = new CarInModel();
                carIn.setKode(resultSet.getString("kode"));
                carIn.setCustomerName(resultSet.getString("customer_name"));
                carIn.setPlatNo(resultSet.getString("plat_no"));
                carIn.setDateIn(resultSet.getString("date_in"));
                carIn.setCarType(resultSet.getString("car_type"));
                carIn.setTelphoneNo(resultSet.getString("telephone_no"));
                // Set other attributes accordingly
                carInList.add(carIn);
            }
	} catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeStatement();
        }
        
        return carInList;
    }

    @Override
    public int create(CarInModel carIn) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int upsert(CarInModel carIn) {
        try {
            query = "INSERT INTO car_in(kode, customer_name, plat_no, car_type, telephone_no) " +
                    "VALUES(?, ?, ?, ?, ?)" +
                    "ON DUPLICATE KEY UPDATE kode=VALUES(kode), customer_name=VALUES(customer_name), plat_no=VALUES(plat_no)," +
                    "car_type=VALUES(car_type), telephone_no=VALUES(telephone_no)";
            
            pstmt = dbConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, carIn.getKode());
            pstmt.setString(2, carIn.getCustomerName());
            pstmt.setString(3, carIn.getPlatNo());
            pstmt.setString(4, carIn.getCarType());
            pstmt.setString(5, carIn.getTelphoneNo());
            
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
    public int update(CarInModel carIn) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(CarInModel carIn) {
        try {
            query = "DELETE FROM car_in WHERE kode = ?";

            pstmt = dbConnection.prepareStatement(query);
            pstmt.setString(1, carIn.getKode());

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
