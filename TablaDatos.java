import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class TablaDatos extends JPanel  implements ActionListener {
   
   ArrayList<Contacto> datosContac = new ArrayList<Contacto>();

   JButton btnEliminar;
   JScrollPane scroll = new JScrollPane();
   AdminContactos admC = new AdminContactos();

   JTable tabla;

   public TablaDatos() {
      
      datosContac = admC.Datos();
      
      String titulos [] = {"Nombre", "Telefono","Correo","Cumpleaños","Tipo de contacto"};
      String info [][] = obtenerDatos();
      setLayout (new GridLayout(1,4));
 
      tabla = new JTable(info,titulos);
         
      tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      scroll.setViewportView(tabla);
      add(scroll);
      
      btnEliminar = new JButton("Eliminar");
      btnEliminar.addActionListener(this);
      add(btnEliminar);
   }
   

   private String[][] obtenerDatos() {
      int x = 0;
      
      String informacion[][] = new String[datosContac.size()][5];
      Iterator<Contacto> itrContacto = datosContac.iterator();
      
      while(itrContacto.hasNext()) {
         Contacto contacto = itrContacto.next();
         
         informacion[x][0] = contacto.getNombre();
         informacion[x][1] = contacto.getTelefono();
         informacion[x][2] = contacto.getEmail();
         informacion[x][3] = contacto.getCum();
         informacion[x][4] = contacto.getTipo();
         
         x++;
      
      }
      
      return informacion;
      
   }

   public void actionPerformed(ActionEvent e) {
      if(e.getSource() == btnEliminar){
     
         int fila= tabla.getSelectedRow();
           if(fila>=0){
               int rpta = JOptionPane.showConfirmDialog(this, "Deseas eliminar la fila", "Sistema", JOptionPane.INFORMATION_MESSAGE);
               if(rpta == JOptionPane.YES_OPTION){
                  datosContac.remove(fila); 
               }
           }else{
               JOptionPane.showMessageDialog(null,"Seleccione fila");
           }
      }     
   }   
}

