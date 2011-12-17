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


package br.com.ibutj;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

/**
 * Classe Abstrata que estende a JInternalFrame com recursos para manipulação de formulário.<br>
 * A classe automaticamente cria a barra de botões CRUD.
 * Com os botões Novo, Editar, Cancelar, Salvar, Excluir, Pesquisar e Fechar.<br>
 * Para usar a classe basta estender a ela. Os eventos dos botões deverão ser adicionado dentro do construtor da classe.<br><br>
 * @author Mardone Dias
 * @version 1.0.0
 */
public abstract class JForm extends JInternalFrame {

    protected JToolBar tbar;
    protected JButton btnNovo;
    protected JButton btnEditar;
    protected JButton btnSalvar;
    protected JButton btnExcluir;
    protected JButton btnCancelar;
    protected JButton btnPesquisar;
    protected JButton btnFechar;
    protected String recursos;
    protected JPanel cadastro;
    protected JPanel pesquisa;
    protected JTextField campoId;

    public JForm() {
    }

    /**
     * Centraliza o formulário no JDesktopPanel.
     */
    public void centralizarFormulario() {
        Dimension paneSize = this.getSize();
        Dimension screenSize = this.getDesktopPane().getSize();
        this.setLocation((screenSize.width - paneSize.width) / 2, (screenSize.height - paneSize.height) / 2);
    }

    /**
     * Fecha o formulário e libera da memória.
     */
    public void fechar() {
        this.dispose();
    }

}
