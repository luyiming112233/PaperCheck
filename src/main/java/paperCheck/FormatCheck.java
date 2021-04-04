package paperCheck;

import config.WordConfig;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class FormatCheck {
    private String inputPath;
    private String outputPath;
    private XWPFDocument inputDoc;
    private XWPFDocument outputDoc;
    private WordConfig wordConfig;

    public FormatCheck(String input, String output, WordConfig wordConfig) throws IOException {
        this.inputPath = input;
        this.outputPath = output;
        this.wordConfig = wordConfig;
        this.inputDoc = new XWPFDocument(new FileInputStream(input));
        this.outputDoc = new XWPFDocument();
    }

    public void process() {
        // 实际处理逻辑,以下是段落输出实例
        List<XWPFParagraph> paragraphs = inputDoc.getParagraphs();
        for (XWPFParagraph item: paragraphs) {
            System.out.println(item.getText());
        }
    }
}
