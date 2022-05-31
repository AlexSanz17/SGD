/**
 * RespuestaTramite.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.gob.segdi.wsiopidetramite.ws;

public class RespuestaTramite  implements java.io.Serializable {
    private java.lang.String vcodres;

    private java.lang.String vdesres;

    public RespuestaTramite() {
    }

    public RespuestaTramite(
           java.lang.String vcodres,
           java.lang.String vdesres) {
           this.vcodres = vcodres;
           this.vdesres = vdesres;
    }


    /**
     * Gets the vcodres value for this RespuestaTramite.
     * 
     * @return vcodres
     */
    public java.lang.String getVcodres() {
        return vcodres;
    }


    /**
     * Sets the vcodres value for this RespuestaTramite.
     * 
     * @param vcodres
     */
    public void setVcodres(java.lang.String vcodres) {
        this.vcodres = vcodres;
    }


    /**
     * Gets the vdesres value for this RespuestaTramite.
     * 
     * @return vdesres
     */
    public java.lang.String getVdesres() {
        return vdesres;
    }


    /**
     * Sets the vdesres value for this RespuestaTramite.
     * 
     * @param vdesres
     */
    public void setVdesres(java.lang.String vdesres) {
        this.vdesres = vdesres;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RespuestaTramite)) return false;
        RespuestaTramite other = (RespuestaTramite) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.vcodres==null && other.getVcodres()==null) || 
             (this.vcodres!=null &&
              this.vcodres.equals(other.getVcodres()))) &&
            ((this.vdesres==null && other.getVdesres()==null) || 
             (this.vdesres!=null &&
              this.vdesres.equals(other.getVdesres())));
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
        if (getVcodres() != null) {
            _hashCode += getVcodres().hashCode();
        }
        if (getVdesres() != null) {
            _hashCode += getVdesres().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RespuestaTramite.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.wsiopidetramite.segdi.gob.pe/", "RespuestaTramite"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vcodres");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vcodres"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vdesres");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vdesres"));
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
