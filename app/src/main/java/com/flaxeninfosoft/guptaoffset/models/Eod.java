package com.flaxeninfosoft.guptaoffset.models;

import com.flaxeninfosoft.guptaoffset.utils.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Date;

public class Eod {

    @SerializedName(Constants.ID)
    @Expose
    private Long id;

    @SerializedName(Constants.EMPLOYEE_ID)
    @Expose
    private Long empId;

    @SerializedName(Constants.DATE)
    @Expose
    private Date date;

    @SerializedName(Constants.SCHOOL_VISITS)
    @Expose
    private int schoolVisits;

    @SerializedName(Constants.PETROL_EXPENSE)
    @Expose
    private int petrolExpense;

    @SerializedName(Constants.OTHER_EXPENSE)
    @Expose
    private String otherExpense;

    @SerializedName(Constants.LATITUDE)
    @Expose
    private Double latitude;

    @SerializedName(Constants.LONGITUDE)
    @Expose
    private Double longitude;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSchoolVisits() {
        return schoolVisits;
    }

    public void setSchoolVisits(int schoolVisits) {
        this.schoolVisits = schoolVisits;
    }

    public int getPetrolExpense() {
        return petrolExpense;
    }

    public void setPetrolExpense(int petrolExpense) {
        this.petrolExpense = petrolExpense;
    }

    public String getOtherExpense() {
        return otherExpense;
    }

    public void setOtherExpense(String otherExpense) {
        this.otherExpense = otherExpense;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
