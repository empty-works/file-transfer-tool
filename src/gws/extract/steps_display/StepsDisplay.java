/*
 */
package gws.extract.steps_display;

import java.util.ArrayList;

/**
 *
 * @author MP
 */
public class StepsDisplay extends javax.swing.JPanel 
{
    private ArrayList<StepBox> stepBoxList = new ArrayList<>();
    final static private int MAX_NUM_STEPS = 5;
    
    /***************************************************************************
     * 
     ***************************************************************************/
    public StepsDisplay() 
    {
        initComponents();
        addSteps();
        showFirstStep();
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private void addSteps()
    {
        for(int i = 0; i < MAX_NUM_STEPS; i++)
        {
            stepBoxList.add(new StepBox(i));
            MainCon.add(stepBoxList.get(i));
        }
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private void showFirstStep()
    {
        stepBoxList.get(0).highLightStep(0);
    }
    
    /***************************************************************************
     * 
     * @param stepNum 
     ***************************************************************************/
    final public void takeStep(int stepNum)
    {
        for(StepBox box : stepBoxList)
        {
            box.highLightStep(stepNum);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        MainCon = new javax.swing.JPanel();

        setToolTipText(null);
        setOpaque(false);
        setLayout(new java.awt.GridBagLayout());

        MainCon.setToolTipText(null);
        MainCon.setMinimumSize(new java.awt.Dimension(550, 35));
        MainCon.setOpaque(false);
        MainCon.setPreferredSize(new java.awt.Dimension(550, 35));
        MainCon.setLayout(new java.awt.GridLayout(1, 5));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(MainCon, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainCon;
    // End of variables declaration//GEN-END:variables
}
