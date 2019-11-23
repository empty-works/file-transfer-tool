/*
 */
package gws.extract.tool;

import gws.extract.abstract_buttons.ButtonTraverseActionInterface;
import gws.extract.abstract_buttons.TraverseButton;
import gws.extract.beans.MyColors;
import gws.extract.beans.TransferProperties;
import gws.extract.confirm_display.ConfirmDisplay;
import gws.extract.csv_selector.CSVSelector;
import gws.extract.dest_dir_display.DestDirDisplay;
import gws.extract.file_typ_selector.FileTypeSelector;
import gws.extract.source_file_display.SourceDirDisplay;
import gws.extract.steps_display.StepsDisplay;
import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;

/**
 * @author MP
 */
public class FileTransferTool extends javax.swing.JFrame implements ButtonTraverseActionInterface
{
    final private TransferProperties transferProperties = new TransferProperties();
    private int stepNum = 0;
    private FilesDisplay fd;
    private StepsDisplay sd;
    
    /***************************************************************************
     * Constructor
     ***************************************************************************/
    public FileTransferTool() 
    {
        initComponents();
        setColors();
        setPosition();
        addStepsDisplay();
        addTraverseButtons();
        addFilesDisplay();
        addFirstStep();
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private void setPosition()
    {
        this.setLocationRelativeTo(null);
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private void setColors()
    {
        MainCon.setBackground(MyColors.LIGHT_BLUE);
        MainCon.setBorder(BorderFactory.createLineBorder(MyColors.TRAVERSE_DARK, 2));
        StepsPanel.setBackground(MyColors.LIGHT_BLUE);
        MiddleCon.setBackground(MyColors.LIGHT_BLUE);
        //SidePanel.setBackground(MyColors.LIGHT_BLUE);
        TopPanel.setBackground(MyColors.LIGHT_BLUE);
        MiddlePanel.setBackground(MyColors.LIGHT_BLUE);
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private void addStepsDisplay()
    {
        sd = new StepsDisplay();
        StepsPanel.add(sd);
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private void addTraverseButtons()
    {
        TraverseButton tbBack = new TraverseButton(FileTransferTool.this, TraverseButton.BACK);
        TraverseButton tbNext = new TraverseButton(FileTransferTool.this, TraverseButton.NEXT);
        BackButtonCon.add(tbBack);
        NextButtonCon.add(tbNext);
        transferProperties.BackButton = tbBack;
        transferProperties.NextButton = tbNext;
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private void addFilesDisplay()
    {
        fd = new FilesDisplay();
        //SidePanel.add(fd);
        transferProperties.FilesDisplay = fd;
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private void addFirstStep()
    {
        setPage(0);
    }
    
    /***************************************************************************
     * 
     * @param pageNum 
     ***************************************************************************/
    private void setPage(int stepNum)
    {
        MiddlePanel.removeAll();
        MiddlePanel.revalidate();
        Component comp = null;
        switch(stepNum)
        {
            case 0: comp = new FileTypeSelector(transferProperties);
                    break;
            case 1: comp = new SourceDirDisplay(transferProperties);
                    break;
            case 2: comp = new DestDirDisplay(transferProperties);
                    break;
            case 3: comp = new CSVSelector(transferProperties);
                    break;
            case 4: comp = new ConfirmDisplay(transferProperties);
                    break;
        }
        MiddlePanel.add(comp);
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    @Override
    final public void pressNext()
    {
        fd.showMessage();
        stepNum++;
        sd.takeStep(stepNum);
        setPage(stepNum);
    }
    
     /***************************************************************************
     * 
     ***************************************************************************/
    @Override
    final public void pressBack()
    {
        fd.showMessage();
        stepNum--;
        sd.takeStep(stepNum);        
        setPage(stepNum);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        FileTypeRadioButtons = new javax.swing.ButtonGroup();
        TransferTypeRadioButtons = new javax.swing.ButtonGroup();
        MainCon = new javax.swing.JPanel();
        TitlePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        MiddleCon = new javax.swing.JPanel();
        TopPanel = new javax.swing.JPanel();
        MiddlePanel = new javax.swing.JPanel();
        BackButtonCon = new javax.swing.JPanel();
        NextButtonCon = new javax.swing.JPanel();
        StepsPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(2147483647, 600));
        setMinimumSize(new java.awt.Dimension(960, 600));
        setPreferredSize(new java.awt.Dimension(960, 700));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        MainCon.setToolTipText(null);
        MainCon.setLayout(new java.awt.GridBagLayout());

        TitlePanel.setToolTipText(null);
        TitlePanel.setMinimumSize(new java.awt.Dimension(400, 50));
        TitlePanel.setOpaque(false);
        TitlePanel.setPreferredSize(new java.awt.Dimension(400, 50));
        TitlePanel.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("File Transfer Tool v2.00 by MP");
        TitlePanel.add(jLabel1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        MainCon.add(TitlePanel, gridBagConstraints);

        MiddleCon.setToolTipText(null);
        MiddleCon.setPreferredSize(new java.awt.Dimension(100, 600));
        MiddleCon.setLayout(new java.awt.GridBagLayout());

        TopPanel.setToolTipText(null);
        TopPanel.setMaximumSize(new java.awt.Dimension(32767, 100));
        TopPanel.setMinimumSize(new java.awt.Dimension(10, 100));
        TopPanel.setLayout(new java.awt.GridLayout(1, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        MiddleCon.add(TopPanel, gridBagConstraints);

        MiddlePanel.setToolTipText(null);
        MiddlePanel.setMaximumSize(new java.awt.Dimension(32767, 425));
        MiddlePanel.setMinimumSize(new java.awt.Dimension(10, 425));
        MiddlePanel.setOpaque(false);
        MiddlePanel.setPreferredSize(new java.awt.Dimension(200, 425));
        MiddlePanel.setLayout(new java.awt.GridLayout(1, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 100, 0, 100);
        MiddleCon.add(MiddlePanel, gridBagConstraints);

        BackButtonCon.setToolTipText(null);
        BackButtonCon.setMinimumSize(new java.awt.Dimension(70, 125));
        BackButtonCon.setOpaque(false);
        BackButtonCon.setPreferredSize(new java.awt.Dimension(70, 125));
        BackButtonCon.setLayout(new java.awt.GridLayout(1, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        MiddleCon.add(BackButtonCon, gridBagConstraints);

        NextButtonCon.setToolTipText(null);
        NextButtonCon.setMinimumSize(new java.awt.Dimension(70, 125));
        NextButtonCon.setOpaque(false);
        NextButtonCon.setPreferredSize(new java.awt.Dimension(70, 125));
        NextButtonCon.setLayout(new java.awt.GridLayout(1, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        MiddleCon.add(NextButtonCon, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 10.0;
        gridBagConstraints.weighty = 10.0;
        MainCon.add(MiddleCon, gridBagConstraints);

        StepsPanel.setBackground(new java.awt.Color(255, 102, 102));
        StepsPanel.setToolTipText(null);
        StepsPanel.setMinimumSize(new java.awt.Dimension(10, 75));
        StepsPanel.setPreferredSize(new java.awt.Dimension(100, 75));
        StepsPanel.setLayout(new java.awt.GridLayout(1, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        MainCon.add(StepsPanel, gridBagConstraints);

        getContentPane().add(MainCon);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FileTransferTool.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FileTransferTool.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FileTransferTool.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FileTransferTool.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FileTransferTool().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackButtonCon;
    private javax.swing.ButtonGroup FileTypeRadioButtons;
    private javax.swing.JPanel MainCon;
    private javax.swing.JPanel MiddleCon;
    private javax.swing.JPanel MiddlePanel;
    private javax.swing.JPanel NextButtonCon;
    private javax.swing.JPanel StepsPanel;
    private javax.swing.JPanel TitlePanel;
    private javax.swing.JPanel TopPanel;
    private javax.swing.ButtonGroup TransferTypeRadioButtons;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
