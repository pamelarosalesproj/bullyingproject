/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bullyingmestrado.swing;

import edu.bullyingmestrado.dao.WpUsers;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pamela
 */
public class ActivityUserTableModel extends AbstractTableModel{
    
    private final String[] colunas;
    private final List usersList;
    
    public ActivityUserTableModel(List usersList){
        colunas = new String[4];
        colunas[0] = "id";
        colunas[1] = "user name";
        colunas[2] = "first name";
        colunas[3]= "e-mail";
        this.usersList = usersList;
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
        WpUsers user = (WpUsers)this.usersList.get(rowIndex); 
        switch(columnIndex){
            case 0: return user.getId();
            case 1: return user.getUserLogin();
            case 2: return user.getDisplayName();
            case 3: return user.getUserEmail();
            default: return null;
        }   
    }

    @Override
    public int getRowCount() {
        return this.usersList.size();
    }
    
}
