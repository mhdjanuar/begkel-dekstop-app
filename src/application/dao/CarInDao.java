/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package application.dao;

import application.models.CarInModel;
import java.util.List;

/**
 *
 * @author mhdja
 */
public interface CarInDao {
    public List<CarInModel> findAll();
    
    public int create(CarInModel carIn);
    
    public int upsert(CarInModel carIn);
    
    public int update(CarInModel carIn);
    
    public void delete(CarInModel carIn);
}
