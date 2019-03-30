package Sample7;

/**
 * Created by Alex on 29.03.2019
 */
public class Document {
    private volatile byte[] data;

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public boolean isready() {
        return data != null;
    }
}
