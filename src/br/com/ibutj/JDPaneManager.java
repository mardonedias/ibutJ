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
import javax.swing.DefaultDesktopManager;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;


/**
 * Classe que estende a DefaultDesktopManager, que reescreve o método dragFrame() para limitar a área de movimentação dos JInternalFrames.
 * @author Mardone Dias
 * @version 1.0.0
 */
public class JDPaneManager extends DefaultDesktopManager {

    /**
     * Esse método é chamado toda vez que a classe é movida na tela.
     * @param f Componente
     * @param x Posição x
     * @param y Posição y
     */
    @Override
    public void dragFrame(JComponent f, int x, int y) {
        if (f instanceof JInternalFrame) {
            JInternalFrame frame = (JInternalFrame) f;
            JDesktopPane desk = frame.getDesktopPane();
            Dimension d = desk.getSize();

            if (x < 0) {
                x = 0; 
            } else {
                if (x + frame.getWidth() > d.width) {
                    x = d.width - frame.getWidth(); 
                }
            }
            if (y < 0) {
                y = 0; 
            } else {
                if (y + frame.getHeight() > d.height) {
                    y = d.height - frame.getHeight(); 
                }
            }
        }

        super.dragFrame(f, x, y);
    }
}
