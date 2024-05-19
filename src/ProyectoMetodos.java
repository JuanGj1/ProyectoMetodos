
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Character.toUpperCase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.io.Console;
import java.util.Scanner;
    
public class ProyectoMetodos {
  public static void main(String[] args) throws IOException {
        login();//entrada con contraseña
        ArrayList <Datos> GestEstul=new ArrayList();//almacenamiento
        Scanner leer=new Scanner(System.in);
        LeerArchivo(GestEstul);//lectura del archivo csv
        
        //entrada al menu principal
        char op;
        int opc=0;
        
        do{
            Menu();
            System.out.println();
            op=leer.next().charAt(0);
            op=toUpperCase(op);
            switch(op){   
                    case '3':// Opción de Mostrar Datos
                    System.out.println("-----------------------------DATOS-----------------------------");
                    ImprimirArray(GestEstul);
                    break;

                case '4':// Opción de Ordenamiento
                    System.out.println();
                    Ordenamiento();
                    Aleatorio(GestEstul);
                    break;

                case '5':// Opción de Busqueda
                    System.out.println();
                    Busqueda();
                    AleatorioBusq(GestEstul);

                    System.out.println();
                    break;

                case '1': // Opción para agregar datos
                    System.out.println();
                    agregarDatos(GestEstul);
                    System.out.println("Datos agregados correctamente.");
                    break;
           case '2':// Opción para eliminar  datos 
                    System.out.println();
                    borrarDatos(GestEstul);
                    System.out.println("Datos borrados correctamente.");
                    break;
            }
        } while (op != 'S');// Opción de SALIDA
    }
   //____________________ MENU PRINCIPAL________________________
   public static void Menu(){
        System.out.println("\n");
        System.out.println("-------------------------MENU PRINCIPAL-------------------------");
        System.out.println("(1) = Agregar Datos"); 
        System.out.println("(2) = Eliminar  Datos");
        System.out.println("(3) = Mostrar Datos ");
    	System.out.println("(4) = Ordenamiento");
       	System.out.println("(5) = Busqueda ");	
       

        System.out.println("(S) = SALIR");
        System.out.println("Seleccione la letra de la opcion que desea realizar: ");
    }

   //MENU ORDENAMIENTO________________________ 
    private static void Ordenamiento() {
        System.out.println("----------------------MENU DE ORDENAMIENTO----------------------");
        System.out.println("(1) = Clave");
        System.out.println("(2) = Apellido");
        System.out.println("(3) = Volver");
        System.out.println();
    
    }
    
    //MENU BUSQUEDA_______________________
    private static void Busqueda() {
        System.out.println("----------------------MENU DE BUSQUEDA----------------------");
        System.out.println("(1) = Buscar Clave");
         System.out.println("(2) = Buscar Apellido");
        System.out.println("(3) = Volver");
        System.out.println();
    }
    
    //CONTRASEÑA PARA PODER INGRESAR__________________ 
    public static void login() {
        Scanner leer=new Scanner(System.in);
        String[] jefeinfo = {"Alberto","Juan"};//NOMBRE DE USUARIOS 
        String[] contraseña = {"1234","4321"};//CONTRASEÑAS 
        String jefe = "";
        String contra = "";
        System.out.println("Usuario");
        jefe = leer.nextLine();
        System.out.println("Contraseña");
        contra = leer.nextLine();
        boolean dato = false;
        do {
            
            if (jefeinfo[0].equals(jefe) && contraseña[0].equals(contra) || jefeinfo[1].equals(jefe) && contraseña[1].equals(contra) ){  
                dato = true;
            }else{
                dato = false;
             }
            if (dato == true){
                System.out.println("---------------------------BIENVENIDOS AL SISTEMA---------------------------");
            }else{
                System.out.println("!!ERROR!!");
                System.out.println("El Usuario es Incorrecto");
                System.out.println("Usuario:");
                jefe = leer.nextLine();
                System.out.println("Contraseña;");
                contra = leer.nextLine();
            }
           }while (dato == false);
    }
    
    //LECTURA DEL ARCHIVO EXCEL____________________ 

