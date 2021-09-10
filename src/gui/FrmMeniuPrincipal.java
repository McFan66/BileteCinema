/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import comparators.ComparatorBilet;
import dvdrental.Bilet;
import dvdrental.Spectacol;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import models.BiletB;
import models.SpectacolB;
import observer.ObserverData;
import repositories.BiletFileRepository;
import repositories.BiletHibernateRepository;
import repositories.BiletRepository;
import services.BiletServiceImpl;
import services.SpectacoleServiceImpl;
import threads.FanaRunnable;
import utils.DateUtils;

/**
 *
 * @author Stefan
 */
public class FrmMeniuPrincipal extends javax.swing.JFrame implements observer.FObserver {

    private List<Bilet> listaBilete = new ArrayList<Bilet>();
    private BiletServiceImpl biletService = BiletServiceImpl.getInstance();
    private BiletRepository biletRepository = new BiletHibernateRepository();
    private DefaultTableModel defaultTableModel;
    private String[] columnNames = new String[]{"Numele Spectacolului", "Data si Ora", "Pretul", "Randul si locul"};
    private String[][] data;
    private DefaultListModel listModel = new DefaultListModel();
    private SpectacoleServiceImpl spectacoleService = SpectacoleServiceImpl.getInstance();
    private List<Spectacol> listaSpectacole = new ArrayList<Spectacol>();
    private FanaRunnable fanaRunnable;
    private boolean pressed;

