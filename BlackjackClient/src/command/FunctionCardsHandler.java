/**
 * 功能牌列表處理器
 */
public class FunctionCardsHandler implements ServerMessageHandler {
    @Override
    public void handle(MessageContext context) {
        String[] parts = context.getParts();
        // 更新機會牌 UI
        context.updateFunctionCards(parts.length > 1 ? parts[1] : "");
    }
}
