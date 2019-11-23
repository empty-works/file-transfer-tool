/*
 */
package gws.extract.abstract_buttons;

import gws.extract.beans.MyColors;
import gws.extract.beans.TransferProperties;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.BorderFactory;

/**
 *
 * @author MP
 */
public abstract class ConfirmButton extends javax.swing.JPanel 
{
    protected TransferProperties transProps;
    
    /***************************************************************************
     * 
     ***************************************************************************/
    public ConfirmButton(TransferProperties tp) 
    {
        initComponents();
        this.transProps = tp;
        setButtonDefault();
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private void setButtonDefault()
    {
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        ButtonLabel.setBackground(MyColors.DARK_COLOR);
        ButtonLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        ButtonLabel.setForeground(Color.WHITE);
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private void setButtonMouseOver()
    {
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ButtonLabel.setBackground(MyColors.MOUSE_OVER_COLOR);
        ButtonLabel.setBorder(BorderFactory.createLineBorder(MyColors.DARK_COLOR, 1));
        ButtonLabel.setForeground(MyColors.DARK_COLOR);
    }

    /***************************************************************************
     * 
     ***************************************************************************/
    abstract protected void doAction();
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonLabel = new javax.swing.JLabel();

        setToolTipText(null);
        setOpaque(false);
        setLayout(new java.awt.GridLayout(1, 0));

        ButtonLabel.setFont(new java.awt.Font("Arial Black", 0, 60)); // NOI18N
        ButtonLabel.setForeground(new java.awt.Color(255, 255, 255));
        ButtonLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ButtonLabel.setText("Copy");
        ButtonLabel.setToolTipText(null);
        ButtonLabel.setOpaque(true);
        ButtonLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonLabelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ButtonLabelMousePressed(evt);
            }
        });
        add(ButtonLabel);
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonLabelMouseEntered
        
        setButtonMouseOver();
        
    }//GEN-LAST:event_ButtonLabelMouseEntered

    private void ButtonLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonLabelMouseExited
        
        setButtonDefault();
        
    }//GEN-LAST:event_ButtonLabelMouseExited

    private void ButtonLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonLabelMousePressed
        
        doAction();
        
    }//GEN-LAST:event_ButtonLabelMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JLabel ButtonLabel;
    // End of variables declaration//GEN-END:variables
}
