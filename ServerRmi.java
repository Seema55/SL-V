/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi2;

import java.rmi.registry.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class ServerRmi 
{
    
    public static void main(String args[])
    {
    try 
    {
        Registry r=java.rmi.registry.LocateRegistry.createRegistry(1099);
        r.rebind("ab", new ServerImpl());
        System.out.println(" Server is connected or object registered....");
        
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
}
    
}
