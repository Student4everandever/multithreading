package Sample7;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Alex on 29.03.2019
 */
public class Writer extends Thread {
    private final Document doc;
    private final String path;

    public Writer(Document doc, String path) {
        this.doc = doc;
        this.path = path;
    }

    @Override
    public void run() {

        synchronized (doc) {
            while(!doc.isready()) {
                try {
                    doc.wait();
                } catch (InterruptedException e) {
                    return;
                }
            }
        }

        System.out.println("Writing document to " + path);

        try(FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(doc.getData());
            System.out.println("Done: " + path);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
