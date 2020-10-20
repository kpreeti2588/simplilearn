/**
 * SetJdbcTemplate.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ymail.dao;

public class SetJdbcTemplate  implements java.io.Serializable {
    private org.springframework.jdbc.core.JdbcTemplate jdbcTemplate;

    public SetJdbcTemplate() {
    }

    public SetJdbcTemplate(
           org.springframework.jdbc.core.JdbcTemplate jdbcTemplate) {
           this.jdbcTemplate = jdbcTemplate;
    }


    /**
     * Gets the jdbcTemplate value for this SetJdbcTemplate.
     * 
     * @return jdbcTemplate
     */
    public org.springframework.jdbc.core.JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }


    /**
     * Sets the jdbcTemplate value for this SetJdbcTemplate.
     * 
     * @param jdbcTemplate
     */
    public void setJdbcTemplate(org.springframework.jdbc.core.JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SetJdbcTemplate)) return false;
        SetJdbcTemplate other = (SetJdbcTemplate) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.jdbcTemplate==null && other.getJdbcTemplate()==null) || 
             (this.jdbcTemplate!=null &&
              this.jdbcTemplate.equals(other.getJdbcTemplate())));
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
        if (getJdbcTemplate() != null) {
            _hashCode += getJdbcTemplate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SetJdbcTemplate.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dao.ymail.com", ">setJdbcTemplate"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jdbcTemplate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dao.ymail.com", "jdbcTemplate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://core.jdbc.springframework.org", "JdbcTemplate"));
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
