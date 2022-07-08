/**
 * EntidadBean.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.gob.segdi.wsentidadprod.ws;

public class EntidadBean  implements java.io.Serializable {
    private int sident;

    private int sidpadent;

    private java.lang.String vnoment;

    private java.lang.String vrucent;

    public EntidadBean() {
    }

    public EntidadBean(
           int sident,
           int sidpadent,
           java.lang.String vnoment,
           java.lang.String vrucent) {
           this.sident = sident;
           this.sidpadent = sidpadent;
           this.vnoment = vnoment;
           this.vrucent = vrucent;
    }


    /**
     * Gets the sident value for this EntidadBean.
     * 
     * @return sident
     */
    public int getSident() {
        return sident;
    }


    /**
     * Sets the sident value for this EntidadBean.
     * 
     * @param sident
     */
    public void setSident(int sident) {
        this.sident = sident;
    }


    /**
     * Gets the sidpadent value for this EntidadBean.
     * 
     * @return sidpadent
     */
    public int getSidpadent() {
        return sidpadent;
    }


    /**
     * Sets the sidpadent value for this EntidadBean.
     * 
     * @param sidpadent
     */
    public void setSidpadent(int sidpadent) {
        this.sidpadent = sidpadent;
    }


    /**
     * Gets the vnoment value for this EntidadBean.
     * 
     * @return vnoment
     */
    public java.lang.String getVnoment() {
        return vnoment;
    }


    /**
     * Sets the vnoment value for this EntidadBean.
     * 
     * @param vnoment
     */
    public void setVnoment(java.lang.String vnoment) {
        this.vnoment = vnoment;
    }


    /**
     * Gets the vrucent value for this EntidadBean.
     * 
     * @return vrucent
     */
    public java.lang.String getVrucent() {
        return vrucent;
    }


    /**
     * Sets the vrucent value for this EntidadBean.
     * 
     * @param vrucent
     */
    public void setVrucent(java.lang.String vrucent) {
        this.vrucent = vrucent;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EntidadBean)) return false;
        EntidadBean other = (EntidadBean) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.sident == other.getSident() &&
            this.sidpadent == other.getSidpadent() &&
            ((this.vnoment==null && other.getVnoment()==null) || 
             (this.vnoment!=null &&
              this.vnoment.equals(other.getVnoment()))) &&
            ((this.vrucent==null && other.getVrucent()==null) || 
             (this.vrucent!=null &&
              this.vrucent.equals(other.getVrucent())));
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
        _hashCode += getSident();
        _hashCode += getSidpadent();
        if (getVnoment() != null) {
            _hashCode += getVnoment().hashCode();
        }
        if (getVrucent() != null) {
            _hashCode += getVrucent().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EntidadBean.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.wsentidad.segdi.gob.pe/", "EntidadBean"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sident");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sident"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sidpadent");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sidpadent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vnoment");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vnoment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vrucent");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vrucent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
