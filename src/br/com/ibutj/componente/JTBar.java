/*
 * Copyright 2011 Mardone Dias
 * 
 * Este arquivo é parte da biblioteca ibutJ
 * 
 * ibutJ é um software livre; você pode redistribui-lo e/ou 
 * modifica-lo dentro dos termos da Licença Pública Geral GNU como 
 * publicada pela Fundação do Software Livre (FSF); na versão 2 da 
 * Licença, ou (na sua opnião) qualquer versão.
 * 
 * Esta biblioteca é distribuida na esperança que possa ser  util, 
 * mas SEM NENHUMA GARANTIA; sem uma garantia implicita de ADEQUAÇÂO a qualquer
 * MERCADO ou APLICAÇÃO EM PARTICULAR. Veja a
 * Licença Pública Geral GNU para maiores detalhes.
 * 
 * Você deve ter recebido uma cópia da Licença Pública Geral GNU
 * junto com este programa, se não, acesse http://www.gnu.org/copyleft/gpl.txt
 */
package br.com.ibutj.componente;

import br.com.ibutj.JAction;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author mardone
 */
public class JTBar extends javax.swing.JPanel implements java.beans.Customizer {

    private Object bean;
    protected javax.swing.Icon imgNovo;
    protected javax.swing.Icon imgEditar;
    protected javax.swing.Icon imgSalvar;
    protected javax.swing.Icon imgCancelar;
    protected javax.swing.Icon imgExcluir;
    protected javax.swing.Icon imgPesquisar;
    protected javax.swing.Icon imgFechar;
    protected JTextField campoId;
    protected JPanel cadastro = null;
    protected JPanel pesquisa = null;

    /** Creates new customizer JTBar */
    public JTBar() {
        initComponents();
        init();
        btnNovo.addActionListener(new JAction() {

            @Override
            public void atualizarEstado(ActionEvent e) {
                crudAtualizar(e);
            }
        });

        btnEditar.addActionListener(new JAction() {

            @Override
            public void atualizarEstado(ActionEvent e) {
                crudAtualizar(e);
            }
        });

        btnSalvar.addActionListener(new JAction() {
//            @Override
//            public void atualizarEstado(ActionEvent e) {
//                crudAtualizar(e);
//            }
        });

        btnCancelar.addActionListener(new JAction() {

            @Override
            public void atualizarEstado(ActionEvent e) {
                limpar(cadastro);
                crudAtualizar(e);
            }
        });

        btnExcluir.addActionListener(new JAction() {

            @Override
            public void atualizarEstado(ActionEvent e) {
                crudAtualizar(e);
            }
        });

        btnPesquisar.addActionListener(new JAction() {

            @Override
            public void atualizarEstado(ActionEvent e) {
                crudAtualizar(e);
            }

            @Override
            public void click(ActionEvent e) {
                trocarPainel();
            }
        });

    }

    private void init() {
        btnNovo.setToolTipText("Inserir");
        btnEditar.setToolTipText("Editar");
        btnSalvar.setToolTipText("Salvar");
        btnCancelar.setToolTipText("Cancelar");
        btnExcluir.setToolTipText("Excluir");
        btnPesquisar.setToolTipText("Pesquisar");
        btnFechar.setToolTipText("Fechar");

        setImagem(btnNovo, "novo.png");
        setImagem(btnEditar, "editar.png");
        setImagem(btnSalvar, "salvar.png");
        setImagem(btnCancelar, "cancelar.png");
        setImagem(btnExcluir, "excluir.png");
        setImagem(btnPesquisar, "pesquisar.png");
        setImagem(btnFechar, "fechar.png");
    }

    /**
     * Atribui imagem a um botão.
     * @param botao
     * @param imagem Nome da imagem com extensão
     */
    public void setImagem(JButton botao, String imagem) {
        botao.setIcon(new ImageIcon(getClass().getResource("/br/com/ibutj/recursos/" + imagem)));
        botao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    }

    public void setObject(Object bean) {
        this.bean = bean;
    }

    public JPanel get_PainelCadastro() {
        return cadastro;
    }

    public void set_PainelCadastro(javax.swing.JPanel cadastro) {
        this.cadastro = cadastro;
    }

