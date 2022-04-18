package com.claro.axe.entidades;

import com.claro.axe.nucleo.Comando;


/*
 */
/**
 * Un <code>servidor</code> en el cual se ejecutan <code>servicios</code> a
 * gestionar
 *
 * @autor oramierz
 * @since 26-06-2015
 * @version 2.0
 */
public class Servidor {

    /**
     * Usuario para autenticar en el Servidor
     */
    private String usu;

    /**
     * Clave/Contraseña del Servidor
     */
    private String clave;

    /**
     * Direccion IP del Servidor
     */
    private String ip;

    /**
     *@param ejecutar es un objeto que en forma abstracta ejecuta el comando pertinente, como subir, bajar o status.
     * @element-type Subir
     */
    public void ejecutaComando(Comando ejecutar) {
        ejecutar.execute();
    }

    public String getUsuario() {
        return usu;
    }

    public String getClave() {
        return clave;
    }

    public String getIp() {
        return ip;
    }

    public void setUsuario(String usu) {
        this.usu = usu;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }


}
