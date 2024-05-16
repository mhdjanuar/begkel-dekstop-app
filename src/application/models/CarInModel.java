/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.models;

/**
 *
 * @author mhdja
 */
public class CarInModel {

    /**
     * @return the kode
     */
    private int id;
    private String kode;
    private String customerName;
    private String platNo;
    private String dateIn;
    private String carType;
    private String telphoneNo;
    /**
     * @return the id
     */
    
    public String getKode() {
        return kode;
    }

    /**
     * @param kode the kode to set
     */
    public void setKode(String kode) {
        this.kode = kode;
    }
    
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the platNo
     */
    public String getPlatNo() {
        return platNo;
    }

    /**
     * @param platNo the platNo to set
     */
    public void setPlatNo(String platNo) {
        this.platNo = platNo;
    }

    /**
     * @return the dateIn
     */
    public String getDateIn() {
        return dateIn;
    }

    /**
     * @param dateIn the dateIn to set
     */
    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    /**
     * @return the carType
     */
    public String getCarType() {
        return carType;
    }

    /**
     * @param carType the carType to set
     */
    public void setCarType(String carType) {
        this.carType = carType;
    }

    /**
     * @return the telphoneNo
     */
    public String getTelphoneNo() {
        return telphoneNo;
    }

    /**
     * @param telphoneNo the telphoneNo to set
     */
    public void setTelphoneNo(String telphoneNo) {
        this.telphoneNo = telphoneNo;
    }
}
