

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import model.HibernateUtil;
import org.hibernate.Session;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nermin
 */
public class main {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
     
        FormUposlenici forma=new FormUposlenici();
        forma.setTitle("Uposlenici");
        
        Baza bazaUposlenih=new Baza();
//        Baza.Connect();
        ArrayList<Uposlenik> zaposleni=Baza.sviUposlenici();
        ModelTabelaUposlenika Model=new ModelTabelaUposlenika(zaposleni);
        forma.tableUposlenici.setModel(Model);
        forma.setVisible(true);
        

    }
    
}
