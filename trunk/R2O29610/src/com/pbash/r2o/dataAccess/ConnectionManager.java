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
package com.pbash.r2o.dataAccess;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import com.pbash.r2o.util.DBConfig;

/**
 *
 * @author Bash
 * created in june 2010
 */
public class ConnectionManager {

    private String password;
    private Connection connexion;
    ResultSetMetaData metaData;
    private static ConnectionManager instance;

    private ConnectionManager() {
    }

    public static ConnectionManager getInstance() {

        if (instance == null) {
            instance = new ConnectionManager();
        }
        if (instance.connexion == null) {
            try {
                instance.makeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return instance;
    }

    public void makeConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DBConfig.driver);
        connexion = DriverManager.getConnection(DBConfig.url, DBConfig.user, DBConfig.password);
        connexion.setAutoCommit(false);
        System.out.println("Connection created");
    }

    private DatabaseMetaData getDatabaseMetaData() throws SQLException {

        if (connexion == null) {
            throw new SQLException("connection is null");
        } else {
            return connexion.getMetaData();
        }


    }

    private String[] getColumnNames(ResultSet resultat) throws SQLException {
        metaData = resultat.getMetaData();
        String[] noms = new String[metaData.getColumnCount()];
        for (int i = 0; i < noms.length; i++) {
            String nomColonne = metaData.getColumnName(i + 1);
            System.out.println(nomColonne);
            noms[i] = nomColonne;
        }
        return noms;
    }

    public HashMap getColumnNamesAndClass(String table) throws SQLException {

        String sql = "SELECT * FROM " + table;
        Statement statement = connexion.createStatement();
        ResultSet resultat = statement.executeQuery(sql);

        HashMap<String, Class> htable = new HashMap<String, Class>();
        metaData = resultat.getMetaData();
        // String[] noms = new String[metaData.getColumnCount()];

        for (int i = 0; i < metaData.getColumnCount(); i++) {
            String nomColonne = metaData.getColumnName(i + 1);

            Class cla = getColumnClass(i + 1);
            // System.out.println(nomColonne+" -- "+cla.getSimpleName());
            synchronized (htable) {
                htable.put(nomColonne, cla);
            }
        }
        return htable;
    }

    public String getPrimaryKey(String table) throws SQLException {
        DatabaseMetaData dbmd = getDatabaseMetaData();
        String key = "";
        String dbName = dbmd.getDatabaseProductName();

        ResultSet rst = dbmd.getPrimaryKeys("", "popbd", table);
        while (rst.next()) {
            key = rst.getString("COLUMN_NAME");
            // System.out.println();
        }
        return key;
    }
    public String getPrimaryKeyClassName(){
          Class cla = getColumnClass(1);
          return cla.getSimpleName();
    }
    public ArrayList<String> getColumnNamesAndClassArr(String table) throws SQLException {

        String sql = "SELECT * FROM " + table;
        Statement statement = connexion.createStatement();
        ResultSet resultat = statement.executeQuery(sql);

        ArrayList<String> htable = new ArrayList<String>();
        metaData = resultat.getMetaData();
        // String[] noms = new String[metaData.getColumnCount()];



        for (int i = 0; i < metaData.getColumnCount(); i++) {
            String nomColonne = metaData.getColumnName(i + 1);

            Class cla = getColumnClass(i + 1);
            //System.out.println(nomColonne+" -- "+cla.getSimpleName());
            synchronized (htable) {
                htable.add(i, cla.getSimpleName() + "," + nomColonne);
            }
        }
        return htable;
    }

//    public HashTable getColumnsNamesAndClass(){
//
//
//    }
    public String[] getColumnNames(String table) {

        String[] noms = {};
        try {
            String sql = "SELECT * FROM " + table;
            Statement statement = connexion.createStatement();
            ResultSet resultat = statement.executeQuery(sql);

            noms = getColumnNames(resultat);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return noms;
    }

    public String[] getTableNames() {
        ArrayList<String> Atables = new ArrayList<String>();
        String[] tables;
        try {
            ResultSet rst = this.getDatabaseMetaData().
                    getTables(connexion.getCatalog(),
                    null, "%", null);
            while (rst.next()) {

                Object valeurColonne = rst.getObject(3);
                //  System.out.println(valeurColonne.toString());
                Atables.add(valeurColonne.toString());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        tables = new String[Atables.size()];
        for (int i = 0; i < Atables.size(); i++) {

            tables[i] = Atables.get(i);
//            System.out.println(tables[i]);
        }

        return tables;

    }

    private Class getColumnClass(int column) {
        int type = 0;
        try {
            type = metaData.getColumnType(column);
        } catch (SQLException e) {
            //return super.getColumnClass(column);
            e.printStackTrace();
        }

        switch (type) {
            case Types.CHAR:
            case Types.VARCHAR:
            case Types.LONGVARCHAR:
                return String.class;

            case Types.BIT:
                return Boolean.class;

            case Types.TINYINT:
            case Types.SMALLINT:
            case Types.INTEGER:
                return Integer.class;

            case Types.BIGINT:
                return Long.class;

            case Types.FLOAT:
            case Types.DOUBLE:
                return Double.class;

            case Types.DATE:
            case Types.TIMESTAMP:
                return java.sql.Date.class;
            case Types.BLOB:
                return java.sql.Blob.class;

            default:
                return Object.class;
        }
    }

    public void commit() throws SQLException {

        connexion.commit();

    }

    public void clean() {
        try {
            connexion.close();
            connexion = null;

        } catch (SQLException ex) {
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Connection getConnexion() {
        return connexion;
    }

    public static void main(String[] args) {
        ConnectionManager cm = getInstance();
        try {
            cm.makeConnection();

           // cm.getKeys();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
