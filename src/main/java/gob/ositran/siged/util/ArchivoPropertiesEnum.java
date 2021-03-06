/*LICENCIA DE USO DEL SGD .TXT*/package gob.ositran.siged.util;

/**
 *
 * @author javier castillo
 */
public enum ArchivoPropertiesEnum {

    // externos (fuera del WAR)
    LDAP("siged/ldap.properties"),
    // internos (incluidos en el WAR)
    DAEMON("daemon.properties"),
    SAS("sas.properties");

    private String ubicacion;

    ArchivoPropertiesEnum(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    @Override
    public String toString() {
        return ubicacion;
    }
}
