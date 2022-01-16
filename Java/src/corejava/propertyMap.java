package corejava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class propertyMap {
    public static void main(String[] args) throws IOException {
        var out=new FileOutputStream("program.properties");
        var settings=new Properties();
        settings.setProperty("width","600.0");
        settings.setProperty("filename","../HTML/myWebPages/introduction.html");
        settings.store(out,"Program Properties");
        var in=new FileInputStream("program.properties");
        settings.load(in);
        System.out.println(settings);
        System.out.println(System.getProperties());//get the information of the local system
    }
}
