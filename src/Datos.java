public class Datos {
int Clave;
  String Nombre;
  String Apellido;
  String Carrera;
  String Genero;
  String Matricula;

public Datos(int Clave, String Nombre, String Apellido, String Carrera, String Genero, String Matricula) {
    this.Clave = Clave;
    this.Nombre = Nombre;
    this.Apellido = Apellido;
    this.Carrera = Carrera;
    this.Genero = Genero;
    this.Matricula = Matricula;
  }

@Override
public String toString() {
    return String.format("%-6d | %-17s | %-35s | %-20s | %-45s | %20s", Clave, Nombre, Apellido, Carrera, Genero, Matricula);
}
  
  
   public int getClave() {
        return Clave;
    }
  
  public void setClave(int clav) {                                                                                   
        this.Clave = clav;
    }
  
  public String getNombre() {
        return Nombre;
    }
  
  public void setNombre(String nom) {                                                                                   
        this.Nombre = nom;
    }
  
  public String getApellido() {
        return Apellido;
    }
  
  public void setApellido (String ape) {                                                                                   
        this.Apellido = ape;
    }
  
    public String getCarrera() {
        return Carrera;
    }
  
  public void setCarrera (String depo) {                                                                                   
        this.Carrera = depo;
    }
   public String getGenero() {
        return Genero;
    }
  
  public void setGenero (String gen) {                                                                                   
        this.Genero = gen;
    }
  public String getMatricula() {
        return Matricula;
    }
  
  public void setMatricula(String num) {                                                                                   
        this.Matricula = num;
    }
}