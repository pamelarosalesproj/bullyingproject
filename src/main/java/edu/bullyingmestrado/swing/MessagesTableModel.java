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
        colunas = new String[7];
        
      /*  colunas[0] = "Id User";
        colunas[1] = "Id Conversation";
        colunas[2] = "id Comment";*/
        colunas[0] = "Message";
        colunas[1] = "bullying";
        colunas[2] = "teasing";
        colunas[3] = "author";
        colunas[4] = "form";
        colunas[5]= "fuzzy?";
        colunas[6]= "severity";
        /*colunas[0] = "user name";
        colunas[1] = "login name";
        colunas[2] = "message";
        colunas[3]=  "is bullying trace?";
        colunas[4]=  "is teasing trace?";
        colunas[5]= "author";
        colunas[6]= "bullying type";
        colunas[7]= "severity";*/
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
           
            case 0: return tweet.getText();
            case 1: return tweet.getBullyingTraceClassResult();
            case 2: return tweet.getTeasingTraceClassResult();
            case 3: return tweet.getAuthorRoleClassResult();
            case 4: return tweet.getFormBullyingClassResult();
            case 5: return tweet.getValidForFuzzified();
            case 6: return tweet.getValueSeverity();
            default: return null;
        }   
    }

    @Override
    public int getRowCount() {
        return this.messagesList.size();
    }
    
   
    
}
