package View;

import Controller.ControllerPlacas;
import Controller.ControllerProcessador;
import Controller.ControllerSoquete;
import Model.ModelPlacas;
import Model.ModelProcessador;
import Model.ModelSoquete;
import Util.UtilAtualizacao;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author LUIZ LAURO SILVA GONÇALVES
 */
public class ViewPrincipal extends javax.swing.JFrame {

    //ConexaoMySql
    Connection conexao = null;
    private JDialogMensagem jDialogMensagem;
    String tipo = "";
    Boolean miniatura_visivel = true;
    //""""""""""""""""""""""""""""""""""""""""""""""""""//
    ControllerSoquete controllerSoquete = new ControllerSoquete();
    ModelSoquete modelSoquete = new ModelSoquete();
    ArrayList<ModelSoquete> listaModelSoquete = new ArrayList<>();
    int codigoSoquete = 0;

    //""""""""""""""""""""""""""""""""""""""""""""""""""//
    ControllerProcessador controllerProcessador = new ControllerProcessador();
    ModelProcessador modelProcessador = new ModelProcessador();
    ArrayList<ModelProcessador> listaModelProcessador = new ArrayList<>();
    //""""""""""""""""""""""""""""""""""""""""""""""""""//  
    ControllerPlacas controllerPlacas = new ControllerPlacas();
    ModelPlacas modelPlacas = new ModelPlacas();
    ArrayList<ModelPlacas> listaModelPlacas = new ArrayList<>();
    //""""""""""""""""""""""""""""""""""""""""""""""""""//
    private ViewSobre viewSobre;

    //""""""""""""""""""""""""""""""""""""""""""""""""""// 
    /**
     * Creates new form Interfaz
     */
    public ViewPrincipal() {
        initComponents();
        //Como alterar o ícone default do java JFrame Swing?
        URL url = this.getClass().getResource("/Imagem64/Deflaut.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
        //Lista os soquetes
        try {
            listaModelSoquete = controllerSoquete.getListaSoqueteController();
            //limpa o combobox de nome do cliente
            jcbModeloSoquete.removeAllItems();
            jcbModeloSoquete.addItem("Todos");
            for (int i = 0; i < listaModelSoquete.size(); i++) {
                jcbModeloSoquete.addItem(listaModelSoquete.get(i).getModelo_soq());
            }
        } catch (Exception e) {
        }
        this.carrega("");

    }

    public void carrega(String Pconcional) {
        listaModelPlacas = controllerPlacas.getListaPlacasController(Pconcional);
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);
        for (int i = 0; i < listaModelPlacas.size(); i++) {
            //lista de objeto
            modelo.addRow(new Object[]{
                listaModelPlacas.get(i).getCod_soq(),
                listaModelPlacas.get(i).getNome_pla(),
                listaModelPlacas.get(i).getUrl_pla()
            });

        }

    }

    public void carregaProcessadores(int Pcodigo) {
        listaModelProcessador = controllerProcessador.getListaProcessadorController(" WHERE cod_soq = " + Pcodigo);
        DefaultTableModel modelo = (DefaultTableModel) jTable2.getModel();
        modelo.setNumRows(0);

        for (int i = 0; i < listaModelProcessador.size(); i++) {
            //lista de objeto
            modelo.addRow(new Object[]{
                listaModelProcessador.get(i).getCod_pro(),
                listaModelProcessador.get(i).getCpu_modelo_pro()
            });

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jPanel1 = new javax.swing.JPanel();
        jCPanel2 = new com.bolivia.panel.JCPanel();
        imagem1 = new imagem.Imagem();
        jcbModeloSoquete = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtPesquisar = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        txtPesquisar1 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QCPU");

        jToolBar1.setBackground(new java.awt.Color(204, 255, 204));
        jToolBar1.setRollover(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        jCPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jCPanel2.setFirstColor(new java.awt.Color(255, 255, 255));
        jCPanel2.setSecondColor(new java.awt.Color(255, 255, 255));
        jCPanel2.setUseMode(com.bolivia.panel.USEMODE.BICOLOR);
        jCPanel2.setVisibleLogo(false);

        imagem1.setBackground(new java.awt.Color(255, 255, 255));
        imagem1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        imagem1.setForeground(new java.awt.Color(255, 255, 255));
        imagem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem96/motherboard.png"))); // NOI18N

        jcbModeloSoquete.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Intel Socket 1151" }));
        jcbModeloSoquete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));
        jcbModeloSoquete.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcbModeloSoquetePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SOQUETE", "MODELO", "URL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(1);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(1);
            jTable1.getColumnModel().getColumn(2).setMinWidth(1);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(1);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(1);
        }

        txtPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jCPanel2Layout = new javax.swing.GroupLayout(jCPanel2);
        jCPanel2.setLayout(jCPanel2Layout);
        jCPanel2Layout.setHorizontalGroup(
            jCPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jCPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jCPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jCPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtPesquisar, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jcbModeloSoquete, javax.swing.GroupLayout.Alignment.LEADING, 0, 215, Short.MAX_VALUE)
                        .addComponent(imagem1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jCPanel2Layout.setVerticalGroup(
            jCPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jCPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagem1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbModeloSoquete, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(154, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "COD", "MODELO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setMinWidth(1);
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTable2.getColumnModel().getColumn(0).setMaxWidth(1);
        }

        txtPesquisar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisar1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtPesquisar1)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtPesquisar1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Propaganda");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(228, 228, 228))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jMenu1.setText("Arquivo");

        jMenuItem3.setText("Nova placa");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");
        jMenuBar1.add(jMenu2);

        jMenu4.setText("Visualizar");

        jMenuItem2.setText("Miniatura");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuBar1.add(jMenu4);

        jMenu3.setText("Sobre");

        jMenuItem1.setText("Sobre");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jCPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jcbModeloSoquetePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbModeloSoquetePopupMenuWillBecomeInvisible
        if (jcbModeloSoquete.isPopupVisible()) {
            try {
                modelSoquete = controllerSoquete.getNomeSoqueteController(jcbModeloSoquete.getSelectedItem().toString());
                //jTextField1.setText(String.valueOf(modelSoquete.getCod_soq()));

                codigoSoquete = modelSoquete.getCod_soq();
                if (jcbModeloSoquete.getSelectedItem() == "Todos") {
                    this.carrega("");
                } else {
                    this.carrega(" WHERE cod_soq = " + codigoSoquete);

                }
            } catch (Exception e) {
                System.out.println("erro : " + e);
            }
        }
    }//GEN-LAST:event_jcbModeloSoquetePopupMenuWillBecomeInvisible

    private void txtPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarKeyReleased
        DefaultTableModel modelo = (DefaultTableModel) this.jTable1.getModel();
        final TableRowSorter<TableModel> classificador = new TableRowSorter<>(modelo);
        this.jTable1.setRowSorter(classificador);
        String texto = txtPesquisar.getText().replace("(", "\\(").replace(")", "\\)");
//         if (jcFiltro.getSelectedItem().equals("Todos")) {
        classificador.setRowFilter(RowFilter.regexFilter("(?i)" + texto, 1));
//        classificador.setRowFilter(RowFilter.regexFilter(texto, 0));
//        } 


    }//GEN-LAST:event_txtPesquisarKeyReleased


    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int linha = jTable1.getSelectedRow();
        if (linha >= 0) {
            try {
                int Pcodigo = (int) jTable1.getValueAt(linha, 0);
                this.carregaProcessadores(Pcodigo);
                if (UtilAtualizacao.verificarConexão()) {
                    String urlImagem = jTable1.getValueAt(linha, 2).toString();
                    //se conecta a uirl
                    URL urlImg = new URL(urlImagem);
                    // inicializa a imagem URL dentro de um objeto ImageIcon
                    ImageIcon imgIcon = new ImageIcon(urlImg);
                    // faz o preload da imagem
                    while (imgIcon.getImageLoadStatus() == MediaTracker.LOADING);
                    imagem1.setIcon(imgIcon);
                } else {
                    imagem1.setIcon(new ImageIcon(getClass().getResource("/Imagem96/motherboard.png")));
                }
            } catch (Exception e) {
                jDialogMensagem = new JDialogMensagem(null, true);
                jDialogMensagem.showMessage("Error", "Error: " + e, "ERRO", "PADRAO", null);
                jDialogMensagem.setVisible(true);
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked

    }//GEN-LAST:event_jTable2MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.viewSobre = new ViewSobre(this, true);
        viewSobre.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if (imagem1.isVisible()) {
            imagem1.setVisible(false);
            miniatura_visivel = false;
        } else {
            imagem1.setVisible(true);
            miniatura_visivel = true;
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void txtPesquisar1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisar1KeyReleased
        DefaultTableModel modelo = (DefaultTableModel) this.jTable2.getModel();
        final TableRowSorter<TableModel> classificador = new TableRowSorter<>(modelo);
        this.jTable1.setRowSorter(classificador);
        String texto = txtPesquisar1.getText().replace("(", "\\(").replace(")", "\\)");
//         if (jcFiltro.getSelectedItem().equals("Todos")) {
        classificador.setRowFilter(RowFilter.regexFilter("(?i)" + texto, 1));
//        classificador.setRowFilter(RowFilter.regexFilter(texto, 0));
//        }
    }//GEN-LAST:event_txtPesquisar1KeyReleased

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
            java.util.logging.Logger.getLogger(ViewPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private imagem.Imagem imagem1;
    private com.bolivia.panel.JCPanel jCPanel2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JComboBox<String> jcbModeloSoquete;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JTextField txtPesquisar1;
    // End of variables declaration//GEN-END:variables

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.setTitle("QCPU"+tipo);
        this.tipo = tipo;
    }

}
