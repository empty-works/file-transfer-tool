/*
 */
package gws.extract.tool;

import gws.extract.beans.MyColors;
import gws.extract.beans.TransferProperties;
import gws.extract.abstract_buttons.OpenButton;
import java.awt.Color;
import javax.swing.BorderFactory;
import gws.extract.abstract_buttons.ButtonOpenActionInterface;

/**
 *
 * @author MP
 */
public abstract class SuperDisplay extends javax.swing.JPanel implements ButtonOpenActionInterface
{
    final protected TransferProperties transferProps;
    protected OpenButton openButton;
    private String buttonTitle = "";
    protected String fullPath = "";
    private int openType;
    private String iconFileName;
    
    /***************************************************************************
     * 
     ***************************************************************************/
    public SuperDisplay(TransferProperties transferProps) 
    {
        initComponents();
        this.transferProps = transferProps;
        CheckmarkLabel.setVisible(false);
        addButton();
        setColors();
        resetProgressBar();
        setTraverseButtons();
        checkStatus();
    }

    /***************************************************************************
     * 
     ***************************************************************************/
    private void addButton()
    {
        buttonTitle = getButtonTitle();
        openType = getOpenType();
        openButton = new OpenButton(buttonTitle, openType, SuperDisplay.this);
        iconFileName = getIconFileName();
        openButton.setIcon(iconFileName);
        ButtonCon.add(openButton);
    }
    
    abstract protected String getIconFileName();

    /***************************************************************************
     * 
     ***************************************************************************/
    abstract protected String getButtonTitle();
    
    /***************************************************************************
     * 
     ***************************************************************************/
    abstract protected int getOpenType();
    
