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

import com.pbash.r2o.dataAccess.*;
import java.sql.*;
import java.util.ArrayList;

public class Categorie extends DataObject {

    private String IDCategorie;
    private String Nom;

    public Categorie() {
    }

    public Categorie(String IDCategorie, String Nom) {
        this.IDCategorie = IDCategorie;
        this.Nom = Nom;
    }

    public String getIDCategorie() {
        return this.IDCategorie;
    }

    public String getNom() {
        return this.Nom;
    }

    public void setIDCategorie(String IDCategorie) {
        this.IDCategorie = IDCategorie;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public boolean create() throws Exception {
        String createSQL = "insert into Categorie values(?,?)";
        statement = cm.getConnexion().prepareStatement(createSQL);

        boolean executed = false;
        statement.setString(1, IDCategorie);
        statement.setString(2, Nom);
        executed = statement.execute();

        return executed;
    }

    public void read(String keyValue) throws Exception {

        String readSQL = "select * from Categorie where idCategorie=?";
        statement = cm.getConnexion().prepareStatement(readSQL);
        statement.setString(1, keyValue);
        ResultSet rst = statement.executeQuery();

        while (rst.next()) {
            this.setIDCategorie(rst.getString(1));
            this.setNom(rst.getString(2));

        }
    }

    public int update() throws Exception {
        String updateSQL = "update Categorie set IDCategorie=? , Nom=?  where IDCategorie = ?";
        statement = cm.getConnexion().prepareStatement(updateSQL);
        statement.setString(1, IDCategorie);
        statement.setString(2, Nom);
        statement.setString(3, IDCategorie);
        int rowafect = statement.executeUpdate();
        return rowafect;
    }

    public ArrayList<DataObject> getAll() throws Exception {
        ArrayList<DataObject> all = new ArrayList<DataObject>();
        String allQuery = " select * from Categorie";
        statement = cm.getConnexion().prepareStatement(allQuery);
        ResultSet rst = statement.executeQuery();
        Categorie anCategorie;
        synchronized (all) {
            while (rst.next()) {
                anCategorie = new Categorie();
                anCategorie.setIDCategorie(rst.getString(1));
                anCategorie.setNom(rst.getString(2));
                all.add(anCategorie);

            }
            return all;
        }
    }

    public int delete(String key) throws Exception{
         String updateSQL = "delete from categorie where idcategorie = ?";
        statement = cm.getConnexion().prepareStatement(updateSQL);
        statement.setString(1, key);

        int rowafect = statement.executeUpdate();
        return rowafect;
    }
}
