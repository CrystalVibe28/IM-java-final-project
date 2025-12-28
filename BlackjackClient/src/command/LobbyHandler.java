/**
 * 返回大廳處理器
 */
public class LobbyHandler implements ServerMessageHandler {
    @Override
    public void handle(MessageContext context) {
        context.setPveMode(false);
        context.showPanel("LOBBY");
        context.getGamePanel().clearFunctionCards();
    }
}
