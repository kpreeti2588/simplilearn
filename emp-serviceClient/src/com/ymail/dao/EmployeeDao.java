/**
 * EmployeeDao.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ymail.dao;

public interface EmployeeDao extends java.rmi.Remote {
    public java.lang.Object[] getDetails() throws java.rmi.RemoteException;
    public org.springframework.jdbc.core.JdbcTemplate getJdbcTemplate() throws java.rmi.RemoteException;
    public void setJdbcTemplate(org.springframework.jdbc.core.JdbcTemplate jdbcTemplate) throws java.rmi.RemoteException;
    public void saveEmployee() throws java.rmi.RemoteException;
    public void updateEmployee(com.ymail.model.EmployeeDetails details) throws java.rmi.RemoteException;
    public void deleteEmployee(com.ymail.model.EmployeeDetails details) throws java.rmi.RemoteException;
}
