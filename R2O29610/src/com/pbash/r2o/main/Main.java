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

import com.pbash.r2o.dataAccess.ConnectionManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Bash
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
           ConnectionManager cm =ConnectionManager.getInstance();
                   cm.makeConnection();
            for (int i = 0; i < cm.getTableNames().length; i++) {

                String tn = cm.getTableNames()[i];
                System.out.println("--- " + tn + " ---");
                HashMap h = (cm.getColumnNamesAndClass(tn));
                Set it = h.keySet();
                for (Object key : it) {
                    // String key =  (String) it.next();

                    Class cl = (Class) h.get(key);
                    System.out.println("+" + key.toString() + " [" + cl.getSimpleName() + "]");
                }
                System.out.println("\n");
            }



            cm.clean();

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
