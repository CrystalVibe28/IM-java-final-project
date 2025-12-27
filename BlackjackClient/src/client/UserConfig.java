import java.io.*;
import java.nio.file.*;
import java.util.UUID;

/**
 * 用戶配置管理 - 負責本地儲存和載入用戶配置
 * 儲存內容：uid（用戶識別碼）、name（暱稱）、serverIp（伺服器IP）
 */
public class UserConfig {
    private static final String CONFIG_FILE = "user_config.txt";
    private static final String DELIMITER = "|";
    
    private String uid;
    private String name;
    private String serverIp;
    
    /**
     * 建構子 - 自動載入配置或生成新的 UID
     */
    public UserConfig() {
        loadConfig();
    }
    
    /**
     * 從本地檔案載入配置
     * 若檔案不存在或格式錯誤，則生成新的 UID
     */
    private void loadConfig() {
        try {
            Path path = Paths.get(CONFIG_FILE);
            if (Files.exists(path)) {
                String content = Files.readString(path);
                String[] parts = content.split("\\" + DELIMITER);
                
                if (parts.length >= 3) {
                    this.uid = parts[0];
                    this.name = parts[1];
                    this.serverIp = parts[2];
                    System.out.println("載入配置成功 - Name: " + name + ", IP: " + serverIp);
                    return;
                }
            }
        } catch (IOException e) {
            System.out.println("無法載入配置檔案，將建立新配置");
        }
        
        // 若載入失敗，生成新的 UID
        this.uid = UUID.randomUUID().toString();
        this.name = "";
        this.serverIp = "127.0.0.1";
        System.out.println("生成新的 UID: " + uid);
    }
    
    /**
     * 儲存配置到本地檔案
     */
    public void saveConfig() {
        try {
            String content = uid + DELIMITER + name + DELIMITER + serverIp;
            Files.writeString(Paths.get(CONFIG_FILE), content);
            System.out.println("配置已儲存");
        } catch (IOException e) {
            System.err.println("無法儲存配置檔案: " + e.getMessage());
        }
    }
    
    // Getter 方法
    public String getUid() {
        return uid;
    }
    
    public String getName() {
        return name;
    }
    
    public String getServerIp() {
        return serverIp;
    }
    
    // Setter 方法
    public void setName(String name) {
        this.name = name;
    }
    
    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }
}
