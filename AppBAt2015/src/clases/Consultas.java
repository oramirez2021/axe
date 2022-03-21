/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import paquete.frmBat1;
import util.DBCon;

/**
 *
 * @author gsimonitor
 */
public class Consultas {
    PreparedStatement pstm=null;
    ResultSet rss=null;
    DBCon cn1=new DBCon();
    //Objeto que permite ejecutar un BAT
    int found=0;
//che es control checkBox de formulario
   public void StopOas(int c){
       String oas="";
        try{
        switch (c)  {
            case 1:oas="Stop130.2.0.32oas.bat";break;
            case 2:oas="Stop130.2.18.194oas.bat";break;              
            case 3:oas="Stop192.168.10.25oas.bat";break;
            case 4:oas="Stop192.168.21.8oas.bat";break;                
    }   
        if(c!=0){
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\oas\\"+oas);
        }else{
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\oas\\Stop130.2.0.32oas.bat");
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\oas\\Stop130.2.18.194oas.bat");
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\oas\\Stop192.168.10.25oas.bat");
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\oas\\Stop192.168.21.8oas.bat");
        }
            
}
catch(IOException e){
    System.out.println(e.toString());
}
    }
   public void StartOas(int c){
       String oas="";
        try{
        switch (c)  {
            case 1:oas="Start130.2.0.32oas.bat";break;
            case 2:oas="Start130.2.18.194oas.bat";break;              
            case 3:oas="Start192.168.10.25oas.bat";break;
            case 4:oas="Start192.168.21.8oas.bat";break;                
    } 
         if(c!=0){
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\oas\\"+oas);
        }else{
        System.out.println("entro y se hizo todo");
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\oas\\Start130.2.0.32oas.bat");
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\oas\\Start130.2.18.194oas.bat");
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\oas\\Start192.168.10.25oas.bat");
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\oas\\Start192.168.21.8oas.bat");
        }
}
catch(IOException e){
    System.out.println(e.toString());
}
    }
    public void StopIas(int c){
       String ser="";
       String ias="";
        try{
        switch (c)  {
            case 1:ser="192.168.10.31";ias="Stop192.168.10.31ias.bat " +LeerClave(ser,"ias")[1];break;
            case 2:ser="192.168.21.168";ias="Stop192.168.21.168ias.bat "+LeerClave(ser,"ias")[1];break;              
            case 3:ser="192.168.21.172";ias="Stop192.168.21.172ias.bat "+LeerClave(ser,"ias")[1];break;
            case 4:ser="192.168.21.173";ias="Stop192.168.21.173ias.bat "+LeerClave(ser,"ias")[1];break;               
            case 5:ser="192.168.21.174";ias="Stop192.168.21.174ias.bat "+LeerClave(ser,"ias")[1];break;
            case 6:ser="192.168.21.175";ias="Stop192.168.21.175ias.bat "+LeerClave(ser,"ias")[1];break;
            case 7:ser="192.168.21.176";ias="Stop192.168.21.176ias.bat "+LeerClave(ser,"ias")[1];break;
            case 8:ser="192.168.21.177";ias="Stop192.168.21.177ias.bat "+LeerClave(ser,"ias")[1];break;
            case 9:ser="192.168.21.178";ias="Stop192.168.21.178ias.bat "+LeerClave(ser,"ias")[1];break;
            case 10:ser="130.2.80.174";ias="Stop130.2.80.174ias.bat "+LeerClave(ser,"ias")[1];break;
    } 
         if(c!=0){
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ias\\"+ias);
        }else{
        ser="192.168.10.31";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ias\\"+"Stop192.168.10.31ias.bat " +LeerClave(ser,"ias")[1]);
        ser="192.168.21.168";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ias\\"+"Stop192.168.21.168ias.bat "+LeerClave(ser,"ias")[1]);
        ser="192.168.21.172";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ias\\"+"Stop192.168.21.172ias.bat "+LeerClave(ser,"ias")[1]);
        ser="192.168.21.173";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ias\\"+"Stop192.168.21.173ias.bat "+LeerClave(ser,"ias")[1]);
        ser="192.168.21.174";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ias\\"+"Stop192.168.21.174ias.bat "+LeerClave(ser,"ias")[1]);
        ser="192.168.21.175";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ias\\"+"Stop192.168.21.175ias.bat "+LeerClave(ser,"ias")[1]);
        ser="192.168.21.176";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ias\\"+"Stop192.168.21.176ias.bat "+LeerClave(ser,"ias")[1]);
        ser="192.168.21.177";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ias\\"+"Stop192.168.21.177ias.bat "+LeerClave(ser,"ias")[1]);
        ser="192.168.21.178";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ias\\"+"Stop192.168.21.178ias.bat "+LeerClave(ser,"ias")[1]);
        ser="130.2.80.174";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ias\\"+"Stop130.2.80.174ias.bat "+LeerClave(ser,"ias")[1]);
        }
}
catch(IOException e){
    System.out.println(e.toString());
}
    }
    public void StartIas(int c){
       String ser="";
       String ias="";
        try{
        switch (c)  {
            case 1:ser="192.168.10.31";ias="Start192.168.10.31ias.bat " +LeerClave(ser,"ias")[1];break;
            case 2:ser="192.168.21.168";ias="Start192.168.21.168ias.bat "+LeerClave(ser,"ias")[1];break;              
            case 3:ser="192.168.21.172";ias="Start192.168.21.172ias.bat "+LeerClave(ser,"ias")[1];break;
            case 4:ser="192.168.21.173";ias="Start192.168.21.173ias.bat "+LeerClave(ser,"ias")[1];break;               
            case 5:ser="192.168.21.174";ias="Start192.168.21.174ias.bat "+LeerClave(ser,"ias")[1];break;
            case 6:ser="192.168.21.175";ias="Start192.168.21.175ias.bat "+LeerClave(ser,"ias")[1];break;
            case 7:ser="192.168.21.176";ias="Start192.168.21.176ias.bat "+LeerClave(ser,"ias")[1];break;
            case 8:ser="192.168.21.177";ias="Start192.168.21.177ias.bat "+LeerClave(ser,"ias")[1];break;
            case 9:ser="192.168.21.178";ias="Start192.168.21.178ias.bat "+LeerClave(ser,"ias")[1];break;
            case 10:ser="130.2.80.174";ias="Start130.2.80.174ias.bat "+LeerClave(ser,"ias")[1];break;
    } 
         if(c!=0){
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ias\\"+ias);
        }else{
        ser="192.168.10.31";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ias\\"+"Start192.168.10.31ias.bat " +LeerClave(ser,"ias")[1]);
        ser="192.168.21.168";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ias\\"+"Start192.168.21.168ias.bat "+LeerClave(ser,"ias")[1]);
        ser="192.168.21.172";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ias\\"+"Start192.168.21.172ias.bat "+LeerClave(ser,"ias")[1]);
        ser="192.168.21.173";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ias\\"+"Start192.168.21.173ias.bat "+LeerClave(ser,"ias")[1]);
        ser="192.168.21.174";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ias\\"+"Start192.168.21.174ias.bat "+LeerClave(ser,"ias")[1]);
        ser="192.168.21.175";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ias\\"+"Start192.168.21.175ias.bat "+LeerClave(ser,"ias")[1]);
        ser="192.168.21.176";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ias\\"+"Start192.168.21.176ias.bat "+LeerClave(ser,"ias")[1]);
        ser="192.168.21.177";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ias\\"+"Start192.168.21.177ias.bat "+LeerClave(ser,"ias")[1]);
        ser="192.168.21.178";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ias\\"+"Start192.168.21.178ias.bat "+LeerClave(ser,"ias")[1]);
        ser="130.2.80.174";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ias\\"+"Start130.2.80.174ias.bat "+LeerClave(ser,"ias")[1]);
        }
}
catch(IOException e){
    System.out.println(e.toString());
}
    }
    public void StopUssd(int c){
       String uss="";
        try{
        switch (c)  {
            case 1:uss="Stop130.2.18.12uss.bat";break;
            case 2:uss="Stop130.2.18.186uss.bat";break;              
            case 3:uss="Stop130.2.18.23uss.bat";break;
            case 4:uss="Stop130.2.18.145uss.bat";break;               
            case 5:uss="Stop130.2.18.43uss.bat";break;
            
    } 
         if(c!=0){
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\uss\\"+uss);
        }else{
       Runtime.getRuntime().exec("cmd /c start C:\\servicios\\uss\\Stop130.2.18.12uss.bat");
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\uss\\Stop130.2.18.186uss.bat");
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\uss\\Stop130.2.18.23uss.bat");
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\uss\\Stop130.2.18.145uss.bat");
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\uss\\Stop130.2.18.43uss.bat");
        }
}
catch(IOException e){
    System.out.println(e.toString());
}
    }
    public void StartUssd(int c){
       String uss="";
        try{
        switch (c)  {
            case 1:uss="Start130.2.18.12uss.bat";break;
            case 2:uss="Start130.2.18.186uss.bat";break;              
            case 3:uss="Start130.2.18.23uss.bat";break;
            case 4:uss="Start130.2.18.145uss.bat";break;               
            case 5:uss="Start130.2.18.43uss.bat";break;
            
    } 
         if(c!=0){
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\uss\\"+uss);
        }else{
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\uss\\Start130.2.18.12uss.bat");
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\uss\\Start130.2.18.186uss.bat");
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\uss\\Start130.2.18.23uss.bat");
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\uss\\Start130.2.18.145uss.bat");
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\uss\\Start130.2.18.43uss.bat");
        }
}
catch(IOException e){
    System.out.println(e.toString());
}
    }
    public void StopHub(int c){
       String ser="";
       String hub="";
        try{
        switch (c)  {
            case 1:ser="130.2.18.126";hub="Stop130.2.18.126hub.bat " +LeerClave(ser,"hub")[0]+","+LeerClave(ser,"hub")[1];break;
            case 2:ser="130.2.17.34";hub="Stop130.2.17.34hub.bat "+LeerClave(ser,"hub")[0]+","+LeerClave(ser,"hub")[1];break;              
            case 3:ser="192.168.35.192";hub="Stop192.168.35.192hub.bat "+LeerClave(ser,"hub")[0]+","+LeerClave(ser,"hub")[1];break;
            case 4:ser="130.2.17.151";hub="Stop130.2.17.151hub.bat "+LeerClave(ser,"hub")[0]+","+LeerClave(ser,"hub")[1];break;               
    } 
         if(c!=0){
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\hub\\"+hub);
        }else{
        ser="130.2.18.126";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\hub\\"+"Stop130.2.18.126hub.bat " +LeerClave(ser,"hub")[0]+","+LeerClave(ser,"hub")[1]);
        ser="130.2.17.34";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\hub\\"+"Stop130.2.17.34hub.bat "+LeerClave(ser,"hub")[0]+","+LeerClave(ser,"hub")[1]);
        ser="192.168.35.192";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\hub\\"+"Stop192.168.35.192hub.bat "+LeerClave(ser,"hub")[0]+","+LeerClave(ser,"hub")[1]);
        ser="130.2.17.151";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\hub\\"+"Stop130.2.17.151hub.bat "+LeerClave(ser,"hub")[0]+","+LeerClave(ser,"hub")[1]);
        }
}
catch(IOException e){
    System.out.println(e.toString());
}
    }
    public void StartHub(int c){
       String ser="";
       String hub="";
        try{
        switch (c)  {
            case 1:ser="130.2.18.126";hub="Start130.2.18.126hub.bat " +LeerClave(ser,"hub")[0]+","+LeerClave(ser,"hub")[1];break;
            case 2:ser="130.2.17.34";hub="Start130.2.17.34hub.bat "+LeerClave(ser,"hub")[0]+","+LeerClave(ser,"hub")[1];break;              
            case 3:ser="192.168.35.192";hub="Start192.168.35.192hub.bat "+LeerClave(ser,"hub")[0]+","+LeerClave(ser,"hub")[1];break;
            case 4:ser="130.2.17.151";hub="Start130.2.17.151hub.bat "+LeerClave(ser,"hub")[0]+","+LeerClave(ser,"hub")[1];break;               
    } 
         if(c!=0){
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\hub\\"+hub);
        }else{
        ser="130.2.18.126";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\hub\\"+"Start130.2.18.126hub.bat " +LeerClave(ser,"hub")[0]+","+LeerClave(ser,"hub")[1]);
        ser="130.2.17.34";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\hub\\"+"Start130.2.17.34hub.bat "+LeerClave(ser,"hub")[0]+","+LeerClave(ser,"hub")[1]);
        ser="192.168.35.192";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\hub\\"+"Start192.168.35.192hub.bat "+LeerClave(ser,"hub")[0]+","+LeerClave(ser,"hub")[1]);
        ser="130.2.17.151";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\hub\\"+"Start130.2.17.151hub.bat "+LeerClave(ser,"hub")[0]+","+LeerClave(ser,"hub")[1]);
        }
}
catch(IOException e){
    System.out.println(e.toString());
}
    }
    public void StopIde(int c){
       String ser="";
       String ide="";
        try{
        switch (c)  {
            case 1:ser="130.2.18.226";ide="Stop130.2.18.226ide.bat " +LeerClave(ser,"ide")[0]+","+LeerClave(ser,"ide")[1];break;
            case 2:ser="130.2.18.203";ide="Stop130.2.18.203ide.bat "+LeerClave(ser,"ide")[0]+","+LeerClave(ser,"ide")[1];break;              
            case 3:ser="130.2.18.214";ide="Stop130.2.18.214ide.bat "+LeerClave(ser,"ide")[0]+","+LeerClave(ser,"ide")[1];break;
            case 4:ser="130.2.18.216";ide="Stop130.2.18.216ide.bat "+LeerClave(ser,"ide")[0]+","+LeerClave(ser,"ide")[1];break;               
            case 5:ser="130.2.18.212";ide="Stop130.2.18.212ide.bat "+LeerClave(ser,"ide")[0]+","+LeerClave(ser,"ide")[1];break;               
            case 6:ser="130.2.18.243";ide="Stop130.2.18.243ide.bat "+LeerClave(ser,"ide")[0]+","+LeerClave(ser,"ide")[1];break;               
            case 7:ser="130.2.18.20";ide="Stop130.2.18.20ide.bat "+LeerClave(ser,"ide")[0]+","+LeerClave(ser,"ide")[1];break;
            case 8:ser="130.2.18.233";ide="Stop130.2.18.233ide.bat "+LeerClave(ser,"ide")[0]+","+LeerClave(ser,"ide")[1];break;
            case 9:ser="192.168.35.47";ide="Stop192.168.35.47ide.bat "+LeerClave(ser,"ide")[0]+","+LeerClave(ser,"ide")[1];break;
        } 
         if(c!=0){
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ide\\"+ide);
        }else{
        ser="130.2.18.226";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ide\\"+"Stop130.2.18.226ide.bat " +LeerClave(ser,"ide")[0]+","+LeerClave(ser,"ide")[1]);
        ser="130.2.18.203";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ide\\"+"Stop130.2.18.203ide.bat "+LeerClave(ser,"ide")[0]+","+LeerClave(ser,"ide")[1]);
        ser="130.2.18.214";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ide\\"+"Stop130.2.18.214ide.bat "+LeerClave(ser,"ide")[0]+","+LeerClave(ser,"ide")[1]);
        ser="130.2.18.216";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ide\\"+"Stop130.2.18.216ide.bat "+LeerClave(ser,"ide")[0]+","+LeerClave(ser,"ide")[1]);
        ser="130.2.18.212";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ide\\"+"Stop130.2.18.212ide.bat "+LeerClave(ser,"ide")[0]+","+LeerClave(ser,"ide")[1]);
        ser="130.2.18.243";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ide\\"+"Stop130.2.18.243ide.bat "+LeerClave(ser,"ide")[0]+","+LeerClave(ser,"ide")[1]);
        ser="130.2.18.20";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ide\\"+"Stop130.2.18.20ide.bat "+LeerClave(ser,"ide")[0]+","+LeerClave(ser,"ide")[1]);
        ser="130.2.18.233";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ide\\"+"Stop130.2.18.233ide.bat "+LeerClave(ser,"ide")[0]+","+LeerClave(ser,"ide")[1]);
        ser="192.168.35.47";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ide\\"+"Stop192.168.35.47ide.bat "+LeerClave(ser,"ide")[0]+","+LeerClave(ser,"ide")[1]);
        }
}
catch(IOException e){
    System.out.println(e.toString());
}
    } 
    public void StartIde(int c){
       String ser="";
       String ide="";
        try{
        switch (c)  {
             case 1:ser="130.2.18.226";ide="Start130.2.18.226ide.bat " +LeerClave(ser,"ide")[0]+","+LeerClave(ser,"ide")[1];break;
            case 2:ser="130.2.18.203";ide="Start130.2.18.203ide.bat "+LeerClave(ser,"ide")[0]+","+LeerClave(ser,"ide")[1];break;              
            case 3:ser="130.2.18.214";ide="Start130.2.18.214ide.bat "+LeerClave(ser,"ide")[0]+","+LeerClave(ser,"ide")[1];break;
            case 4:ser="130.2.18.216";ide="Start130.2.18.216ide.bat "+LeerClave(ser,"ide")[0]+","+LeerClave(ser,"ide")[1];break;               
            case 5:ser="130.2.18.212";ide="Start130.2.18.212ide.bat "+LeerClave(ser,"ide")[0]+","+LeerClave(ser,"ide")[1];break;               
            case 6:ser="130.2.18.243";ide="Start130.2.18.243ide.bat "+LeerClave(ser,"ide")[0]+","+LeerClave(ser,"ide")[1];break;               
            case 7:ser="130.2.18.20";ide="Start130.2.18.20ide.bat "+LeerClave(ser,"ide")[0]+","+LeerClave(ser,"ide")[1];break;
            case 8:ser="130.2.18.233";ide="Start130.2.18.233ide.bat "+LeerClave(ser,"ide")[0]+","+LeerClave(ser,"ide")[1];break;
            case 9:ser="192.168.35.47";ide="Start192.168.35.47ide.bat "+LeerClave(ser,"ide")[0]+","+LeerClave(ser,"ide")[1];break;
    } 
         if(c!=0){
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ide\\"+ide);
        }else{
        ser="130.2.18.226";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ide\\"+"Start130.2.18.226ide.bat " +LeerClave(ser,"ide")[0]+","+LeerClave(ser,"ide")[1]);
        ser="130.2.18.203";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ide\\"+"Start130.2.18.203ide.bat "+LeerClave(ser,"ide")[0]+","+LeerClave(ser,"ide")[1]);
        ser="130.2.18.214";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ide\\"+"Stop130.2.18.214ide.bat "+LeerClave(ser,"ide")[0]+","+LeerClave(ser,"ide")[1]);
        ser="130.2.18.216";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ide\\"+"Start130.2.18.216ide.bat "+LeerClave(ser,"ide")[0]+","+LeerClave(ser,"ide")[1]);
        ser="130.2.18.212";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ide\\"+"Start130.2.18.212ide.bat "+LeerClave(ser,"ide")[0]+","+LeerClave(ser,"ide")[1]);
        ser="130.2.18.243";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ide\\"+"Start130.2.18.243ide.bat "+LeerClave(ser,"ide")[0]+","+LeerClave(ser,"ide")[1]);
        ser="130.2.18.20";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ide\\"+"Start130.2.18.20ide.bat "+LeerClave(ser,"ide")[0]+","+LeerClave(ser,"ide")[1]);
        ser="130.2.18.233";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ide\\"+"Start130.2.18.233ide.bat "+LeerClave(ser,"ide")[0]+","+LeerClave(ser,"ide")[1]);
        ser="192.168.35.47";
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ide\\"+"Start192.168.35.47ide.bat "+LeerClave(ser,"ide")[0]+","+LeerClave(ser,"ide")[1]);
        }
}
catch(IOException e){
    System.out.println(e.toString());
}
    }
    public void StopCmsM(int c){
       String cms1="";
       String cms2=";";
        try{
        switch (c)  {
            case 1:cms1="Stop130.2.120.13cmsM.bat";cms2="Status130.2.120.13cmsM.bat 2";break;
            case 2:cms1="Stop130.2.120.14cmsM.bat";cms2="Status130.2.120.14cmsM.bat 2";break;
            case 3:cms1="Stop130.2.120.15cmsM.bat";cms2="Status130.2.120.15cmsM.bat 2";break;
    }   
        if(c!=0){
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\cmsM\\"+cms1);
        Thread.sleep(5000);
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\cmsM\\"+cms2);
        }
            
}
        catch(InterruptedException ex){
    System.out.println(ex.toString());
}
catch(IOException e){
    System.out.println(e.toString());
}
    }
    public void StartCmsM(int c){
       String cms1="";
       String cms2="";
        try{
        switch (c)  {
            case 1:cms1="Start130.2.120.13cmsM.bat";cms2="Status130.2.120.13cmsM.bat 1";break;
            case 2:cms1="Start130.2.120.14cmsM.bat";cms2="Status130.2.120.14cmsM.bat 1";break;
            case 3:cms1="Start130.2.120.15cmsM.bat";cms2="Status130.2.120.15cmsM.bat 1";break;
    }   
        if(c!=0){
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\cmsM\\"+cms1);
        Thread.sleep(5000);
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\cmsM\\"+cms2);
        }
            
}
catch(IOException e){
    System.out.println(e.toString());
}
catch(InterruptedException ex){
    System.out.println(ex.toString());
}
    }
    public void StopCmsN(int c){
       String cms1="";
       String cms2="";
        try{
        switch (c)  {
            case 1:cms1="Stop130.2.120.10cmsN.bat";cms2="Status130.2.120.10cmsN.bat 2";break;
            case 2:cms1="Stop130.2.120.11cmsN.bat";cms2="Status130.2.120.11cmsN.bat 2";break;
            case 3:cms1="Stop130.2.120.12cmsN.bat";cms2="Status130.2.120.12cmsN.bat 2";break;
    }   
        if(c!=0){
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\cmsN\\"+cms1);
        Thread.sleep(5000);
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\cmsN\\"+cms2);
        }
}
        catch(InterruptedException ex){
    System.out.println(ex.toString());
}
catch(IOException e){
    System.out.println(e.toString());
}
    }
    public void StartCmsN(int c){
       String cms1="";
       String cms2="";
        try{
        switch (c)  {
            case 1:cms1="Start130.2.120.10cmsN.bat";cms2="Status130.2.120.10cmsN.bat 1";break;
            case 2:cms1="Start130.2.120.11cmsN.bat";cms2="Status130.2.120.11cmsN.bat 1";break;
            case 3:cms1="Start130.2.120.12cmsN.bat";cms2="Status130.2.120.12cmsN.bat 1";break;
    }   
        if(c!=0){
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\cmsN\\"+cms1);
        Thread.sleep(5000);
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\cmsN\\"+cms2);
        }
}
catch(IOException e){
    System.out.println(e.toString());
}
catch(InterruptedException ex){
    System.out.println(ex.toString());
}
    }    
    public void StatusOas1(String ser){
        String valor="";
      try{
          //Ejecuto el bat enviandole la clave leida del archivo server.cfg de la ruta compartida.
          //Esto a su vez crea los archivos bat por cada servidor.
          Runtime.getRuntime().exec("cmd /c start C:\\servicios\\oas\\"+"Status"+ser+"oas.bat");
       
        }
      
        catch(IOException e){
        System.out.println(e.toString());
        }
    }
    
