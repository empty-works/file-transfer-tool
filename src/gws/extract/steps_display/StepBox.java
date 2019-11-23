/*
 */
package gws.extract.steps_display;

import gws.extract.beans.MyColors;
import java.awt.Color;

/**
 *
 * @author MP
 */
public class StepBox extends javax.swing.JPanel 
{
    private int stepNum;
    
    /***************************************************************************
     * 
     ***************************************************************************/
    public StepBox(int stepNum) 
    {
        initComponents();
        this.stepNum = stepNum;
        StepLabel.setText("" + (stepNum + 1));
        setDefaultColors();
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private void setDefaultColors()
    {
        StepLabel.setBackground(MyColors.TRAVERSE_DARK);
        StepLabel.setForeground(Color.WHITE);
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private void setHighlightedColors()
    {
        StepLabel.setBackground(Color.WHITE);
        StepLabel.setForeground(MyColors.TRAVERSE_DARK);
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    final public void highLightStep(int incomingStepNum)
    {
        if(stepNum == incomingStepNum)
        {
            setHighlightedColors();
        }
        else
        {
            setDefaultColors();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        StepLabel = new javax.swing.JLabel();

        setToolTipText(null);
        setMinimumSize(new java.awt.Dimension(110, 65));
        setPreferredSize(new java.awt.Dimension(110, 65));
        setLayout(new java.awt.GridLayout(1, 0));

        StepLabel.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        StepLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        StepLabel.setText("Step 0");
        StepLabel.setToolTipText(null);
        StepLabel.setMaximumSize(new java.awt.Dimension(235, 45));
        StepLabel.setMinimumSize(new java.awt.Dimension(235, 45));
        StepLabel.setOpaque(true);
        add(StepLabel);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel StepLabel;
    // End of variables declaration//GEN-END:variables
}
