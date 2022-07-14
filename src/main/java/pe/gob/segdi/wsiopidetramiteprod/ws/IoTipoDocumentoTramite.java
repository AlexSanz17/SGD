/**
 * IoTipoDocumentoTramite.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.gob.segdi.wsiopidetramiteprod.ws;

public class IoTipoDocumentoTramite  implements java.io.Serializable {
    private java.lang.String ccodtipdoctra;

    private java.lang.String vnomtipdoctra;

    public IoTipoDocumentoTramite() {
    }

    public IoTipoDocumentoTramite(
           java.lang.String ccodtipdoctra,
           java.lang.String vnomtipdoctra) {
           this.ccodtipdoctra = ccodtipdoctra;
           this.vnomtipdoctra = vnomtipdoctra;
    }


    /**
     * Gets the ccodtipdoctra value for this IoTipoDocumentoTramite.
     * 
     * @return ccodtipdoctra
     */
    public java.lang.String getCcodtipdoctra() {
        return ccodtipdoctra;
    }


    /**
     * Sets the ccodtipdoctra value for this IoTipoDocumentoTramite.
     * 
     * @param ccodtipdoctra
     */
    public void setCcodtipdoctra(java.lang.String ccodtipdoctra) {
        this.ccodtipdoctra = ccodtipdoctra;
    }


    /**
     * Gets the vnomtipdoctra value for this IoTipoDocumentoTramite.
     * 
     * @return vnomtipdoctra
     */
    public java.lang.String getVnomtipdoctra() {
        return vnomtipdoctra;
    }


    /**
     * Sets the vnomtipdoctra value for this IoTipoDocumentoTramite.
     * 
     * @param vnomtipdoctra
     */
    public void setVnomtipdoctra(java.lang.String vnomtipdoctra) {
        this.vnomtipdoctra = vnomtipdoctra;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IoTipoDocumentoTramite)) return false;
        IoTipoDocumentoTramite other = (IoTipoDocumentoTramite) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ccodtipdoctra==null && other.getCcodtipdoctra()==null) || 
             (this.ccodtipdoctra!=null &&
              this.ccodtipdoctra.equals(other.getCcodtipdoctra()))) &&
            ((this.vnomtipdoctra==null && other.getVnomtipdoctra()==null) || 
             (this.vnomtipdoctra!=null &&
              this.vnomtipdoctra.equals(other.getVnomtipdoctra())));
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
        if (getCcodtipdoctra() != null) {
            _hashCode += getCcodtipdoctra().hashCode();
        }
        if (getVnomtipdoctra() != null) {
            _hashCode += getVnomtipdoctra().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IoTipoDocumentoTramite.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.wsiopidetramite.segdi.gob.pe/", "ioTipoDocumentoTramite"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ccodtipdoctra");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ccodtipdoctra"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vnomtipdoctra");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vnomtipdoctra"));
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
