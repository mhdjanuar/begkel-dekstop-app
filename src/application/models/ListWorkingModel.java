/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.models;

/**
 *
 * @author mhdja
 */
public class ListWorkingModel {
    private String kodeTransaction;
    private String kodeCar;
    private String kodeService;
    private String kodeSparepart;
    private int workingEstimate;
    private int stock;
    private int priceTotal;
    
    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
   
     /**
     * @return the kodeCar
     */
    public String getKodeCar() {
        return kodeCar;
    }

    /**
     * @param kodeCar the kodeCar to set
     */
    public void setKodeCar(String kodeCar) {
        this.kodeCar = kodeCar;
    }
    
    /**
     * @return the kodeTransaction
     */
    public String getKodeTransaction() {
        return kodeTransaction;
    }

    /**
     * @param kodeTransaction the kodeTransaction to set
     */
    public void setKodeTransaction(String kodeTransaction) {
        this.kodeTransaction = kodeTransaction;
    }

    /**
     * @return the kodeService
     */
    public String getKodeService() {
        return kodeService;
    }

    /**
     * @param kodeService the kodeService to set
     */
    public void setKodeService(String kodeService) {
        this.kodeService = kodeService;
    }

    /**
     * @return the kodeSparepart
     */
    public String getKodeSparepart() {
        return kodeSparepart;
    }

    /**
     * @param kodeSparepart the kodeSparepart to set
     */
    public void setKodeSparepart(String kodeSparepart) {
        this.kodeSparepart = kodeSparepart;
    }

    /**
     * @return the workingEstimate
     */
    public int getWorkingEstimate() {
        return workingEstimate;
    }

    /**
     * @param workingEstimate the workingEstimate to set
     */
    public void setWorkingEstimate(int workingEstimate) {
        this.workingEstimate = workingEstimate;
    }

    /**
     * @return the priceTotal
     */
    public int getPriceTotal() {
        return priceTotal;
    }

    /**
     * @param priceTotal the priceTotal to set
     */
    public void setPriceTotal(int priceTotal) {
        this.priceTotal = priceTotal;
    }
}
