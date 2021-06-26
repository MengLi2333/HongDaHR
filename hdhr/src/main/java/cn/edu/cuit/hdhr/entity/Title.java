package cn.edu.cuit.hdhr.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Title implements Serializable {
    private Long titleID;
    private String titleName;
    private String qualification;
    private String duty;
    private String workTarget;
}
