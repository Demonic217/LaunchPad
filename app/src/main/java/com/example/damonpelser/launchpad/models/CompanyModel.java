package com.example.damonpelser.launchpad.models;

/**
 * Created by damon on 2017/10/20.
 */

public class CompanyModel {
    //TODO Add compIcon back once I figure out how to pull the logo strings from storage
    String compLogo, compName, closeDate, compDesc, compLat, compLong, compOpp, compCriteria, compTC;

    public CompanyModel(String compLogo, String compName, String closeDate, String compDesc, String compLat, String compLong, String compOpp, String compCriteria, String compTC) {
        this.compName = compName;
        this.compLogo = compLogo;
        this.closeDate = closeDate;
        this.compDesc = compDesc;
        this.compLat = compLat;
        this.compLong = compLong;
        this.compOpp = compOpp;
        this.compCriteria = compCriteria;
        this.compTC = compTC;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getCompLogo() {
        return compLogo;
    }

    public void setCompLogo(String compIcon) {
        this.compLogo = compIcon;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    public String getCompDesc() {
        return compDesc;
    }

    public void setCompDesc(String compDesc) {
        this.compDesc = compDesc;
    }

    public String getCompLat() {
        return compLat;
    }

    public void setCompLat(String compLat) {
        this.compLat = compLat;
    }

    public String getCompLong() {
        return compLong;
    }

    public void setCompLong(String compLong) {
        this.compLong = compLong;
    }

    public String getCompOpp() {
        return compOpp;
    }

    public void setCompOpp(String compOpp) {
        this.compOpp = compOpp;
    }

    public String getCompCriteria() {
        return compCriteria;
    }

    public void setCompCriteria(String compCriteria) {
        this.compCriteria = compCriteria;
    }

    public String getCompTC() {
        return compTC;
    }

    public void setCompTC(String compTC) {
        this.compTC = compTC;
    }
}
