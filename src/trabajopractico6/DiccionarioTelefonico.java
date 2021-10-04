/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajopractico6;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author sant
 */
public class DiccionarioTelefonico {
    static TreeMap<Long, Cliente> telefonos = new TreeMap();
    
    static boolean agregarCliente(Cliente cliente, long telefono){
        if(telefonos.containsKey(telefono)){
            return false;
        }
        telefonos.put(telefono, cliente);
        return true;
    }
    
    static Cliente buscarCliente(long telefono){
        return telefonos.get(telefono);
    }
    
    static List<Long> buscarTelefono(String apellido){
        ArrayList<Long> numeros = new ArrayList();
        
       for(Map.Entry<Long, Cliente> e:telefonos.entrySet()){
           Long clave = e.getKey();
           Cliente valor = e.getValue();
           
           if(valor.getApellido().equals(apellido)){
                numeros.add(clave);
            }
       }
        
       return numeros;
    }
    
    static List<Cliente> buscarClientes(String ciudad){
        ArrayList<Cliente> clientes = new ArrayList();
        
       for(Map.Entry<Long, Cliente> e:telefonos.entrySet()){
           Long clave = e.getKey();
           Cliente valor = e.getValue();
           
           if(valor.getCiudad().equals(ciudad)){
           clientes.add(valor);
           }  
       }
       return clientes;
    }
       
    static void borrarCliente(long dni){
        Long telefono = null;
        for (Map.Entry<Long, Cliente> e : telefonos.entrySet()) {
            Long clave = e.getKey();
            Cliente valor = e.getValue();
            if(valor.getDni() == dni){
                telefono = clave;
            }
        }
        if(telefono != null){
            telefonos.remove(telefono);
        }
        
    }
}
