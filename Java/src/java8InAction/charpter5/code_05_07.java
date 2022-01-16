package java8InAction.charpter5;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Stream;

public class code_05_07 {
    public static void main(String[] args) {
        //create Stream
        Stream<String> stringStream=Stream.of("Vinay","king","jack","marry");
        stringStream.map(String::toUpperCase).forEach(System.out::println);
        Stream<String> emptyStream=Stream.empty();//create an empty stream
        //create an int Stream
        int[] nums={1,4,2,66,7};
        int sum= Arrays.stream(nums).sum();
        System.out.println(sum);

        //create a file stream
        try(Stream<String> lines= Files
                .lines(Paths.get("D:\\myFile\\Java\\src\\java8InAction\\charpter5\\code_05_07.txt")
                        , Charset.defaultCharset())){
            lines.flatMap(line->Arrays.stream(line.split(" "))).map(w->w.toLowerCase(Locale.ROOT))
                    .map(w->w.split("")).flatMap(Arrays::stream).distinct().forEach(System.out::print);
        }catch (IOException e){
            System.out.println("can't find the file!");
        }
        System.out.println();

        //iterate
        Stream.iterate(new int[]{0,1},a->new int[]{a[1],a[1]+a[0]}).limit(20).forEach(a->System.out.print(a[0]+" "));
    }
}
