/**
 * PVE 模式開始處理器
 */
public class PveStartedHandler implements ServerMessageHandler {
    @Override
    public void handle(MessageContext context) {
        context.setPveMode(true);
        context.getGamePanel().getStatusLabel().setText("單人練習模式");
        context.getGamePanel().getRoomIdLabel().setText("PVE Mode");
        context.showPanel("GAME");
        context.getGamePanel().resetUI();
        context.getGamePanel().getStartGameButton().setVisible(false);
    }
}
