/**
 * 加入房間成功處理器
 */
public class RoomJoinedHandler implements ServerMessageHandler {
    @Override
    public void handle(MessageContext context) {
        String[] parts = context.getParts();
        context.getGamePanel().getStatusLabel().setText("等待房主開始...");
        context.getGamePanel().getRoomIdLabel().setText("房號: " + parts[1]);
        context.showPanel("GAME");
        context.getGamePanel().resetUI();
        context.getGamePanel().getStartGameButton().setVisible(false);
    }
}
