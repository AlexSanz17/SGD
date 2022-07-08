/**
 * DocumentoAnexo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.gob.segdi.wsiopidetramiteprod.ws;

public class DocumentoAnexo  implements java.io.Serializable {
    private java.lang.String vnomdoc;

    public DocumentoAnexo() {
    }

    public DocumentoAnexo(
           java.lang.String vnomdoc) {
           this.vnomdoc = vnomdoc;
    }


    /**
     * Gets the vnomdoc value for this DocumentoAnexo.
     * 
     * @return vnomdoc
     */
    public java.lang.String getVnomdoc() {
        return vnomdoc;
    }


    /**
     * Sets the vnomdoc value for this DocumentoAnexo.
     * 
     * @param vnomdoc
     */
    public void setVnomdoc(java.lang.String vnomdoc) {
        this.vnomdoc = vnomdoc;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DocumentoAnexo)) return false;
        DocumentoAnexo other = (DocumentoAnexo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.vnomdoc==null && other.getVnomdoc()==null) || 
             (this.vnomdoc!=null &&
              this.vnomdoc.equals(other.getVnomdoc())));
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
        if (getVnomdoc() != null) {
            _hashCode += getVnomdoc().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DocumentoAnexo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.wsiopidetramite.segdi.gob.pe/", "DocumentoAnexo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vnomdoc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vnomdoc"));
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
