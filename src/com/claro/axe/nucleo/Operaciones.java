package com.claro.axe.nucleo;

import com.claro.axe.entidades.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/*
 */
/**
 * En esta clase se recibe en el contructor el objeto ConfiguracionServ como
 * parametro. Esta clase tiene toda la logica de negocio programada para subir,
 * bajar, y ver el status.
 */
public class Operaciones {

    private String rutaAplicativo;
    private Servidor serv;
    private ConfiguracionServ config;
    private List<ConfiguracionServ> listaServ;
    private String cate;
    private String ip;

    public Operaciones(String rutaAplicativo, String cate, String ip, List<ConfiguracionServ> listaServ) {
        this.rutaAplicativo = rutaAplicativo;
        this.cate = cate;
        this.ip = ip;
        this.listaServ = listaServ;
    }

    public void subir() {
        serv = adquiereServidorAdicional(cate, ip);
        config = adquiereValoresServidor(ip);
        if (serv.getClave() != null) {//solo si se leyeron los valores se puede ejecutar los comandos.
            String orden;
            String accion;  
            try {
                accion = "Start";
                String aa = "x";
                orden = accion + ".bat " + serv.getUsuario() + "," + serv.getClave() + "," + serv.getIp() + "," + rutaAplicativo + "," + aa + "," + config.getRuta() + " ," + config.getNomSubir();
                if (!ip.equals("") || ip != null) {
                    Runtime.getRuntime().exec("cmd /c start " + rutaAplicativo + "servicios\\" + orden);
                }
            } catch (IOException e) {
                System.out.println(e.toString());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Al haber problemas al cargar los servidores o claves no se puede realizar esta operacion. \n Revisar la unidad Z, y/o los archivos que tienen las claves.");
        }
    }

    public void bajar() {
        serv = adquiereServidorAdicional(cate, ip);
        config = adquiereValoresServidor(ip);
        if (serv.getClave() != null && config.getNomBajar() != null) {//solo si se leyeron los valores se puede ejecutar los comandos.
            String orden;
            String accion;
            try {
                accion = "Stop";
                String aa = "x";
                orden = accion + ".bat " + serv.getUsuario() + "," + serv.getClave() + "," + serv.getIp() + "," + rutaAplicativo + "," + aa + "," + config.getRuta() + " ," + config.getNomBajar();
                if (!ip.equals("") || ip != null) {
                    Runtime.getRuntime().exec("cmd /c start " + rutaAplicativo + "servicios\\" + orden);
                }
            } catch (IOException e) {
                System.out.println(e.toString());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Al haber problemas al cargar los servidores o claves no se puede realizar esta operacion. \n Revisar la unidad Z, y/o los archivos que tienen las claves.");
        }
    }

    public void subirM() {
        int numServidores = listaServ.size();
        String orden;
        String accion = "Start";
        try {
            String categoria = "";
            for (int i = 0; i < numServidores; i++) {
                categoria = listaServ.get(i).getCategoria();
                if (categoria.equals(cate)) {
                    config = listaServ.get(i);
                    String ip1 = config.getIp();

                    serv = adquiereServidorAdicional(categoria, ip1);
                    if (serv.getClave() != null) {//solo si se leyeron los valores se puede ejecutar los comandos.
                        orden = accion + ".bat " + serv.getUsuario() + "," + serv.getClave() + "," + serv.getIp() + "," + rutaAplicativo + ",,," + config.getRuta() + "," + config.getNomSubir();
                        Runtime.getRuntime().exec("cmd /c start " + rutaAplicativo + "servicios\\" + orden);
                    } else {
                        JOptionPane.showMessageDialog(null, "Al haber problemas al cargar los servidores o claves no se puede realizar esta operacion. \n Revisar la unidad Z, y/o los archivos que tienen las claves.");
                        break;
                    }
                }

            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public void bajarM() {
    }

    public void status() {
    }

    public void statusM() {
    }
//Procesos necesarios para realizar las operaciones

    /**
     * Este metodo devuelve en una lista los valores como ip, usuario y clave.
     *
     * @return servAdi	almacena el servidor que coincide con la busqueda
     * @param servicio sirve para poder leer el archivo plano correto porque
     * existen dos; uno para el ias, y otro para los demas servicios.
     * @param ip es el ip que se buscara en el archivo plano
     */
    public Servidor adquiereServidorAdicional(String servicio, String ip) {
        Servidor servAdi = new Servidor();
        StringTokenizer tk;
        File f;
        if (servicio.equals("ias")) {
            f = new File("Z:\\servers.cfg");
        } else {
            f = new File("Z:\\servers1.cfg");
        }
        FileReader fr;

        try {
            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            //br.
            String linea;
            while ((linea = br.readLine()) != null) {
                //lee la linea
                tk = new StringTokenizer(linea, ",");
                while (tk.hasMoreTokens()) {
                    String ip1 = tk.nextElement().toString();//ip
                    if (ip1.equals(ip)) {
                        servAdi.setIp(ip1);
                        servAdi.setUsuario(tk.nextElement().toString());//usuario
                        servAdi.setClave(tk.nextElement().toString());//clave
                        break;
                    }
                }
            }
            fr.close();
            br.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + " \n Problemas al leer el archivo de claves", "Mensaje", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {

        }
        return servAdi;
    }

    /**
     * Este metodo devuelve los valores(Item) de la lista de servidores que
     * corresponden al ip que requiere una operacion.
     *
     * @param ip ingresa el ip que requiere una operacion para que se devuelva
     * el item coincidente de la lista de servidores.
     * @return serv	objeto que contiene los valores del ip que requiere una
     * operacion.
     */
    private ConfiguracionServ adquiereValoresServidor(String ip) {//antiguo devuelve Item
        ConfiguracionServ serv = new ConfiguracionServ();
        int rows = listaServ.size();
        for (int i = 0; i < rows; i++) {
            if (listaServ.get(i).getIp().equals(ip)) {
                serv = listaServ.get(i);//se llenan los valores del item coincidente al objeto ConfigSer llamado serv.
                if (listaServ.get(i).getRuta().equals("&")) {
                    serv.setRuta("x");
                }
                break;
            }
        }
        return serv;
    }
}
