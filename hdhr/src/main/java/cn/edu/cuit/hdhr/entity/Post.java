package cn.edu.cuit.hdhr.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Post implements Serializable {
    private Long postID;
    private String postName;
    private Long parentID;
    private String duty;
    private String qualification;
    private String purview;
    private String workContent;
}
