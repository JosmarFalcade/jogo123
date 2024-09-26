/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Ladrao;
import servicos.ServicosFactory;
import servicos.LadraoServicos;

/**
 *
 * @author 182310075
 */
public class JFLadrao extends javax.swing.JFrame {

    int idEdit;

    /**
     * Creates new form JFLadrao
     */
    public JFLadrao() {
        initComponents();
        addRowToTable();
        jbEditarLadrao.setVisible(false);
        jbDeletarLadrao.setVisible(false);
    }

    public void addRowToTable() {
        //pega a modelagem da tabela na interface grafica
        DefaultTableModel model = (DefaultTableModel) jtLadroes.getModel();
        model.getDataVector().removeAllElements();//remove as linhas da tabela
        model.fireTableDataChanged();
        Object rowData[] = new Object[6];//cria vetor de 6 posicoes que corresponde as colunas da tabela
        LadraoServicos ladraoS = ServicosFactory.getLadraoServicos();//percorre lista e popula vetor e add vetor a tabela
        for (Ladrao ladrao : ladraoS.listaLadrao()) {
            rowData[0] = ladrao.getId();
            rowData[1] = ladrao.getNome();
            rowData[2] = ladrao.getOlho();
            rowData[3] = ladrao.isSexo() == false ? "Feminino" : "Masculino"; //if Ternary Operator
            rowData[4] = ladrao.getPlanoDeFuga();
            rowData[5] = ladrao.getPontosDeVida();
            model.addRow(rowData);
        }
    }

    private void limpaCampos() {
        jtfNomeLadrao.setText("");
        jtfCabeloLadrao.setText("");
        jtfOlhoLadrao.setText("");
        jtfPeleLadrao.setText("");
        bgSexoLadrao.clearSelection();
        jtfNomeLadrao.requestFocus();
        jtfPlanoDeFuga.setText("");
    }

