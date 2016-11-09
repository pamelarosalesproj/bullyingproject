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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 *
 * @author pamela
 */
public class Fuzzification {
    
    private static final Logger logger = LogManager.getLogger(Fuzzification.class.getName());

    public Fuzzification() {
    
    }
     
    public double getFuzzy(boolean printAvailable, String varname1, String varname2, String varname3, 
                            double value1, double value2, double value3){
        
    	String fileName = Constants.PATH_LONG_FCL +varname1+ Constants.UNDERLINE + varname2+ Constants.EXT_FCL;

        logger.info(Constants.MSG_INFO_FILECREATED + fileName + Constants.SINGLE_QUOTE);
        FIS fis = FIS.load(fileName,true);

        // Load the FCL file according to the inputs
        if( fis == null ) { 
           logger.error(Constants.MSG_ERROR_NOFILE +  fileName + Constants.SINGLE_QUOTE);
           
        }
        //Get the set of rules
        FunctionBlock functionBlock = fis.getFunctionBlock(null);
  
        // Entradas del Fuzzificador  
         System.out.println("\nFuzzy inputs: ");
         System.out.println("\n"+varname1+" | "+value1);
         System.out.println("\n"+varname2+" | "+value2);
         System.out.println("\n"+varname3+" | "+value3);
         
        //Set inputs
        fis.setVariable(varname1, value1);
        fis.setVariable(varname2, value2);
        fis.setVariable(varname3, value3);

        //Evaluate
        fis.evaluate();
        
        //Salida del Fuzzificador: Severity
        fis.getVariable(Constants.V_SEVERITY).getLatestDefuzzifiedValue();
              
        double result =  fis.getVariable(Constants.V_SEVERITY).getLatestDefuzzifiedValue();
        
        if (printAvailable){
             JFuzzyChart.get().chart(functionBlock);
             JFuzzyChart.get().chart(fis.getVariable(Constants.V_SEVERITY), fis.getVariable(Constants.V_SEVERITY).getDefuzzifier(), true);
        }
        return result;
     }
    
}