    /***************************************************************************
     * 
     ***************************************************************************/
    final public void executeButtonAction()
    {
        executeAction();
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    abstract protected void executeAction();
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private void setColors()
    {
        TitleLabel.setForeground(MyColors.DARK_COLOR);
        StatusLabel1.setForeground(MyColors.DARK_COLOR);
        StatusLabel2.setForeground(MyColors.DARK_COLOR);
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    protected void resetProgressBar()
    {
        ScanProgressBar.setStringPainted(true);
        ScanProgressBar.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        ScanProgressBar.setBackground(MyColors.TRAVERSE_LIGHT);
        ScanProgressBar.setMaximum(100);
        ScanProgressBar.setIndeterminate(false);
        ScanProgressBar.setValue(0);
    }
    
     /***************************************************************************
     * 
     ***************************************************************************/
    private void setTraverseButtons()
    {
        transferProps.BackButton.setVisible(true);
        transferProps.NextButton.setVisible(true);
        if(propertiesAreNotReady())
        {
            transferProps.NextButton.setVisible(false);
        }
    }
    
     /***************************************************************************
     * 
     ***************************************************************************/
    abstract protected boolean propertiesAreNotReady();
    
    /***************************************************************************
     * 
     ***************************************************************************/
    abstract protected void checkStatus();
    
    /***************************************************************************
     * 
     ***************************************************************************/
    protected void showStatus(boolean show)
    {
        StatusCon.setVisible(show);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        StatusCon = new javax.swing.JPanel();
        StatusLabel1 = new javax.swing.JLabel();
        StatusLabel2 = new javax.swing.JLabel();
        StatusConPlaceholder = new javax.swing.JPanel();
        MiddlePanel = new javax.swing.JPanel();
        ButtonCon = new javax.swing.JPanel();
        ScanProgressBar = new javax.swing.JProgressBar();
        BottomPanel = new javax.swing.JPanel();
        TitleLabel = new javax.swing.JLabel();
        CheckmarkLabel = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(new java.awt.GridBagLayout());

        StatusCon.setBackground(new java.awt.Color(255, 255, 255));
        StatusCon.setToolTipText(null);
        StatusCon.setMinimumSize(new java.awt.Dimension(0, 90));
        StatusCon.setOpaque(false);
        StatusCon.setPreferredSize(new java.awt.Dimension(0, 90));
        StatusCon.setLayout(new java.awt.GridLayout(2, 0));

        StatusLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        StatusLabel1.setForeground(new java.awt.Color(0, 0, 0));
        StatusLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        StatusLabel1.setToolTipText(null);
        StatusCon.add(StatusLabel1);

        StatusLabel2.setFont(new java.awt.Font("Arial Black", 1, 17)); // NOI18N
        StatusLabel2.setForeground(new java.awt.Color(0, 0, 0));
        StatusLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        StatusLabel2.setText("C://The/Ultimate/Folder/Is/Here/Tonight/You/Are/Welcome");
        StatusCon.add(StatusLabel2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        add(StatusCon, gridBagConstraints);

        StatusConPlaceholder.setBackground(new java.awt.Color(0, 0, 0));
        StatusConPlaceholder.setToolTipText(null);
        StatusConPlaceholder.setMinimumSize(new java.awt.Dimension(0, 90));
        StatusConPlaceholder.setOpaque(false);
        StatusConPlaceholder.setPreferredSize(new java.awt.Dimension(0, 90));
        StatusConPlaceholder.setLayout(new java.awt.GridLayout(2, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        add(StatusConPlaceholder, gridBagConstraints);

        MiddlePanel.setToolTipText(null);
        MiddlePanel.setMinimumSize(new java.awt.Dimension(0, 155));
        MiddlePanel.setOpaque(false);
        MiddlePanel.setPreferredSize(new java.awt.Dimension(300, 155));
        MiddlePanel.setLayout(new java.awt.GridBagLayout());

        ButtonCon.setToolTipText(null);
        ButtonCon.setMinimumSize(new java.awt.Dimension(10, 155));
        ButtonCon.setOpaque(false);
        ButtonCon.setPreferredSize(new java.awt.Dimension(100, 155));
        ButtonCon.setLayout(new java.awt.GridLayout(1, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        MiddlePanel.add(ButtonCon, gridBagConstraints);

        ScanProgressBar.setBackground(new java.awt.Color(204, 51, 255));
        ScanProgressBar.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        ScanProgressBar.setToolTipText(null);
        ScanProgressBar.setMaximumSize(new java.awt.Dimension(32767, 155));
        ScanProgressBar.setMinimumSize(new java.awt.Dimension(300, 155));
        ScanProgressBar.setPreferredSize(new java.awt.Dimension(300, 155));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        MiddlePanel.add(ScanProgressBar, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        add(MiddlePanel, gridBagConstraints);

        BottomPanel.setToolTipText(null);
        BottomPanel.setMaximumSize(new java.awt.Dimension(2147483647, 100));
        BottomPanel.setMinimumSize(new java.awt.Dimension(10, 100));
        BottomPanel.setOpaque(false);
        BottomPanel.setPreferredSize(new java.awt.Dimension(197, 100));
        BottomPanel.setLayout(new java.awt.GridBagLayout());

        TitleLabel.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        TitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleLabel.setToolTipText(null);
        BottomPanel.add(TitleLabel, new java.awt.GridBagConstraints());

        CheckmarkLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CheckmarkLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gws/extract/image_assets/check94x75.png"))); // NOI18N
        CheckmarkLabel.setToolTipText(null);
        CheckmarkLabel.setMaximumSize(new java.awt.Dimension(150, 0));
        CheckmarkLabel.setMinimumSize(new java.awt.Dimension(150, 0));
        CheckmarkLabel.setPreferredSize(new java.awt.Dimension(150, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 0.1;
        BottomPanel.add(CheckmarkLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        add(BottomPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JPanel BottomPanel;
    private javax.swing.JPanel ButtonCon;
    protected javax.swing.JLabel CheckmarkLabel;
    protected javax.swing.JPanel MiddlePanel;
    protected javax.swing.JProgressBar ScanProgressBar;
    protected javax.swing.JPanel StatusCon;
    protected javax.swing.JPanel StatusConPlaceholder;
    protected javax.swing.JLabel StatusLabel1;
    protected javax.swing.JLabel StatusLabel2;
    private javax.swing.JLabel TitleLabel;
    // End of variables declaration//GEN-END:variables
}
