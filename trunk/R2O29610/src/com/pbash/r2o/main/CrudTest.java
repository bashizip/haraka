/*
R2O (Relational to Object) is a free ORM ( Object- realtional mapping) tool.
Copyright (C) 2010 Patrick Bashizi.

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this package; if not, write to the Free Software
Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package com.pbash.r2o.main;
//import pojos.Corrdp;

import com.pbash.r2o.dataAccess.ConnectionManager;
import pojos.Promotion;
//import pojos.Article;

/**
 *
 * @author Bash
 */
public class CrudTest {

    public static void main(String[] args) {
        try {

//          Unite unit=new Unite(4,"Boite558");
//            unit.create();
//
//            Unite unit2 = new Unite();
//at1=new Categorie();
            //cat.create(
//            unit2.read("4");

//            Corrdp cor=new Corrdp(16l, 1l, "NH25");
//            cor.create();
            // Corrdp cor = new Corrdp(0L, 252l, "Carine");

//           Categorie cat=new Categorie("OA", "Oeuvre magistrale");
            //    Categorie cat1 = new Categorie();
            //   int ra=cat1.delete("VO");
//            cat.update();
            //  ArrayList<DataObject> all = cat1.getAll();
//
//            Article art = new Article();
//
//            ArrayList<DataObject> all = art.getAll();
//            for (DataObject cat : all) {
//                Article a = (Article) cat;
//                System.out.println(a.getDesignation());
//            }

//            cat1.read("OA");
            // cor.update();
               Promotion promo = new Promotion("Prepo", " test");
                    promo.create();

               ConnectionManager.getInstance().commit();

            //    System.out.println(ra);
//            for (DataObject cat : all) {
//                System.out.println(((Categorie) cat).getNom() + "," + ((Categorie) cat).getIDCategorie());
//            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
