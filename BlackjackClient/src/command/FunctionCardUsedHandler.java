import javax.swing.JTextArea;

/**
 * 功能牌使用通知處理器
 */
public class FunctionCardUsedHandler implements ServerMessageHandler {
    @Override
    public void handle(MessageContext context) {
        String[] parts = context.getParts();
        // 機會牌使用通知（已在聊天室透過 MSG 顯示，此處可做額外處理）
        if (parts.length >= 4) {
            JTextArea chatArea = context.getGamePanel().getChatArea();
            chatArea.append("[機會牌] " + parts[1] + " 使用了「" + parts[2] + "」對 " + parts[3] + "\n");
            chatArea.setCaretPosition(chatArea.getDocument().getLength());
        }
    }
}
