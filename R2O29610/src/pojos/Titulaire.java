// Generated by R2O 1.0.Developped by Patrick Bashizi Mutuzi. All right reserved.

package pojos;


import com.pbash.r2o.dataAccess.DataObject;
import java.sql.*;
import java.util.ArrayList;


public class Titulaire extends DataObject{

private Integer idTitulaire;
private String nom;
private String postnom;
private String prenom;



public Titulaire(){

}


public Titulaire(Integer idTitulaire,String nom,String postnom,String prenom
){
this.idTitulaire=idTitulaire;
this.nom=nom;
this.postnom=postnom;
this.prenom=prenom;
}
public Integer  getIdTitulaire(){
return this.idTitulaire;
}
public String  getNom(){
return this.nom;
}
public String  getPostnom(){
return this.postnom;
}
public String  getPrenom(){
return this.prenom;
}
public void setIdTitulaire(Integer idTitulaire){
 this.idTitulaire=idTitulaire;
}
public void setNom(String nom){
 this.nom=nom;
}
public void setPostnom(String postnom){
 this.postnom=postnom;
}
public void setPrenom(String prenom){
 this.prenom=prenom;
}

public boolean create() throws Exception{
String createSQL="insert into Titulaire values(?,?,?,?)";
statement = cm.getConnexion().prepareStatement(createSQL);

boolean executed=false;
statement.setInt(1,idTitulaire);
statement.setString(2,nom);
statement.setString(3,postnom);
statement.setString(4,prenom);
executed=statement.execute();

return executed;
}

public void read(String keyValue) throws Exception{

String readSQL="select * from Titulaire where idTitulaire=?";
statement = cm.getConnexion().prepareStatement(readSQL);
statement.setString(1,keyValue);
 ResultSet rst=statement.executeQuery();

while (rst.next()) {
this.setIdTitulaire(rst.getInt(1));
this.setNom(rst.getString(2));
this.setPostnom(rst.getString(3));
this.setPrenom(rst.getString(4));

}
}

public int update() throws Exception{
String updateSQL="update Titulaire set idTitulaire=? , nom=? , postnom=? , prenom=?  where idTitulaire = ?";
statement = cm.getConnexion().prepareStatement(updateSQL);
statement.setInt(1,idTitulaire);
statement.setString(2,nom);
statement.setString(3,postnom);
statement.setString(4,prenom);
statement.setInt(5,idTitulaire);
int rowafect=statement.executeUpdate();
return rowafect;
}
public ArrayList<DataObject> getAll() throws Exception {
ArrayList<DataObject> all = new ArrayList<DataObject>();
String allQuery = " select * from Titulaire";
statement = cm.getConnexion().prepareStatement(allQuery);
ResultSet rst = statement.executeQuery();
Titulaire anTitulaire;
synchronized(all){
while (rst.next()) {
anTitulaire= new Titulaire();
 anTitulaire.setIdTitulaire(rst.getInt(1));
 anTitulaire.setNom(rst.getString(2));
 anTitulaire.setPostnom(rst.getString(3));
 anTitulaire.setPrenom(rst.getString(4));
 all.add( anTitulaire);

}return all;
}
}

public int delete(String key) throws Exception{
String deleteSQL = "delete from Titulaire where idTitulaire = ?";
 statement = cm.getConnexion().prepareStatement(deleteSQL);
statement.setString(1, key);
int rowafect = statement.executeUpdate();
return rowafect;
}
}