    private boolean validaInputs() {
        if (jtfNomeLadrao.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preecher o nome");
            jtfNomeLadrao.requestFocus();
            return false;
        }
        if (jtfCabeloLadrao.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preecher o cabelo");
            jtfCabeloLadrao.requestFocus();
            return false;
        }
        if (jtfOlhoLadrao.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preecher o olho");
            jtfOlhoLadrao.requestFocus();
            return false;
        }
        if (jtfPeleLadrao.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preecher a pele");
            jtfPeleLadrao.requestFocus();
            return false;
        }
        if (!jrbFemininoLadrao.isSelected()
                && !jrbMasculinoLadrao.isSelected()) {
            JOptionPane.showMessageDialog(this, "Selecionar Sexo");
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgSexoLadrao = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jtfNomeLadrao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfCabeloLadrao = new javax.swing.JTextField();
        Olho = new javax.swing.JLabel();
        jtfOlhoLadrao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfPeleLadrao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jrbFemininoLadrao = new javax.swing.JRadioButton();
        jrbMasculinoLadrao = new javax.swing.JRadioButton();
        jLSexoLadrao = new javax.swing.JLabel();
        jbSalvarLadrao = new javax.swing.JButton();
        jbLimparLadrao = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jbDeletarLadrao = new javax.swing.JButton();
        jbEditarLadrao = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jtfPlanoDeFuga = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtLadroes = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Ladrão");

        jLabel2.setText("Nome");

        jtfNomeLadrao.setName("jtfNomeLadrao"); // NOI18N

        jLabel3.setText("Cabelo");

        jtfCabeloLadrao.setName("jtfCabeloLadrao"); // NOI18N

        Olho.setText("Olho");

        jtfOlhoLadrao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfOlhoLadraoActionPerformed(evt);
            }
        });

        jLabel4.setText("Pele");

        bgSexoLadrao.add(jrbFemininoLadrao);
        jrbFemininoLadrao.setText("Feminino");

        bgSexoLadrao.add(jrbMasculinoLadrao);
        jrbMasculinoLadrao.setText("Masculino");

        jLSexoLadrao.setText("Sexo");

        jbSalvarLadrao.setText("Salvar");
        jbSalvarLadrao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarLadraoActionPerformed(evt);
            }
        });

        jbLimparLadrao.setText("Limpar");
        jbLimparLadrao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparLadraoActionPerformed(evt);
            }
        });

        jbDeletarLadrao.setText("Deletar");
        jbDeletarLadrao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeletarLadraoActionPerformed(evt);
            }
        });

        jbEditarLadrao.setText("Editar");
        jbEditarLadrao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarLadraoActionPerformed(evt);
            }
        });

        jLabel6.setText("Plano de Fuga");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfPeleLadrao, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(jtfCabeloLadrao)
                            .addComponent(jtfPlanoDeFuga, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Olho)
                            .addComponent(jLSexoLadrao))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jrbFemininoLadrao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jtfOlhoLadrao, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jrbMasculinoLadrao)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtfNomeLadrao, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbEditarLadrao, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbDeletarLadrao, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbLimparLadrao, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbSalvarLadrao, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
            .addComponent(jSeparator2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfNomeLadrao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfCabeloLadrao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Olho)
                    .addComponent(jtfOlhoLadrao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfPeleLadrao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jrbFemininoLadrao)
                    .addComponent(jLSexoLadrao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbMasculinoLadrao)
                    .addComponent(jLabel6)
                    .addComponent(jtfPlanoDeFuga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSalvarLadrao)
                    .addComponent(jbLimparLadrao)
                    .addComponent(jbDeletarLadrao)
                    .addComponent(jbEditarLadrao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jtLadroes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Olho", "Sexo", "Plano de Fuga", "HP"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtLadroes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtLadroesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtLadroes);
        if (jtLadroes.getColumnModel().getColumnCount() > 0) {
            jtLadroes.getColumnModel().getColumn(0).setResizable(false);
            jtLadroes.getColumnModel().getColumn(1).setResizable(false);
            jtLadroes.getColumnModel().getColumn(2).setResizable(false);
            jtLadroes.getColumnModel().getColumn(3).setResizable(false);
            jtLadroes.getColumnModel().getColumn(4).setResizable(false);
            jtLadroes.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbLimparLadraoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparLadraoActionPerformed
        // TODO add your handling code here:
        limpaCampos();
    }//GEN-LAST:event_jbLimparLadraoActionPerformed

    private void jbSalvarLadraoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarLadraoActionPerformed
        // TODO add your handling code here:
        if (jbSalvarLadrao.getText().equals("Salvar")) {

            if (validaInputs()) {
                Ladrao l = new Ladrao();
                l.setNome(jtfNomeLadrao.getText());
                l.setOlho(jtfOlhoLadrao.getText());
                l.setCabelo(jtfCabeloLadrao.getText());
                l.setPele(jtfPeleLadrao.getText());
                l.setPlanoDeFuga(jtfPlanoDeFuga.getText());
                if (jrbFemininoLadrao.isSelected()
                        || jrbMasculinoLadrao.isSelected()) {

                    l.setSexo(!jrbFemininoLadrao.isSelected());
    }//GEN-LAST:event_jbSalvarLadraoActionPerformed
                LadraoServicos ladraoS = ServicosFactory.getLadraoServicos();
                ladraoS.cadastrarLadrao(l);
                addRowToTable();
                limpaCampos();
            }
        } else {
            //codigo do update
            Ladrao lad = new Ladrao();
            lad.setId(idEdit);
            lad.setNome(jtfNomeLadrao.getText());
            lad.setCabelo(jtfCabeloLadrao.getText());
            lad.setOlho(jtfOlhoLadrao.getText());
            lad.setPele(jtfPeleLadrao.getText());
            lad.setPlanoDeFuga(jtfPlanoDeFuga.getText());
            LadraoServicos ladraoS = ServicosFactory.getLadraoServicos();
            ladraoS.atualizarLadrao(lad);
            addRowToTable();
            JOptionPane.showMessageDialog(this, "Ladrao Aualizada com sucesso!");
            jbSalvarLadrao.setText("Salvar");
            jLSexoLadrao.setVisible(true);
            jrbFemininoLadrao.setVisible(true);
            jrbMasculinoLadrao.setVisible(true);
            jbLimparLadrao.setEnabled(true);
        }
    }

    private void jbDefault() {
        jbSalvarLadrao.setText("Salvar");
        jLSexoLadrao.setVisible(true);
        jrbFemininoLadrao.setVisible(true);
        jrbMasculinoLadrao.setVisible(true);
        jbLimparLadrao.setEnabled(true);
        jbDeletarLadrao.setVisible(false);
        jbDeletarLadrao.setText("Deletar");
        jbEditarLadrao.setVisible(false);
    }
    private void jtfOlhoLadraoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfOlhoLadraoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfOlhoLadraoActionPerformed

    private void jtLadroesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtLadroesMouseClicked
        // TODO add your handling code here:
        jbEditarLadrao.setVisible(true);
        jbDeletarLadrao.setVisible(true);
    }//GEN-LAST:event_jtLadroesMouseClicked

    private void jbDeletarLadraoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeletarLadraoActionPerformed
        // TODO add your handling code here:
        if (jbDeletarLadrao.getText().equals("Deletar")) {
            int linha = jtLadroes.getSelectedRow();
            int id = (int) jtLadroes.getValueAt(linha, 0);
            String nome = (String) jtLadroes.getValueAt(linha, 1);
            Object[] btnMSG = {"Sim", "Não"};
            int resp = JOptionPane.showOptionDialog(this, "Deseja realmente deletar" + nome, ".:Deletar:.", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, btnMSG, btnMSG[0]);
            if (resp == 0) {
                LadraoServicos ladraoS = ServicosFactory.getLadraoServicos();
                ladraoS.deletarLadrao(id);
                addRowToTable();
                JOptionPane.showMessageDialog(this, "Ladrao" + nome + "deletado com sucesso");
            } else {
                JOptionPane.showMessageDialog(this, "Ok, delete cancelado pelo usuário");
            }
            jbDeletarLadrao.setVisible(false);
            jbEditarLadrao.setVisible(false);
        } else {
            addRowToTable();
            JOptionPane.showMessageDialog(this, "Edição cancelada com sucesso!");
            jbDefault();
            limpaCampos();
        }
    }//GEN-LAST:event_jbDeletarLadraoActionPerformed

    private void jbEditarLadraoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarLadraoActionPerformed
        // TODO add your handling code here:
        jbLimparLadrao.setEnabled(false);
        jbSalvarLadrao.setText("Atualizar");
        jbDeletarLadrao.setText("Cancelar");
        jrbFemininoLadrao.setVisible(false);
        jrbMasculinoLadrao.setVisible(false);
        jLSexoLadrao.setVisible(false);

        //buscar ladrao e carregar nos campos
        int linha = jtLadroes.getSelectedRow();
        idEdit = (int) jtLadroes.getValueAt(linha, 0);

        Ladrao ladrao = new Ladrao();
        try {
            LadraoServicos ladraoS = ServicosFactory.getLadraoServicos();
            ladrao = ladraoS.getLadraoById(idEdit);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        //carrega na tela
        jtfNomeLadrao.setText(ladrao.getNome());
        jtfCabeloLadrao.setText(ladrao.getCabelo());
        jtfOlhoLadrao.setText(ladrao.getOlho());
        jtfPeleLadrao.setText(ladrao.getPele());
        jtfPlanoDeFuga.setText(ladrao.getPlanoDeFuga());
    }//GEN-LAST:event_jbEditarLadraoActionPerformed

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
            java.util.logging.Logger.getLogger(JFLadrao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFLadrao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFLadrao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFLadrao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFLadrao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Olho;
    private javax.swing.ButtonGroup bgSexoLadrao;
    private javax.swing.JLabel jLSexoLadrao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbDeletarLadrao;
    private javax.swing.JButton jbEditarLadrao;
    private javax.swing.JButton jbLimparLadrao;
    private javax.swing.JButton jbSalvarLadrao;
    private javax.swing.JRadioButton jrbFemininoLadrao;
    private javax.swing.JRadioButton jrbMasculinoLadrao;
    private javax.swing.JTable jtLadroes;
    private javax.swing.JTextField jtfCabeloLadrao;
    private javax.swing.JTextField jtfNomeLadrao;
    private javax.swing.JTextField jtfOlhoLadrao;
    private javax.swing.JTextField jtfPeleLadrao;
    private javax.swing.JTextField jtfPlanoDeFuga;
    // End of variables declaration//GEN-END:variables
}