    public JPanel get_PainelPesquisa() {
        return pesquisa;
    }

    public void set_PainelPesquisa(javax.swing.JPanel pesquisa) {
        this.pesquisa = pesquisa;
    }

    public Icon get_ImagemNovo() {
        return this.imgNovo;
    }

    public void set_ImagemNovo(javax.swing.Icon imgNovo) {
        this.imgNovo = imgNovo;
        this.btnNovo.setIcon(imgNovo);
    }

    public Icon get_ImagemEditar() {
        return this.imgEditar;
    }

    public void set_ImagemEditar(javax.swing.Icon imgEditar) {
        this.imgEditar = imgEditar;
        this.btnEditar.setIcon(imgEditar);
    }

    public Icon get_ImagemSalvar() {
        return this.imgEditar;
    }

    public void set_ImagemSalvar(javax.swing.Icon imgSalvar) {
        this.imgSalvar = imgSalvar;
        this.btnSalvar.setIcon(imgSalvar);
    }

    public Icon get_ImagemCancelar() {
        return this.imgCancelar;
    }

    public void set_ImagemCancelar(javax.swing.Icon imgCancelar) {
        this.imgCancelar = imgCancelar;
        this.btnCancelar.setIcon(imgCancelar);
    }

    public Icon get_ImagemPesquisar() {
        return this.imgPesquisar;
    }

    public void set_ImagemPesquisar(javax.swing.Icon imgPesquisar) {
        this.imgPesquisar = imgPesquisar;
        this.btnPesquisar.setIcon(imgPesquisar);
    }

    public Icon get_ImagemFechar() {
        return this.imgFechar;
    }

    public void set_ImagemFechar(javax.swing.Icon imgFechar) {
        this.imgFechar = imgFechar;
        this.btnFechar.setIcon(imgFechar);
    }

    public JTextField get_CampoId() {
        return this.campoId;
    }

    public void set_CampoId(javax.swing.JTextField id) {
        this.campoId = id;
    }


    /*
     * EVENTOS
     */
    /**
     * Muda visibilidade dos paineis de cadastro e pesquisa do formulário.
     */
    public void trocarPainel() {
        if (this.cadastro.isVisible()) {
            this.setModoNavegacao();
            limpar(pesquisa);
            this.cadastro.setVisible(false);
            this.pesquisa.setVisible(true);
        } else {
            this.cadastro.setVisible(true);
            this.pesquisa.setVisible(false);
        }
    }

    public void setModoAdicao() {
        ativar(this.cadastro);
        limpar(this.cadastro);
        campoId.setEditable(false);
        btnNovo.setEnabled(false);
        btnEditar.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnSalvar.setEnabled(true);
        btnExcluir.setEnabled(false);
        btnPesquisar.setEnabled(false);
        btnFechar.setEnabled(false);
    }

    /**
     * Altera o estado dos botões para Edição. Nesso estado os 
     * campos do formulário serão ativados para edição. 
     */
    public void setModoEdicao() {
        ativar(this.cadastro);
        campoId.setEditable(false);
        btnNovo.setEnabled(false);
        btnEditar.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnSalvar.setEnabled(true);
        btnExcluir.setEnabled(false);
        btnPesquisar.setEnabled(false);
        btnFechar.setEnabled(false);
    }

    /**
     * Altera o estado dos botões para Navegação. 
     * Nesse modo os campos do formulário serão bloqueados para alteração.
     */
    public void setModoNavegacao() {
        desativar(this.cadastro);
        btnNovo.setEnabled(true);
        btnCancelar.setEnabled(false);
        btnSalvar.setEnabled(false);
        btnFechar.setEnabled(true);
        btnPesquisar.setEnabled(true);

        if (campoId.getText().equals("")) {
            btnEditar.setEnabled(false);
            btnExcluir.setEnabled(false);
        } else {
            btnEditar.setEnabled(true);
            btnExcluir.setEnabled(true);
        }

    }

    /**
     * Atualiza o estado dos botoes CRUD.
     * @param e Evento do botão.
     */
    public void crudAtualizar(ActionEvent e) {
        if (e.getSource() == btnNovo) {
            setModoAdicao();
        } else if (e.getSource() == btnCancelar || e.getSource() == btnExcluir || e.getSource() == btnPesquisar) {
            setModoNavegacao();
        } else if (e.getSource() == btnEditar) {
            setModoEdicao();
        }
    }

