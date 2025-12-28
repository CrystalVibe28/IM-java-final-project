import javax.swing.JOptionPane;
import java.awt.Color;

/**
 * 回合結束處理器
 */
public class GameOverHandler implements ServerMessageHandler {
    @Override
    public void handle(MessageContext context) {
        String[] parts = context.getParts();
        context.getGamePanel().updateGameTable(parts[1], parts[2]);
        String result = parts[3].replace("\\n", "\n");
        JOptionPane.showMessageDialog(context.getClient(), result, "回合結果", JOptionPane.INFORMATION_MESSAGE);
        context.getNetworkClient().send(Protocol.READY);
        context.getGamePanel().getStatusLabel().setText("等待其他玩家確認...");
        context.getGamePanel().getStatusLabel().setForeground(Color.WHITE);
        context.getGamePanel().lockButtons();
        context.checkStartButtonVisibility();
        // 回合結束，禁用機會牌（等待進入機會牌階段時才啟用）
        context.getGamePanel().setFunctionCardsEnabled(false);
    }
}
