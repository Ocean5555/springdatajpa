package com.ocean.entity;

import javax.persistence.*;
import java.util.Date;
/**
 * Created by Ocean on 2019/3/7 10:48.
 */
@Entity
@Table(name = "emp")
public class Emp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empno;
    private String ename;
    private String job;
    private Integer mgr;
    private Date hiredate;
    private Float sal;
    private Float comm;
    @ManyToOne //多个emp对应一个dept
    @JoinColumn(name = "deptno") //指定关联字段
    private Dept dept;

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Float getSal() {
        return sal;
    }

    public void setSal(Float sal) {
        this.sal = sal;
    }

    public Float getComm() {
        return comm;
    }

    public void setComm(Float comm) {
        this.comm = comm;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}
