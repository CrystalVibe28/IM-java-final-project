/**
 * 系統訊息處理器
 */
public class MsgHandler implements ServerMessageHandler {
    @Override
    public void handle(MessageContext context) {
        String[] parts = context.getParts();
        context.getGamePanel().getStatusLabel().setText(parts[1]);
    }
}
