import java.sql.Connection;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Class03BuscadorPlantillaFuncion {
    public static void main(String[] args){

        String funcionTeclado = "";
        Scanner teclado = new Scanner(System.in);
        System.out.println("Eliga una Función: \n 1 - ENFERMERA \n 2 - INTERINO" );
        int num = teclado.nextInt();
        if(num == 1){
            funcionTeclado =  "'ENFERMERA'";
        }else if(num==2) {
            funcionTeclado = "'INTERINO'";
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String connectionString = "jdbc:mysql://localhost:3306/hospital";

            Connection cn = DriverManager.getConnection(connectionString, "root", "root");

            String sql = "SELECT APELLIDO, FUNCION, SALARIO FROM PLANTILLA WHERE FUNCION=" + funcionTeclado;

            Statement st = cn.createStatement();

            ResultSet rs = st.executeQuery(sql);
            System.out.println("APELLIDO    FUNCIÓN     SALARIO\n");

            while(rs.next()) {

                String apellido = rs.getString("apellido");
                String funcion = rs.getString("funcion");
                String salario = rs.getString("salario");

                System.out.println(apellido + " - " + funcion + " - " + salario);
            }

            rs.close();
            cn.close();

        } catch (Exception e){
            System.out.println("Error es: " + e);
        }

    
    }


    
}
