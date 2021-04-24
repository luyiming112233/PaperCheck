package config;

public class WordConfig {
    private String dirTitleFontSize;
    private String dirTitleFontNAme;
    private String dirTitleIsBold;

    public WordConfig() {
    }


    @Override
    public String toString() {
        return "WordConfig [dirTitleFontNAme=" + dirTitleFontNAme + ", dirTitleFontSize=" + dirTitleFontSize + ", dirTitleIsBold=" + dirTitleIsBold + "]";
    }

    public String getDirTitleFontSize() {
        return dirTitleFontSize;
    }

    public void setDirTitleFontSize(String dirTitleFontSize) {
        this.dirTitleFontSize = dirTitleFontSize;
    }

    public String getDirTitleFontNAme() {
        return dirTitleFontNAme;
    }

    public void setDirTitleFontNAme(String dirTitleFontNAme) {
        this.dirTitleFontNAme = dirTitleFontNAme;
    }

    public String getDirTitleIsBold() {
        return dirTitleIsBold;
    }

    public void setDirTitleIsBold(String dirTitleIsBold) {
        this.dirTitleIsBold = dirTitleIsBold;
    }
}
