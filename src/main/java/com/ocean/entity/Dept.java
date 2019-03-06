package com.ocean.entity;

import javax.persistence.*;

/**
 * Created by Ocean on 2019/3/6 14:44.
 */
@Entity     //springboot will loads this class on startup
@Table(name = "dept")
public class Dept {
    @Id     //下面的属性是主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)         //使用数据库自动增长的值作为主键
    @Column(name = "deptno")
    private Integer deptNo;
    @Column(name = "dname")
    private String dName;
    @Column(name = "loc")
    private String localtion;

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getLocaltion() {
        return localtion;
    }

    public void setLocaltion(String localtion) {
        this.localtion = localtion;
    }
}
