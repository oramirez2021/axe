/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.claro.axe.entidades;

import java.util.List;

/**
 *
 * @author ADMIN
 */
/**
 * Comando registra informacion sobre los comando nativos
 */
public class ConfiguracionServ {

    private List<ConfiguracionCate> listaCate;

    public ConfiguracionServ(List<ConfiguracionCate> listaCate) {
        this.listaCate = listaCate;
    }
    public ConfiguracionServ() {
       
    }
    /**
     * Es el estado del servidor en el formulario: si vale 1, se muestra, si
     * valo 0 lo contrario.
     */
    private String estado;
    /**
     * Ip del servidor.
     */
    private String ip;

    /**
     * La categoria del servidor. Tipo de servicio.
     */
    private String categoria;

    /**
     * La ruta del comando en el servidor.
     */
    private String ruta;

    /**
     * Nombre del comando que sube los servicios.
     */
    private String nomSubir;

    /**
     * Nombre del comando que baja los servicios.
     */
    private String nomBajar;

    /**
     * ruta del comando para ver el status del servidor.
     */
    private String rutaStatus;

    /**
     * Nombre del comando para ver el estado de los servicios del servidor.
     */
    private String nomStatus;

    /**
     * nombre del archivo plano donde se pinta el valor de la consulta de
     * status.
     */
    private String statusArchPla;

    /**
     * Otro nombre que podría llevar el servidor para que se muestre en el
     * formulario.
     */
    private String alias;

    public String getIp() {
        return ip;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getRuta() {
        return ruta;
    }

    public String getNomSubir() {
        return nomSubir;
    }

    public String getNomBajar() {
        return nomBajar;
    }

    public String getRutaStatus() {
        return rutaStatus;
    }

    public String getNomStatus() {
        return nomStatus;
    }

    public String getStatusArchPla() {
        return statusArchPla;
    }

    public String getAlias() {
        return alias;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public void setNomSubir(String nomSubir) {
        this.nomSubir = nomSubir;
    }

    public void setNomBajar(String nomBajar) {
        this.nomBajar = nomBajar;
    }

    public void setRutaStatus(String rutaStatus) {
        this.rutaStatus = rutaStatus;
    }

    public void setNomStatus(String nomStatus) {
        this.nomStatus = nomStatus;
    }

    public void setStatusArchPla(String statusArchPla) {
        this.statusArchPla = statusArchPla;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Consulta si la categoria existe en la lista de categorias obtenidas, de
     * ser asi. el servidor se agrega en una lista de Servidores, en la clase
     * "FabricaServidores"
     *
     * @return cateHab esta variable devuelve un valor 1, si categ. esta
     * habilitada y 0 si no lo esta.
     
     * @param cateServidor contiene la categoria del servidor en ese momento
     * consultado, desde la lista de servidores.
     */
    public int categoriaHabilitada(String cateServidor) {
        int cateHab = 0;
        int numCate = listaCate.size();
        for (int i = 0; i < numCate; i++) {
            if (cateServidor.equals(listaCate.get(i).getCate()) && listaCate.get(i).getEstado().equals("1")) {
                cateHab = 1;
            }
        }
        return cateHab;

    }

}
