package com.claro.axe.nucleo;

import com.claro.axe.entidades.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class FabricaServidores implements ActionListener, MouseListener {

    //Entidades
    private ConfiguracionServ config;//Clase Servidor
    private List<ConfiguracionServ> listaServ;
    private List<ConfiguracionCate> listaCate;
    private Servidor ser;
    //-----------
    private String rutaPlano;
    //Algunos controles de formularios
    private JFrame formu = null;
    private int ii = 0;
    private int numServidores;
    private int numCategorias;
    //Controles
    private JCheckBox[][] chkServidores;//Arreglo de servidores, accion bajar
    private JCheckBox[][] chkReinicio;
    private JRadioButton[] rbtStatusServidoresM;
    private JPanel pnlContCateServ;
    private JTabbedPane tabPane;
    private JPanel panelDelTab;
    Operaciones ope;

    public FabricaServidores(String rutaPlano, JFrame formu) {
        this.rutaPlano = rutaPlano;

        this.formu = formu;

    }

    /**
     * Este metodo devuelve un valor list con todas las filas de configuracion
     * del archivo plano configuracion.cfg.
     *
     *
     */
    public void adquirirServidores() {
        listaServ = null;
        File f;
        FileReader fr;
        BufferedReader br;
        //---------------
        //Este objeto permite el desplazamiento dentro del archivo separado por ;
        StringTokenizer tk;
        StringTokenizer tk1;
        int rows = 0, rows1 = 0, cols;
        //Variable
        String estado;
        try {
            f = new File(rutaPlano + "configuracion.cfg");
            try {
                fr = new FileReader(f);
                br = new BufferedReader(fr);
                //Se obtiene la cantidad de registros
                String linea;
                linea = br.readLine();
                tk = new StringTokenizer(linea, "|");
                //Columnas del archivo plano
                cols = tk.countTokens();
                //se calcula el numero de regristros del archivo plano.
                while ((linea = br.readLine()) != null) {
                    if (linea.trim().equals("*")) {
                        break;
                    } else {
                        tk1 = new StringTokenizer(linea, "|");
                        if (!tk1.nextElement().equals("0")) {
                            rows++;
                        }
                    }
                }
                config = new ConfiguracionServ(listaCate);
                listaServ = new ArrayList<>();
                fr.close();
                fr = new FileReader(f);
                br = new BufferedReader(fr);
                br.readLine();//ignora la primera linea del archivo plano por tener el encabezado.
                //Recorrer Archivo de configuración.
                int c = 0, f1 = 0;
                while ((linea = br.readLine()) != null) {
                    //lee la linea
                    tk = new StringTokenizer(linea, "|");
                    while (tk.hasMoreTokens()) {
                        estado = tk.nextElement().toString();//estado del servidor descrito en archivo plano 1 o 0.
                        int cc = 1;
                        if (estado.equals("1")) {//se ve el estado
                            config.setEstado(estado);
                            //obtener valores en variables tmp antes de agregarlas a el obj config y luego a la lista de servidores.
                            String valorTmpIp = tk.nextElement().toString();
                            String valorTmpCate = tk.nextElement().toString();
                            String valorTmpRuta = tk.nextElement().toString();
                            String valorTmpNomSubir = tk.nextElement().toString();
                            String valorTmpNomBajar = tk.nextElement().toString();
                            String valorTmpRutaStatus = tk.nextElement().toString();
                            String valorTmpNomStatus = tk.nextElement().toString();
                            String valorTmpAlias = tk.nextElement().toString();
                            String valorTmpStatusArchPla = tk.nextElement().toString();
                            //Se pregunta si la categoria del servidor esta habilitada para agregar al formulario
                            int cateHab = config.categoriaHabilitada(valorTmpCate);
                            if (cateHab == 1) {//si es asi se agrega a lista de servidores
                                config = new ConfiguracionServ(listaCate);
                                config.setIp(valorTmpIp);
                                config.setCategoria(valorTmpCate);
                                config.setRuta(valorTmpRuta);
                                config.setNomSubir(valorTmpNomSubir);
                                config.setNomBajar(valorTmpNomBajar);
                                config.setRutaStatus(valorTmpRutaStatus);
                                config.setNomStatus(valorTmpNomStatus);
                                config.setAlias(valorTmpAlias);
                                config.setStatusArchPla(valorTmpStatusArchPla);
                                //se añade a la lista de servidores
                                listaServ.add(config);
                                rows1++;
                            }
                            cc++;

                            f1++;
                        }
                        c++;
                    }
                }
                br.close();
                fr.close();
            } catch (FileNotFoundException ex) {
                System.out.println(ex.toString());
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        //Ordenar arreglo
        ConfiguracionServ aux;
        int pasadas = 1;
        while (pasadas < rows1) {
            for (int i = 0; i < rows1 - 1; i++) {
                if (listaServ.get(i).getCategoria().trim().compareTo(listaServ.get(i + 1).getCategoria().trim()) > 0) { //comparando las categorias
                    //intercambio
                    aux = listaServ.get(i);
                    listaServ.set(i, listaServ.get(i + 1));
                    listaServ.set(i + 1, aux);

                }
            }
            pasadas++;
        }

    }

    /**
     * Este metodo devuelve un valor list con todas las filas de configuracion
     * del archivo plano configuracion.cfg.
     *
     *
     */
    public void adquirirCategorias() {
        ConfiguracionCate configCate;
        listaCate = new ArrayList<>();
        File f;
        FileReader fr;
        BufferedReader br;
        StringTokenizer tk;
        String linea;
        String estado, cate, etiquetaCate;//categoria obtenida del archivo plano
        int rows = 0, rows1 = 0;//todos los items de el archivo plano
        try {
            f = new File(rutaPlano + "configuracionCate.cfg");
            try {
                fr = new FileReader(f);
                br = new BufferedReader(fr);
                br.readLine();//ignora la primera linea del archivo plano por tener el encabezado.
                //calculando el numero de registros
                while ((linea = br.readLine()) != null && !linea.trim().equals("*")) {
                    rows++;
                }
                //se reinicializa buffer
                fr.close();
                fr = new FileReader(f);
                br = new BufferedReader(fr);
                br.readLine();//ignora la primera linea del archivo plano por tener el encabezado.
                //Recorrer Archivo de configuración.
                int c = 0;
                while ((linea = br.readLine()) != null && !linea.trim().equals("*")) {
                    //lee la linea
                    tk = new StringTokenizer(linea, "|");
                    while (tk.hasMoreTokens()) {
                        configCate = new ConfiguracionCate();
                        estado = tk.nextElement().toString();//estado de la categoria
                        if (estado.equals("1")) {
                            cate = tk.nextElement().toString();//categoria desde el archivo
                            etiquetaCate = tk.nextElement().toString();//etiqueta para que salga en el formulario.
                            configCate.setEstado(estado);
                            configCate.setCate(cate);
                            configCate.setEtiquetaCate(etiquetaCate);
                            listaCate.add(configCate);
                            rows1++;
                        }
                    }
                    c++;
                }
                br.close();
            } catch (FileNotFoundException ex) {
                System.out.println(ex.toString());
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        //Ordenar arreglo
        ConfiguracionCate aux;
        int pasadas = 1;
        while (pasadas < rows1) {
            for (int i = 0; i < rows1 - 1; i++) {
                if (listaCate.get(i).getCate().trim().compareTo(listaCate.get(i + 1).getCate().trim()) > 0) { //comparando las categorias
                    //intercambios
                    aux = listaCate.get(i);
                    listaCate.set(i, listaCate.get(i + 1));
                    listaCate.set(i + 1, aux);
                }
            }
            pasadas++;
        }

    }

    /**
     * Este metodo pinta en el formulario los controles con los servidores
     * leidos en el archivo plano, que ahora estan en una lista.
     *
     */
    public void pintaServidores() {
        adquirirCategorias();
        adquirirServidores();
        redefineListaCate();
        //alistar tabPane y panel contenedor.
        tabPane = new JTabbedPane();
        tabPane.setBounds(10, 5, 1400, 695);
        panelDelTab = new JPanel();
        panelDelTab.setBounds(10, 5, 500, 500);
        panelDelTab.setLayout(null);
//        //declaracion de variables de controles
        int cX = 105;
        JPanel[] pnlStatusServidores;//Individual
        numServidores = listaServ.size();
        numCategorias = listaCate.size();
        chkServidores = new JCheckBox[numServidores][2];//Servidores, accion de bajar.
        pnlStatusServidores = new JPanel[numServidores];//Individual
        //Se instancian masivos
        chkReinicio = new JCheckBox[numCategorias][2];//Masivo
        rbtStatusServidoresM = new JRadioButton[numCategorias];
        pnlContCateServ = new JPanel();
        int y = 30;//variable que almacena el valor y de el primer control puesto en el 1er panel
        //Start Stop, Masivos
        int swIncrementoY = 0, ii = 0;//ii es el iiice que hace avanzar los registros de la lista Categoria.
        for (int i = 0; i < numServidores; i++) {
            if (i == 0 && ii == 0) {//se entra por primera vez y se crea el primer panel
                pnlContCateServ = new JPanel();
                pnlContCateServ.setLayout(null);
                //pintar en el panel
                pnlContCateServ.setBounds(cX, 5, 230, 320);
                pnlContCateServ.setBorder(BorderFactory.createLineBorder(Color.blue));

            }
            //Controles bajar
            chkServidores[i][0] = new JCheckBox();
            chkServidores[i][0].setBounds(10, y, 115, 20);
            chkServidores[i][0].addActionListener(this);
            chkServidores[i][0].setText(listaServ.get(i).getAlias());
            chkServidores[i][0].setFont(new Font("Thaoma", Font.BOLD, 12));
            chkServidores[i][0].setName(listaServ.get(i).getCategoria() + listaServ.get(i).getIp());
            pnlContCateServ.add(chkServidores[i][0]);
            chkServidores[i][0].setVisible(true);
            //Controles subir
            chkServidores[i][1] = new JCheckBox();
            chkServidores[i][1].setBounds(130, y, 20, 20);
            chkServidores[i][1].addActionListener(this);
            chkServidores[i][1].setFont(new Font("Thaoma", Font.BOLD, 12));
            chkServidores[i][1].setName(listaServ.get(i).getCategoria() + listaServ.get(i).getIp());
            pnlContCateServ.add(chkServidores[i][1]);
            chkServidores[i][1].setVisible(true);
            //Controles paneles para estatus
            pnlStatusServidores[i] = new JPanel();
            pnlStatusServidores[i].setBounds(160, y + 4, 18, 18);
            pnlStatusServidores[i].setBorder(BorderFactory.createLineBorder(Color.decode("#9933FF")));
            pnlStatusServidores[i].addMouseListener(this);
            pnlStatusServidores[i].setName(listaServ.get(i).getCategoria() + listaServ.get(i).getIp());//s de subir
            pnlContCateServ.add(pnlStatusServidores[i]);
            pnlStatusServidores[i].setVisible(true);

            if (i != numServidores - 1) {
                if (!listaServ.get(i).getCategoria().equals(listaServ.get(i + 1).getCategoria())) {
                    //Se diseña el panel y se agrega etiqueta del panel, y se muestra en el formulario

                    disenoPanelContenedor(pnlContCateServ, listaCate.get(ii).getEtiquetaCate());
                    pintaServidoresMasivo(listaServ.get(i).getCategoria(), y + 20);
                    ii++;
                    //Se crea un nuevo panel contenedory
                    swIncrementoY = 0;
                    pnlContCateServ = new JPanel();
                    pnlContCateServ.setLayout(null);
                    //pintar en el panel
                    cX += 230;
                    y = 10;
                    if (ii < 5) {//maximo de paneles primera fila
                        pnlContCateServ.setBounds(cX, 5, 230, 320);

                    } else {
                        if (ii < 10) {
                            if (ii == 5) {
                                cX = 105;
                            }
                            pnlContCateServ.setBounds(cX, 330, 230, 330);
                        } else {
                            JOptionPane.showConfirmDialog(null, "No se puede agregar mas paneles, el máximo es de 10");
                        }
                    }
                    pnlContCateServ.setBorder(BorderFactory.createLineBorder(Color.blue));
                }
            } else {
                disenoPanelContenedor(pnlContCateServ, listaCate.get(ii).getEtiquetaCate());
                pintaServidoresMasivo(listaServ.get(i).getCategoria(), y + 20);

            }
            //**************************************
            y = y + 20;
        }
        tabPane.add("UNIX", panelDelTab);
        panelDelTab.setVisible(true);
        formu.add(tabPane);
        tabPane.setVisible(true);
        formu.repaint();
//        //Se define Array valor
//        valor = new String[numServidores];
//        //Se obtiene datos como la maquina que ejecuta, esto es para crear archivos planos para lectura de status.
//        obtenerIp();
//        //Se da a todos los sw de hilos el valor 1
//        sw_hilo = new int[numServidores];
//        for (int i = 0; i < numServidores; i++) {
//            sw_hilo[i] = 1;
//        }
//        //instanciar los threads para  la visualizacion de status
//        threadhilo = new Thread[numServidores];
//        for (int i = 0; i < numServidores; i++) {
//            threadhilo[i] = new Thread(this);
//        }
    }

    private void redefineListaCate() {
        int numCategorias = listaCate.size();
        int numServidores = listaServ.size();
        int sw = 0;
        List<ConfiguracionCate> listaCate1;
        listaCate1 = listaCate;
        int i;
        for (i = 0; i < numCategorias; i++) {
            sw = 0;
            int i1;
            for (i1 = 0; i1 < numServidores; i1++) {
                if (listaCate1.get(i).getCate().equals(listaServ.get(i1).getCategoria())) {
                    sw = 1;
                    break;
                }

            }
            if (sw != 1) {//elimina item de listaCate
                for (int iii = i; iii < numCategorias - 1; iii++) {
                    listaCate1.set(iii, listaCate1.get(iii + 1));
                }
                numCategorias--;
                i--;
            }
        }
        listaCate = new ArrayList<>();
        ConfiguracionCate configCate;

        for (i = 0; i < numCategorias; i++) {
            configCate = new ConfiguracionCate();
            configCate.setEstado(listaCate1.get(i).getEstado());
            configCate.setCate(listaCate1.get(i).getCate());
            configCate.setEtiquetaCate(listaCate1.get(i).getEtiquetaCate());
            listaCate.add(configCate);
        }
    }

    private void disenoPanelContenedor(JPanel panel, String etiquetaCate) {
        JLabel etiqueta = new JLabel(etiquetaCate);
        etiqueta.setBounds(100, 10, 50, 10);
        etiqueta.setForeground(Color.decode("#6600CC"));
        panel.add(etiqueta);
        etiqueta.setVisible(true);
//        formu.add(panel);
        panelDelTab.add(panel);
        panel.setVisible(true);

    }

    /**
     * Este metodo permite pintar en el formulario los controles operacionales
     * masivos.
     *
     * @param cate es la categoria a pintar usando los controles operacionales
     * @param numCategorias es el numero de categorias habilitados para pintarse
     * @param y es la coordenada y donde se comenzara a pintar los controles
     * masivos para cata en el formulario masivos (Subir, bajar, status)
     */
    private void pintaServidoresMasivo(String cate, int y) {

        chkReinicio[ii][0] = new JCheckBox();
        String x = cate.toUpperCase().substring(0, 1) + cate.substring(1);
        chkReinicio[ii][0].setName("che" + x + "0All");
        chkReinicio[ii][0].setBounds(10, y + 5, 20, 20);
        chkReinicio[ii][0].addActionListener(this);
        chkReinicio[ii][1] = new JCheckBox();
        chkReinicio[ii][1].setName("che" + x + "1All");
        chkReinicio[ii][1].setBounds(130, y + 5, 20, 20);
        chkReinicio[ii][1].addActionListener(this);
        pnlContCateServ.add(chkReinicio[ii][0]);
        pnlContCateServ.add(chkReinicio[ii][1]);
        //Radio buton para status masivo
        rbtStatusServidoresM[ii] = new JRadioButton();
        rbtStatusServidoresM[ii].setName("rbt" + x + "Status");
        rbtStatusServidoresM[ii].setBounds(160, y + 5, 18, 18);
        rbtStatusServidoresM[ii].addActionListener(this);
        pnlContCateServ.add(rbtStatusServidoresM[ii]);
        //Etiquetas que dicen Stop y Start
        y = y + 20;
        JLabel lblStop = new JLabel("Stop");
        lblStop.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblStop.setBounds(10, y, 50, 20);
        lblStop.setForeground(Color.red);
        JLabel lblStart = new JLabel("Start");
        lblStart.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblStart.setBounds(130, y, 50, 20);
        lblStart.setForeground(Color.decode("#009900"));
        pnlContCateServ.add(lblStop);
        pnlContCateServ.add(lblStart);
        pnlContCateServ.repaint();
        ii++;

    }

    /**
     * Este metodo busca la coordenada de la categoria del servidor consultado.
     * leidos en el archivo plano, que ahora estan en una lista.
     *
     * @param listaServ es la categoria del servidor en cueatión. CateServidor
     * @param listaCate la lista que contiene todas las filas leidas de archivo
     * ConfiguracionCate plano configuracion
     */
    private int buscaCoordenadaY(String CateServidor, List<ConfiguracionCate> ListaCate) {
        int numCate = ListaCate.size();
        int y = 0;
        for (int i = 0; i < numCate; i++) {
            if (CateServidor.equals(ListaCate.get(i).getCate())) {
//                y = Integer.parseInt(ListaCate.get(i).getCoorY1());
                break;
            }
        }
        return y;
    }

//    private void definirOperaciones(String rutaAplicativo, String ruta, String nomComando, String usuario, String clave, String ip, String tipoOpe) {
//        ope = new Operaciones();
//        if (tipoOpe.equals("subir")) {
//            subirServicio = new Subir(ope);
//        }
//        if (tipoOpe.equals("bajar")) {
//            bajarServicio = new Bajar(ope);
//        }
//        if (tipoOpe.equals("estado")) {
//            statusServicio = new Estado(ope);
//        }
//    }
    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //INDIVIDUAL - Sirve para definir la accion al presionar cualquier control checkBox de servidor, ya sea para subir o bajar
        for (int j = 0; j < 2; j++) {//j es el indice del arreglo que indica los chkbox de servidores que se utilizan para bajar los servicios si es 0, o subir si es 1, son dos tipos subir y bajar por eso se pone 2 como limite
            for (int i = 0; i < numServidores; i++) {
                if (e.getSource() == chkServidores[i][j]) {
                    String ip = chkServidores[i][0].getName().substring(3);
                    String cate = chkServidores[i][0].getName().substring(0, 3);
                    ope = new Operaciones(rutaPlano, cate, ip, listaServ);
                    ser = new Servidor();
                    if (j == 0) {
                        activaBajarServidor("BAJAR", chkServidores[i][j]);

                    } else {
//                        activaBajarServidor("SUBIR");
                    }
                }
            }
        }

        //MASIVO - Sirve para definir la accion al presionar cualquier control checkBox de servidor, ya sea para subir o bajar
        for (int j = 0; j < 2; j++) {//j es el indice del arreglo que indica los chkbox de servidores que se utilizan para bajar los servicios si es 0, o subir si es 1, son dos tipos subir y bajar por eso se pone 2 como limite
            for (int i = 0; i < numCategorias; i++) {
                System.out.println(chkReinicio[i][j]);
                System.out.println(e.getSource());
                if (e.getSource() == chkReinicio[i][j]) {
                    String ip = "";
                    String cate = chkReinicio[i][0].getName().substring(3, 6).toLowerCase();
                    ope = new Operaciones(rutaPlano, cate, ip, listaServ);
                    ser = new Servidor();
                    if (j == 0) {
//                        activaBajarServidorMasivo(chkReinicio[i][0], chkReinicio[i][1]);//reinicio bajar "0"

                    } else {
//                        activaSubirServidorMasivo(chkReinicio[i][1], chkReinicio[i][0]);//reinicio Subir "1"
                        ser.ejecutaComando(new SubirM(ope));
                    }
                }
            }
        }
        //MASIVO - Sirve para consultar el estatus de una categoria en forma masiva

        for (int i = 0; i < numCategorias; i++) {
            if (e.getSource() == rbtStatusServidoresM[i]) {
//                activaStatusMasivo(rbtStatusServidoresM[i]);
            }
        }

    }
//Métodos de ejecución de operaciones, contiene validaciones. También crea la interacción entre controles de formularios.

    private void activaBajarServidor(String funcion, JCheckBox control) {

        int x = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea " + funcion + " los servicios del Servidor "+ control.getName() +" seleccionado?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if (x == 0) {
//            item = devuelveItem(controlB.getName().substring(3));//se lee de varaible estructurada que tiene el item del archivo de configuracion
//            con1.stopStartServidor(controlB.getName().substring(3), cate, rutas[0], rutas[1], 0, item[3], item[5]);//primer parametro se extrae  el ip, que es el nombre del control, segundo parametro es la categoria, el ultimo parametro es 1 si la accion es subir, y 0 si es bajar
//            controlS.setSelected(false);
            if (funcion.equals("BAJAR")) {
                ser.ejecutaComando(new Bajar(ope));
            } else {
                ser.ejecutaComando(new Subir(ope));
            }
        }
    }

}
