import javax.swing.JOptionPane;
import java.awt.Color;

/**
 * 回合取消處理器
 */
public class RoundCancelHandler implements ServerMessageHandler {
    @Override
    public void handle(MessageContext context) {
        String[] parts = context.getParts();
        // 回合取消通知（莊家離開）
        if (parts.length > 1) {
            JOptionPane.showMessageDialog(context.getClient(), parts[1], "回合取消", JOptionPane.WARNING_MESSAGE);
        }
        context.getGamePanel().getStatusLabel().setText("回合取消，等待新一局開始...");
        context.getGamePanel().getStatusLabel().setForeground(Color.ORANGE);
        context.getGamePanel().lockButtons();
        context.getGamePanel().setFunctionCardsEnabled(false);
        context.getGamePanel().getSkipFunctionCardButton().setVisible(false);
        context.checkStartButtonVisibility();
    }
}
