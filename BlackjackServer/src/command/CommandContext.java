import java.util.Map;

/**
 * 命令執行上下文 - 封裝命令執行所需的資訊
 */
public class CommandContext {
    private final ClientHandler handler;
    private final String[] parts;
    private final Map<String, GameRoom> rooms;

    public CommandContext(ClientHandler handler, String[] parts, Map<String, GameRoom> rooms) {
        this.handler = handler;
        this.parts = parts;
        this.rooms = rooms;
    }

    /**
     * 取得客戶端處理器
     */
    public ClientHandler getHandler() {
        return handler;
    }

    /**
     * 取得解析後的命令參數
     */
    public String[] getParts() {
        return parts;
    }

    /**
     * 取得房間列表
     */
    public Map<String, GameRoom> getRooms() {
        return rooms;
    }

    /**
     * 取得指定索引的參數（若不存在則返回 null）
     */
    public String getParam(int index) {
        if (parts != null && index >= 0 && index < parts.length) {
            return parts[index];
        }
        return null;
    }

    /**
     * 取得參數數量
     */
    public int getParamCount() {
        return parts != null ? parts.length : 0;
    }

    /**
     * 向客戶端發送訊息
     */
    public void send(String message) {
        handler.send(message);
    }

    /**
     * 取得客戶端名稱
     */
    public String getClientName() {
        return handler.getName();
    }

    /**
     * 取得客戶端 UID
     */
    public String getClientUid() {
        return handler.getUid();
    }

    /**
     * 取得當前房間
     */
    public GameRoom getCurrentRoom() {
        return handler.getCurrentRoom();
    }

    /**
     * 設定當前房間
     */
    public void setCurrentRoom(GameRoom room) {
        handler.setCurrentRoom(room);
    }
}
