/**
 * HP 更新處理器
 */
public class HpUpdateHandler implements ServerMessageHandler {
    @Override
    public void handle(MessageContext context) {
        String[] parts = context.getParts();
        context.getGamePanel().updatePlayerList(parts[1], context.getPlayerName());
        context.checkStartButtonVisibility();
    }
}
