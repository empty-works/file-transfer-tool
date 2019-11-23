/*
 */
package gws.extract.abstract_buttons;

import gws.extract.beans.MyColors;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.ImageIcon;

/**
 *
 * @author MP
 */
public class TraverseButton extends javax.swing.JPanel 
{
    final private ButtonTraverseActionInterface btai;
    final private int buttonType;
    final static public int BACK = 0, NEXT = 1;
    private ImageIcon defaultArrow, mouseOverArrow;
    
    /***************************************************************************
     * 
     ***************************************************************************/
    public TraverseButton(ButtonTraverseActionInterface btai, int buttonType) 
    {
        initComponents();
        this.btai = btai;
        this.buttonType = buttonType;
        setArrows(buttonType);
        mouseDefaultTraverseButton();
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private void setArrows(int buttonType)
    {
        switch(buttonType)
        {
            case BACK: defaultArrow = new javax.swing.ImageIcon(getClass().getResource("/gws/extract/image_assets/play-arrow-left.png"));
                       mouseOverArrow = new javax.swing.ImageIcon(getClass().getResource("/gws/extract/image_assets/play-arrow-dark-blue-left.png"));
                       break;
            case NEXT: defaultArrow = new javax.swing.ImageIcon(getClass().getResource("/gws/extract/image_assets/play-arrow.png"));
                       mouseOverArrow = new javax.swing.ImageIcon(getClass().getResource("/gws/extract/image_assets/play-arrow-dark-blue.png"));
                       break;
            default:
        }
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private void mouseOverTraverseButton()
    {
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ButtonLabel.setBackground(Color.WHITE);
        ButtonLabel.setForeground(MyColors.TRAVERSE_DARK);
        ButtonLabel.setIcon(mouseOverArrow);
        //button.setBorder(BorderFactory.createLineBorder(MyColors.DARK_ORANGE, 1));
    }
    
    /***************************************************************************
     * 
     * @param button 
     ***************************************************************************/
    private void mouseDefaultTraverseButton()
    {
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        ButtonLabel.setBackground(MyColors.DARK_ORANGE);
        ButtonLabel.setForeground(Color.WHITE);
        ButtonLabel.setIcon(defaultArrow);
        //button.setBorder(BorderFactory.createLineBorder(MyColors.TRAVERSE_DARK, 1));
    }
    
    /***************************************************************************
     *
     ***************************************************************************/ 
    private void pressType()
    {
        switch(buttonType)
        {
            case BACK: btai.pressBack();
                       break;
            case NEXT: btai.pressNext();
                       break;
            default:
        }
    }    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonLabel = new javax.swing.JLabel();

        setLayout(new java.awt.GridLayout());

        ButtonLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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
        mouseOverTraverseButton();
    }//GEN-LAST:event_ButtonLabelMouseEntered

    private void ButtonLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonLabelMouseExited
        mouseDefaultTraverseButton();
    }//GEN-LAST:event_ButtonLabelMouseExited

    private void ButtonLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonLabelMousePressed
        
        pressType();
        
    }//GEN-LAST:event_ButtonLabelMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ButtonLabel;
    // End of variables declaration//GEN-END:variables
}
