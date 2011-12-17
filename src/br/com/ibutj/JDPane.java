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

import java.awt.Rectangle;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 * Classe que estende a JDesktopPane, contendo novas funcionalidades.<br/>
 * OBS.: Essa classe pode ser adicionada a paleta de componentes, para ser usada através do Arrastar e soltar (DragAndDrop).
 * @author Mardone Dias
 * @version 1.0.0
 */
public class JDPane extends JDesktopPane {

    public JDPane() {
        this.setDesktopManager(new JDPaneManager());
    }

    public void organizarEmCascata() {
        Rectangle dBounds = this.getBounds(); // Bordas do JDesktopPane
        int separation = 28; // distancia entre as janelas

        // Pega todos os frames e organiza, o ultimo fica mais em baido e mais pra cima
        int i = this.getAllFrames().length; // quantidade de frames
        for (JInternalFrame f : this.getAllFrames()) {
            f.setLocation(i * separation, i * separation);
            i--; //mutiplicador
        }
    }

    /**
     * Fecha todas as JInternalFrames
     */
    public void fecharTodos() {
        JInternalFrame allFrames[] = getAllFrames();
        for (int i = 0; i < allFrames.length; i++) {
            allFrames[i].dispose();
        }
    }

    /**
     *Adiciona Formulário (JInternalFrame) ao JDesktopPane<br/><br/>
     * Exemplo:<br/><br/>
     * Cliente cli=new Cliente();<br/>
     * desktop.abrirJanela(cli);<br/><br/>
     *
     * <b>OBS.: desktop é o JDesktopPane onde você quer abrir o formulário.</b><br/>
     *
     * @param formulario JForm Formulário JInternalFrame.
     */
    public void abrirJanela(JForm formulario) {
        for (JInternalFrame f : this.getAllFrames()) {
            //se uma janela semelhante estiver aberta
            if (f.getClass().toString().equalsIgnoreCase(formulario.getClass().toString())) {
                f.moveToFront(); // traz janela para frente para facilitar a escolha
                return;
            }
        }

        this.add(formulario); //adiciona na tela
        formulario.setVisible(true); // seta visivel
    }

    /**
     *Adiciona formulário (JInternalFrame) ao JDesktopPane, com a função de organizar os mesmos em cascata e abrir multiplas cópias<br/><br/>
     * Exemplo:<br/><br/>
     * Cliente cli=new Cliente();<br/>
     * desktop.abrirEm(cli, true, true);<br/><br/>
     *
     * <b>OBS.: desktop é o JDesktopPane onde você quer abrir o formulário.</b><br/>
     *
     * @param formulario Formulário JInternalFrame.
     * @param cascata Define se a janela será organizada em cascata ou não (true ou false).
     * @param multiplasjanelas Define se pode ser aberta múltiplas cópias do formulário (true ou false).
     */
    public void abrirJanela(JForm formulario, boolean cascata, boolean multiplasjanelas) {

        for (JInternalFrame f : this.getAllFrames()) {
            //se uma janela semelhante estiver aberta
            if (f.getClass().toString().equalsIgnoreCase(formulario.getClass().toString())) {
                f.moveToFront(); // traz janela para frente para facilitar a escolha
                if (multiplasjanelas) {
                    Object[] opções = {"Utilizar Aberta", "Abrir Nova"};
                    int qst = JOptionPane.showOptionDialog(null, "Abrir uma nova janela ou utilizar a que ja esta aberta?",
                            "Janela duplicada",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            opções,
                            opções[0]);
                    // se utilizar a aberta retorna e não abre outra,
                    // caso contrário sai do for e abre outra igual
                    if (qst == 0) {
                        return;
                    } else if (qst == 1) {
                        break;
                    }
                } else {
                    return;
                }
            }
        }

        this.add(formulario); //adiciona na tela
        formulario.setVisible(true); // seta visivel
        if (cascata) {
            this.organizarEmCascata(); //coloca em cascata para deixar "pratico"
        }
    }

}
