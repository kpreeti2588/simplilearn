/**
 * JdbcAccessor.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.springframework.jdbc.support;

public abstract class JdbcAccessor  implements java.io.Serializable {
    private java.lang.Object dataSource;

    private java.lang.String databaseProductName;

    private java.lang.Object exceptionTranslator;

    private boolean lazyInit;

    public JdbcAccessor() {
    }

    public JdbcAccessor(
           java.lang.Object dataSource,
           java.lang.String databaseProductName,
           java.lang.Object exceptionTranslator,
           boolean lazyInit) {
           this.dataSource = dataSource;
           this.databaseProductName = databaseProductName;
           this.exceptionTranslator = exceptionTranslator;
           this.lazyInit = lazyInit;
    }


    /**
     * Gets the dataSource value for this JdbcAccessor.
     * 
     * @return dataSource
     */
    public java.lang.Object getDataSource() {
        return dataSource;
    }


    /**
     * Sets the dataSource value for this JdbcAccessor.
     * 
     * @param dataSource
     */
    public void setDataSource(java.lang.Object dataSource) {
        this.dataSource = dataSource;
    }


    /**
     * Gets the databaseProductName value for this JdbcAccessor.
     * 
     * @return databaseProductName
     */
    public java.lang.String getDatabaseProductName() {
        return databaseProductName;
    }


    /**
     * Sets the databaseProductName value for this JdbcAccessor.
     * 
     * @param databaseProductName
     */
    public void setDatabaseProductName(java.lang.String databaseProductName) {
        this.databaseProductName = databaseProductName;
    }


    /**
     * Gets the exceptionTranslator value for this JdbcAccessor.
     * 
     * @return exceptionTranslator
     */
    public java.lang.Object getExceptionTranslator() {
        return exceptionTranslator;
    }


    /**
     * Sets the exceptionTranslator value for this JdbcAccessor.
     * 
     * @param exceptionTranslator
     */
    public void setExceptionTranslator(java.lang.Object exceptionTranslator) {
        this.exceptionTranslator = exceptionTranslator;
    }


    /**
     * Gets the lazyInit value for this JdbcAccessor.
     * 
     * @return lazyInit
     */
    public boolean isLazyInit() {
        return lazyInit;
    }


    /**
     * Sets the lazyInit value for this JdbcAccessor.
     * 
     * @param lazyInit
     */
    public void setLazyInit(boolean lazyInit) {
        this.lazyInit = lazyInit;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof JdbcAccessor)) return false;
        JdbcAccessor other = (JdbcAccessor) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dataSource==null && other.getDataSource()==null) || 
             (this.dataSource!=null &&
              this.dataSource.equals(other.getDataSource()))) &&
            ((this.databaseProductName==null && other.getDatabaseProductName()==null) || 
             (this.databaseProductName!=null &&
              this.databaseProductName.equals(other.getDatabaseProductName()))) &&
            ((this.exceptionTranslator==null && other.getExceptionTranslator()==null) || 
             (this.exceptionTranslator!=null &&
              this.exceptionTranslator.equals(other.getExceptionTranslator()))) &&
            this.lazyInit == other.isLazyInit();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getDataSource() != null) {
            _hashCode += getDataSource().hashCode();
        }
        if (getDatabaseProductName() != null) {
            _hashCode += getDatabaseProductName().hashCode();
        }
        if (getExceptionTranslator() != null) {
            _hashCode += getExceptionTranslator().hashCode();
        }
        _hashCode += (isLazyInit() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(JdbcAccessor.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://support.jdbc.springframework.org", "JdbcAccessor"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataSource");
        elemField.setXmlName(new javax.xml.namespace.QName("http://support.jdbc.springframework.org", "dataSource"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("databaseProductName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://support.jdbc.springframework.org", "databaseProductName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exceptionTranslator");
        elemField.setXmlName(new javax.xml.namespace.QName("http://support.jdbc.springframework.org", "exceptionTranslator"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lazyInit");
        elemField.setXmlName(new javax.xml.namespace.QName("http://support.jdbc.springframework.org", "lazyInit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
