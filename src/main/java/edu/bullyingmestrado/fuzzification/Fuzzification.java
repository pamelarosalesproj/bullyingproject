/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bullyingmestrado.fuzzification;
import edu.bullyingmestrado.commons.Constants;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
/**
 *
 * @author pamela
 */
public class Fuzzification {
    
    public Fuzzification() {
    
    }
     
    public double getFuzzy(String varname1, String varname2, String varname3, 
                            double value1, double value2, double value3){
    	String fileName = "src/main/resources/fcl/" +varname1+ Constants.UNDERLINE + varname2+ Constants.EXT_FCL;
        System.out.println("nome arquivo fcl " + fileName);
        FIS fis = FIS.load(fileName,true);

        // Cargar el archivo FCL
        if( fis == null ) { 
            System.err.println("ERROR - No se puede encontrar el archivo: '" + fileName + "'");
           
        }
     // Obtener el conjunto de Reglas
        FunctionBlock functionBlock = fis.getFunctionBlock(null);
  
     // Entradas del Fuzzificador  
        JFuzzyChart.get().chart(functionBlock);
         System.out.println("\nFuzzy inputs: ");
         System.out.println("\n"+varname1+" | "+value1);
         System.out.println("\n"+varname2+" | "+value2);
         System.out.println("\n"+varname3+" | "+value3);
     // Set inputs
        fis.setVariable(varname1, value1);
        fis.setVariable(varname2, value2);
        fis.setVariable(varname3, value3);

     // Evaluate
        fis.evaluate();
        
     // Salida del Fuzzificador: Severity
        fis.getVariable(Constants.V_SEVERITY).getLatestDefuzzifiedValue();
        
     // Grafico del fuzzificador
       JFuzzyChart.get().chart(fis.getVariable(Constants.V_SEVERITY), fis.getVariable(Constants.V_SEVERITY).getDefuzzifier(), true);

     
        double result =  fis.getVariable(Constants.V_SEVERITY).getLatestDefuzzifiedValue();
        return result;
     }
    
}
