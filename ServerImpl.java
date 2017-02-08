/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ServerImpl  extends UnicastRemoteObject implements Interface
{
    
    // String username;
     String password;
    public ServerImpl() throws RemoteException
    {
       
        //username="Seema";
        //password="dongare";
        
    }
    
     public int login(String uname,String pass)  throws RemoteException
    {
         String a="seema";
         String b="dongare";
         if(uname.equals(a) && pass.equals(b))
         {
	      return 1;
         }
					
         else	
         {
	       return 0;
         }
    }
    
   // ClientRmi c=new ClientRmi();
    /*
    public int login(String uname,String pass,String user1[], String pass1[])  throws RemoteException
    {  int flag=0;
        for(int i=0;i<user1.length;i++)
        {
         if(uname.equals(user1[i]) && pass.equals(pass1[i]))
         {
	     flag=1;
         }
					
         else	
         {
	      flag=0;
         }
        }
        
       if(flag==1)
                    return 1;
             else
                 return 0;
    }
    */
   public int availibility(int c1,int room[])
	{
            int flag=0;
	    for(int i=0;i<room.length;i++)
            {
              if(c1==room[i])
                  flag=1;
             // break;
               
            }
             if(flag==1)
                    return 1;
             else
                 return 0;


        }
}