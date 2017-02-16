/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bullyingmestrado.swing;

import edu.bullyingmestrado.commons.Constants;
import edu.bullyingmestrado.dao.WpBpActivity;
import edu.bullyingmestrado.dao.WpUsers;
import edu.bullyingmestrado.entities.MessagesUser;
import edu.bullyingmestrado.entities.Tweet;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pamela
 */
public class MessagesTableModel extends AbstractTableModel{
    private final String[] colunas;
    private final List messagesList;
    
    public MessagesTableModel(List messagesList){
        colunas = new String[8];
        
      /*  colunas[0] = "Id User";*/
        colunas[0] = "Id";
      //  colunas[2] = "id Comment";
        colunas[1] = "Message";
        colunas[2] = "bullying";
        colunas[3] = "teasing";
        colunas[4] = "author";
        colunas[5] = "form";
        colunas[6]= "fuzzy?";
        colunas[7]= "severity";
        this.messagesList = messagesList;
        System.out.println("Total Messages:" + messagesList.size());
        
    }
    
    
    @Override
    public int getColumnCount() {
       return this.colunas.length;
    }
    
     @Override
    public String getColumnName(int num){
        return this.colunas[num];
    }

    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tweet tweet = (Tweet)this.messagesList.get(rowIndex); 
       
        
        switch(columnIndex){
            case 0: return tweet.getTextId();
            case 1: return tweet.getText();
            case 2: return tweet.getBullyingTraceClassResult();
            case 3: return tweet.getTeasingTraceClassResult();
            case 4: return tweet.getAuthorRoleClassResult();
            case 5: return tweet.getFormBullyingClassResult();
            case 6: return tweet.getValidForFuzzified();
            case 7: return tweet.getValueSeverity();
            default: return null;
        }   
    }

    @Override
    public int getRowCount() {
        return this.messagesList.size();
    }
    
   
    
}
