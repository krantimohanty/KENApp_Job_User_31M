package com.example.suchismita.essappleave.Model;

/**
 * Created by suchismita on 2/20/2017.
 */

public class ApprovedLeaveModel {

String appId,leaveType, date, no_leave ;


    public ApprovedLeaveModel()
    {

    }

    public ApprovedLeaveModel(String appId, String leaveType, String date, String leaveNo)
    {
this.appId=appId;
        this.leaveType=leaveType;
        this.date=date;
        this.no_leave=leaveNo;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String  getNo_leave() {
        return no_leave;
    }

    public void setNo_leave(String no_leave) {
        this.no_leave = no_leave;
    }
}
