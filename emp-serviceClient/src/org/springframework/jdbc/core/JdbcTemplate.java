/**
 * JdbcTemplate.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.springframework.jdbc.core;

public class JdbcTemplate  extends org.springframework.jdbc.support.JdbcAccessor  implements java.io.Serializable {
    private int fetchSize;

    private boolean ignoreWarnings;

    private int maxRows;

    private int queryTimeout;

    private boolean resultsMapCaseInsensitive;

    private boolean skipResultsProcessing;

    private boolean skipUndeclaredResults;

    public JdbcTemplate() {
    }

    public JdbcTemplate(
           java.lang.Object dataSource,
           java.lang.String databaseProductName,
           java.lang.Object exceptionTranslator,
           boolean lazyInit,
           int fetchSize,
           boolean ignoreWarnings,
           int maxRows,
           int queryTimeout,
           boolean resultsMapCaseInsensitive,
           boolean skipResultsProcessing,
           boolean skipUndeclaredResults) {
        super(
            dataSource,
            databaseProductName,
            exceptionTranslator,
            lazyInit);
        this.fetchSize = fetchSize;
        this.ignoreWarnings = ignoreWarnings;
        this.maxRows = maxRows;
        this.queryTimeout = queryTimeout;
        this.resultsMapCaseInsensitive = resultsMapCaseInsensitive;
        this.skipResultsProcessing = skipResultsProcessing;
        this.skipUndeclaredResults = skipUndeclaredResults;
    }


    /**
     * Gets the fetchSize value for this JdbcTemplate.
     * 
     * @return fetchSize
     */
    public int getFetchSize() {
        return fetchSize;
    }


    /**
     * Sets the fetchSize value for this JdbcTemplate.
     * 
     * @param fetchSize
     */
    public void setFetchSize(int fetchSize) {
        this.fetchSize = fetchSize;
    }


    /**
     * Gets the ignoreWarnings value for this JdbcTemplate.
     * 
     * @return ignoreWarnings
     */
    public boolean isIgnoreWarnings() {
        return ignoreWarnings;
    }


    /**
     * Sets the ignoreWarnings value for this JdbcTemplate.
     * 
     * @param ignoreWarnings
     */
    public void setIgnoreWarnings(boolean ignoreWarnings) {
        this.ignoreWarnings = ignoreWarnings;
    }


    /**
     * Gets the maxRows value for this JdbcTemplate.
     * 
     * @return maxRows
     */
    public int getMaxRows() {
        return maxRows;
    }


    /**
     * Sets the maxRows value for this JdbcTemplate.
     * 
     * @param maxRows
     */
    public void setMaxRows(int maxRows) {
        this.maxRows = maxRows;
    }


    /**
     * Gets the queryTimeout value for this JdbcTemplate.
     * 
     * @return queryTimeout
     */
    public int getQueryTimeout() {
        return queryTimeout;
    }


    /**
     * Sets the queryTimeout value for this JdbcTemplate.
     * 
     * @param queryTimeout
     */
    public void setQueryTimeout(int queryTimeout) {
        this.queryTimeout = queryTimeout;
    }


    /**
     * Gets the resultsMapCaseInsensitive value for this JdbcTemplate.
     * 
     * @return resultsMapCaseInsensitive
     */
    public boolean isResultsMapCaseInsensitive() {
        return resultsMapCaseInsensitive;
    }


    /**
     * Sets the resultsMapCaseInsensitive value for this JdbcTemplate.
     * 
     * @param resultsMapCaseInsensitive
     */
    public void setResultsMapCaseInsensitive(boolean resultsMapCaseInsensitive) {
        this.resultsMapCaseInsensitive = resultsMapCaseInsensitive;
    }


    /**
     * Gets the skipResultsProcessing value for this JdbcTemplate.
     * 
     * @return skipResultsProcessing
     */
    public boolean isSkipResultsProcessing() {
        return skipResultsProcessing;
    }


    /**
     * Sets the skipResultsProcessing value for this JdbcTemplate.
     * 
     * @param skipResultsProcessing
     */
    public void setSkipResultsProcessing(boolean skipResultsProcessing) {
        this.skipResultsProcessing = skipResultsProcessing;
    }


    /**
     * Gets the skipUndeclaredResults value for this JdbcTemplate.
     * 
     * @return skipUndeclaredResults
     */
    public boolean isSkipUndeclaredResults() {
        return skipUndeclaredResults;
    }


    /**
     * Sets the skipUndeclaredResults value for this JdbcTemplate.
     * 
     * @param skipUndeclaredResults
     */
    public void setSkipUndeclaredResults(boolean skipUndeclaredResults) {
        this.skipUndeclaredResults = skipUndeclaredResults;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof JdbcTemplate)) return false;
        JdbcTemplate other = (JdbcTemplate) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.fetchSize == other.getFetchSize() &&
            this.ignoreWarnings == other.isIgnoreWarnings() &&
            this.maxRows == other.getMaxRows() &&
            this.queryTimeout == other.getQueryTimeout() &&
            this.resultsMapCaseInsensitive == other.isResultsMapCaseInsensitive() &&
            this.skipResultsProcessing == other.isSkipResultsProcessing() &&
            this.skipUndeclaredResults == other.isSkipUndeclaredResults();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        _hashCode += getFetchSize();
        _hashCode += (isIgnoreWarnings() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getMaxRows();
        _hashCode += getQueryTimeout();
        _hashCode += (isResultsMapCaseInsensitive() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isSkipResultsProcessing() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isSkipUndeclaredResults() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(JdbcTemplate.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://core.jdbc.springframework.org", "JdbcTemplate"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fetchSize");
        elemField.setXmlName(new javax.xml.namespace.QName("http://core.jdbc.springframework.org", "fetchSize"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ignoreWarnings");
        elemField.setXmlName(new javax.xml.namespace.QName("http://core.jdbc.springframework.org", "ignoreWarnings"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maxRows");
        elemField.setXmlName(new javax.xml.namespace.QName("http://core.jdbc.springframework.org", "maxRows"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("queryTimeout");
        elemField.setXmlName(new javax.xml.namespace.QName("http://core.jdbc.springframework.org", "queryTimeout"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultsMapCaseInsensitive");
        elemField.setXmlName(new javax.xml.namespace.QName("http://core.jdbc.springframework.org", "resultsMapCaseInsensitive"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("skipResultsProcessing");
        elemField.setXmlName(new javax.xml.namespace.QName("http://core.jdbc.springframework.org", "skipResultsProcessing"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("skipUndeclaredResults");
        elemField.setXmlName(new javax.xml.namespace.QName("http://core.jdbc.springframework.org", "skipUndeclaredResults"));
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
