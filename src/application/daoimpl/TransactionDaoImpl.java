/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.daoimpl;

import application.dao.TransactionDao;
import application.models.ListWorkingModel;
import application.utils.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author mhdja
 */
public class TransactionDaoImpl implements TransactionDao {
    private Connection dbConnection = null;
    private PreparedStatement pstmt = null;
    private ResultSet resultSet = null;
    private String query;
    
    public TransactionDaoImpl () {
        dbConnection = DatabaseUtil.getInstance().getConnection();
    }

    @Override
    public List<ListWorkingModel> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int createTransactionService(ListWorkingModel transaction) {
        System.out.print(transaction.getWorkingEstimate());
        
        try {
            query = "INSERT INTO working_transaction_service(kode_transaction, kode_service) " +
                    "VALUES(?, ?)";
            
            pstmt = dbConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, transaction.getKodeTransaction());
            pstmt.setString(2, transaction.getKodeService());
            
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
    public int createTransactionSparepart(ListWorkingModel transaction) {
        try {
            query = "INSERT INTO working_transaction_sparepart(kode_transaction, kode_sparepart) " +
                    "VALUES(?, ?)";
            
            pstmt = dbConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, transaction.getKodeTransaction());
            pstmt.setString(2, transaction.getKodeSparepart());
            
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
    public int upsert(ListWorkingModel transaction) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(ListWorkingModel transaction) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(ListWorkingModel transaction) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    public int createTransaction(ListWorkingModel transaction) {
        try {
            query = "INSERT INTO working_transaction(kode_transaction, working_estimate, price_total, kode_car) " +
                    "VALUES(?, ?, ?, ?)";
            
            pstmt = dbConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, transaction.getKodeTransaction());
            pstmt.setInt(2, transaction.getWorkingEstimate());
            pstmt.setInt(3, transaction.getPriceTotal());
            pstmt.setString(4, transaction.getKodeCar());
            
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
