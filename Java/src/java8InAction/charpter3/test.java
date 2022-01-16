package java8InAction.charpter3;

import java8InAction.charpter3.interfaces.BufferedReaderProcessor;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws IOException {
        var in=new Scanner(System.in);
        System.out.printf("please enter a file name:");
        var fileName=in.nextLine();
        in.close();
        var message=processFile(br->br.readLine()+"\n"+br.readLine(),fileName);
        System.out.println(message);

    }
    public static String processFile(BufferedReaderProcessor processor,String fileName) throws IOException {
        try(BufferedReader file=new BufferedReader(new FileReader(("D:\\myFile\\Java\\src\\java8InAction\\charpter3\\"+fileName)))) {
            return processor.process(file);//one already known problem: filename has to be completed;
        }

    }
}
