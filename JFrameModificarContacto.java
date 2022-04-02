import javax.swing.*;
import java.awt.*;

public class JFrameModificarContacto extends JFrame {
   ModificarContacto mdContac = new ModificarContacto();
  
   public JFrameModificarContacto() {
      initComponents();
   }
   
   private void initComponents() {
      setSize(500,250);
      setTitle("Modificar Contacto");

      setResizable(true);
      setVisible(true);
      
      setContentPane(mdContac); 
   }
}