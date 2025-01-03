/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package application.dao;

import application.models.ListWorkingModel;
import java.util.List;

/**
 *
 * @author mhdja
 */
public interface TransactionDao {
     public List<ListWorkingModel> findAll();
    
    public int createTransactionService(ListWorkingModel transaction);
    
    public int createTransactionSparepart(ListWorkingModel transaction);
    
    public int createTransaction(ListWorkingModel transaction);
    
    public int upsert(ListWorkingModel transaction);
    
    public int update(ListWorkingModel transaction);
    
    public void delete(ListWorkingModel transaction);
}
