/*
 */
package gws.extract.file_typ_selector;

import gws.extract.beans.MyColors;
import gws.extract.beans.TransferProperties;
import gws.extract.tool.StaticVar;

/**
 *
 * @author MP
 */
public class FileTypeSelector extends javax.swing.JPanel 
{
    private FileSelectButton mp3Button, jpgButton;
    private TransferProperties transferProps;
    
    /***************************************************************************
     * 
     ***************************************************************************/
    public FileTypeSelector(TransferProperties transferProps)
    {
        initComponents();
        this.transferProps = transferProps;
        addButtons();
        setTraverseButtons();
        checkForPreviousAnswer();
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private void addButtons()
    {
        mp3Button = new FileSelectButton(StaticVar.MP3_EXT.toUpperCase(), FileTypeSelector.this);
        jpgButton = new FileSelectButton(StaticVar.IMG_EXT.toUpperCase(), FileTypeSelector.this);
        ButtonsCon.add(mp3Button);
        ButtonsCon.add(jpgButton);
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private void setTraverseButtons()
    {
        transferProps.BackButton.setVisible(false); // Always hidden for file type selection.
        transferProps.NextButton.setVisible(true);
        if(transferProps.fileType.equals(""))
        {
            transferProps.NextButton.setVisible(false);
        }
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private void checkForPreviousAnswer()
    {
        if(transferProps.fileType.equals(StaticVar.MP3_EXT)){mp3Button.showCheckmark(true);}
        if(transferProps.fileType.equals(StaticVar.IMG_EXT)){jpgButton.showCheckmark(true);}
    }

    /***************************************************************************
     * 
     ***************************************************************************/
    final public String getTransferPropertiesValue()
    {
        return transferProps.fileType;
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    final public void pushButton()
    {
        transferProps.resetValues();
        resetButtonCheckmarks();
        showNextButton();
    }

    /***************************************************************************
     * 
     ***************************************************************************/
    private void resetButtonCheckmarks()
    {
        mp3Button.showCheckmark(false);
        jpgButton.showCheckmark(false);
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private void showNextButton()
    {
        transferProps.NextButton.setVisible(true);
    }
    
    /***************************************************************************
     * 
     * @param fileExt 
     ***************************************************************************/
    final public void setValue(String fileExt)
    {
        transferProps.fileType = fileExt;
        System.out.println(transferProps.fileType);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        MainCon = new javax.swing.JPanel();
        ButtonsCon = new javax.swing.JPanel();

        setToolTipText(null);
        setMaximumSize(new java.awt.Dimension(32767, 425));
        setMinimumSize(new java.awt.Dimension(0, 425));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(0, 425));
        setLayout(new java.awt.GridLayout(1, 0));

        MainCon.setToolTipText(null);
        MainCon.setOpaque(false);
        MainCon.setPreferredSize(new java.awt.Dimension(0, 425));
        MainCon.setLayout(new java.awt.GridBagLayout());

        ButtonsCon.setToolTipText(null);
        ButtonsCon.setOpaque(false);
        ButtonsCon.setPreferredSize(new java.awt.Dimension(0, 150));
        ButtonsCon.setLayout(new java.awt.GridLayout(2, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(25, 0, 25, 0);
        MainCon.add(ButtonsCon, gridBagConstraints);

        add(MainCon);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ButtonsCon;
    private javax.swing.JPanel MainCon;
    // End of variables declaration//GEN-END:variables
}