    /**
     * Creates new form FrmMeniuPrincipal
     */
    public FrmMeniuPrincipal() {
        //super(parent);

        Calendar c1 = Calendar.getInstance();
        Date dataInceput = new Date();
        Date dataFinal = new Date();
        dataInceput = DateUtils.getDateWithSpecialHourMinuteSecond(c1.getTime(), 0, 0, 0);
        dataFinal = DateUtils.getDateWithSpecialHourMinuteSecond(c1.getTime(), 23, 59, 59);
        listaBilete = biletService.getBileteByData(dataInceput, dataFinal);
        Collections.sort(listaBilete, new ComparatorBilet());
        data = new String[listaBilete.size()][4];
        int x = 0;
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        for (Bilet b : listaBilete) {
            
            data[x][0] = b.getSpectacol().getTitlu();
            data[x][1] = formatter.format(b.getData());
            data[x][2] = String.valueOf(b.getSpectacol().getPret());
            data[x][3] = String.format("Rand: %d Loc: %d", b.getRand() + 1, b.getLoc());
            x++;
        }

        defaultTableModel = new DefaultTableModel(data, columnNames);
        listaSpectacole = spectacoleService.getSpectacoleWithDurataAfterDate(c1.getTime());
        for (Spectacol s : listaSpectacole) {
            listModel.addElement(s);

        }

        initComponents();
        BiletServiceImpl.getInstance().addObserver(this);
        SpectacoleServiceImpl.getInstance().addObserver(this);
        tblBilete.setModel(defaultTableModel);
        jList1.setModel(listModel);
        setTitle("Meniu principal");
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        fanaRunnable = new FanaRunnable() {
            @Override
            public void customRun() {
                lblCeas.setText(sdf.format(System.currentTimeMillis()));
                try {
                    Thread.sleep(900);
                } catch (InterruptedException ex) {
                    Logger.getLogger(FrmMeniuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        };//(lblCeas);
        Thread th = new Thread(fanaRunnable);

        th.start();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spectacolPanel1 = new gui.SpectacolPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBilete = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        btnVanzare = new javax.swing.JButton();
        btnSala = new javax.swing.JButton();
        btnRaport = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        lblCeas = new javax.swing.JLabel();
        btnPause = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Meniu Principal");

        tblBilete.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Numele Spectacolului", "Data si Ora", "Pretul", "Randul si Locul"
            }
        ));
        jScrollPane2.setViewportView(tblBilete);
        if (tblBilete.getColumnModel().getColumnCount() > 0) {
            tblBilete.getColumnModel().getColumn(0).setPreferredWidth(120);
        }

        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane3.setPreferredSize(new java.awt.Dimension(820, 330));

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setCellRenderer(spectacolPanel1);
        jList1.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
        jList1.setVisibleRowCount(1);
        jScrollPane3.setViewportView(jList1);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnVanzare.setText("Vanzare");
        btnVanzare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVanzareActionPerformed(evt);
            }
        });

        btnSala.setText("Sala");
        btnSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalaActionPerformed(evt);
            }
        });

        btnRaport.setText("Raport");
        btnRaport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRaportActionPerformed(evt);
            }
        });

        jButton4.setText("Log out");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnVanzare, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(btnRaport, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSala, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnVanzare, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                    .addComponent(btnSala, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRaport, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        lblCeas.setText("00:00");

        btnPause.setText("Pause");
        btnPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPauseActionPerformed(evt);
            }
        });

        jMenu1.setText("Administrare");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Administrare Spectacole");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Administrare Casieri");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Exit");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPause)
                        .addGap(18, 18, 18)
                        .addComponent(lblCeas, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCeas, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(btnPause))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVanzareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVanzareActionPerformed
        FrmVanzare frmVanzare = new FrmVanzare(this, true);
        frmVanzare.setLocationRelativeTo(this);
        frmVanzare.setVisible(true);
    }//GEN-LAST:event_btnVanzareActionPerformed

    private void btnSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalaActionPerformed
        FrmConfigSala frmConfigSala = new FrmConfigSala(this, true);
        frmConfigSala.setLocationRelativeTo(this);
        frmConfigSala.setVisible(true);
    }//GEN-LAST:event_btnSalaActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // TODO add your handling code here:
        System.exit(1);
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        FrmAdministrareSpectacole frmAdministrareSpectacole = new FrmAdministrareSpectacole(this, true);
        frmAdministrareSpectacole.setLocationRelativeTo(this);
        frmAdministrareSpectacole.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        FrmAdministrareCasieri frmAdministrareCasieri = new FrmAdministrareCasieri(this, true);
        frmAdministrareCasieri.setLocationRelativeTo(this);
        frmAdministrareCasieri.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnRaportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRaportActionPerformed
        FrmRaport frmRaport = new FrmRaport(this, true);
        frmRaport.setLocationRelativeTo(this);
        frmRaport.setVisible(true);
    }//GEN-LAST:event_btnRaportActionPerformed

    private void btnPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPauseActionPerformed
        if (!pressed) {
            fanaRunnable.setStop(true);
            btnPause.setText("Resume");

        } else {
            fanaRunnable.setStop(false);
            btnPause.setText("Pause");

        }
        pressed = !pressed;

    }//GEN-LAST:event_btnPauseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPause;
    private javax.swing.JButton btnRaport;
    private javax.swing.JButton btnSala;
    private javax.swing.JButton btnVanzare;
    private javax.swing.JButton jButton4;
    private javax.swing.JList<dvdrental.Spectacol> jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCeas;
    private gui.SpectacolPanel spectacolPanel1;
    private javax.swing.JTable tblBilete;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(ObserverData observerData) {
        if (observerData instanceof BiletB) {
            BiletB bilet = (BiletB) observerData;
            System.out.println("Meniul principal actualizam observerul" + bilet.getDetalii());
            Calendar c1 = Calendar.getInstance();
            Date dataInceput = new Date();
            Date dataFinal = new Date();
            dataInceput = DateUtils.getDateWithSpecialHourMinuteSecond(c1.getTime(), 0, 0, 0);
            dataFinal = DateUtils.getDateWithSpecialHourMinuteSecond(c1.getTime(), 23, 59, 59);
            listaBilete = biletService.getBileteByData(dataInceput, dataFinal);
            Collections.sort(listaBilete, new ComparatorBilet());
            data = new String[listaBilete.size()][4];
            int x = 0;
            DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH.mm");
            for (Bilet b : listaBilete) {
                data[x][0] = b.getSpectacol().getTitlu();
                data[x][1] = formatter.format(b.getData());
                data[x][2] = String.valueOf(b.getSpectacol().getPret());
                data[x][3] = String.format("Rand: %d Loc: %d", b.getRand() + 1, b.getLoc());
                x++;
            }
            defaultTableModel = new DefaultTableModel(data, columnNames);
            tblBilete.setModel(defaultTableModel);
            setTitle("Meniu principal");
        } else if (observerData instanceof SpectacolB) {
            listModel.clear();
            Calendar c1 = Calendar.getInstance();
            defaultTableModel = new DefaultTableModel(data, columnNames);
            listaSpectacole = spectacoleService.getSpectacoleWithDurataAfterDate(c1.getTime());
            for (Spectacol s : listaSpectacole) {
                listModel.addElement(s);
            }
            jList1.setModel(listModel);
            setTitle("Meniu principal");
        }
    }
}
