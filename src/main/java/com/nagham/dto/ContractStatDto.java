package com.nagham.dto;


public class ContractStatDto {

    int approvedContract;
    int rejectedContract;
    int pendingContract;
    int closedContract;
    int sum;
    float dataPercent;

    public int getApprovedContract() {
        return approvedContract;
    }

    public void setApprovedContract(int approvedContract) {
        this.approvedContract = approvedContract;
    }

    public int getRejectedContract() {
        return rejectedContract;
    }

    public void setRejectedContract(int rejectedContract) {
        this.rejectedContract = rejectedContract;
    }

    public int getPendingContract() {
        return pendingContract;
    }

    public void setPendingContract(int pendingContract) {
        this.pendingContract = pendingContract;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public float getDataPercent() {
        return dataPercent;
    }

    public void setDataPercent(float dataPercent) {
        this.dataPercent = dataPercent;
    }

    public int getClosedContract() {
        return closedContract;
    }

    public void setClosedContract(int closedContract) {
        this.closedContract = closedContract;
    }
}
