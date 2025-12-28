/**
 * 登入成功處理器
 */
public class LoginOkHandler implements ServerMessageHandler {
    @Override
    public void handle(MessageContext context) {
        context.showPanel("LOBBY");
    }
}
