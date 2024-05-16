/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.daoimpl;

import application.dao.ServiceDao;
import application.models.ServiceModel;
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
public class ServiceDaoImpl implements ServiceDao {
    private Connection dbConnection = null;
    private PreparedStatement pstmt = null;
    private ResultSet resultSet = null;
    private String query;
    
    public ServiceDaoImpl() {
        dbConnection = DatabaseUtil.getInstance().getConnection();
    }

    @Override
    public List<ServiceModel> findAll() {
        List<ServiceModel> services = new ArrayList<>();
        
        try {
            query = "SELECT * FROM service";
            pstmt = dbConnection.prepareStatement(query);
            resultSet = pstmt.executeQuery();
            
            while (resultSet.next()) {
                ServiceModel service = new ServiceModel();
                service.setKode(resultSet.getString("kode_service"));
                service.setName(resultSet.getString("name_service"));
                service.setDesc(resultSet.getString("description_service"));
                service.setPrice(resultSet.getInt("price"));
                // Set other attributes accordingly
                services.add(service);
            }
	} catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeStatement();
        }
        
        return services;
    }

    @Override
    public int create(ServiceModel service) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int upsert(ServiceModel service) {
        try {
            query = "INSERT INTO service(kode_service, name_service, description_service, price) " +
                    "VALUES(?, ?, ?, ?)" +
                    "ON DUPLICATE KEY UPDATE kode_service=VALUES(kode_service), name_service=VALUES(name_service)," +
                    "description_service=VALUES(description_service), price=VALUES(price)";
            
            pstmt = dbConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, service.getKode());
            pstmt.setString(2, service.getName());
            pstmt.setString(3, service.getDesc());
            pstmt.setInt(4, service.getPrice());
            
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
    public int update(ServiceModel service) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(ServiceModel service) {
        try {
            query = "DELETE FROM service WHERE kode_service = ?";

            pstmt = dbConnection.prepareStatement(query);
            pstmt.setString(1, service.getKode());

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
