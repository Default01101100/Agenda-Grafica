import java.util.*;

public class AdminContactos {
   
   static ArrayList<Contacto> Arrcontacto = new ArrayList<Contacto>();
   private Contacto objContacto;
   
   public void agregar (String nombre, String telefono, String email, String cum, String tipo) {
      objContacto = new Contacto();
      
      objContacto.setNombre(nombre);
      objContacto.setTelefono(telefono);
      objContacto.setEmail(email);
      objContacto.setCum(cum);
      objContacto.setTipo(tipo);
      
      Arrcontacto.add(objContacto);

   }
   
   public void agregarModificado (String nombre, String telefono, String email, String cum,String tip) {
      objContacto = new Contacto();
      
      objContacto.setNombre(nombre);
      objContacto.setTelefono(telefono);
      objContacto.setEmail(email);
      objContacto.setCum(cum);
      objContacto.setTipo(tip);
      
      Arrcontacto.add(objContacto);

   }
  
   
   public void mostrar() {
      System.out.println("Personas registradas en la agenda");
      
      Iterator<Contacto> itrContacto = Arrcontacto.iterator();   
      
      while(itrContacto.hasNext()) {
         
         Contacto contacto = itrContacto.next();
         
            System.out.println("\nNombre: " + contacto.getNombre());
            System.out.println("Telefono: " + contacto.getTelefono());
            System.out.println("Correo: " + contacto.getEmail());
            System.out.println("Fecha de Cumpleaños: " + contacto.getCum());
            System.out.println("Tipo: " + contacto.getTipo());
      }
   }
   
   public ArrayList Datos() {
     return Arrcontacto;
  }
}