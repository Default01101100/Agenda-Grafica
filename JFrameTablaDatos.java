import javax.swing.*;
import java.awt.*;

public class JFrameTablaDatos extends JFrame {
   TablaDatos td = new TablaDatos();
  
   public JFrameTablaDatos() {
      initComponents();
   }
    
   private void initComponents() {
      setSize(650,150);
      setTitle("Contactos Registrados");
      
      setResizable(true);
      setVisible(true);
      
      setContentPane(td); 
   }
}