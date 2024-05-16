/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package application.dao;

import application.models.ServiceModel;
import java.util.List;

/**
 *
 * @author mhdja
 */
public interface ServiceDao {
    public List<ServiceModel> findAll();
    
    public int create(ServiceModel service);
    
    public int upsert(ServiceModel service);
    
    public int update(ServiceModel service);
    
    public void delete(ServiceModel service);
}
