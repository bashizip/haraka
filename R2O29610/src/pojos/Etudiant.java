// Generated by R2O 1.0.Developped by Patrick Bashizi Mutuzi. All right reserved.

package pojos;


import com.pbash.r2o.dataAccess.DataObject;
import java.sql.*;
import java.util.ArrayList;


public class Etudiant extends DataObject{

private Integer idEtudiant;
private String nom;
private String postnom;
private String prenom;
private String password;
private String promotion;



public Etudiant(){

}


public Etudiant(Integer idEtudiant,String nom,String postnom,String prenom,String password,String promotion
){
this.idEtudiant=idEtudiant;
this.nom=nom;
this.postnom=postnom;
this.prenom=prenom;
this.password=password;
this.promotion=promotion;
}
public Integer  getIdEtudiant(){
return this.idEtudiant;
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
public String  getPassword(){
return this.password;
}
public String  getPromotion(){
return this.promotion;
}
public void setIdEtudiant(Integer idEtudiant){
 this.idEtudiant=idEtudiant;
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
public void setPassword(String password){
 this.password=password;
}
public void setPromotion(String promotion){
 this.promotion=promotion;
}

public boolean create() throws Exception{
String createSQL="insert into Etudiant values(?,?,?,?,?,?)";
statement = cm.getConnexion().prepareStatement(createSQL);

boolean executed=false;
statement.setInt(1,idEtudiant);
statement.setString(2,nom);
statement.setString(3,postnom);
statement.setString(4,prenom);
statement.setString(5,password);
statement.setString(6,promotion);
executed=statement.execute();

return executed;
}

public void read(String keyValue) throws Exception{

String readSQL="select * from Etudiant where idEtudiant=?";
statement = cm.getConnexion().prepareStatement(readSQL);
statement.setString(1,keyValue);
 ResultSet rst=statement.executeQuery();

while (rst.next()) {
this.setIdEtudiant(rst.getInt(1));
this.setNom(rst.getString(2));
this.setPostnom(rst.getString(3));
this.setPrenom(rst.getString(4));
this.setPassword(rst.getString(5));
this.setPromotion(rst.getString(6));

}
}

public int update() throws Exception{
String updateSQL="update Etudiant set idEtudiant=? , nom=? , postnom=? , prenom=? , password=? , promotion=?  where idEtudiant = ?";
statement = cm.getConnexion().prepareStatement(updateSQL);
statement.setInt(1,idEtudiant);
statement.setString(2,nom);
statement.setString(3,postnom);
statement.setString(4,prenom);
statement.setString(5,password);
statement.setString(6,promotion);
statement.setInt(7,idEtudiant);
int rowafect=statement.executeUpdate();
return rowafect;
}
public ArrayList<DataObject> getAll() throws Exception {
ArrayList<DataObject> all = new ArrayList<DataObject>();
String allQuery = " select * from Etudiant";
statement = cm.getConnexion().prepareStatement(allQuery);
ResultSet rst = statement.executeQuery();
Etudiant anEtudiant;
synchronized(all){
while (rst.next()) {
anEtudiant= new Etudiant();
 anEtudiant.setIdEtudiant(rst.getInt(1));
 anEtudiant.setNom(rst.getString(2));
 anEtudiant.setPostnom(rst.getString(3));
 anEtudiant.setPrenom(rst.getString(4));
 anEtudiant.setPassword(rst.getString(5));
 anEtudiant.setPromotion(rst.getString(6));
 all.add( anEtudiant);

}return all;
}
}

public int delete(String key) throws Exception{
String deleteSQL = "delete from Etudiant where idEtudiant = ?";
 statement = cm.getConnexion().prepareStatement(deleteSQL);
statement.setString(1, key);
int rowafect = statement.executeUpdate();
return rowafect;
}
}
