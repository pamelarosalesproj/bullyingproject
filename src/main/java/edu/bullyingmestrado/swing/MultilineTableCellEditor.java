/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bullyingmestrado.swing;

/**
 *
 * @author pamela
 */
import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class MultilineTableCellEditor extends AbstractCellEditor implements TableCellEditor {

    JComponent component = new JTextArea();
    JTable table;
    int lastRowIndex;

    public MultilineTableCellEditor() {
        JTextArea textArea = ((JTextArea) component);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                table.setRowHeight(lastRowIndex, (int) (textArea.getPreferredSize().getHeight()));
            }
        });
        textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                table.setRowHeight(lastRowIndex, (int) (textArea.getPreferredSize().getHeight()));
            }
        });
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected,
                                                 int rowIndex, int vColIndex) {
        this.table = table;
        lastRowIndex = rowIndex;

        ((JTextArea) component).setText((String) value);
        component.setFont(table.getFont());

        return component;
    }

    public Object getCellEditorValue() {
        return ((JTextArea) component).getText();
    }
}