    public static void LeerArchivo(ArrayList<Datos> GestEmpl) throws IOException {
        String csvFile = "C:\\Users\\juanj\\Downloads\\Datos.csv";
 // Ruta del archivo CSV
        String line = "";
        String csvSplitBy = ","; 
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Lee el archivo línea por línea
            while ((line = br.readLine()) != null) {
                String[] campos = line.split(csvSplitBy);

                // Obtiene los datos de cada campo según el orden en el CSV
                int clave = Integer.parseInt(campos[0]);
                String nombre = campos[1];
                String apellido = campos[2];
                String Materia = campos[3];
                String genero = campos[4];
                String Matricula = campos[5];

                // Crea un objeto Datos y lo agrega a la lista de gestion 
                Datos d = new Datos(clave, nombre, apellido, Materia, genero, Matricula);
                GestEmpl.add(d);
            }
        }
    }
   
    //Elige de forma ALEATORIA el metodo por el que se ordena y toma el tiempo que se tarda el ordenamiento______
    public static void Aleatorio(ArrayList<Datos>GestEstul){
        Scanner leer=new Scanner(System.in);
        Random alea=new Random();
        ProyectoMetodos info=new ProyectoMetodos();
        
        int opc=0;
        long tf, ti,TiempoT;
        int elegir= alea.nextInt(10);
        System.out.println("Ingrese el número del dato que desea Ordenar: ");
        opc=leer.nextInt();
        System.out.println();
        
        if(opc==1){   
            switch (elegir) {
               case 0:
                    System.out.println("\t"+"Metodo Burbuja");
                    ti=System.nanoTime();
                    BubbleSortClave(GestEstul);
                    tf=System.nanoTime();
                    TiempoT=(long)(tf-ti);
                    System.out.println("\t"+"Tardando un tiempo de: " +TiempoT + " Nanosegundos");
                    break;

                case 1: 
                    System.out.println("\t"+"Metodo Bidireccional");
                    ti=System.nanoTime();
                    BurbujaBidireccionalClave(GestEstul);
                    tf=System.nanoTime();
                    TiempoT=(long)(tf-ti);
                    System.out.println("\t"+"Tardando un tiempo de: " +TiempoT + " Nanosegundos");
                    break;
                 
                case 2:
                    System.out.println("\t"+"Metodo Seleccion");
                    ti=System.nanoTime();
                    SeleccionClave(GestEstul);
                    tf=System.nanoTime();
                    TiempoT=(long)(tf-ti);
                    System.out.println("\t"+"Tardando un tiempo de: " +TiempoT + " Nanosegundos");
                    break;
                   
                case 3:
                    System.out.println("\t"+"Metodo Insercción");
                    ti=System.nanoTime();
                    InserccionClave(GestEstul);
                    tf=System.nanoTime();
                    TiempoT=(long)(tf-ti);
                    System.out.println("\t"+"Tardando un tiempo de: " +TiempoT + " Nanosegundos");
                    break;
                    
                case 4:
                    System.out.println("\t"+"Metodo Shell");
                    ti=System.nanoTime();
                    ShellClave(GestEstul);
                    tf=System.nanoTime();
                    TiempoT=(long)(tf-ti);
                    System.out.println("\t"+"Tardando un tiempo de: " +TiempoT + " Nanosegundos");
                    break;  
                    
                case 5:
                    System.out.println("\t"+"Metodo QuickSort");
                    ti=System.nanoTime();
                    QuickSortClave(GestEstul,0,GestEstul.size()-1);
                    tf=System.nanoTime();
                    TiempoT=(long)(tf-ti);
                    System.out.println("\t"+"Tardando un tiempo de: " +TiempoT + " Nanosegundos");
                    break;
                    case 6:
                    System.out.println("\t"+"Metodo MergeSort");
                    ti=System.nanoTime();
                    MergeSortClave(GestEstul,0,GestEstul.size()-1);
                    tf=System.nanoTime();
                    TiempoT=(long)(tf-ti);
                    System.out.println("\t"+"Tardando un tiempo de: " +TiempoT + " Nanosegundos");
                    break;
                      case 7:
                    System.out.println("\t"+"Metodo Radix Sort ");
                    ti=System.nanoTime();
                    RadixSortClave(GestEstul);
                    tf=System.nanoTime();
                    TiempoT=(long)(tf-ti);
                    System.out.println("\t"+"Tardando un tiempo de: " +TiempoT + " Nanosegundos");
                    break;
                    case 8:
                      System.out.println("\t"+"Metodo Bucket Sort ");
                    ti=System.nanoTime();
                    BucketSortClave(GestEstul);
                    tf=System.nanoTime();
                    TiempoT=(long)(tf-ti);
                    System.out.println("\t"+"Tardando un tiempo de: " +TiempoT + " Nanosegundos");
                    break;
                      case 9:
                      System.out.println("\t"+"Metodo Counting Sort");
                    ti=System.nanoTime();
                    CountingSortClave(GestEstul);
                    tf=System.nanoTime();
                    TiempoT=(long)(tf-ti);
                    System.out.println("\t"+"Tardando un tiempo de: " +TiempoT + " Nanosegundos");
                    break;
                    case 10:
                      System.out.println("\t"+"Metodo Heap Sort");
                    ti=System.nanoTime();
                    HeapSortClave(GestEstul);
                    tf=System.nanoTime();
                    TiempoT=(long)(tf-ti);
                    System.out.println("\t"+"Tardando un tiempo de: " +TiempoT + " Nanosegundos");
                    break;
            }
        }
        else if(opc==2){
            switch (elegir) {
                case 0:
                    System.out.println("\t"+"Metodo Burbuja");
                    ti=System.nanoTime();
                    BubbleSortApellido(GestEstul);
                    tf=System.nanoTime();
                    TiempoT=(long)(tf-ti);
                    System.out.println("\t"+"Tardando un tiempo de: " +TiempoT + " Nanosegundos");
                    break;
                
                case 1:
                    System.out.println("\t"+"Metodo Bidireccional");
                    ti=System.nanoTime();
                    BurbujaBidireccionalApellido(GestEstul);
                    tf=System.nanoTime();
                    TiempoT=(long)(tf-ti);
                    System.out.println("\t"+"Tardando un tiempo de: " +TiempoT + " Nanosegundos");
                    break;
                
                case 2:
                    System.out.println("\t"+"Metodo Seleccion");
                    ti=System.nanoTime();
                    SeleccionApellido(GestEstul);
                    tf=System.nanoTime();
                    TiempoT=(long)(tf-ti);
                    System.out.println("\t"+"Tardando un tiempo de: " +TiempoT + " Nanosegundos");
                    break;
                
                case 3:
                    System.out.println("\t"+"Metodo Insercción");
                    ti=System.nanoTime();
                    InserccionApellido(GestEstul); 
                    tf=System.nanoTime();
                    TiempoT=(long)(tf-ti);
                    System.out.println("\t"+"Tardando un tiempo de: " +TiempoT + " Nanosegundos");
                    break;
                    
                case 4:
                    System.out.println("\t"+"Metodo Shell");
                    ti=System.nanoTime();
                    ShellApellido(GestEstul);
                    tf=System.nanoTime();
                    TiempoT=(long)(tf-ti);
                    System.out.println("\t"+"Tardando un tiempo de: " +TiempoT + " Nanosegundos");
                    break;  
                    
                case 5:
                    System.out.println("\t"+"Metodo QuickSort");
                    ti=System.nanoTime();
                    QuickSortApellido(GestEstul,0,GestEstul.size()-1);
                    tf=System.nanoTime();
                    TiempoT=(long)(tf-ti);
                    System.out.println("\t"+"Tardando un tiempo de: " +TiempoT + " Nanosegundos");
                    break;
                    case 6:
                    System.out.println("\t"+"Metodo MergeSort");
                    ti=System.nanoTime();
                    MergeSortClave(GestEstul,0,GestEstul.size()-1);
                    tf=System.nanoTime();
                    TiempoT=(long)(tf-ti);
                    System.out.println("\t"+"Tardando un tiempo de: " +TiempoT + " Nanosegundos");
                    break;
                     case 7:
                    System.out.println("\t"+"Metodo Radix Sort ");
                    ti=System.nanoTime();
                    RadixSortClave(GestEstul);
                    tf=System.nanoTime();
                    TiempoT=(long)(tf-ti);
                    System.out.println("\t"+"Tardando un tiempo de: " +TiempoT + " Nanosegundos");
                    break;
                   case 8:
                      System.out.println("\t"+"Metodo Bucket Sort ");
                    ti=System.nanoTime();
                    BucketSortClave(GestEstul);
                    tf=System.nanoTime();
                    TiempoT=(long)(tf-ti);
                    System.out.println("\t"+"Tardando un tiempo de: " +TiempoT + " Nanosegundos");
                    break;
                      case 9:
                      System.out.println("\t"+"Metodo Counting Sort");
                    ti=System.nanoTime();
                    CountingSortClave(GestEstul);
                    tf=System.nanoTime();
                    TiempoT=(long)(tf-ti);
                    System.out.println("\t"+"Tardando un tiempo de: " +TiempoT + " Nanosegundos");
                    break;
                    case 10:
                      System.out.println("\t"+"Metodo Heap Sort");
                    ti=System.nanoTime();
                    HeapSortClave(GestEstul);
                    tf=System.nanoTime();
                    TiempoT=(long)(tf-ti);
                    System.out.println("\t"+"Tardando un tiempo de: " +TiempoT + " Nanosegundos");
                    break;
                   
                    //metos //
                               }
        }
        else if(opc==10){
        }
    }
    
    //ALEATORIO DE LOS METODOS DE BUSQUEDA_________________
   public static void AleatorioBusq(ArrayList<Datos> GestEstul) {
    Scanner leer = new Scanner(System.in);
    Random alea = new Random();
    ProyectoMetodos info = new ProyectoMetodos();

    int opc = 0;
    long tf, ti, TiempoT;
    int elegir = alea.nextInt(2);
    System.out.println("Ingrese el número de la acción que desea realizar: ");
    opc = leer.nextInt();
    System.out.println();

    try (PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users\\juanj\\OneDrive\\Documentos\\Reportes.txt", true))) {
         writer.println("\n==================== NUEVO REPORTE DE BÚSQUEDA ====================");  // Añade un separador para cada nueva búsqueda

        if (opc == 1) {
            System.out.println("Ingrese el Clave que desea buscar: ");
            String Clave = leer.next();
            boolean encontrado = false;

            ti = System.nanoTime();
            for (Datos dato : GestEstul) {
                if (String.valueOf(dato.getClave()).equalsIgnoreCase(Clave)) {
                    String resultado = String.format(
                        "Clave encontrada: %s%nClave: %s%nNombre: %s%nApellido: %s%nCarrera: %s%nGénero: %s%nMatrícula: %s",
                        dato.getClave(), dato.getClave(), dato.getNombre(), dato.getApellido(), dato.getCarrera(), dato.getGenero(), dato.getMatricula()
                    );
                    System.out.println(resultado);
                    writer.println(resultado);
                    encontrado = true;
                }
            }
            tf = System.nanoTime();
            TiempoT = (tf - ti);

            if (!encontrado) {
                System.out.println("Clave no encontrada en la lista.");
                writer.println("Clave no encontrada en la lista.");
            } else {
                String tipoBusqueda = elegir == 0 ? "BUSQUEDA SECUENCIAL" : "BUSQUEDA BINARIA";
                String tiempoResultado = String.format("La búsqueda se realizó por %s%nTardando un tiempo de: %d Nanosegundos", tipoBusqueda, TiempoT);
                System.out.println(tiempoResultado);
                writer.println(tiempoResultado);
            }

        } else if (opc == 2) {
            System.out.println("Ingrese el apellido que desea buscar: ");
            String apellido = leer.next();
            boolean encontrado = false;

            ti = System.nanoTime();
            for (Datos dato : GestEstul) {
                if (dato.getApellido().equalsIgnoreCase(apellido)) {
                    String resultado = String.format(
                        "Apellido encontrado: %s%nClave: %s%nNombre: %s%nApellido: %s%nCarrera: %s%nGénero: %s%nMatrícula: %s",
                        dato.getApellido(), dato.getClave(), dato.getNombre(), dato.getApellido(), dato.getCarrera(), dato.getGenero(), dato.getMatricula()
                    );
                    System.out.println(resultado);
                    writer.println(resultado);
                    encontrado = true;
                }
            }
            tf = System.nanoTime();
            TiempoT = (tf - ti);

            if (!encontrado) {
                System.out.println("Apellido no encontrado en la lista.");
                writer.println("Apellido no encontrado en la lista.");
            } else {
                String tipoBusqueda = elegir == 0 ? "BUSQUEDA SECUENCIAL" : "BUSQUEDA BINARIA";
                String tiempoResultado = String.format("La búsqueda se realizó por %s%nTardando un tiempo de: %d Nanosegundos", tipoBusqueda, TiempoT);
                System.out.println(tiempoResultado);
                writer.println(tiempoResultado);
            }
        }
    } catch (IOException e) {
        System.out.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
    }
}


    //IMPRESION ORDENADA______________________ 
    public static void ImprimirArray(ArrayList<Datos> GestEstul) {
        System.out.println("Clave  |   Nombre       | Apellido       |    Genero       |   Carrera       |     Matricula");
        System.out.println("");
        for (Datos empleado : GestEstul) {
            System.out.println(empleado);
        }
    }

    // Método para agregar datos
    public static void agregarDatos(ArrayList<Datos> GestEstul) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese la Clave:");
        int clave = scanner.nextInt();
        
        System.out.println("Ingrese el Nombre:");
        String nombre = scanner.next();
        
        System.out.println("Ingrese el Apellido:");
        String apellido = scanner.next();
        
        System.out.println("Ingrese el Materia:");
        String carrera = scanner.next();
        
        System.out.println("Ingrese el Género:");
        String genero = scanner.next();
        
        System.out.println("Ingrese el Matricula:");
        String matricula = scanner.next();
        
        Datos nuevoDato = new Datos(clave, nombre, apellido, carrera, genero,  matricula);
        GestEstul.add(nuevoDato);
    }
     public static void borrarDatos(ArrayList<Datos> GestEstul) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la clave del dato que desea borrar:");
        int clave = scanner.nextInt();
        boolean encontrado = false;

        for (Datos dato : GestEstul) {
            if (dato.getClave() == clave) {
                GestEstul.remove(dato);
                System.out.println("Dato con clave " + clave + " borrado.");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró ningún dato con la clave proporcionada.");
        }
    }

    


    //METODO BURBUJA______________________
    //Burbuja por CLave
    public static void BubbleSortClave(ArrayList <Datos> GestEstul){
        for (int i = 0; i < (GestEstul.size() - 1); i++) {
            for (int j = 0; j < (GestEstul.size()-i - 1); j++) {
                if (GestEstul.get(j).getClave() > GestEstul.get(j + 1).getClave()) { 
                    
                    Datos aux = GestEstul.get(j);
                    GestEstul.set(j, GestEstul.get(j+1));
                    GestEstul.set(j+1, aux);
                }
            }
        }
    }
    
    //Burbuja por Apellido
    public static void BubbleSortApellido(ArrayList <Datos> GestEstul){
        for (int i = 0; i < (GestEstul.size() - 1); i++) {
            for (int j = 0; j < (GestEstul.size()-i -1); j++) {
                if (GestEstul.get(j).getApellido().compareToIgnoreCase(GestEstul.get(j+1).getApellido()) > 0) {
                    
                    Datos aux = GestEstul.get(j);
                    GestEstul.set(j, GestEstul.get(j+1));
                    GestEstul.set(j+1, aux);
                }
            }
        }
    }
        
    //METODO BURBUJA BIDIRECCIONAL____________________
    //Bidireccional por Clave
    public static void BurbujaBidireccionalClave(ArrayList <Datos> GestEstul){
        int izq = 0;
        int der = GestEstul.size() - 1;
        int ultimo = GestEstul.size() - 1;
        do {
            for (int i = izq; i < der; i++) {
                if (GestEstul.get(i).getClave() > GestEstul.get(i + 1).getClave()) {
                    Datos aux = GestEstul.get(i);
                    GestEstul.set(i, GestEstul.get(i + 1));
                    GestEstul.set(i + 1, aux);
                    ultimo = i;
                }
            }
            der = ultimo;
            for (int j = der; j > izq; j--) {
                if (GestEstul.get(j - 1).getClave() > GestEstul.get(j).getClave()) {
                    Datos aux = GestEstul.get(j);
                    GestEstul.set(j, GestEstul.get(j - 1));
                    GestEstul.set(j - 1, aux);
                    ultimo = j;
                }
            }
            izq = ultimo;
        }while (izq < der);
    }
    
    //Bidireccional por Apellido
    public static void BurbujaBidireccionalApellido(ArrayList <Datos> GestEstul){
        int izq = 0;
        int der = GestEstul.size() - 1;
        int ultimo = GestEstul.size() - 1;
        do {
            for (int i = izq; i < der; i++) {
                if (GestEstul.get(i).getApellido().compareToIgnoreCase(GestEstul.get(i+1).getApellido()) > 0) {
                    Datos aux = GestEstul.get(i);
                    GestEstul.set(i, GestEstul.get(i + 1));
                    GestEstul.set(i + 1, aux);
                    ultimo = i;
                }
            }
            der = ultimo;
            for (int j = der; j > izq; j--) {
                if (GestEstul.get(j - 1).getClave() > GestEstul.get(j).getClave()) {
                    Datos aux = GestEstul.get(j);
                    GestEstul.set(j, GestEstul.get(j - 1));
                    GestEstul.set(j - 1, aux);
                    ultimo = j;
                }
            }
            izq = ultimo;
        }while (izq < der);    
    }

    //METODO SELECCION________________________ 
    //Seleccion por Clave
    public static void SeleccionClave(ArrayList <Datos> GestEstul) {
        for (int i = 0; i < GestEstul.size() - 1; i++) {
            for (int j = i + 1; j < GestEstul.size(); j++) {
                if (GestEstul.get(i).getClave() > GestEstul.get(j).getClave()) {
                    Datos aux = GestEstul.get(i);
                    GestEstul.set(i, GestEstul.get(j));
                    GestEstul.set(j, aux);
                }
            }
        }
    }
    
    //Seleccion por Apellido
    public static void SeleccionApellido(ArrayList <Datos> GestEstul) {
        for (int i = 0; i < GestEstul.size() - 1; i++) {
            int k=i;
            for (int j = i + 1; j <GestEstul.size(); j++) {
                if (GestEstul.get(j).getApellido().compareToIgnoreCase(GestEstul.get(k).getApellido()) < 0) {
                k=j;
                }
            }
            if(k!=i){
                    Datos aux = GestEstul.get(i);
                    GestEstul.set(i, GestEstul.get(k));
                    GestEstul.set(k, aux);
                }
            }
        }
    
    //METODO INSERCCION______________________
    //Insercción por Clave
    public static void InserccionClave(ArrayList <Datos> GestEstul){
        for (int i = 1; i <GestEstul.size(); i++) { 
            int aux =GestEstul.get(i).getClave();
            Datos auxiliar =GestEstul.get(i);
            int j = i;            
            while ((j > 0) && (aux <GestEstul.get(j - 1).getClave())) {                              
                GestEstul.set(j, GestEstul.get(j - 1));
                j--;
            }
            GestEstul.set(j, auxiliar);
        }
    }
    
    //Insercción por Apellido
        public static void InserccionApellido(ArrayList <Datos> GestEstul){
        for (int i = 1; i <GestEstul.size(); i++) { 
            String aux =GestEstul.get(i).getApellido();
            Datos auxiliar=GestEstul.get(i);
            int j=i;            
            while ((j>0) && (GestEstul.get(j-1).getApellido().compareToIgnoreCase (aux) > 0)) {   
                GestEstul.set(j, GestEstul.get(j - 1));
                j--;
            }
            GestEstul.set(j, auxiliar);
        }
    }
    
    //METODO SHELL_____________________
    //Shell por Clave
    public static void ShellClave(ArrayList <Datos> GestEstul) {
        int num=GestEstul.size()-1;
        int incremento=num/2;
        while (incremento>0) {
            for (int i=incremento; i<=num; i++) {
                int j=i-incremento;
                while (j>=incremento) {
                   int k= j + incremento;
                    if (GestEstul.get(j).getClave() > GestEstul.get(k).getClave()) {
                        Datos aux = GestEstul.get(j);
                        GestEstul.set(j, GestEstul.get(k));
                        GestEstul.set(k, aux);
                        j=j-incremento;
                    }else {
                        j=j-incremento;
                    }
                }
            }
            incremento=incremento/2;
        }
    }
    
    //Shell por Apellido
    public static void ShellApellido(ArrayList <Datos> GestEstul) {
        int num=GestEstul.size()-1;
        int incremento=num/2;
        while (incremento>0) {
            for (int i=incremento; i<=num; i++) {
                int j=i-incremento;
                while (j>=incremento) {
                    int k= j + incremento;
                    if (GestEstul.get(j).getApellido().compareToIgnoreCase(GestEstul.get(k).getApellido()) > 0) {
                        Datos aux = GestEstul.get(j);
                        GestEstul.set(j, GestEstul.get(k));
                        GestEstul.set(k, aux);
                        j=j-incremento;
                    }else {
                        j=j - incremento;
                    }
                }
            }
            incremento=incremento/2;
        }
    }

    //METODO QUICKSHORT_____________________
    //QuickShort por Clave
    public static void QuickSortClave(ArrayList <Datos> GestEstul, int inicio, int fin) {
        int central=(inicio+fin)/2;
        if (inicio >= fin) {
            return;
        }
        int pivote=GestEstul.get(central).getClave();
        int i = inicio;
        int j = fin;
        do {
            while (GestEstul.get(i).getClave()<pivote) {
                i++;
            }
            while (GestEstul.get(j).getClave()>pivote) {
                j--;
            }
            if (i <= j) {
                Datos aux = GestEstul.get(i);
                GestEstul.set(i, GestEstul.get(j));
                GestEstul.set(j, aux);
                i++;
                j--;
            }
        } while (i <= j);
        if (inicio < j) {
            QuickSortClave(GestEstul, inicio, j);
        }
        if (i < fin) {
            QuickSortClave(GestEstul, i, fin);
        }
    }
    
    //QuickShort por Apellido
    public static void QuickSortApellido(ArrayList <Datos> GestEstul, int inicio, int fin) {
        int central=(inicio+fin)/2;

        if (inicio >= fin) {
            return;
        }
        String pivote = GestEstul.get(central).getApellido();
        int i = inicio;
        int j = fin;
        do {
            while (GestEstul.get(i).getApellido().compareToIgnoreCase(pivote) < 0) {
                i++;
            }
            while (GestEstul.get(j).getApellido().compareToIgnoreCase(pivote) > 0) {
                j--;
            }
            if (i <= j) {
                Datos aux = GestEstul.get(i);
                GestEstul.set(i, GestEstul.get(j));
                GestEstul.set(j, aux);
                i++;
                j--;
            }
        } while (i <= j);
        if (inicio < j) {
            QuickSortApellido(GestEstul, inicio, j);
        }
        if (i < fin) {
            QuickSortApellido(GestEstul, i, fin);
        }
    }
    
    
    //BUSQUEDA BINARIA______________________
    public static int BusqBinaria(ArrayList <Datos> GestEstul, int numBuscado) {
        int inicio=0;
        int fin=GestEstul.size()-1;
        int posicion=0;
        int resultado=0;

        System.out.println();
        while(inicio<=fin){
            posicion=(inicio+fin)/2;
            if(GestEstul.get(posicion).getClave()==numBuscado){
                return posicion;
            }if(GestEstul.get(posicion).getClave()<numBuscado){
                inicio=posicion+1;
            }else{
                fin=posicion-1;
            }
        }
        return -1;
    }
    
    public static void MetBinaria(ArrayList <Datos> GestEstul){
        Scanner leer = new Scanner(System.in); 
        System.out.println();
        System.out.println("¡¡¡Ingrese la clave a buscar!!!");
        int numBuscado = leer.nextInt();
        int resultado=BusqBinaria(GestEstul,numBuscado);
        
        if(resultado != -1){
            System.out.println("\t"+"La clave "+numBuscado+" fue encontrado en la posicion: "+resultado);
            System.out.println();
            System.out.println("\t"+"La clave fue encontrada por BUSQUEDA BINARIA");
        }else{
            System.out.println("\t"+"Los datos no estan ordenados de forma descendente ");
            System.out.println();
            System.out.println("\t"+"La clave se busco por METODO DE BUSQUEDA BINARIA");
        }
    }
    
   //BUSQUEDA SECUENCIAL___________________
    public static void BusqSecuencial(ArrayList <Datos> GestEstul){
        int pos=-1;
        Scanner leer=new Scanner(System.in);
        System.out.println();
        System.out.println("¡¡¡Ingrese la clave a buscar!!!");
        int numBuscado = leer.nextInt();
        System.out.println();
        for(int i=0;i<GestEstul.size();i++){
            if(numBuscado==GestEstul.get(i).getClave()){
                pos=i;
                break;
            }
        }
        if(pos != -1){
            System.out.println();
            System.out.println("\t"+"La clave fue encontrada en la posicion: "+pos);
        }else{
            System.out.println();
            System.out.println("\t"+"La clave no fue encontrada");
        }      
    }     
        
   //Metodo MergeSort___________________
           public static void MergeSortClave(ArrayList <Datos> GestEstul, int inicio, int fin) {
    if (inicio < fin) {
        int mitad = (inicio + fin) / 2;
        MergeSortClave(GestEstul, inicio, mitad);
        MergeSortClave(GestEstul, mitad + 1, fin);
        mergeClave(GestEstul, inicio, mitad, fin);
    }
}

