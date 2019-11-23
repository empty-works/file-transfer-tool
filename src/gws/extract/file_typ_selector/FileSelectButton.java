/*
 */
package gws.extract.file_typ_selector;

import gws.extract.beans.MyColors;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.BorderFactory;

/**
 *
 * @author MP
 */
public class FileSelectButton extends javax.swing.JPanel 
{
    final private String fileExt;
    private FileTypeSelector fileSelector;
    private boolean isCheckmarkVisible = false;
    
    /***************************************************************************
     * 
     ***************************************************************************/
    public FileSelectButton(String fileExt, FileTypeSelector fileSelector) 
    {
        initComponents();
        this.fileExt = fileExt;
        this.fileSelector = fileSelector;
        setFileExtText();
        showCheckmark(false);
        setDefaultProperties();
        setTransferPropertiesValue();
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private void setFileExtText()
    {
        ClickLabel.setText(fileExt);
    }

    /***************************************************************************
     * 
     ***************************************************************************/
    private void setTransferPropertiesValue()
    {
        if(fileSelector.getTransferPropertiesValue().equals(fileExt))
        {
            showCheckmark(true);
        }
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private void setDefaultProperties()
    {
        if(isCheckmarkVisible == false)
        {
            this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            ClickLabel.setForeground(Color.WHITE);
            FileSelectButton.this.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
            FileSelectButton.this.setBackground(MyColors.DARK_COLOR);
        }
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private void setMouseOverProperties()
    {
        if(isCheckmarkVisible == false)
        {
            this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            ClickLabel.setForeground(MyColors.DARK_COLOR);
            FileSelectButton.this.setBackground(MyColors.MOUSE_OVER_COLOR);
        }
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private void pressButton()
    {
        if(isCheckmarkVisible == false)
        {
            fileSelector.pushButton();
            fileSelector.setValue(fileExt.toLowerCase());
            setDefaultProperties();
            showCheckmark(true);
        }
    }
    
    /***************************************************************************
     * 
     * @return 
     ***************************************************************************/
    final public String getFileExt()
    {
        return fileExt;
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    final public void showCheckmark(boolean show)
    {
        isCheckmarkVisible = show;
        CheckmarkLabel.setVisible(show);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        CheckmarkLabel = new javax.swing.JLabel();
        ClickLabel = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setToolTipText(null);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        setLayout(new java.awt.GridBagLayout());

        CheckmarkLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CheckmarkLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gws/extract/image_assets/check94x75.png"))); // NOI18N
        CheckmarkLabel.setToolTipText(null);
        CheckmarkLabel.setMaximumSize(new java.awt.Dimension(200, 100));
        CheckmarkLabel.setMinimumSize(new java.awt.Dimension(200, 100));
        CheckmarkLabel.setPreferredSize(new java.awt.Dimension(200, 100));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(CheckmarkLabel, gridBagConstraints);

        ClickLabel.setFont(new java.awt.Font("Arial Black", 0, 50)); // NOI18N
        ClickLabel.setForeground(new java.awt.Color(255, 255, 255));
        ClickLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ClickLabel.setText("File Type");
        ClickLabel.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(ClickLabel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        setMouseOverProperties();
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        setDefaultProperties();
    }//GEN-LAST:event_formMouseExited

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        pressButton();
    }//GEN-LAST:event_formMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CheckmarkLabel;
    private javax.swing.JLabel ClickLabel;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
