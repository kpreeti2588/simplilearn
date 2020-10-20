package com.ymail.dao;

public class EmployeeDaoProxy implements com.ymail.dao.EmployeeDao {
  private String _endpoint = null;
  private com.ymail.dao.EmployeeDao employeeDao = null;
  
  public EmployeeDaoProxy() {
    _initEmployeeDaoProxy();
  }
  
  public EmployeeDaoProxy(String endpoint) {
    _endpoint = endpoint;
    _initEmployeeDaoProxy();
  }
  
  private void _initEmployeeDaoProxy() {
    try {
      employeeDao = (new com.ymail.dao.EmployeeDaoServiceLocator()).getEmployeeDao();
      if (employeeDao != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)employeeDao)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)employeeDao)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (employeeDao != null)
      ((javax.xml.rpc.Stub)employeeDao)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.ymail.dao.EmployeeDao getEmployeeDao() {
    if (employeeDao == null)
      _initEmployeeDaoProxy();
    return employeeDao;
  }
  
  public java.lang.Object[] getDetails() throws java.rmi.RemoteException{
    if (employeeDao == null)
      _initEmployeeDaoProxy();
    return employeeDao.getDetails();
  }
  
  public org.springframework.jdbc.core.JdbcTemplate getJdbcTemplate() throws java.rmi.RemoteException{
    if (employeeDao == null)
      _initEmployeeDaoProxy();
    return employeeDao.getJdbcTemplate();
  }
  
  public void setJdbcTemplate(org.springframework.jdbc.core.JdbcTemplate jdbcTemplate) throws java.rmi.RemoteException{
    if (employeeDao == null)
      _initEmployeeDaoProxy();
    employeeDao.setJdbcTemplate(jdbcTemplate);
  }
  
  public void saveEmployee() throws java.rmi.RemoteException{
    if (employeeDao == null)
      _initEmployeeDaoProxy();
    employeeDao.saveEmployee();
  }
  
  public void updateEmployee(com.ymail.model.EmployeeDetails details) throws java.rmi.RemoteException{
    if (employeeDao == null)
      _initEmployeeDaoProxy();
    employeeDao.updateEmployee(details);
  }
  
  public void deleteEmployee(com.ymail.model.EmployeeDetails details) throws java.rmi.RemoteException{
    if (employeeDao == null)
      _initEmployeeDaoProxy();
    employeeDao.deleteEmployee(details);
  }
  
  
}