private static void mergeClave(ArrayList <Datos> GestEstul, int inicio, int mitad, int fin) {
    int n1 = mitad - inicio + 1;
    int n2 = fin - mitad;

    Datos[] L = new Datos[n1];
    Datos[] R = new Datos[n2];

    for (int i = 0; i < n1; ++i)
        L[i] = GestEstul.get(inicio + i);
    for (int j = 0; j < n2; ++j)
        R[j] = GestEstul.get(mitad + 1 + j);

    int i = 0, j = 0;
    int k = inicio;
    while (i < n1 && j < n2) {
        if (L[i].getClave() <= R[j].getClave()) {
            GestEstul.set(k, L[i]);
            i++;
        } else {
            GestEstul.set(k, R[j]);
            j++;
        }
        k++;
    }

    while (i < n1) {
        GestEstul.set(k, L[i]);
        i++;
        k++;
    }

    while (j < n2) {
        GestEstul.set(k, R[j]);
        j++;
        k++;
    }
}
    //RadixSort___________________
public static void RadixSortClave(ArrayList <Datos> GestEstul) {
    int max = getMax(GestEstul);
    for (int exp = 1; max / exp > 0; exp *= 10) {
        countSortClave(GestEstul, exp);
    }
}

private static void countSortClave(ArrayList <Datos> GestEstul, int exp) {
    int n = GestEstul.size();
    ArrayList<Datos> output = new ArrayList<>(n);
    int i;
    int[] count = new int[10];
    Arrays.fill(count,0);

    for (i = 0; i < n; i++) {
        count[(GestEstul.get(i).getClave() / exp) % 10]++;
    }

    for (i = 1; i < 10; i++) {
        count[i] += count[i - 1];
    }

    for (i = n - 1; i >= 0; i--) {
        output.add(GestEstul.get(i));
        count[(GestEstul.get(i).getClave() / exp) % 10]--;
    }

    for (i = 0; i < n; i++) {
        GestEstul.set(i, output.get(i));
    }
}




