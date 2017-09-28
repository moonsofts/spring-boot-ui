package com.test.data.domain;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.typeconversion.DateLong;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@JsonIdentityInfo(generator=JSOGGenerator.class)//防止查询数据的时候引发递归效应
@NodeEntity //节点实体
public class Actor {
    @GraphId //节点唯一标识 ， 系统自动生成
    Long id;
    private String name;
    private int sex;
    @DateLong
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")//neo4j 没有日期格式数据类型，用注解进行转换
    private Date born;

    public Actor() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getBorn() {
        return born;
    }

    public void setBorn(Date born) {
        this.born = born;
    }
}
