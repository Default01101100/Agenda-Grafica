import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class ModificarContacto extends JPanel implements ActionListener {
   
   AdminContactos adminContac = new AdminContactos();
   ArrayList<Contacto> datosContac = new ArrayList<Contacto>();
   
   private JButton btnModificar, btnCancelar, btnGuardar, btnBuscar;
   private JTextField txtNuevoNombre,txtNuevoTelefono,txtNuevoCorreo,txtNuevoCum,txtNuevoTipo;
   private JLabel lblNombreNuevo, lblNuevoTelefono, lblCorreoNuevo, lblCumNuevo, lblNuevoTipo,datos;   
   
   int index = 0;
   
   public ModificarContacto() {
      
      datosContac = adminContac.Datos();
      setLayout(new GridLayout(8,2));
      JLabel etiqueta = new JLabel("Ingrese el nombre de la persona que desea buscar: ");
      JLabel etiqueta2 = new JLabel("");
      
      add(etiqueta);
      add(etiqueta2);
      
      btnBuscar = new JButton("Buscar");
      btnBuscar.addActionListener(this);
      add(btnBuscar);
         
      datos = new JLabel();
      add(datos);

      lblNombreNuevo = new JLabel("Nombre: ", JLabel.RIGHT);
      txtNuevoNombre = new JTextField(30);
      
      add(lblNombreNuevo);
      add(txtNuevoNombre);
    
      lblNuevoTelefono = new JLabel("Telefono: ", JLabel.RIGHT);
      txtNuevoTelefono= new JTextField(13);
      
      add(lblNuevoTelefono);
      add(txtNuevoTelefono);
         
      JLabel lblCorreoNuevo= new JLabel("Correo: ", JLabel.RIGHT);
      txtNuevoCorreo = new JTextField(30);
      
      add(lblCorreoNuevo);
      add(txtNuevoCorreo);
         
      JLabel lblCumNuevo = new JLabel("Cumpleanios(dd/mm/aaaa): ", JLabel.RIGHT);
      txtNuevoCum = new JTextField(10);
      
      add(lblCumNuevo);
      add(txtNuevoCum);
      
      JLabel lblNuevoTipo = new JLabel("Tipo: ", JLabel.RIGHT);
      txtNuevoTipo = new JTextField(10);
      
      add(lblNuevoTipo);
      add(txtNuevoTipo);
 
      btnGuardar = new JButton("Guardar");
      btnGuardar.addActionListener(this);
      
      add(btnGuardar);
  
   }
   
   public void actionPerformed(ActionEvent e){
      
      boolean bandera = false;
      int cont = 0, entrada = 0;
      
      
      if(e.getSource()==btnBuscar){
               if(txtNuevoNombre.getText()==null || txtNuevoNombre.getText().isEmpty()){
                     
                        JOptionPane.showMessageDialog(null, "Debes introducir un nombre para buscarlo y modificarlo", "Aviso" , JOptionPane.INFORMATION_MESSAGE);
                     
                  }
                  else{
                       Iterator<Contacto> itrContacto = datosContac.iterator();
                        
                        while(itrContacto.hasNext()){
                           
                           Contacto contacto = itrContacto.next();
                           
                           if(txtNuevoNombre.getText().equals(contacto.getNombre())) {
                               
                               JOptionPane.showMessageDialog(null, "La persona esta registrada en la agenda", "Aviso" , JOptionPane.INFORMATION_MESSAGE);
                               txtNuevoNombre.setText(null);
                               bandera = true;
                               cont++;
                               
                               datos.setText(String.valueOf("Nombre: "+contacto.getNombre()+" Telefono: "+ contacto.getTelefono()+" Correo: "+ contacto.getEmail()+ " CumpleAños: "+contacto.getCum()+contacto.getTipo()));
                               
                               contacto.setNombre("");
                               contacto.setTelefono("");
                               contacto.setEmail("");
                               contacto.setCum("");
                               contacto.setTipo("");
                               
                               break;
                           }     
                         }
                         
                         if(bandera == false)
                           JOptionPane.showMessageDialog(null, "La persona que desea modificar no existe", "Aviso" , JOptionPane.INFORMATION_MESSAGE);  
                     }
              }       
              
       if(e.getSource()==btnGuardar) {
         
         if(txtNuevoNombre.getText()==null || txtNuevoNombre.getText().isEmpty() || 
            
            txtNuevoTelefono.getText()==null || txtNuevoTelefono.getText().isEmpty() ||
            txtNuevoCorreo.getText()==null || txtNuevoCorreo.getText().isEmpty() || 
            txtNuevoCum.getText()==null || txtNuevoCum.getText().isEmpty() ||
            txtNuevoCum.getText()==null || txtNuevoCum.getText().isEmpty()){
                           
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos", "Aviso" , JOptionPane.INFORMATION_MESSAGE);
                           
         }else{
            
            adminContac.agregarModificado(txtNuevoNombre.getText(), txtNuevoTelefono.getText(), txtNuevoCorreo.getText(), txtNuevoCum.getText(),txtNuevoTipo.getText());
                              
            JOptionPane.showMessageDialog(null, "Se modifico con exito", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            
            txtNuevoNombre.setText(null); 
            txtNuevoTelefono.setText(null);
            txtNuevoCorreo.setText(null);
            txtNuevoCum.setText(null);
            txtNuevoTipo.setText(null);
             
            txtNuevoNombre.requestFocus();
                           
         }
       }
   }   
}