//BucketSort___________________
public static void BucketSortClave(ArrayList <Datos> GestEstul) {
    int n = GestEstul.size();
    if (n <= 0) return;

    int max = getMax(GestEstul);
    int min = getMin(GestEstul);

    int bucketCount = (max - min) / n + 1;
    ArrayList<ArrayList<Datos>> buckets = new ArrayList<>(bucketCount);

    for (int i = 0; i < bucketCount; i++) {
        buckets.add(new ArrayList<>());
    }

    for (int i = 0; i < n; i++) {
        int bucketIndex = (GestEstul.get(i).getClave() - min) / n;
        buckets.get(bucketIndex).add(GestEstul.get(i));
    }

    int currentIndex = 0;
    for (ArrayList<Datos> bucket : buckets) {
        Collections.sort(bucket, Comparator.comparingInt(Datos::getClave));
        for (Datos data : bucket) {
            GestEstul.set(currentIndex++, data);
        }
    }
}

//CountingSort___________________
public static void CountingSortClave(ArrayList <Datos> GestEstul) {
    int max = getMax(GestEstul);
    int min = getMin(GestEstul);
    int range = max - min + 1;

    int[] count = new int[range];
    int[] output = new int[GestEstul.size()];

    for (Datos data : GestEstul) {
        count[data.getClave() - min]++;
    }

    for (int i = 1; i < range; i++) {
        count[i] += count[i - 1];
    }

    for (int i = GestEstul.size() - 1; i >= 0; i--) {
        output[count[GestEstul.get(i).getClave() - min] - 1] = GestEstul.get(i).getClave();
        count[GestEstul.get(i).getClave() - min]--;
    }

    for (int i = 0; i < GestEstul.size(); i++) {
        GestEstul.get(i).setClave(output[i]);
    }
}

