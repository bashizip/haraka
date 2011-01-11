/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pbash.r2o.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Properties;

/**
 *
 * @author bash
 */
public class ConfigFileLoader {

    private Properties Props;
    String fileName;
    String fpath = "src\\META-INF\\";

    public ConfigFileLoader(String fileName) {
        try {
            this.Props = new Properties();
            this.fileName = fileName;

            this.getConfiguration();


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    

    private void getConfiguration() throws Exception {

        FileInputStream fis = null;

        File dir = new File(fpath);

        if (!dir.exists()) {
            dir.mkdir();
        }
        File confile = new File(fpath + fileName);

        if (!confile.exists()) {
            FileOutputStream out = new FileOutputStream(confile);
            getProps().setProperty("db1.url", "url");
            getProps().setProperty("db1.user", "user");
            getProps().setProperty("db1.password", "password");
            getProps().setProperty("db1.driver", "driver");
            getProps().store(out, Calendar.getInstance().getTime()+"");
            out.close();
        }else{
        fis = new FileInputStream(confile);

        getProps().load(fis);
        fis.close();
        }
    }

    public void storeConfiguration() {

        try {

            // Sauvegarde les nouvelles propriétés
            BufferedOutputStream bos = new BufferedOutputStream(
                    new FileOutputStream(fpath + fileName));
            getProps().store(bos, "Proprietes" + Calendar.getInstance().getTime());
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Properties getProps() {
        return this.Props;
    }

    public static void main(String[] args) {
        try {
            ConfigFileLoader c = new ConfigFileLoader("dbconfig.properties");
            c.getConfiguration();

            c.getProps().list(System.out);

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
