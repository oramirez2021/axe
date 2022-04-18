package com.claro.axe.nucleo;

public class Bajar implements Comando {

    public Operaciones ope;

    /**
     * recibe como parametro un objeto ope.
     */
    public Bajar(Operaciones ope) {
        this.ope = ope;
    }

    /**
     * ejecuta el comando necesario (bajar) desde el objeto ope, el cual tiene
     * toda la logica de negocio.
     */
    @Override
    public void execute() {
        ope.bajar();
    }

}
