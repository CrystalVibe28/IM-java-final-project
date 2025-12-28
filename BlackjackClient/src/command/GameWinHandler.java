import javax.swing.JOptionPane;
import java.awt.Color;

/**
 * 遊戲勝利處理器
 */
public class GameWinHandler implements ServerMessageHandler {
    @Override
    public void handle(MessageContext context) {
        String[] parts = context.getParts();
        // 遊戲勝利通知
        if (parts.length > 1) {
            String winnerName = parts[1];
            String winMessage;
            if (winnerName.equals(context.getPlayerName())) {
                winMessage = "🎉 恭喜！你是最後的贏家！";
            } else {
                winMessage = "🏆 遊戲結束！\n贏家是：" + winnerName;
            }
            JOptionPane.showMessageDialog(context.getClient(), winMessage, "遊戲勝利", JOptionPane.INFORMATION_MESSAGE);
            context.getGamePanel().getStatusLabel().setText("遊戲結束，等待新一局開始...");
            context.getGamePanel().getStatusLabel().setForeground(Color.CYAN);
            context.checkStartButtonVisibility();
        }
    }
}
