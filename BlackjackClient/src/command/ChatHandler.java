import javax.swing.JTextArea;

/**
 * 聊天訊息處理器
 */
public class ChatHandler implements ServerMessageHandler {
    @Override
    public void handle(MessageContext context) {
        String[] parts = context.getParts();
        if (parts.length > 1) {
            // 拼接所有訊息部分，避免 | 符號導致訊息被截斷
            StringBuilder message = new StringBuilder(parts[1]);
            for (int i = 2; i < parts.length; i++) {
                message.append("|").append(parts[i]);
            }
            JTextArea chatArea = context.getGamePanel().getChatArea();
            chatArea.append(message.toString() + "\n");
            chatArea.setCaretPosition(chatArea.getDocument().getLength());
        }
    }
}
