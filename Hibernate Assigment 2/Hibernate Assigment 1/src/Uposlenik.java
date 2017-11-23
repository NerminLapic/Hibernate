


import com.sun.javafx.sg.prism.NGTriangleMesh;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nermin
 */
@Entity
@Table(name="uposlenici")
public class Uposlenik implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUposlenika")
    private int id;
    
    @Column(name = "imeUposlenika")
    private String Ime;
    
    @Column(name = "adresaUposlenika")
    private String Adresa;
    
    @Column(name = "brojGodina")
    private int brojGodina;
    
    @Column(name = "visinaDohodka")
    private int visinaDohotka;

    /**
     * Konstruktor klase uposlenik, parametrizovani
     * 
     * @param ime
     * @param adresa
     * @param godine
     * @param dohodak 
     */
    Uposlenik(int id,String ime, String adresa,int godine,int dohodak){
        this.id=id;
        this.Ime=ime;
        this.Adresa=adresa;
        this.brojGodina=godine;
        this.visinaDohotka=dohodak;
    }

    public Uposlenik() {
    }
    
    
    /**
     * @return the Ime
     */
    public String getIme() {
        return Ime;
    }

    /**
     * @param Ime the Ime to set
     */
    public void setIme(String Ime) {
        this.Ime = Ime;
    }

    /**
     * @return the Adresa
     */
    public String getAdresa() {
        return Adresa;
    }

    /**
     * @param Adresa the Adresa to set
     */
    public void setAdresa(String Adresa) {
        this.Adresa = Adresa;
    }

    /**
     * @return the brojGodina
     */
    public int getBrojGodina() {
        return brojGodina;
    }

    /**
     * @param brojGodina the brojGodina to set
     */
    public void setBrojGodina(int brojGodina) {
        this.brojGodina = brojGodina;
    }

    /**
     * @return the visinaDohotka
     */
    public int getVisinaDohotka() {
        return visinaDohotka;
    }

    /**
     * @param visinaDohotka the visinaDohotka to set
     */
    public void setVisinaDohotka(int visinaDohotka) {
        this.visinaDohotka = visinaDohotka;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
 
}
