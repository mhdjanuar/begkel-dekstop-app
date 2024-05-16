/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package application.dao;

import application.models.KaryawanModel;
import java.util.List;

/**
 *
 * @author mhdja
 */
public interface KaryawanDao {
    public List<KaryawanModel> findAll();
    
    public int create(KaryawanModel karyawan);
    
    public int upsert(KaryawanModel karyawan);
    
    public int update(KaryawanModel karyawan);
    
    public void delete(KaryawanModel karyawan);
}
