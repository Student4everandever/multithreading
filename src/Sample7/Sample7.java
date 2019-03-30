package Sample7;

/**
 * Created by Alex on 29.03.2019
 */
public class Sample7 {
    static final String URL = "https://www.dropbox.com";

    public static void main(String[] args) throws InterruptedException {
        Document doc = new Document();

        Writer [] writers = {
                new Writer(doc, "file1.pdf"),
                new Writer(doc, "file2.pdf"),
                new Writer(doc, "file3.pdf"),
        };

        for(Writer writer : writers) {
            writer.start();
        }

        Downloader dl = new Downloader(URL, doc);
        dl.start();
    }
}
