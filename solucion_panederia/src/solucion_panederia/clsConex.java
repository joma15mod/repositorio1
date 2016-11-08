import java.sql.*;
import javax.swing.JOptionPane;

  
  public class clsConex {
 
        Connection miconexion = null; // objeto de conexion
        Statement micomando = null; // objeto para ejecutar comandos sql
        ResultSet regis = null; // objeto para recuperar tuplas desde select
        String Auxsql=""; // para construir las instrucciones de sql
        
        // propiedades de la clase
                
        private String servidor ;
        private String baseD;
        private String usuario;
        private String contra;
//---------------------------------------------------------------------------
public clsConex() {
      try{
     
     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // es el driver
            
     }catch(ClassNotFoundException ex){
         JOptionPane.showMessageDialog(null, "DriverException: "+ex.getMessage());
         
    }
    }
//----------------------------------------------------------------------------
public boolean conectar(){
        boolean conecto=false;
        
        try{
       
     String url = "jdbc:sqlserver://"+ servidor + ";databaseName="+baseD+";user="+usuario+";password="+contra+";";
     
     // crea la conexion activa a la base de datos
     
     miconexion = DriverManager.getConnection(url);
      
     conecto= true;
     
    // crea el objeton para ejecucion de sql
     
     micomando = miconexion.createStatement();
     
     }catch(SQLException ex){
         
         JOptionPane.showMessageDialog(null, "SQLException: "+ ex.getMessage()+"\n"+"SQLEstado : "+ ex.getSQLState()+"\n"+"Error :"+ex.getErrorCode(),"Error",JOptionPane.ERROR_MESSAGE);
     }
        
        return conecto;
        
    }
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------    
public void ejecutar(String cadena){
     
 try{
   micomando.execute(cadena);
   }catch(SQLException ex){
         JOptionPane.showMessageDialog(null, "SQLException: "+ ex.getMessage()+"\n"+"SQLEstado : "+ ex.getSQLState()+"\n"+"Error :"+ex.getErrorCode(),"Error",JOptionPane.ERROR_MESSAGE);
     }    
 }
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 public ResultSet consultar(String Cadena){
     
     this.regis =null;
     try{
        
     this.regis = micomando.executeQuery(Cadena);
       
    }catch(SQLException ex){
         
         JOptionPane.showMessageDialog(null, "SQLException: "+ ex.getMessage()+"\n"+"SQLEstado : "+ ex.getSQLState()+"\n"+"Error :"+ex.getErrorCode(),"Error",JOptionPane.ERROR_MESSAGE);
     }
      return this.regis;
 }
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

public String getServidor() {
        return servidor;
    }

    
    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public String getBaseD() {
        return baseD;
    }

  
    public void setBaseD(String baseD) {
        this.baseD = baseD;
    }

    
    public String getUsuario() {
        return usuario;
    }

    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    
    public void setContra(String contra) {
        this.contra = contra;
    }
  
    
    
    
}