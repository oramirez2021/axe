/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author gsimonitor
 */
public class DBCon {
    
    Connection cn=null;
    String driver="sun.jdbc.odbc.JdbcOdbcDriver";
    String url="";
    public Connection conectar()
    {
        url="jdbc:odbc:dsnCms";
        //System.out.println("Entro a conectar "+dsn);
    try {
        Class.forName(driver);
        cn=DriverManager.getConnection(url,"sysadm","prta12jul");
    }
    catch(ClassNotFoundException e){
        JOptionPane.showMessageDialog(null,e.toString(),"Mensaje",JOptionPane.ERROR_MESSAGE );
    }
    catch(SQLException e){
        JOptionPane.showMessageDialog(null,e.toString(),"Mensaje",JOptionPane.ERROR_MESSAGE );
    }
    return cn;
    }
    public Connection desconectar(){
        try {
            Class.forName(driver);
            
            cn.close();
            //*******************************
            
        }
        catch(ClassNotFoundException e){
        JOptionPane.showMessageDialog(null,e.toString(),"Mensaje",JOptionPane.ERROR_MESSAGE );
    }
        catch(SQLException e){
        JOptionPane.showMessageDialog(null,e.toString(),"Mensaje",JOptionPane.ERROR_MESSAGE );
    }
        return cn;
    }
}
