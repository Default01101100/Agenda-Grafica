import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class BuscarContactos  extends JPanel implements ActionListener {
   AdminContactos adminContac = new AdminContactos();
   ArrayList<Contacto> datosContac = new ArrayList<Contacto>();
      
   private JButton btnBuscar;
   private JTextField txtNombre;
   private JLabel datos, etiqueta, etiqueta2, lblNombre;
   
   public BuscarContactos(){
      
      datosContac = adminContac.Datos();
      
      setLayout(new GridLayout(5,2));
      etiqueta = new JLabel("Ingrese el nombre de la persona que desea buscar: ");
      etiqueta2 = new JLabel("");
      
      add(etiqueta);
      add(etiqueta2);
      
      lblNombre = new JLabel("Nombre: ", JLabel.RIGHT);
      txtNombre = new JTextField(50);
      
      add(lblNombre);
      add(txtNombre);
      
      btnBuscar = new JButton("Buscar");
      btnBuscar.addActionListener(this);
      add(btnBuscar);
   
   
   }
   
   public void actionPerformed(ActionEvent e){
      boolean bandera = false;
      
      if(e.getSource()==btnBuscar){
         
         if(txtNombre.getText()==null || txtNombre.getText().isEmpty()){
            
            JOptionPane.showMessageDialog(null, "Debes introducir un nombre para buscarlo", "Aviso" , JOptionPane.INFORMATION_MESSAGE);
                     
         }else{
               
               Iterator<Contacto> itrContacto = datosContac.iterator();
               while(itrContacto.hasNext()){
                  
                  Contacto contacto = itrContacto.next();
                  
                  if(txtNombre.getText().equals(contacto.getNombre())){
                     
                     JOptionPane.showMessageDialog(null, "La persona esta registrada en la agenda", "Aviso" , JOptionPane.INFORMATION_MESSAGE); 
                     bandera = true;
                     
                     datos = new JLabel();
                     add(datos);
                     
                     datos.setText(String.valueOf("Nombre: "+contacto.getNombre()+" Telefono: "+ contacto.getTelefono()+" Correo: "+ contacto.getEmail()+ " CumpleAños: "+contacto.getCum()+"Tipo: "+contacto.getTipo()));
                               
                     break;
                                     
                  }                
               }
               
               if(bandera == false){
                  
                  JOptionPane.showMessageDialog(null, "La persona no existe", "Aviso" , JOptionPane.INFORMATION_MESSAGE);
                  txtNombre.setText("");
                  txtNombre.requestFocus();
                  
               }               
           }               
      }
   }
}


