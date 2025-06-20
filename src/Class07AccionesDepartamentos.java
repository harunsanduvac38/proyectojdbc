import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Class07AccionesDepartamentos {

    public static void main (String[] args) {

        Scanner teclado = new Scanner(System.in);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionString = "jdbc:mysql://localhost:3306/hospital";
            Connection cn = DriverManager.getConnection(connectionString, "root", "root");

            // SELECT * FROM hospital.DEPT;
            String sql = "SELECT * FROM DEPT";
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("\nID Dept.   Nombre Dept.      Locacion Dept.  \n");

            while(rs.next()) {
                String deptNo = rs.getString("DEPT_NO");
                String deptNombre = rs.getString("DNOMBRE");
                String deptLoc = rs.getString("LOC");
                
                System.out.println(deptNo + "    " + deptNombre + "      " + deptLoc);
            }

            System.out.println("Elige: \n1- INSERTAR DEPARTAMENTO\n2- MODIFICAR DEPARTAMENTO\n3-ELIMINAR DEPARTAMENTO");
            int opcion = Integer.parseInt(teclado.nextLine());

            String idDept = "";
            String nombreDept = "";
            String locDept = "";

            if(opcion==1){
                System.out.println("ID Departamento:");
                idDept = teclado.nextLine();
                System.out.println("Nombre Departamento:");
                nombreDept = teclado.nextLine().toUpperCase();
                System.out.println("Locacion Departamento:");
                locDept = teclado.nextLine().toUpperCase();
                // insert into DEPT values(50, 'TEST', 'LOCALTEST');
                String sqlInsert = "INSERT INTO DEPT VALUES(" + idDept + ", '" + nombreDept + "', '" + locDept + "')";

                int inserted = st.executeUpdate(sqlInsert);
                System.out.println("DEPARTAMENTO INSERTADO: " + inserted);

            }else if(opcion==2) {
                System.out.println("ID Departamento:");
                idDept = teclado.nextLine();
                System.out.println("Nombre Departamento:");
                nombreDept = teclado.nextLine().toUpperCase();
                System.out.println("Locacion Departamento:");
                locDept = teclado.nextLine().toUpperCase();
                // update DEPT set DNOMBRE='MANANA', LOC='ESPANA' where DEPT_NO=60;
                String sqlModificar = "UPDATE DEPT SET DNOMBRE='" + nombreDept + "', LOC='" + locDept + "' where DEPT_NO=" + idDept;
                System.out.println(sqlModificar);

                int modificado = st.executeUpdate(sqlModificar);

                System.out.println("DEPARTAMENTO MODIFICADO :" + modificado);
            }else if(opcion==3) {
                System.out.println("ID Departamento:");
                idDept = teclado.nextLine();

                // DELETE FROM DEPT WHERE DEPT_NO=50;
                String sqlEliminar = "DELETE FROM DEPT WHERE DEPT_NO=" + idDept;

                int eliminado = st.executeUpdate(sqlEliminar);
                System.out.println("DEPARTAMENTO ELIIMINADO: " + eliminado);

            }

            System.out.println("\nNO Dept.   Nombre Dept.      Locacion Dept.  \n");
            rs = st.executeQuery(sql);

            while(rs.next()) {
                String deptNo = rs.getString("DEPT_NO");
                String deptNombre = rs.getString("DNOMBRE");
                String deptLoc = rs.getString("LOC");
                
                System.out.println(deptNo + "         " + deptNombre + "         " + deptLoc);
            }


            rs.close();
            cn.close();
        } catch(Exception e){
            System.out.println("Error: " + e);
        }


    }
}