    /**
     * Limpa todos os campos que estiverem em um container.
     * @param container JPanel ou qualquer outro container.
     */
    public void limpar(Container container) {
        for (Component c : container.getComponents()) {
            if ((c instanceof JTextField) || (c instanceof JFormattedTextField)) {
                ((JTextField) c).setText("");
            } else if (c instanceof JScrollPane) {
                try {
                    ((JTextArea) ((JScrollPane) c).getViewport().getComponent(0)).setText("");
                } catch (ClassCastException e) {
                }
            } else if (c instanceof JComboBox) {
                ((JComboBox) c).setSelectedIndex(0);
            } else if (c instanceof JList) {
                ((JList) c).setSelectedIndex(0);
            } else if (c instanceof JSpinner) {
                ((JSpinner) c).setValue(new Integer(0));
            } else if (c instanceof JPanel) {
                limpar((JPanel) c);
            }
        }
    }

    /**
     * Ativa ou destiva os componentes de um container.
     * @param container JPanel ou qualquer outro container.
     * @param ativo true ou false
     */
    private void ativarComponentes(Container container, boolean ativo) {
        for (Component c : container.getComponents()) {
            if ((c instanceof JTextField) || (c instanceof JFormattedTextField)) {
                ((JTextField) c).setEditable(ativo);
            } else if (c instanceof JScrollPane) {
                try {
                    ((JTextArea) ((JScrollPane) c).getViewport().getComponent(0)).setEditable(ativo);
                } catch (ClassCastException e) {
                }
            } else if (c instanceof JTable) {
                try {
                    ((JTable) ((JScrollPane) c).getViewport().getComponent(0)).setEnabled(ativo);
                } catch (ClassCastException e) {
                }
            } else if (c instanceof JCheckBox) {
                ((JCheckBox) c).setEnabled(ativo);
            } else if (c instanceof JComboBox) {
                ((JComboBox) c).setEnabled(ativo);
            } else if (c instanceof JList) {
                ((JList) c).setEnabled(ativo);
            } else if (c instanceof JButton) {
                ((JButton) c).setEnabled(ativo);
            } else if (c instanceof JSpinner) {
                ((JSpinner) c).setEnabled(ativo);
            } else if (c instanceof JPanel) {
                ativarComponentes((JPanel) c, ativo);
            } else if (c instanceof JTabbedPane) {
                ativarComponentes((JTabbedPane) c, ativo);
            }
        }
    }

    public void ativar(Container container) {
        ativarComponentes(container, true);
    }

    public void desativar(Container container) {
        ativarComponentes(container, false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the FormEditor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtbBase = new javax.swing.JToolBar();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jtbBase.setFloatable(false);
        jtbBase.setRollover(true);

        btnNovo.setText("Novo");
        btnNovo.setFocusable(false);
        btnNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jtbBase.add(btnNovo);

        btnEditar.setText("Editar");
        btnEditar.setFocusable(false);
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jtbBase.add(btnEditar);

        btnCancelar.setText("Cancelar");
        btnCancelar.setFocusable(false);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jtbBase.add(btnCancelar);

        btnSalvar.setText("Salvar");
        btnSalvar.setFocusable(false);
        btnSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jtbBase.add(btnSalvar);

        btnExcluir.setText("Excluir");
        btnExcluir.setFocusable(false);
        btnExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jtbBase.add(btnExcluir);

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.setFocusable(false);
        btnPesquisar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPesquisar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jtbBase.add(btnPesquisar);

        btnFechar.setText("Fechar");
        btnFechar.setFocusable(false);
        btnFechar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFechar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jtbBase.add(btnFechar);

        add(jtbBase, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnExcluir;
    public javax.swing.JButton btnFechar;
    public javax.swing.JButton btnNovo;
    public javax.swing.JButton btnPesquisar;
    public javax.swing.JButton btnSalvar;
    private javax.swing.JToolBar jtbBase;
    // End of variables declaration//GEN-END:variables
}
