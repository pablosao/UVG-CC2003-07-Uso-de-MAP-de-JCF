
/**
 * Clase para seleccionar el tipo de implementación que se desea utilizar en map
 * @author pablo
 * @version 01/03/2019
 */

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class FactoryMaps{
    
    /***
     * Metodo para obtención de las diferentes implementaciones de MAPs
     * @param opcion opción de map que se desea implementar
     * @return instancia del maps seleccionado
     */
    public Map MAPS(String opcion){
        // Opción para HashMAP
        if(opcion.equals("HM")){
            return new HashMap<String, String>();
        }
        //Opcion para 
        else if(opcion.equals("TM")){
            return new TreeMap<String,String>();
        }
        else if (opcion.equals("LH")){
            return new LinkedHashMap<String,String>();
        }
        
        return null;
    }
}
