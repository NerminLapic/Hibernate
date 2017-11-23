
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.persistence.Query;
import model.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nermin
 */
public class Baza {
    
    private static Connection conn;
    
    
//    public static void Connect() throws SQLException{
//        
//     conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/firma","root", "");
//        System.out.println("Uspjenos konektovano na bazu");
//        
//    }
    
   
    /**
     * metod koji vraća listu svih uposelenika iz bazze
     * @return 
     */
     public static ArrayList<Uposlenik> sviUposlenici(){
      
     ArrayList<Uposlenik> listaUposlenih=new ArrayList<>();

     Session session=HibernateUtil.getSessionFactory().openSession();
     org.hibernate.Query query= session.createQuery("from Uposlenik");
     listaUposlenih=(ArrayList<Uposlenik>) query.list();
     session.close();

     return listaUposlenih;
  }
    
    
    /**
     * 
     * Metod koji vraća sa odeređenim imenom
     * @param ime
     * @return 
     * @throws java.sql.SQLException
     */
    
    public static ArrayList<Uposlenik>  nadjiUposlenog(String ime) throws SQLException{
        ArrayList<Uposlenik> lista = new ArrayList<>();
        Session session=HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Query query= session.createQuery("from Uposlenik where imeUposlenika like:ime");
        query.setParameter("ime", ime);
        lista=(ArrayList<Uposlenik>) query.list();
        session.close();
        return lista;
    }
    
    /**
     * Metod za unos novog uposlenika u bazu. Id uposlenika je postavljen na auto increment
     * @param ime
     * @param adresa
     * @param godine
     * @param dohodak
     * @throws SQLException 
     */
    
    public static void unesiUposlenika(String ime,String adresa,int godine, int dohodak) throws SQLException{
        
           Uposlenik tempUposlenik=new Uposlenik();
           tempUposlenik.setIme(ime);
           tempUposlenik.setAdresa(adresa);
           tempUposlenik.setBrojGodina(godine);
           tempUposlenik.setVisinaDohotka(dohodak);
           
           
           Session session=HibernateUtil.getSessionFactory().openSession();
           Transaction tx=null;

           try {
            tx=session.beginTransaction();
            session.save(tempUposlenik);
            tx.commit();
        } catch (Exception e) {
            if(tx!=null){
                tx.rollback();
            }
        }
           finally{
               if(session.isOpen()){
                   session.close();
               }
           }
    } 
    
    /**
     * Metod za brisanje uposlenika za zadatim Id-jem
     * @param id
     * @throws java.sql.SQLException
     */
    
    public static void brisiUposlenika(int id) throws SQLException{
           Uposlenik tempUposlenik=new Uposlenik();
           Session session=HibernateUtil.getSessionFactory().openSession();
           tempUposlenik=(Uposlenik) session.get(Uposlenik.class, id);
           Transaction tx=null;
  
           try {
            tx=session.beginTransaction();
            session.delete(tempUposlenik);
            tx.commit();
        } catch (Exception e) {
            if(tx!=null){
                tx.rollback();
            }
        }
           finally{
               if(session.isOpen()){
                   session.close();
               }
           }
   
    } 

    /**
     * Metod za izmjenu uposlenmika na osnovu zadatog Id broja
     * @param ime
     * @param adresa
     * @param godine
     * @param dohodak
     * @param id

  
     * @throws SQLException 
     */
   
    /**
     * Metod za izmjenu uposlenmika na osnovu zadatog Id broja
     * @param uposlenik
     * @param ime
     * @param adresa
     * @param godine
     * @param dohodak
     * @param id
     * @throws SQLException
     */
    public static void izmjeniUposlenika(Uposlenik uposlenik) throws SQLException{
        Session session=HibernateUtil.getSessionFactory().openSession();
        
        int id=uposlenik.getId();
        String ime=uposlenik.getIme();
        String adresa=uposlenik.getAdresa();
        int godine=uposlenik.getBrojGodina();
        int dohodak=uposlenik.getVisinaDohotka();
        
        
          Transaction tx=null;
           try {
            tx=session.beginTransaction();
            org.hibernate.Query query=session.createQuery("update Uposlenik set adresaUposlenika=:adresa, imeUposlenika= :ime, brojGodina= :godine, visinaDohodka= :dohodak WHERE idUposlenika=:id");
            query.setParameter("adresa", adresa);
            query.setParameter("ime", ime);
            query.setParameter("godine", godine);
            query.setParameter("dohodak", dohodak); 
            query.setParameter("id", id);
            query.executeUpdate();
            tx.commit();
        } catch (Exception e) {
            if(tx!=null){
                tx.rollback();
            }
        }
           finally{
               if(session.isOpen()){
                   session.close();
               }
           }   
  
    } 
}