import javax.swing.*;
import java.awt.*;

public class JFrameBuscarContacto extends JFrame {
   BuscarContactos busquedaContac = new BuscarContactos();
  
   public JFrameBuscarContacto() {
      initComponents();
   }
   
   private void initComponents() {
      setSize(500,250);
      
      setTitle("Buscar Contacto");
      setResizable(true);
      setVisible(true);
      
      setContentPane(busquedaContac); 
   }
}



