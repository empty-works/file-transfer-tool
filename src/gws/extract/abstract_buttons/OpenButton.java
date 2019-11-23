/*
 */
package gws.extract.abstract_buttons;

import gws.extract.beans.MyColors;
import java.awt.Color;
import java.awt.Cursor;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author MP
 */
public class OpenButton extends javax.swing.JPanel 
{
    final static public int DIRECTORY = 0, FILE = 1;
    private File file = null;
    final private int openType;
    final private ButtonOpenActionInterface bai;
    
    /***************************************************************************
     *
     ***************************************************************************/ 
    public OpenButton(String title, int openType, ButtonOpenActionInterface bai) 
    {
        initComponents();
        OpenLabel.setText(title);
        this.openType = openType;
        this.bai = bai;
        setButtonDefault();
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private void setButtonDefault()
    {
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        this.setBackground(MyColors.DARK_COLOR);
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        OpenLabel.setForeground(Color.WHITE);
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private void setButtonMouseOver()
    {
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setBackground(MyColors.MOUSE_OVER_COLOR);
        this.setBorder(BorderFactory.createLineBorder(MyColors.DARK_COLOR, 1));
        OpenLabel.setForeground(MyColors.DARK_COLOR);
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private void doOpenAction()
    {
        if(openType == DIRECTORY){openDirectory();}
        else if(openType == FILE){openCSVFile();}
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private void openDirectory()
    {
        JFileChooser directoryChooser = new JFileChooser();
        directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = directoryChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
            file = directoryChooser.getSelectedFile();
            if(file.isDirectory())
            {
                try
                {
                    bai.executeButtonAction();
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(this, e, "OpenButton - openDirectory", 
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private void openCSVFile()
    {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("csv", "csv");
        fileChooser.setFileFilter(filter);
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
            file = fileChooser.getSelectedFile();
            if(file.exists())
            {
                try
                {
                    bai.executeButtonAction();
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(this, e, "OpenButton - openCSVFile", 
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    
    /***************************************************************************
     * 
     * @param filename 
     ***************************************************************************/
    public void setIcon(String filename)
    {
        IconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gws/extract/image_assets/" + filename)));
    }
    
    /***************************************************************************
     * 
     * @return 
     ***************************************************************************/
    final public File getFile()
    {
        return file;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        IconLabel = new javax.swing.JLabel();
        OpenLabel = new javax.swing.JLabel();

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

        IconLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gws/extract/image_assets/sourceFolder128x128.png"))); // NOI18N
        IconLabel.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(IconLabel, gridBagConstraints);

        OpenLabel.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        OpenLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OpenLabel.setText("Choose Folder");
        OpenLabel.setToolTipText(null);
        OpenLabel.setMaximumSize(new java.awt.Dimension(59, 50));
        OpenLabel.setMinimumSize(new java.awt.Dimension(59, 50));
        OpenLabel.setPreferredSize(new java.awt.Dimension(59, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        add(OpenLabel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        setButtonMouseOver();
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        setButtonDefault();
    }//GEN-LAST:event_formMouseExited

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        doOpenAction();
    }//GEN-LAST:event_formMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IconLabel;
    private javax.swing.JLabel OpenLabel;
    // End of variables declaration//GEN-END:variables
}
