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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JAction implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        atualizarEstado(e);
        click(e);
    }

    public void click(ActionEvent e) {
    }

    public void atualizarEstado(ActionEvent e) {
    }
}
