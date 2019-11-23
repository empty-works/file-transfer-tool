/*
 */
package gws.extract.confirm_display;

import gws.extract.beans.MyColors;
import gws.extract.beans.TransferProperties;
import java.awt.Color;
import javax.swing.BorderFactory;

/**
 *
 * @author MP
 */
public class ConfirmDisplay extends javax.swing.JPanel 
{
    final private TransferProperties transferProps;
    
    /***************************************************************************
     * 
     ***************************************************************************/
    public ConfirmDisplay(TransferProperties transferProps) 
    {
        initComponents();
        this.transferProps = transferProps;
        setColors();
        addButtons();
        setTraverseButtons();
        setNames();
        setPropsObjects();
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private void setColors()
    {
        SourceLabel.setForeground(Color.WHITE);
        SourceLabel.setBackground(MyColors.TRAVERSE_DARK);
        SourceFolderName.setBackground(MyColors.TRAVERSE_LIGHT);
        SourceFolderName.setForeground(MyColors.TRAVERSE_DARK);
        
        DestinationLabel.setForeground(Color.WHITE);
        DestinationLabel.setBackground(MyColors.TRAVERSE_DARK);
        DestinationFolderName.setBackground(MyColors.TRAVERSE_LIGHT);
        DestinationFolderName.setForeground(MyColors.TRAVERSE_DARK);
        
        CSVLabel.setForeground(Color.WHITE);
        CSVLabel.setBackground(MyColors.TRAVERSE_DARK);
        CSVFileName.setBackground(MyColors.TRAVERSE_LIGHT);
        CSVFileName.setForeground(MyColors.TRAVERSE_DARK);
        
        TopPanel.setBorder(BorderFactory.createLineBorder(MyColors.TRAVERSE_DARK, 1));
        TransferProgressBar.setBorder(BorderFactory.createLineBorder(MyColors.TRAVERSE_DARK, 1));
        //ProcessedFilesCon.setBorder(BorderFactory.createLineBorder(MyColors.DARK_GREEN, 1));
        NumFilesTransferredLabel.setForeground(MyColors.DARK_GREEN);
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private void addButtons()
    {
        CopyMoveCon.add(new CopyButton(transferProps));
        CopyMoveCon.add(new MoveButton(transferProps));
    }
    
     /***************************************************************************
     * 
     ***************************************************************************/
    private void setTraverseButtons()
    {
        transferProps.BackButton.setVisible(true);
        transferProps.NextButton.setVisible(false);
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private void setNames()
    {
        SourceFolderName.setText(transferProps.sourceName);
        DestinationFolderName.setText(transferProps.targetName);
        CSVFileName.setText(transferProps.csvName);
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private void setPropsObjects()
    {
        transferProps.CopyMoveCon = CopyMoveCon;
        transferProps.NumTransferFilesLabel = NumFilesTransferredLabel;
        TransferProgressBar.setIndeterminate(true);
        TransferProgressBar.setStringPainted(true);
        transferProps.TransferProgressBar = TransferProgressBar;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        TopPanel = new javax.swing.JPanel();
        SourceCon = new javax.swing.JPanel();
        SourceLabel = new javax.swing.JLabel();
        SourceFolderName = new javax.swing.JLabel();
        DestinationCon = new javax.swing.JPanel();
        DestinationLabel = new javax.swing.JLabel();
        DestinationFolderName = new javax.swing.JLabel();
        CSVCon = new javax.swing.JPanel();
        CSVLabel = new javax.swing.JLabel();
        CSVFileName = new javax.swing.JLabel();
        ProcessedFilesCon = new javax.swing.JPanel();
        ArrowsCon = new javax.swing.JPanel();
        NumFilesTransferredLabel = new javax.swing.JLabel();
        CopyMoveCon = new javax.swing.JPanel();
        TransferProgressBar = new javax.swing.JProgressBar();

        setToolTipText(null);
        setOpaque(false);
        setLayout(new java.awt.GridBagLayout());

        TopPanel.setBackground(new java.awt.Color(255, 255, 255));
        TopPanel.setToolTipText(null);
        TopPanel.setOpaque(false);
        TopPanel.setPreferredSize(new java.awt.Dimension(0, 170));
        TopPanel.setLayout(new java.awt.GridLayout(4, 0));

        SourceCon.setToolTipText(null);
        SourceCon.setOpaque(false);
        SourceCon.setLayout(new java.awt.GridBagLayout());

        SourceLabel.setBackground(new java.awt.Color(0, 153, 153));
        SourceLabel.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        SourceLabel.setForeground(new java.awt.Color(255, 255, 255));
        SourceLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        SourceLabel.setText(" Source Folder: ");
        SourceLabel.setToolTipText(null);
        SourceLabel.setMaximumSize(new java.awt.Dimension(200, 0));
        SourceLabel.setMinimumSize(new java.awt.Dimension(200, 0));
        SourceLabel.setOpaque(true);
        SourceLabel.setPreferredSize(new java.awt.Dimension(200, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 0.1;
        SourceCon.add(SourceLabel, gridBagConstraints);

        SourceFolderName.setBackground(new java.awt.Color(0, 255, 255));
        SourceFolderName.setFont(new java.awt.Font("Arial Black", 0, 13)); // NOI18N
        SourceFolderName.setForeground(new java.awt.Color(0, 102, 102));
        SourceFolderName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SourceFolderName.setToolTipText(null);
        SourceFolderName.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        SourceCon.add(SourceFolderName, gridBagConstraints);

        TopPanel.add(SourceCon);

        DestinationCon.setToolTipText(null);
        DestinationCon.setOpaque(false);
        DestinationCon.setLayout(new java.awt.GridBagLayout());

        DestinationLabel.setBackground(new java.awt.Color(0, 153, 153));
        DestinationLabel.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        DestinationLabel.setForeground(new java.awt.Color(255, 255, 255));
        DestinationLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        DestinationLabel.setText(" Destination Folder: ");
        DestinationLabel.setToolTipText(null);
        DestinationLabel.setMaximumSize(new java.awt.Dimension(200, 0));
        DestinationLabel.setMinimumSize(new java.awt.Dimension(200, 0));
        DestinationLabel.setOpaque(true);
        DestinationLabel.setPreferredSize(new java.awt.Dimension(200, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 0.1;
        DestinationCon.add(DestinationLabel, gridBagConstraints);

        DestinationFolderName.setBackground(new java.awt.Color(0, 255, 255));
        DestinationFolderName.setFont(new java.awt.Font("Arial Black", 0, 13)); // NOI18N
        DestinationFolderName.setForeground(new java.awt.Color(0, 102, 102));
        DestinationFolderName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DestinationFolderName.setToolTipText(null);
        DestinationFolderName.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        DestinationCon.add(DestinationFolderName, gridBagConstraints);

        TopPanel.add(DestinationCon);

        CSVCon.setToolTipText(null);
        CSVCon.setOpaque(false);
        CSVCon.setLayout(new java.awt.GridBagLayout());

        CSVLabel.setBackground(new java.awt.Color(0, 153, 153));
        CSVLabel.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        CSVLabel.setForeground(new java.awt.Color(255, 255, 255));
        CSVLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        CSVLabel.setText(" CSV File: ");
        CSVLabel.setToolTipText(null);
        CSVLabel.setMaximumSize(new java.awt.Dimension(200, 21));
        CSVLabel.setMinimumSize(new java.awt.Dimension(200, 21));
        CSVLabel.setOpaque(true);
        CSVLabel.setPreferredSize(new java.awt.Dimension(200, 21));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 0.1;
        CSVCon.add(CSVLabel, gridBagConstraints);

        CSVFileName.setBackground(new java.awt.Color(0, 255, 255));
        CSVFileName.setFont(new java.awt.Font("Arial Black", 0, 13)); // NOI18N
        CSVFileName.setForeground(new java.awt.Color(0, 102, 102));
        CSVFileName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CSVFileName.setToolTipText(null);
        CSVFileName.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        CSVCon.add(CSVFileName, gridBagConstraints);

        TopPanel.add(CSVCon);

        ProcessedFilesCon.setBackground(new java.awt.Color(102, 255, 102));
        ProcessedFilesCon.setToolTipText(null);
        ProcessedFilesCon.setLayout(new java.awt.GridLayout(1, 0));

        ArrowsCon.setToolTipText(null);
        ArrowsCon.setOpaque(false);
        ArrowsCon.setLayout(new java.awt.GridLayout(1, 4));

        NumFilesTransferredLabel.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        NumFilesTransferredLabel.setForeground(new java.awt.Color(255, 255, 255));
        NumFilesTransferredLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NumFilesTransferredLabel.setText("Ready to transfer files...");
        NumFilesTransferredLabel.setToolTipText(null);
        ArrowsCon.add(NumFilesTransferredLabel);

        ProcessedFilesCon.add(ArrowsCon);

        TopPanel.add(ProcessedFilesCon);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        add(TopPanel, gridBagConstraints);

        CopyMoveCon.setToolTipText(null);
        CopyMoveCon.setMinimumSize(new java.awt.Dimension(100, 155));
        CopyMoveCon.setOpaque(false);
        CopyMoveCon.setPreferredSize(new java.awt.Dimension(0, 155));
        CopyMoveCon.setLayout(new java.awt.GridLayout(1, 2));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(CopyMoveCon, gridBagConstraints);

        TransferProgressBar.setFont(new java.awt.Font("Arial Black", 1, 30)); // NOI18N
        TransferProgressBar.setToolTipText(null);
        TransferProgressBar.setMaximumSize(new java.awt.Dimension(32767, 155));
        TransferProgressBar.setMinimumSize(new java.awt.Dimension(10, 155));
        TransferProgressBar.setPreferredSize(new java.awt.Dimension(148, 155));
        TransferProgressBar.setString("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(TransferProgressBar, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ArrowsCon;
    private javax.swing.JPanel CSVCon;
    private javax.swing.JLabel CSVFileName;
    private javax.swing.JLabel CSVLabel;
    private javax.swing.JPanel CopyMoveCon;
    private javax.swing.JPanel DestinationCon;
    private javax.swing.JLabel DestinationFolderName;
    private javax.swing.JLabel DestinationLabel;
    public javax.swing.JLabel NumFilesTransferredLabel;
    private javax.swing.JPanel ProcessedFilesCon;
    private javax.swing.JPanel SourceCon;
    private javax.swing.JLabel SourceFolderName;
    private javax.swing.JLabel SourceLabel;
    private javax.swing.JPanel TopPanel;
    protected javax.swing.JProgressBar TransferProgressBar;
    // End of variables declaration//GEN-END:variables
}
