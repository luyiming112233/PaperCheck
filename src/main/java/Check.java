import config.*;
import paperCheck.FormatCheck;

public class Check {
    public static void main(String[] args) throws Exception {
        // 读取配置文件
        WordConfig wordConfig = ConfigReader.getWordConfig("src/main/resources/config.xml");
        System.out.println("Config"+ wordConfig.toString());
        // 执行word文件格式检查,支持docx文件格式
        FormatCheck check = new FormatCheck("src/main/resources/test.docx", "src/main/resources/res.docx", wordConfig);
        check.process();
        System.out.println("paper check finish!");
    }
}