    public void StatusIas1(String ser){
        String valor="";
      try{
          //Ejecuto el bat enviandole la clave leida del archivo server.cfg de la ruta compartida.
          //Esto a su vez crea los archivos bat por cada servidor.
          Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ias\\"+"Status"+ser+"ias.bat " +LeerClave(ser,"ias")[1]);
       
        }
      
        catch(IOException e){
        System.out.println(e.toString());
        }
//       return valor;
    }
    public void StatusUss1(String ser){
        String valor="";
      try{
          //Ejecuto el bat enviandole la clave leida del archivo server.cfg de la ruta compartida.
          //Esto a su vez crea los archivos bat por cada servidor.
          Runtime.getRuntime().exec("cmd /c start C:\\servicios\\uss\\"+"Status"+ser+"uss.bat");
       
        }
      
        catch(IOException e){
        System.out.println(e.toString());
        }
    }
    public void StatusHub1(String ser){
        String valor="";
      try{
          //Ejecuto el bat enviandole la clave leida del archivo server.cfg de la ruta compartida.
          //Esto a su vez crea los archivos bat por cada servidor.
          Runtime.getRuntime().exec("cmd /c start C:\\servicios\\hub\\"+"Status"+ser+"hub.bat " +LeerClave(ser,"hub")[0]+","+LeerClave(ser,"hub")[1]);
       
        }
      
        catch(IOException e){
        System.out.println(e.toString());
        }
//       return valor;
    }
     public void StatusIde1(String ser){
        String valor="";
      try{
          //Ejecuto el bat enviandole la clave leida del archivo server.cfg de la ruta compartida.
          //Esto a su vez crea los archivos bat por cada servidor.
          Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ide\\"+"Status"+ser+"ide.bat " +LeerClave(ser,"ide")[0]+","+LeerClave(ser,"ide")[1]);
       
        }
      
        catch(IOException e){
        System.out.println(e.toString());
        }
//       return valor;
    }
     public String valorStatus(String ser, String servicio, String tipo){
         //Contador de intentos de creacion de archivo!
         //int c=1;
        String valor="";
          try {
            //Se define si la solucitud es masiva, o puntual
            if(tipo.equals("m")){
                Thread.sleep(30000);
            }else{
                Thread.sleep(7000);
            }
            System.out.println("Hola");
            } catch (InterruptedException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
            }
        try {
            File f=new File("c:\\servicios\\"+servicio+"\\"+ser+".txt");
            try {
                FileReader fr;
                fr = new FileReader(f);
                BufferedReader br=new BufferedReader(fr);
                valor=br.readLine();
                br.close();
                fr.close();
            } catch (FileNotFoundException ex) {
                System.out.println(ex.toString());
                found=0;
           }
        }
            catch (IOException ex) {
                Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            found=1;
       try{
       return valor.trim();
       }catch(Exception e){
           System.out.println("archivo vacio");
           valor="";
           return valor;
       }
    }
     public String valorStatusCms(String ser, String servicio,String ope){
         //Contador de intentos de creacion de archivo!
         //int c=1;
        String valor="";
        try {
            File f;
            if(ope.equals("subir")){
            f=new File("c:\\servicios\\"+servicio+"\\"+ser+".txt");
            }else{
                    if(ope.equals("actual")){
                        f=new File("c:\\servicios\\"+servicio+"\\"+ser+"act.txt");    
                    }else{
                        f=new File("c:\\servicios\\"+servicio+"\\"+ser+"abajo.txt");    
                    }
            }
            try {
                FileReader fr;
                fr = new FileReader(f);
                BufferedReader br=new BufferedReader(fr);
                valor=br.readLine();
                br.close();
                fr.close();
            } catch (FileNotFoundException ex) {
                System.out.println(ex.toString());
           }
        }
            catch (IOException ex) {
                Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                
            }
       try{
       System.out.println(valor.trim());
       return valor.trim();
       }catch(Exception e){
           System.out.println("archivo vacio");
           valor="";
           return valor;
       }
    }
//     public void arcVac(String ser, String servicio){
//         try {
//            File f=new File("c:\\servicios\\"+servicio+"\\"+ser+".txt");
//            try {
//                FileWriter fw;
//                fw = new FileWriter(f);
//                BufferedWriter bw=new BufferedWriter(fw);
//                bw.write("");
//                bw.close();
//                fw.close();
//            } catch (FileNotFoundException ex) {
//                System.out.println(ex.toString());
//           }
//        }catch(Exception ex){
//            System.out.println(ex.toString());
//        }
//     }
    public void StatusUssd(int c){
       String uss="";
        try{
        switch (c)  {
            case 1:uss="Status130.2.18.12Solo.bat";break;
            case 2:uss="Status130.2.18.186DOS.bat";break;              
            case 3:uss="Status130.2.18.23CUA.bat";break;
            case 4:uss="Status130.2.18.145SEIS.bat";break;               
            case 5:uss="Status130.2.18.43seisC.bat";break;
            
        } 
         if(c!=0){
        Runtime.getRuntime().exec("cmd /c start C:\\servicios\\ussd\\"+uss);
        }
}
catch(IOException e){
    System.out.println(e.toString());
}
    }
    //lectura de claves ias desde una carpeta compartida como unidad virtual
    //servidor windows 130.2.18.156

    public String[] LeerClave(String servidor,String servicio){
        String ip="";
        //Arreglo que almacena los datos requeridos del archivo plano
        String[] datos=new String[2];
        StringTokenizer tk=null;
        File f=null;
        if(servicio.equals("ias")){
        f=new File("Z:\\servers.cfg");    
        }
        if(servicio.equals("hub") || servicio.equals("ide")){
        f=new File("Z:\\servers1.cfg");       
        }
        FileReader fr;
       try {
           fr = new FileReader(f);
           BufferedReader br=new BufferedReader(fr);
           //br.
           String linea="";
           while((linea=br.readLine())!=null){
               //lee la linea
               tk=new StringTokenizer(linea,",");
               int c=0;
               while(tk.hasMoreTokens()){
                   c++;
                   ip=tk.nextElement().toString();
                   if(ip.equals(servidor)){
                        System.out.println(c);
                        System.out.println(ip);
                        datos[0]=tk.nextElement().toString();
                        datos[1]=tk.nextElement().toString();
                   }
               }
           }
           
          fr.close();
          br.close();
       } catch (FileNotFoundException ex) {
           Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException ex) {
           Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
       }
      
      
       return datos; 
    }
    //Corredor de Ias
     public String CorreIas0(String tipo){
         StatusIas1("192.168.10.31");
         String x=valorStatus("192.168.10.31","ias",tipo);
         return x;
    }
    public String CorreIas1(String tipo){
        StatusIas1("192.168.21.168");
        String x=valorStatus("192.168.21.168","ias",tipo);
        return x;
    }
    public String CorreIas2(String tipo){
        StatusIas1("192.168.21.172");
        String x=valorStatus("192.168.21.172","ias",tipo);
        return x;
    }
    public String CorreIas3(String tipo){
          StatusIas1("192.168.21.173");
        String x=valorStatus("192.168.21.173","ias",tipo);
        return x;
    }
    public String CorreIas4(String tipo){
          StatusIas1("192.168.21.174");
          String x= valorStatus("192.168.21.174","ias",tipo);
         return x;
    }
    public String CorreIas5(String tipo){
          StatusIas1("192.168.21.175");
          String x=valorStatus("192.168.21.175","ias",tipo);;
         return x;
    }
    public String CorreIas6(String tipo){
          StatusIas1("192.168.21.176");
         String x=valorStatus("192.168.21.176","ias",tipo);
         return x;
    }
    public String CorreIas7(String tipo){
          StatusIas1("192.168.21.177");
          String x=valorStatus("192.168.21.177","ias",tipo);
         return x;
    }
    public String CorreIas8(String tipo){
          StatusIas1("192.168.21.178");
         String x=valorStatus("192.168.21.178","ias",tipo);
        return x;
    }
    public String CorreIas9(String tipo){
          StatusIas1("130.2.80.174");
           String x=valorStatus("130.2.80.174","ias",tipo);
        return x;
    }
   //Corredro de Hub para Status
    public String CorreHub0(String tipo){
         StatusHub1("130.2.18.126");
         String x=valorStatus("130.2.18.126","hub",tipo);
         return x;
    }
    public String CorreHub1(String tipo){
        StatusHub1("130.2.17.34");
        String x=valorStatus("130.2.17.34","hub",tipo);
        return x;
    }
    public String CorreHub2(String tipo){
        StatusHub1("192.168.35.192");
        String x=valorStatus("192.168.35.192","hub",tipo);
        return x;
    }
    public String CorreHub3(String tipo){
          StatusHub1("130.2.17.151");
        String x=valorStatus("130.2.17.151","hub",tipo);
        return x;
        
    }
    //Corredro de Ide para Status
    public String CorreIde0(String tipo){
         StatusIde1("130.2.18.226");
         String x=valorStatus("130.2.18.226","ide",tipo);
         return x;
    }
    public String CorreIde1(String tipo){
        StatusIde1("130.2.18.203");
        String x=valorStatus("130.2.18.203","ide",tipo);
        return x;
    }
    public String CorreIde2(String tipo){
        StatusIde1("130.2.18.214");
        String x=valorStatus("130.2.18.214","ide",tipo);
        return x;
    }
    public String CorreIde3(String tipo){
          StatusIde1("130.2.18.216");
        String x=valorStatus("130.2.18.216","ide",tipo);
        return x;
    }
    public String CorreIde4(String tipo){
          StatusIde1("130.2.18.212");
        String x=valorStatus("130.2.18.212","ide",tipo);
        return x;
    }
    public String CorreIde5(String tipo){
          StatusIde1("130.2.18.243");
        String x=valorStatus("130.2.18.243","ide",tipo);
        return x;
    }
    public String CorreIde6(String tipo){
          StatusIde1("130.2.18.20");
        String x=valorStatus("130.2.18.20","ide",tipo);
        return x;
    }
    public String CorreIde7(String tipo){
          StatusIde1("130.2.18.233");
        String x=valorStatus("130.2.18.233","ide",tipo);
        return x;
    }
    public String CorreIde8(String tipo){
          StatusIde1("192.168.35.47");
        String x=valorStatus("192.168.35.47","ide",tipo);
        return x;
    }
   //Corredor de oas
     public String CorreOas0(String tipo){
         StatusOas1("130.2.0.32");
         String x=valorStatus("130.2.0.32","oas",tipo);
         return x;
    }
    public String CorreOas1(String tipo){
        StatusOas1("130.2.18.194");
        String x=valorStatus("130.2.18.194","oas",tipo);
        return x;
    }
    public String CorreOas2(String tipo){
        StatusOas1("192.168.10.25");
        String x=valorStatus("192.168.10.25","oas",tipo);
        return x;
    }
    public String CorreOas3(String tipo){
          StatusOas1("192.168.21.8");
        String x=valorStatus("192.168.21.8","oas",tipo);
        return x;
    }
    //Corredor de ussd
     public String CorreUss0(String tipo){
         StatusUss1("130.2.18.12");
         String x=valorStatus("130.2.18.12","uss",tipo);
         return x;
    }
    public String CorreUss1(String tipo){
        StatusUss1("130.2.18.186");
        String x=valorStatus("130.2.18.186","uss",tipo);
        return x;
    }
    public String CorreUss2(String tipo){
        StatusUss1("130.2.18.23");
        String x=valorStatus("130.2.18.23","uss",tipo);
        return x;
    }
    public String CorreUss3(String tipo){
          StatusUss1("130.2.18.145");
        String x=valorStatus("130.2.18.145","uss",tipo);
        return x;
    }
    public String CorreUss4(String tipo){
          StatusUss1("130.2.18.43");
        String x=valorStatus("130.2.18.43","uss",tipo);
        return x;
    }
    //
     public void CorreCms15(String ser){
       try{
          //Ejecuto el bat enviandole la clave leida del archivo server.cfg de la ruta compartida.
          //Esto a su vez crea los archivos bat por cada servidor.
          Runtime.getRuntime().exec("cmd /c start C:\\servicios\\cmsM\\Status"+ser+"cmsM.bat 3");
       
        }
      
        catch(IOException e){
        System.out.println(e.toString());
        }    
    }
     public void CorreCms14(String ser){
       try{
          //Ejecuto el bat enviandole la clave leida del archivo server.cfg de la ruta compartida.
          //Esto a su vez crea los archivos bat por cada servidor.
          Runtime.getRuntime().exec("cmd /c start C:\\servicios\\cmsM\\Status"+ser+"cmsM.bat 3");
       
        }
      
        catch(IOException e){
        System.out.println(e.toString());
        }    
    }
     public void CorreCms13(String ser){
       try{
          //Ejecuto el bat enviandole la clave leida del archivo server.cfg de la ruta compartida.
          //Esto a su vez crea los archivos bat por cada servidor.
          Runtime.getRuntime().exec("cmd /c start C:\\servicios\\cmsM\\Status"+ser+"cmsM.bat 3");
       
        }
      
        catch(IOException e){
        System.out.println(e.toString());
        }    
    }
      public void CorreCms12(String ser){
       try{
          //Ejecuto el bat enviandole la clave leida del archivo server.cfg de la ruta compartida.
          //Esto a su vez crea los archivos bat por cada servidor.
          Runtime.getRuntime().exec("cmd /c start C:\\servicios\\cmsN\\Status"+ser+"cmsN.bat 3");
       
        }
      
        catch(IOException e){
        System.out.println(e.toString());
        }    
    }
      public void CorreCms11(String ser){
       try{
          //Ejecuto el bat enviandole la clave leida del archivo server.cfg de la ruta compartida.
          //Esto a su vez crea los archivos bat por cada servidor.
          Runtime.getRuntime().exec("cmd /c start C:\\servicios\\cmsN\\Status"+ser+"cmsN.bat 3");
       
        }
      
        catch(IOException e){
        System.out.println(e.toString());
        }    
    }
       public void CorreCms10(String ser){
       try{
          //Ejecuto el bat enviandole la clave leida del archivo server.cfg de la ruta compartida.
          //Esto a su vez crea los archivos bat por cada servidor.
          Runtime.getRuntime().exec("cmd /c start C:\\servicios\\cmsN\\Status"+ser+"cmsN.bat 3");
       
        }
      
        catch(IOException e){
        System.out.println(e.toString());
        }    
    }
   public String consultaCount(String serv) {
        String sql1="select count(*) from v$session l where machine = '"+serv+"'";
        System.out.println(sql1);
        String count="";
        try{
            //System.out.println("entro dsn"+dsn);
            pstm=cn1.conectar().prepareStatement(sql1);
            rss=pstm.executeQuery();
            while(rss.next()){
                count=rss.getString(1);
            }
            rss.close();
            pstm.close();
            cn1.desconectar();
            }
        catch(SQLException e){
        JOptionPane.showMessageDialog(null,e.toString(),"Mensaje",JOptionPane.ERROR_MESSAGE );
    }
    
  
return count;
}
}
