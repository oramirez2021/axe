package com.claro.axe.nucleo;

public class Estado implements Comando {

    public Operaciones ope;

    /**
     * recibe como parametro un objeto ope.
     */
    public Estado(Operaciones ope) {
    }
    /**
     * ejecuta el comando necesario (status) desde el objeto ope, el cual tiene
     * toda la logica de negocio.
     */
    public void execute() {
        ope.status();
    }

}
