import javax.swing.*;
import java.awt.*;

public class CreacionVentanaPrincipal extends JFrame {
 
   VentanaDatos2022 mostrar = new VentanaDatos2022();
   
   public CreacionVentanaPrincipal() {
      initComponents();
   }
   
   private void initComponents() {
      
      setSize(450,500);
      setTitle("Agenda Grafica");
      
      setResizable(false);
      setContentPane(mostrar);
      setVisible(true);
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}