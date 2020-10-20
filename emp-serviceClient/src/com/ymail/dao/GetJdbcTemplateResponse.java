/**
 * GetJdbcTemplateResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ymail.dao;

public class GetJdbcTemplateResponse  implements java.io.Serializable {
    private org.springframework.jdbc.core.JdbcTemplate getJdbcTemplateReturn;

    public GetJdbcTemplateResponse() {
    }

    public GetJdbcTemplateResponse(
           org.springframework.jdbc.core.JdbcTemplate getJdbcTemplateReturn) {
           this.getJdbcTemplateReturn = getJdbcTemplateReturn;
    }


    /**
     * Gets the getJdbcTemplateReturn value for this GetJdbcTemplateResponse.
     * 
     * @return getJdbcTemplateReturn
     */
    public org.springframework.jdbc.core.JdbcTemplate getGetJdbcTemplateReturn() {
        return getJdbcTemplateReturn;
    }


    /**
     * Sets the getJdbcTemplateReturn value for this GetJdbcTemplateResponse.
     * 
     * @param getJdbcTemplateReturn
     */
    public void setGetJdbcTemplateReturn(org.springframework.jdbc.core.JdbcTemplate getJdbcTemplateReturn) {
        this.getJdbcTemplateReturn = getJdbcTemplateReturn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetJdbcTemplateResponse)) return false;
        GetJdbcTemplateResponse other = (GetJdbcTemplateResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getJdbcTemplateReturn==null && other.getGetJdbcTemplateReturn()==null) || 
             (this.getJdbcTemplateReturn!=null &&
              this.getJdbcTemplateReturn.equals(other.getGetJdbcTemplateReturn())));
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
        if (getGetJdbcTemplateReturn() != null) {
            _hashCode += getGetJdbcTemplateReturn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetJdbcTemplateResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dao.ymail.com", ">getJdbcTemplateResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getJdbcTemplateReturn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dao.ymail.com", "getJdbcTemplateReturn"));
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
