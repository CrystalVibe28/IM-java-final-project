import java.util.HashMap;
import java.util.Map;

/**
 * 訊息處理器註冊表 - 管理所有訊息處理器的註冊與取得
 */
public class MessageHandlerRegistry {
    private final Map<String, ServerMessageHandler> handlers = new HashMap<>();

    /**
     * 建立訊息處理器註冊表並註冊所有處理器
     */
    public MessageHandlerRegistry() {
        registerHandlers();
    }

    /**
     * 註冊所有訊息處理器
     */
    private void registerHandlers() {
        // 連線相關
        register(Protocol.LOGIN_OK, new LoginOkHandler());
        register(Protocol.LOBBY, new LobbyHandler());
        register(Protocol.ERROR, new ErrorHandler());

        // 遊戲模式與房間
        register(Protocol.PVE_STARTED, new PveStartedHandler());
        register(Protocol.ROOM_CREATED, new RoomCreatedHandler());
        register(Protocol.ROOM_JOINED, new RoomJoinedHandler());

        // 遊戲狀態
        register(Protocol.STATE, new StateHandler());
        register(Protocol.TURN, new TurnHandler());
        register(Protocol.GAME_OVER, new GameOverHandler());
        register(Protocol.HP_UPDATE, new HpUpdateHandler());
        register(Protocol.GAME_WIN, new GameWinHandler());
        register(Protocol.ROUND_CANCEL, new RoundCancelHandler());

        // 聊天與訊息
        register(Protocol.CHAT, new ChatHandler());
        register(Protocol.MSG, new MsgHandler());

        // 功能牌
        register(Protocol.FUNCTION_CARDS, new FunctionCardsHandler());
        register(Protocol.FUNCTION_CARD_USED, new FunctionCardUsedHandler());
        register(Protocol.FUNCTION_CARD_PHASE, new FunctionCardPhaseHandler());
        register(Protocol.FUNCTION_CARD_PHASE_END, new FunctionCardPhaseEndHandler());
    }

    /**
     * 註冊訊息處理器
     */
    public void register(String messageName, ServerMessageHandler handler) {
        handlers.put(messageName, handler);
    }

    /**
     * 取得訊息處理器
     * 
     * @return 對應的處理器，若不存在則返回 null
     */
    public ServerMessageHandler getHandler(String messageName) {
        return handlers.get(messageName);
    }

    /**
     * 檢查處理器是否存在
     */
    public boolean hasHandler(String messageName) {
        return handlers.containsKey(messageName);
    }
}
