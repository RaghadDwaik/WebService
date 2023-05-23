package com.example.Assignment.Dto;

import lombok.Data;

@Data

public class LaboratoryDto {
    private int labid;

    public int getLabid() {
        return labid;
    }

    public void setLabid(int labid) {
        this.labid = labid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;
}