private static int getMax(ArrayList <Datos> GestEstul) {
    int max = GestEstul.get(0).getClave();
    for (int i = 1; i < GestEstul.size(); i++) {
        if (GestEstul.get(i).getClave() > max) {
            max = GestEstul.get(i).getClave();
        }
    }
    return max;
}

private static int getMin(ArrayList <Datos> GestEstul) {
    int min = GestEstul.get(0).getClave();
    for (int i = 1; i < GestEstul.size(); i++) {
        if (GestEstul.get(i).getClave() < min) {
            min = GestEstul.get(i).getClave();
        }
    }
    return min;
}
//______________________* HeapSor*___________________
public static void HeapSortClave(ArrayList <Datos> GestEstul) {
    int n = GestEstul.size();
    for (int i = n / 2 - 1; i >= 0; i--)
        heapifyClave(GestEstul, n, i);

    for (int i = n - 1; i > 0; i--) {
        Datos temp = GestEstul.get(0);
        GestEstul.set(0, GestEstul.get(i));
        GestEstul.set(i, temp);

        heapifyClave(GestEstul, i, 0);
    }
}

private static void heapifyClave(ArrayList <Datos> GestEstul, int n, int i) {
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;

    if (l < n && GestEstul.get(l).getClave() > GestEstul.get(largest).getClave())
        largest = l;

    if (r < n && GestEstul.get(r).getClave() > GestEstul.get(largest).getClave())
        largest = r;

    if (largest != i) {
        Datos swap = GestEstul.get(i);
        GestEstul.set(i, GestEstul.get(largest));
        GestEstul.set(largest, swap);

        heapifyClave(GestEstul, n, largest);
    }
}
}