
package rmi2;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class ClientRmi 
{
    
    int x,y;
      
    public static void main(String arg[])
    {
        
         String  user1[]={" "," "};
         String pass1[]={" "," "};
         
               int room[]=new int[6];
        Scanner sc=new Scanner(System.in);
        while(true)
        {
        try
         {
      
              ClientRmi c=new ClientRmi();
             
                    Interface c1=(Interface)Naming.lookup("//localhost/ab");
            
                      Class.forName("com.mysql.jdbc.Driver");  
                     Connection con=DriverManager.getConnection(  
                          "jdbc:mysql://localhost:3306/ab","root","root");  
                  //here sonoo is database name, root is username and password  
                          Statement stmt=con.createStatement();  
                    
                     
                  //Statement stmt1=con.createStatement();  
                     
                 
                     
                 /*    
                      String sql = "CREATE TABLE register " +
                       " name VARCHAR(255), " + 
                   "  address VARCHAR(255), " + 
                   " panno INTEGER, " + 
                   "roomno INTEGER ,";
                    stmt.executeUpdate(sql);
                       ResultSet rs1=stmt.executeQuery("select * from register"); 
                       
                     
                     while(rs1.next())  
                     {
                     //  user1=rs.getString(1);
                      // pass1=rs.getString(2);
                      //System.out.println(pass1);
                         //System.out.println(user1);
                       System.out.println(rs1.getString(1)+" "+rs1.getString(2)+" "+rs1.getInt(3)+" "+rs1.getInt(4));  
        //             con.close();
                     }
                */
        
        System.out.println("*********************Hotel Manangement System********************");
        System.out.println("1. Login.");
        System.out.println("2. View Details Hotel.");
         System.out.println("3. Enter your details for booking");
             System.out.println("4. Cancle booking");
             System.out.println("5.Exit");
        System.out.println("\n Please select a service which u want to acess:");
        int op1 = sc.nextInt();
        
        
        
        switch(op1)
        {
            case 1:
                
                /*
                     ResultSet rs=stmt.executeQuery("select * from login"); 
                       int j=0;
                       while(rs.next())  
                     {
                       
                       user1[j]=rs.getString(1);
                       pass1[j]=rs.getString(2);
                      // System.out.println(pass1);
                        // System.out.println(user1);
                      // System.out.println(rs.getString(1)+" "+rs.getString(2));  
        //             con.close();
                         j++;
                     } 
                       for(j=0;j<user1.length;j++)
                           System.out.println(" "+user1[j]);*/
                
                    
                     System.out.println("Enter your Login id ");
                          String uname1=sc.next();
                         System.out.println("Enter your password");
                    String pass2=sc.next();
                    
                     int n=c1.login(uname1,pass2) ;
                     if(n==1)
                         System.out.println("success");
                     
                     else
                         System.out.println("fail");
         
                   
                break;
                  
            case 2:
                     ResultSet rs1=stmt.executeQuery("select * from room"); 
                     int i=0;
                     while(rs1.next())  
                     {
                       
                       System.out.println(rs1.getInt(1));  
                       room[i]=rs1.getInt(1);
                       i++;
                     }
                     
                        //   for (i=0;i<room.length;i++)
                      //   System.out.println(room[i]);
                     
                     
                     System.out.println("Plz enter the room no u want to book");
                     int room1=sc.nextInt();
                      int r=c1.availibility(room1,room);
                    if(r==1)
                        System.out.println("room  is available");
                    else
                        System.out.println(" room is not availabel");
                    
                break;
                
            case 3:
                 
                  ResultSet rs2=stmt.executeQuery("select * from booking"); 
                  while(rs2.next())
                  {
                      System.out.println(rs2.getString(1)+" \t "+rs2.getString(2)+" \t "+rs2.getInt(3)+" \t "+rs2.getInt(4));
                  }
                System.out.println("Enter your name");
                String name=sc.next();
               
                 System.out.println("Enter your Address");
                String address=sc.next();
                
                
                System.out.println("Enter your panno");
                int panno=sc.nextInt();
                
                
                 System.out.println("Enter your Room no");
                int roomno=sc.nextInt();
                
                   String sql = "INSERT INTO booking(name,address,panno,roomno)"+"VALUES('"+name+"','"+address+"','"+panno+"','"+roomno+"')";
                   stmt.executeUpdate(sql);
                break;
                  
                
                
            case 4:
                System.out.println("**********CANCLE BOOKING**********");
                ResultSet rs3=stmt.executeQuery("select * from booking"); 
                  while(rs3.next())
                  {
                      System.out.println(rs3.getString(1)+" \t "+rs3.getString(2)+" \t "+rs3.getInt(3)+" \t "+rs3.getInt(4));
                  }
                  
                  System.out.println("Enter roomnofor cancle the booking");
                  String roomno1=sc.next();
                  
                  
                  String SQL = "DELETE FROM booking WHERE roomno = "+roomno1+" ";
                  stmt.executeUpdate(SQL);
                  
                  
                 System.out.println("**********All booking in Database***********"); 
                 ResultSet rs4=stmt.executeQuery("select * from booking"); 
                  while(rs4.next())
                  {
                      System.out.println(rs4.getString(1)+" \t "+rs4.getString(2)+" \t "+rs4.getInt(3)+" \t "+rs4.getInt(4));
                  }
                   
                  
                
                break;
            case 5: 
                System.exit(0);
                con.close();  
                break;
                    
            default:
                System.out.println("plz enter corect choice");
                     break;
        }
        
         
         }
         catch(Exception e)
         {
             System.out.println(e);
             
         }
         
    }
    
    
    }   
}