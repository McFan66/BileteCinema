/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import ccomponents.CustomLabel;
import dvdrental.Bilet;
import dvdrental.DefaultComboLabel;
import dvdrental.OraSpectacol;
import dvdrental.Spectacol;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import models.MatriceSerializabila;
import repositories.SpectacoleHibernateRepository;
import repositories.SpectacoleRepository;
import services.BiletServiceImpl;

/**
 *
 * @author Stefan
 */
public class FrmVanzare extends javax.swing.JDialog implements FrmListaBilete.OnBileteVandute {

    private SpectacoleRepository spectacoleFileRepository = new SpectacoleHibernateRepository();
    private List<Spectacol> listaSpectacole;
    private DefaultComboBoxModel<Spectacol> comboBoxModel = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<OraSpectacol> comboBoxModel1 = new DefaultComboBoxModel<>();
    private Spectacol spectacolSelectat;
    private Date dataSelectata;
    private OraSpectacol oraSelectata;
    private File fisierConfigurareSala = new File("configSala.ser");
    private MatriceSerializabila matriceSerializabila;
    private String Stergema;
    private String Stergema2;
    private Spectacol test = new Spectacol();
    private ArrayList<Bilet> listaBilete = new ArrayList<>();
    private DefaultListModel listModel = new DefaultListModel();
    private Date azi = Calendar.getInstance().getTime();
    private Calendar c = Calendar.getInstance();
    private int total;
    private BiletServiceImpl biletServiceImpl = BiletServiceImpl.getInstance();

    public FrmVanzare() {
    }

