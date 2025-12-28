import javax.swing.*;

/**
 * 訊息處理器 - 處理伺服器訊息並更新 UI
 * 使用 Command Pattern 處理伺服器訊息
 */
public class MessageHandler {
    private final BlackjackClient client;
    private final MessageHandlerRegistry handlerRegistry;

    public MessageHandler(BlackjackClient client) {
        this.client = client;
        this.handlerRegistry = new MessageHandlerRegistry();
    }

    /**
     * 處理伺服器訊息 - 使用 Command Pattern
     */
    public void handleMessage(String msg) {
        String[] parts = msg.split("\\|");
        String cmd = parts[0];

        SwingUtilities.invokeLater(() -> {
            ServerMessageHandler handler = handlerRegistry.getHandler(cmd);
            if (handler != null) {
                MessageContext context = new MessageContext(client, parts);
                handler.handle(context);
            }
        });
    }

    /**
     * 連線中斷時呼叫
     */
    public void onDisconnected() {
        SwingUtilities.invokeLater(() -> {
            JOptionPane.showMessageDialog(client, "與伺服器斷線");
            System.exit(0);
        });
    }
}
