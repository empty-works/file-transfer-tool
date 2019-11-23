/*
 */
package gws.extract.tool;

import gws.extract.beans.MyColors;

/**
 *
 * @author MP
 */
public class FilesDisplay extends javax.swing.JPanel 
{
    private int numFiles = 0;
    final static int NUM_TO_RESET = 41; // Only allows for 20 file names to be displayed.
    
    /***************************************************************************
     *
     ***************************************************************************/ 
    public FilesDisplay() 
    {
        initComponents();
        setColors();
        showMessage();
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private void setColors()
    {
        DisplayScrollPanel.getViewport().setBackground(MyColors.LIGHT_BLUE);
        DisplayTextArea.setForeground(MyColors.TRAVERSE_DARK);
        //FilesDisplay.this.setBorder(BorderFactory.createLineBorder(MyColors.TRAVERSE_DARK, 1));
    }
    
    /***************************************************************************
     * 
     * @param fileName 
     ***************************************************************************/
    final public void append(String fileName)
    {
        numFiles++;
        switch(numFiles)
        {
            case NUM_TO_RESET: clear();
                               numFiles = 0;
                               break;
            default: DisplayTextArea.append(fileName + "\n");
        }
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    final public void showMessage()
    {
        DisplayTextArea.setText("File names appear here.");
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    final public void clear()
    {
        DisplayTextArea.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        DisplayScrollPanel = new javax.swing.JScrollPane();
        DisplayTextArea = new javax.swing.JTextArea();

        setToolTipText(null);
        setOpaque(false);
        setLayout(new java.awt.GridBagLayout());

        DisplayScrollPanel.setBorder(null);
        DisplayScrollPanel.setToolTipText(null);
        DisplayScrollPanel.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        DisplayTextArea.setEditable(false);
        DisplayTextArea.setColumns(20);
        DisplayTextArea.setFont(new java.awt.Font("Courier New", 1, 11)); // NOI18N
        DisplayTextArea.setRows(5);
        DisplayTextArea.setOpaque(false);
        DisplayScrollPanel.setViewportView(DisplayTextArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(15, 5, 0, 0);
        add(DisplayScrollPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane DisplayScrollPanel;
    private javax.swing.JTextArea DisplayTextArea;
    // End of variables declaration//GEN-END:variables
}
