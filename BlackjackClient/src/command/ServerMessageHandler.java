/**
 * 伺服器訊息處理器介面 - 定義所有訊息處理器的共同行為
 */
public interface ServerMessageHandler {
    /**
     * 處理伺服器訊息
     * 
     * @param context 訊息處理上下文
     */
    void handle(MessageContext context);
}
