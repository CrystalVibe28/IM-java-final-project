/**
 * 遊戲狀態更新處理器
 */
public class StateHandler implements ServerMessageHandler {
    @Override
    public void handle(MessageContext context) {
        String[] parts = context.getParts();
        if (parts.length >= 5) {
            context.getGamePanel().updateGameTable(parts[2], parts[3]);
            context.getGamePanel().updatePlayerList(parts[4], context.getPlayerName());
        }
        context.getGamePanel().getStartGameButton().setVisible(false);
        // 遊戲進行中禁用機會牌
        context.getGamePanel().setFunctionCardsEnabled(false);
    }
}
