
```
package testr20;

import com.pbash.r2o.dataAccess.ConnectionManager;
import com.pbash.r2o.dataAccess.DataObject;
import gen.Categorie;

/**
 *
 * @author bashizip
 */
public class Main {

    static ConnectionManager cm = ConnectionManager.getInstance();
    static Categorie helper = new Categorie();

    //create
    static void create(int id) {
        Categorie cat = new Categorie(id, "Viande", new java.sql.Date(System.currentTimeMillis()));
        try {
            cat.create();

            cm.commit();
        } catch (Exception e) {
            cm.rollback();
            e.printStackTrace();
        }
    }
    //read

    static void read(String key) {
        try {
            helper.read(key);
            cm.commit();
            System.out.println(helper.getIdcategorie() + "\n" + helper.getNom() + "\n" + helper.getDate_creation());
        } catch (Exception e) {
              cm.rollback();
            e.printStackTrace();
        }


    }

    //update
    static void update(int id) {
        Categorie cu = new Categorie(id, "Electrique dcd", new java.sql.Date(System.currentTimeMillis()));
        try {
            cu.update();
            cm.commit();
        } catch (Exception e) {
            cm.rollback();
            e.printStackTrace();
        }

    }
//delete
    static void delete(String id) {
        Categorie cdel = new Categorie();
        try {
            cdel.delete(id);
            cm.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
//read all
    static void readAll() {

        try {
            for (DataObject dao : helper.getAll()) {
                Categorie c = (Categorie) dao;
                System.out.println(c.getNom());
                for (DataObject C : helper.getAll()) {
                    cm.commit();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
              cm.rollback();
        }

    }

    public static void main(String[] args) {
        readAll();   //a vous d'essayer les autres methodes
    }
}
```