package com.claro.axe.entidades;

public class ConfiguracionCate {

    /**
     * Categorias las cuales seran consideradas para mostrarse en el formulario.
     */
    private String estado;

    private String cate;

    private String etiquetaCate;

    public String getCate() {
        return cate;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }

    /**
     * @return estado es el estado de la categoria, si se muestra o no en el
     * formulario.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado	es el estado de la categoria, si se muestra o no.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return etiquetaCate	es la etiqueta de la categoria, la cual se muestra
     * en el formulario, es un alias.
     */
    public String getEtiquetaCate() {
        return etiquetaCate;
    }

    /**
     * @param etiquetaCate	alias de la catgegoria, la cual se muestra en el
     * formulario.
     */
    public void setEtiquetaCate(String etiquetaCate) {
        this.etiquetaCate = etiquetaCate;
    }

}
