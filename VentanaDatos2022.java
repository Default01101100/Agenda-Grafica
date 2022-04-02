import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.applet.AudioClip;



public class VentanaDatos2022 extends JPanel implements ActionListener{
   
   private JButton btnGuardar, btnMostrarTabla, btnMostrarEnConsola,btnBuscar,btnModificar,btnPlay;
   private JTextField txtNombre, txtTelefono, txtEmail, txtCum;
   private JRadioButton tec, casual;
   private JLabel lblNombre, lblTelefono, lblEmail, lblCum, lblTipo;
   
   AdminContactos admC = new AdminContactos();
   ButtonGroup gpoBotones = new ButtonGroup();
   
   public VentanaDatos2022() {  
      
      setLayout(new GridLayout(9,2));
      
      lblNombre = new JLabel("Nombre: ", JLabel.RIGHT);
      txtNombre = new JTextField(30);
      
      add(lblNombre);
      add(txtNombre);
      
      
      lblTelefono = new JLabel("Telefono: " , JLabel.RIGHT);
      txtTelefono = new JTextField(15);
      
      add(lblTelefono);
      add(txtTelefono);
      
      
      lblEmail = new JLabel("Correo: " , JLabel.RIGHT);
      txtEmail = new JTextField(30);
      
      add(lblEmail);
      add(txtEmail);


      lblCum = new JLabel("Fecha de Cumpleaños(dd/mm/aaaa): ", JLabel.RIGHT);
      txtCum = new JTextField(30);
      
      add(lblCum);
      add(txtCum);
      
      lblTipo = new JLabel("Elige el tipo de contacto: ", JLabel.CENTER);
      add(lblTipo);

      
      tec = new JRadioButton("TecNM/CdGuzman", true);
      casual = new JRadioButton("Casual");
      gpoBotones.add(tec);
      gpoBotones.add(casual);
      
      add(tec);
      add(casual);
      
      btnGuardar = new JButton("Guardar");
      btnGuardar.addActionListener(this);
      
      btnMostrarTabla = new JButton("Mostrar Tabla de Contactos");
      btnMostrarTabla.addActionListener(this);
      
      btnMostrarEnConsola = new JButton("Mostrar Lista de Contactos");
      btnMostrarEnConsola.addActionListener(this);
      
      btnModificar = new JButton("Modificar contacto");
      btnModificar.addActionListener(this);
      
      btnBuscar = new JButton("Buscar Contacto");
      btnBuscar.addActionListener(this);
      
      //btnPlay = new JButton("Ritmo");
      //btnPlay.addActionListener(this);

      add(btnGuardar);
      add(btnMostrarTabla);
      add(btnMostrarEnConsola);
      add(btnModificar);
      add(btnBuscar);
      //add(btnPlay);
   }


   public void actionPerformed(ActionEvent e) {
      
      String tipo = "TecNM/CdGuzman";
      
      if (casual.isSelected())
         tipo = "Casual";
         
   
      if(e.getSource () == btnGuardar) {
         
         if(txtNombre.getText()==null || txtNombre.getText().isEmpty()) { 
         
            JOptionPane.showMessageDialog(null, "Debes colocar al menos el nombre","Aviso", JOptionPane.INFORMATION_MESSAGE);
            txtNombre.requestFocus();
            
            AudioClip Sound;
            Sound = java.applet.Applet.newAudioClip(getClass().getResource("/HittheFloor.wav"));
            Sound.play();
         }
       
         else
       
            if(txtTelefono.getText()==null || txtTelefono.getText().isEmpty()) { 
            
            JOptionPane.showMessageDialog(null, "Es necesario capturar el telefono","Aviso", JOptionPane.INFORMATION_MESSAGE);
            txtTelefono.requestFocus();
            
            }
       
         else {
         
            admC.agregar(txtNombre.getText(), txtTelefono.getText(), txtEmail.getText(), txtCum.getText(), tipo);//mandandole estos datos al constructor que tenemos en adminContac
            
            JOptionPane.showMessageDialog(null, "Se guardara la informacion", "Aviso", JOptionPane.INFORMATION_MESSAGE);    
            
            txtNombre.setText(null);
            txtTelefono.setText(null);
            txtEmail.setText(null);
            txtCum.setText(null);
            
            txtNombre.requestFocus();
          }   
       }
      
      if(e.getSource() == btnMostrarEnConsola) {
         admC.mostrar();
      }
         
      if(e.getSource() == btnMostrarTabla) {
         JFrameTablaDatos jftd = new JFrameTablaDatos();
      }
      
      if(e.getSource() == btnModificar) {
         JFrameModificarContacto mdContac = new JFrameModificarContacto();
      }
      
      if(e.getSource() == btnBuscar) {
         JFrameBuscarContacto busquedaContac = new JFrameBuscarContacto();
      }
      
       
     /* if(e.getSource() == btnPlay) {
         Sonido sonido = new Sonido(); 
      } */   
      
      
   }
}