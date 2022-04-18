package com.claro.axe.nucleo;

public class Subir implements Comando {

    /**
     * Objeto operaciones.
     */
    public Operaciones ope;

    /**
     * recibe como parametro un objeto ope.
     */
    public Subir(Operaciones ope) {
        this.ope = ope;
    }

    /**
     * ejecuta el comando necesario (subir) desde el objeto ope, el cual tiene
     * toda la logica de negocio.
     */
    public void execute() {
        ope.subir();
    }

}
