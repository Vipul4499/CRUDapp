import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
//sc for scanner;
//s1/ studnet for student object;
public class Main {
     static Scanner sc=new Scanner(System.in);
     static void insertStudent(){
        Student s1=new Student();
        s1.setRollno(sc.nextInt());
        s1.setName(sc.next());
        s1.setEmail(sc.next());
//        insert
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection Con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mumbai1","root","");
            Statement st= Con.createStatement();
            st.executeUpdate("insert into student values('"+s1.getRollno()+"','"+s1.getName()+"','"+s1.getEmail()+"')");

        }
        catch(Exception e){
            System.out.println(e);
        }
    }
     static void selectStudent(int rollno){
         Student student=new Student();

//        select student
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection Con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mumbai1","root","");
            Statement st= Con.createStatement();
            ResultSet rs= st.executeQuery("select * from student where rollNo = '"+rollno+"'");
            while(rs.next()){
                student.setRollno(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setEmail(rs.getString(3));
            }
            System.out.println(student.getRollno());
            System.out.println(student.getName());
            System.out.println(student.getEmail());

        }
        catch(Exception e){
            System.out.println(e);
        }
    }
     static void updateStudent(){
         Student student= new Student();
         student.setRollno(sc.nextInt());
         student.setName(sc.next());
         student.setEmail(sc.next());
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection Con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mumbai1","root","");
            Statement st= Con.createStatement();
            st.executeUpdate("update student set name'"+student.getName()+"',email'"+student.getEmail()+"',rollNo'"+student.getRollno()+"'");
            selectStudent(student.getRollno());

        }
        catch(Exception e){
            System.out.println(e);
        }
    }
     static void deleteStudent(){
         int rollNo=sc.nextInt();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection Con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mumbai1","root","");
            Statement st= Con.createStatement();
             int count =st.executeUpdate("delete from student where rollNo ='"+rollNo+"'");
             if (count>0){
                 System.out.println("deleted");
             }

        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        insertStudent();
       selectStudent(1);
        updateStudent();
        deleteStudent();






    }

    }


