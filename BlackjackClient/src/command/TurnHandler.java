import java.awt.Color;

/**
 * 輪次通知處理器
 */
public class TurnHandler implements ServerMessageHandler {
    @Override
    public void handle(MessageContext context) {
        String[] parts = context.getParts();
        if ("YOUR".equals(parts[1])) {
            context.getGamePanel().getStatusLabel()
                    .setText("輪到你了！ (目前點數: " + context.getGamePanel().getPlayerScoreStr() + ")");
            context.getGamePanel().getStatusLabel().setForeground(Color.GREEN);
            context.getGamePanel().unlockButtons();
        } else {
            context.getGamePanel().getStatusLabel().setText("等待其他玩家...");
            context.getGamePanel().getStatusLabel().setForeground(Color.YELLOW);
            context.getGamePanel().lockButtons();
        }
        // 遊戲進行中禁用機會牌
        context.getGamePanel().setFunctionCardsEnabled(false);
    }
}
