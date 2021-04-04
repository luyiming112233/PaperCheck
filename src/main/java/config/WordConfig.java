package config;

public class WordConfig {
    private String k1;
    private String k2;

    public WordConfig() {
    }


    @Override
    public String toString() {
        return "WordConfig [k1=" + k1 + ", k2=" + k2 + "]";
    }

    public String getK1() {
        return k1;
    }

    public void setK1(String k1) {
        this.k1 = k1;
    }

    public String getK2() {
        return k2;
    }

    public void setK2(String k2) {
        this.k2 = k2;
    }
}
