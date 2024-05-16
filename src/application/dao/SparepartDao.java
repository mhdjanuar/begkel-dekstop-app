/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package application.dao;

import application.models.SparepartModel;
import java.util.List;

/**
 *
 * @author mhdja
 */
public interface SparepartDao {
    public List<SparepartModel> findAll();
    
    public int create(SparepartModel sparepart);
    
    public int upsert(SparepartModel sparepart);
    
    public int update(SparepartModel sparepart);
    
    public int updateStock(SparepartModel sparepart);
    
    public void delete(SparepartModel sparepart);
}
