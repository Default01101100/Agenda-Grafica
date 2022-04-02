import javax.swing.*;
import java.awt.*;

public class JFrameMostrar extends JFrame
{
   VentanaDatos2022 mostrar = new VentanaDatos2022();
   
    public JFrameMostrar()
   {  
      //super.setVisible(false);
     //super.dispose();
      initComponents();
   }
   
   private void initComponents()
   {
      //super.setVisible(false);
      //super.dispose();
      setSize(300, 200);
      setTitle("AGENDA");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(true);
      setContentPane(mostrar);
      setVisible(true);
       
   }   
}
