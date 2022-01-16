package java8InAction.charpter8;

import myToolKit.BufferedReaderProcessor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class code_08_01 {
    public static void main(String[] args) throws IOException {
        var input=new Scanner(System.in);
        String path=input.nextLine();
        String lines=textProcess(path, BufferedReader::readLine);
        System.out.println(lines);
    }

    public static String textProcess(String path, BufferedReaderProcessor processor) throws IOException
    {
        try(BufferedReader br=new BufferedReader(new FileReader(path)))
        {
            return processor.process(br);
        }
    }
}
