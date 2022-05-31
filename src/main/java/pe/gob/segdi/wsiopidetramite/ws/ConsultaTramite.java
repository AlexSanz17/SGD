/**
 * ConsultaTramite.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.gob.segdi.wsiopidetramite.ws;

public class ConsultaTramite  implements java.io.Serializable {
    private java.lang.String vrucentrem;

    private java.lang.String vrucentrec;

    private java.lang.String vcuo;

    public ConsultaTramite() {
    }

    public ConsultaTramite(
           java.lang.String vrucentrem,
           java.lang.String vrucentrec,
           java.lang.String vcuo) {
           this.vrucentrem = vrucentrem;
           this.vrucentrec = vrucentrec;
           this.vcuo = vcuo;
    }


    /**
     * Gets the vrucentrem value for this ConsultaTramite.
     * 
     * @return vrucentrem
     */
    public java.lang.String getVrucentrem() {
        return vrucentrem;
    }


    /**
     * Sets the vrucentrem value for this ConsultaTramite.
     * 
     * @param vrucentrem
     */
    public void setVrucentrem(java.lang.String vrucentrem) {
        this.vrucentrem = vrucentrem;
    }


    /**
     * Gets the vrucentrec value for this ConsultaTramite.
     * 
     * @return vrucentrec
     */
    public java.lang.String getVrucentrec() {
        return vrucentrec;
    }


    /**
     * Sets the vrucentrec value for this ConsultaTramite.
     * 
     * @param vrucentrec
     */
    public void setVrucentrec(java.lang.String vrucentrec) {
        this.vrucentrec = vrucentrec;
    }


    /**
     * Gets the vcuo value for this ConsultaTramite.
     * 
     * @return vcuo
     */
    public java.lang.String getVcuo() {
        return vcuo;
    }


    /**
     * Sets the vcuo value for this ConsultaTramite.
     * 
     * @param vcuo
     */
    public void setVcuo(java.lang.String vcuo) {
        this.vcuo = vcuo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultaTramite)) return false;
        ConsultaTramite other = (ConsultaTramite) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.vrucentrem==null && other.getVrucentrem()==null) || 
             (this.vrucentrem!=null &&
              this.vrucentrem.equals(other.getVrucentrem()))) &&
            ((this.vrucentrec==null && other.getVrucentrec()==null) || 
             (this.vrucentrec!=null &&
              this.vrucentrec.equals(other.getVrucentrec()))) &&
            ((this.vcuo==null && other.getVcuo()==null) || 
             (this.vcuo!=null &&
              this.vcuo.equals(other.getVcuo())));
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
        if (getVrucentrem() != null) {
            _hashCode += getVrucentrem().hashCode();
        }
        if (getVrucentrec() != null) {
            _hashCode += getVrucentrec().hashCode();
        }
        if (getVcuo() != null) {
            _hashCode += getVcuo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultaTramite.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.wsiopidetramite.segdi.gob.pe/", "ConsultaTramite"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vrucentrem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vrucentrem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vrucentrec");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vrucentrec"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vcuo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vcuo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
