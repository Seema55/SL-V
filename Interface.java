
package rmi2;


import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Interface extends Remote
{
   // public int add(int x,int y)  throws RemoteException ;
     public int login(String uname,String pass)  throws RemoteException ;
      public int availibility(int room1,int room[])  throws RemoteException ;
          
 
}