    /**
     * Creates new form FrmVanzare1
     */
    public FrmVanzare(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        listaSpectacole = spectacoleFileRepository.getAll();

        test.setTitlu("--Selecteaza un spectacol--");
        test.setData(azi);
        test.setDurata(-1);
        comboBoxModel.addElement(test);
        for (Spectacol s : listaSpectacole) {
            Calendar c = Calendar.getInstance();
            c.setTime(s.getData());
            c.add(Calendar.DAY_OF_MONTH, s.getDurata());
            if (c.getTime().after(azi)) {
                comboBoxModel.addElement(s);
            }
        }
        cmbSpectacole.setModel(comboBoxModel);
        cmbOre.setModel(comboBoxModel1);
        chooserDataFilme.getDateEditor().addPropertyChangeListener("date", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println(chooserDataFilme.getDate());
                dataSelectata = chooserDataFilme.getDate();
                generareSala();
            }
        });
        chooserDataFilme.setMinSelectableDate(azi);
        c.setTime(azi);
        c.add(Calendar.DATE, -1);
        Date finalData = c.getTime();
        chooserDataFilme.setMaxSelectableDate(finalData);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        itemBiletRenderer1 = new renderer.ItemBiletRenderer();
        customRenderer2 = new renderer.CustomRenderer();
        customRenderer1 = new renderer.CustomRenderer();
        cmbSpectacole = new javax.swing.JComboBox<dvdrental.Spectacol>();
        chooserDataFilme = new com.toedter.calendar.JDateChooser();
        cmbOre = new javax.swing.JComboBox();
        panelAfisare = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        btnVinde = new javax.swing.JButton();
        btnAnuleaza = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();

        itemBiletRenderer1.setText("itemBiletRenderer1");

        customRenderer2.setText("customRenderer2");

        customRenderer1.setText("customRenderer1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Vanzare");

        cmbSpectacole.setRenderer(customRenderer2);
        cmbSpectacole.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbSpectacoleItemStateChanged(evt);
            }
        });

        chooserDataFilme.setDateFormatString("dd.MM.yyyy");

        cmbOre.setRenderer(customRenderer1);
        cmbOre.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbOreItemStateChanged(evt);
            }
        });

        panelAfisare.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout panelAfisareLayout = new javax.swing.GroupLayout(panelAfisare);
        panelAfisare.setLayout(panelAfisareLayout);
        panelAfisareLayout.setHorizontalGroup(
            panelAfisareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 364, Short.MAX_VALUE)
        );
        panelAfisareLayout.setVerticalGroup(
            panelAfisareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 291, Short.MAX_VALUE)
        );

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setCellRenderer(itemBiletRenderer1);
        jScrollPane1.setViewportView(jList1);

        btnVinde.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnVinde.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/shopcart.png"))); // NOI18N
        btnVinde.setText("Vinde");
        btnVinde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVindeActionPerformed(evt);
            }
        });

        btnAnuleaza.setText("Anuleaza");

        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("Total:0 RON");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelAfisare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbSpectacole, 0, 368, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chooserDataFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbOre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVinde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAnuleaza, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbSpectacole, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(chooserDataFilme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbOre))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTotal)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVinde, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(btnAnuleaza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(panelAfisare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbSpectacoleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbSpectacoleItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            System.out.println(cmbSpectacole.getSelectedItem());
            this.spectacolSelectat = (Spectacol) cmbSpectacole.getSelectedItem();
            if (spectacolSelectat != test) {
                generareSala();
            } else {
                panelAfisare.removeAll();
                panelAfisare.validate();
                panelAfisare.updateUI();
            }
            this.spectacolSelectat = (Spectacol) comboBoxModel.getSelectedItem();
            DateFormat formatter = new SimpleDateFormat("HH:mm");
            //fcmbOre.addItem(formatter.format(spectacolSelectat.getData()));
            cmbOre.removeAllItems();
            //cmbOre.addItem("--Selectati Ora--");
            cmbOre.addItem(new DefaultComboLabel("--Selectati Ora--"));
            List<OraSpectacol> listaOraSpectacole = new ArrayList<>(spectacolSelectat.getOre());
            for (OraSpectacol oraSpectacol : listaOraSpectacole) {
                cmbOre.addItem(oraSpectacol);
            }

            Calendar c = Calendar.getInstance();
            if (spectacolSelectat.getData().before(azi)) {
                chooserDataFilme.setMinSelectableDate(azi);
            } else {
                chooserDataFilme.setMinSelectableDate(spectacolSelectat.getData());
            }
            c.setTime(spectacolSelectat.getData());
            c.add(Calendar.DAY_OF_MONTH, spectacolSelectat.getDurata());
            chooserDataFilme.setMaxSelectableDate(c.getTime());
        }
    }//GEN-LAST:event_cmbSpectacoleItemStateChanged

    private void cmbOreItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbOreItemStateChanged
        // TODO add your handling code here:

        if (evt.getStateChange() == ItemEvent.SELECTED) {
          if (cmbOre.getSelectedIndex() > 0) {
                this.oraSelectata = (OraSpectacol) cmbOre.getSelectedItem();
                generareSala();
            } else {
                panelAfisare.removeAll();
                panelAfisare.validate();
                panelAfisare.updateUI();
            }
        }
    }//GEN-LAST:event_cmbOreItemStateChanged

    private void btnVindeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVindeActionPerformed
        FrmListaBilete frmListaBilete = new FrmListaBilete(this, true, listaBilete, (OraSpectacol) cmbOre.getSelectedItem());
        frmListaBilete.setOnBileteVandute(this);
        System.out.println(listaBilete.size() + " atatea bilete");
        frmListaBilete.setVisible(true);
    }//GEN-LAST:event_btnVindeActionPerformed

    private void generareSala() {
        if (cmbOre.getSelectedIndex() > 0 && spectacolSelectat != null && dataSelectata != null && oraSelectata != null) {
            if (fisierConfigurareSala.exists()) {
                panelAfisare.removeAll();
                init();
                int coloane = matriceSerializabila.getColoane() + 1;
                CustomLabel[][] matrice = new CustomLabel[matriceSerializabila.getLinii()][coloane];
                panelAfisare.setLayout(new GridLayout(matriceSerializabila.getLinii(), coloane));
                int counter;
                for (int i = 0; i < matriceSerializabila.getLinii(); i++) {
                    counter = 0;
                    for (int j = 0; j < coloane; j++) {
                        matrice[i][j] = new CustomLabel(i, j) {
                            @Override
                            public void onLabelClicked(int linie, int coloana) {
                                if (matrice[linie][coloana].isVanzare()) {
                                    matriceSerializabila.enableDisable(linie, coloana - 1);
                                    int numar = 0;

                                    for (int i = 0; i < coloana; i++) {
                                        if (matrice[linie][i].getBackground() == Color.RED) {
                                            numar++;
                                        }
                                    }
                                    final Bilet b = new Bilet(spectacolSelectat, coloana - numar, linie);
                                    b.setLocReal(coloana);
//                                    System.out.println(b.getLocReal()+" "+b.getRand());
                                    Calendar c = Calendar.getInstance();
                                    c.setTime(dataSelectata);
                                    String[] oraMinut = ((OraSpectacol)cmbOre.getSelectedItem()).getOra().split(":");
                                    c.set(Calendar.HOUR_OF_DAY, Integer.parseInt(oraMinut[0]));
                                    c.set(Calendar.MINUTE, Integer.parseInt(oraMinut[1]));
                                    c.set(Calendar.SECOND, 0);
                                    c.set(Calendar.MILLISECOND, 0);

                                    b.setData(c.getTime());
                                    b.setPret(oraSelectata.getPret());
                                    b.setOraSpectacol(oraSelectata);
                                    //  if (matrice[linie][coloana].getBackground() != Color.red) {
                                    //System.out.println(String.format("linie %d coloana %d availble=%s righClick=%s", linie, coloana, matrice[linie][coloana].isAvailable(), matrice[linie][coloana].isRightClickPressed()));
                                    if (matrice[linie][coloana].isAvailable() && !matrice[linie][coloana].isRightClickPressed()) {
                                        listModel.clear();//golire model lista
                                        total = 0;
                                        listaBilete.add(b);
                                        for (Bilet bilet : listaBilete) {
//                                            total = total + spectacolSelectat.getPret();
                                            listModel.addElement(bilet);
                                        }
                                    } else if (matrice[linie][coloana].isRightClickPressed()) {
                                        listModel.clear();//golire model lista

                                        total = 0;

                                        for (int i = 0; i < listaBilete.size(); i++) {
                                            // System.out.println(listaBilete.get(i).getLoc() + " " + listaBilete.get(i).getRand());
                                            // System.out.println(linie + " " + coloana);
                                            if (listaBilete.get(i).getRand() == linie && listaBilete.get(i).getLocReal() == coloana) {
                                                listaBilete.remove(i);
                                            }
                                        }
                                        for (Bilet bilet : listaBilete) {
//                                            total = total + spectacolSelectat.getPret();
                                            listModel.addElement(bilet);
                                        }
                                        //listaBilete.remove(b);
                                        //listModel.removeElement(b);

                                        //total = total - spectacolSelectat.getPret();
                                    }

                                    jList1.setModel(listModel);
                                }
                                // }
                                lblTotal.setText("Total:" + total + " RON");
                            }
                        };
                        matrice[i][j].setVanzare(true);
                        if (j == 0) {
                            matrice[i][j].setText("R" + String.valueOf(i + 1));
                            matrice[i][j].setBackground(Color.yellow);
                        } else {
                            if (matriceSerializabila.getValuetAtLineAndColumn(i, j) == -1) {
                                matrice[i][j].setBackground(Color.red);
                                matrice[i][j].setText("X");
                                matrice[i][j].setAvailable(false);
                                counter++;
                            } else if (matriceSerializabila.getValuetAtLineAndColumn(i, j) == 0) {
                                matrice[i][j].setAvailable(true);
                                // matrice[i][j].setBackground(Color.green);
                                matrice[i][j].setText(String.valueOf(j - counter));
                            }

                        }

//                    if (j == 0) {
//                        matrice[i][j].setText("R" + String.valueOf(i + 1));
//                        matrice[i][j].setBackground(Color.yellow);
//                    } else {
//                        matrice[i][j].setText(String.valueOf(j));
//                    }
                        panelAfisare.add(matrice[i][j]);
                    }
                }
                Calendar cal = Calendar.getInstance();
                cal.setTime(dataSelectata);
                String[] oraMinut = ((OraSpectacol)cmbOre.getSelectedItem()).getOra().split(":");
                cal.set(Calendar.HOUR_OF_DAY, 0);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.SECOND, 0);
                cal.set(Calendar.MILLISECOND, 0);
                List<Bilet> listaBileteCumparate = new ArrayList<Bilet>();
                
                for (Bilet b:((OraSpectacol)cmbOre.getSelectedItem()).getListaBilete()){
                  //  System.out.println(b.getSpectacol().getData() + " ---- " + cal.getTime());
                    if (b.getSpectacol().getData().compareTo(cal.getTime())==0){
                        //System.out.println("salut");
                        listaBileteCumparate.add(b);
                    }
                }
                
                //listaBileteCumparate = biletServiceImpl.getBileteBySpectacolDataAndOra((Spectacol) cmbSpectacole.getSelectedItem(), cal.getTime());
                //listaBileteCumparate =// biletServiceImpl.getBileteBySpectacolDataAndOraSpectacol((Spectacol) cmbSpectacole.getSelectedItem(), cal.getTime(), (OraSpectacol) cmbOre.getSelectedItem());
                //System.out.println(listaBileteCumparate);
                for (Bilet b : listaBileteCumparate) {
                    matrice[b.getRand()][b.getLocReal()].setBackground(Color.blue);
                    matrice[b.getRand()][b.getLocReal()].setVanzare(false);
                    matrice[b.getRand()][b.getLocReal()].setAvailable(false);
                    //System.out.println("SIUUUUUUUUUUUUUUUUUUUU");
                }
                panelAfisare.revalidate();
                panelAfisare.repaint();
            }

        }
    }

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmVanzare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVanzare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVanzare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVanzare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmVanzare dialog = new FrmVanzare(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    private void init() {
        try {
            FileInputStream fileInputStream = new FileInputStream(fisierConfigurareSala);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            matriceSerializabila = (MatriceSerializabila) objectInputStream.readObject();
        } catch (IOException ex) {
            //  Logger.getLogger(SpectacoleFileRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(SpectacoleFileRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnuleaza;
    private javax.swing.JButton btnVinde;
    private com.toedter.calendar.JDateChooser chooserDataFilme;
    private javax.swing.JComboBox cmbOre;
    private javax.swing.JComboBox<dvdrental.Spectacol> cmbSpectacole;
    private renderer.CustomRenderer customRenderer1;
    private renderer.CustomRenderer customRenderer2;
    private renderer.ItemBiletRenderer itemBiletRenderer1;
    private javax.swing.JList<dvdrental.Bilet> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel panelAfisare;
    // End of variables declaration//GEN-END:variables

    @Override
    public void saveBilete() {
        System.out.println("ayae");
        generareSala();
        listModel.clear();
        listaBilete.removeAll(listaBilete);
        lblTotal.setText("Total:0 RON");
        total = 0;

    }
}
