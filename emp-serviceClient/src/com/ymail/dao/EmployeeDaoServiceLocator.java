/**
 * EmployeeDaoServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ymail.dao;

public class EmployeeDaoServiceLocator extends org.apache.axis.client.Service implements com.ymail.dao.EmployeeDaoService {

    public EmployeeDaoServiceLocator() {
    }


    public EmployeeDaoServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public EmployeeDaoServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for EmployeeDao
    private java.lang.String EmployeeDao_address = "http://localhost:9090/emp-service/services/EmployeeDao";

    public java.lang.String getEmployeeDaoAddress() {
        return EmployeeDao_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String EmployeeDaoWSDDServiceName = "EmployeeDao";

    public java.lang.String getEmployeeDaoWSDDServiceName() {
        return EmployeeDaoWSDDServiceName;
    }

    public void setEmployeeDaoWSDDServiceName(java.lang.String name) {
        EmployeeDaoWSDDServiceName = name;
    }

    public com.ymail.dao.EmployeeDao getEmployeeDao() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(EmployeeDao_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getEmployeeDao(endpoint);
    }

    public com.ymail.dao.EmployeeDao getEmployeeDao(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.ymail.dao.EmployeeDaoSoapBindingStub _stub = new com.ymail.dao.EmployeeDaoSoapBindingStub(portAddress, this);
            _stub.setPortName(getEmployeeDaoWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setEmployeeDaoEndpointAddress(java.lang.String address) {
        EmployeeDao_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.ymail.dao.EmployeeDao.class.isAssignableFrom(serviceEndpointInterface)) {
                com.ymail.dao.EmployeeDaoSoapBindingStub _stub = new com.ymail.dao.EmployeeDaoSoapBindingStub(new java.net.URL(EmployeeDao_address), this);
                _stub.setPortName(getEmployeeDaoWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("EmployeeDao".equals(inputPortName)) {
            return getEmployeeDao();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://dao.ymail.com", "EmployeeDaoService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://dao.ymail.com", "EmployeeDao"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("EmployeeDao".equals(portName)) {
            setEmployeeDaoEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
