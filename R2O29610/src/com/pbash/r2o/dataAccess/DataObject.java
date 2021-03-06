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


import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author Bash
 */


public abstract class DataObject {

    protected PreparedStatement statement;
    protected  ConnectionManager cm= ConnectionManager.getInstance();
    public abstract boolean create() throws Exception;
    public  abstract void read(String keyValue) throws Exception;
    public abstract int update() throws Exception;
   // public abstract ArrayList<DataObject> readAll() throws Exception;
   // public abstract void delete(Object help) throws Exception;
    public abstract ArrayList<DataObject> getAll() throws Exception;
    

}
