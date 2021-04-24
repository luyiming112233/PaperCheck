package paperCheck;

import config.WordConfig;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

// 目录标题，仿宋体（英文为Times New Roman)小二号加粗，单倍行距。
// 各章节目录：仿宋体小四号，单倍行距，两端对齐，页码右对齐

public class FormatCheck {
    private String inputPath;
    private String outputPath;

    private XWPFDocument inputDoc;
    private XWPFDocument outputDoc;
    private WordConfig wordConfig;

    public FormatCheck(String inputPath, String outputPath, WordConfig wordConfig) throws IOException {
        this.inputPath = inputPath;
        this.outputPath = outputPath;
        this.wordConfig = wordConfig;

        this.inputDoc = new XWPFDocument(new FileInputStream(inputPath));
    }

    public void process() {
        // 实际处理逻辑,以下是段落输出实例
        processDirTitle();
    }

    public void processDirTitle() {
        List<XWPFParagraph> paragraphs = inputDoc.getParagraphs();

        for (XWPFParagraph paragraph : paragraphs) {
            XWPFRun r1 = paragraph.createRun();
            r1.setColor("FF0000");

            if (paragraph.getText().equals("目录") || paragraph.getText().equals("图目录") || paragraph.getText().equals("表目录")) {
                System.out.println(paragraph.getText());

                List<XWPFRun> runs = paragraph.getRuns();
                for (XWPFRun run : runs) {
                    int fontSize = run.getFontSize();
                    String fontName = run.getFontName();
                    boolean isBold = run.isBold();
                    boolean flag = false;

                    if (fontSize != -1 && fontSize != Integer.valueOf(wordConfig.getDirTitleFontSize())) {
                        r1.setText("字体大小错误：正确为小二，实际为:" + fontSize + "\t");
                        flag = true;
                    }
                    if (fontName != null && !fontName.equals(wordConfig.getDirTitleFontNAme())) {
                        r1.setText("字体错误：正确为仿宋，实际为：" + fontName + "\t");
                        flag = true;
                    }

                    if (fontName != null && (isBold == Boolean.getBoolean(wordConfig.getDirTitleIsBold()))) {
                        r1.setText("未加粗 \t");
                        flag = true;
                    }

                    System.out.println(fontName);
                    System.out.println(fontSize);
                    if (flag) {
                        break;
                    }
                }
            }

        }
    }

    public void writeOutPutDoc() {
        try {
            FileOutputStream out = new FileOutputStream(outputPath);
            inputDoc.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
