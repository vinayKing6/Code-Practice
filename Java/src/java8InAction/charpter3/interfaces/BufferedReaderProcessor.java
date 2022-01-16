package java8InAction.charpter3.interfaces;

import java.io.BufferedReader;
import java.io.IOException;

public interface BufferedReaderProcessor {
    public String process(BufferedReader br) throws IOException;
}
