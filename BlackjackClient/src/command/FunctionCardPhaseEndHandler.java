/**
 * 功能牌階段結束處理器
 */
public class FunctionCardPhaseEndHandler implements ServerMessageHandler {
    @Override
    public void handle(MessageContext context) {
        // 機會卡階段結束
        context.getGamePanel().getSkipFunctionCardButton().setVisible(false);
        context.getGamePanel().setFunctionCardsEnabled(false);
    }
}
