package cn.edu.cuit.hdhr.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Role implements Serializable {
    private Long roleID;
    private String roleName;
}
