package com.claro.axe.nucleo;


public class SubirM implements Comando {

    public Operaciones ope;

    /**
     * recibe como parametro un objeto ope.
     *
     * @param ope objeto Operaciones
     */
    public SubirM(Operaciones ope) {
        this.ope = ope;
    }

    /**
     * ejecuta el comando necesario (subir Masivamente) desde el objeto ope, el
     * cual tiene toda la logica de negocio.
     */
    @Override
    public void execute() {
        ope.subirM();
    }

}
