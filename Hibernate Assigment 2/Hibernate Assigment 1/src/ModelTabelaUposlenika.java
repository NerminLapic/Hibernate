

import java.util.List;
import javax.swing.table.AbstractTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nermin
 */
public class ModelTabelaUposlenika extends AbstractTableModel{
    
    private static final int IME=0;
    private static final int ADRESA=1;
    private static final int GODINE=2;
    private static final int DOHODAK=3;
    
    private String [] columnNames={"Ime","Adresa","Godine","Dohodak"};
    static public List<Uposlenik> uposlenici;
    
    public ModelTabelaUposlenika(List<Uposlenik> uposlenici){
       this.uposlenici=uposlenici;
                
    }

    @Override
    public int getRowCount() {
        return uposlenici.size();
    }

    @Override
    public int getColumnCount() {
       return columnNames.length;
    }

    @Override
    public String getColumnName(int col){
        return columnNames[col];
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Uposlenik tempUposlenik=uposlenici.get(rowIndex);
        switch(columnIndex){
            case IME:
                return tempUposlenik.getIme();
            case ADRESA:
                return tempUposlenik.getAdresa();
            case GODINE:
                return tempUposlenik.getBrojGodina();
            case DOHODAK:
                return tempUposlenik.getVisinaDohotka();
            default:
                return tempUposlenik.getIme();
        }
      
    }
    
    @Override
    public Class getColumnClass(int columnIndex){
        return getValueAt(0, columnIndex).getClass();
    }
    
}
