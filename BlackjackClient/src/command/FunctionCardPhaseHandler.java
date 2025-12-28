import java.awt.Color;

/**
 * 功能牌階段處理器
 */
public class FunctionCardPhaseHandler implements ServerMessageHandler {
    @Override
    public void handle(MessageContext context) {
        String[] parts = context.getParts();
        // 機會卡階段輪次通知
        if (parts.length > 1 && "YOUR".equals(parts[1])) {
            // 輪到自己選擇機會牌
            context.getGamePanel().getStatusLabel().setText("選擇使用機會牌或點「不使用機會牌」");
            context.getGamePanel().getStatusLabel().setForeground(Color.ORANGE);
            context.getGamePanel().setFunctionCardsEnabled(true);
            context.getGamePanel().getSkipFunctionCardButton().setVisible(true);
        } else {
            // 等待其他玩家
            context.getGamePanel().setFunctionCardsEnabled(false);
            context.getGamePanel().getSkipFunctionCardButton().setVisible(false);
        }
    }
}
