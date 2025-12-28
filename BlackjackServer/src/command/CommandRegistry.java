import java.util.HashMap;
import java.util.Map;

/**
 * 命令註冊表 - 管理所有命令的註冊與取得
 */
public class CommandRegistry {
    private final Map<String, Command> commands = new HashMap<>();

    /**
     * 建立命令註冊表並註冊所有命令
     */
    public CommandRegistry() {
        registerCommands();
    }

    /**
     * 註冊所有命令
     */
    private void registerCommands() {
        // 登入相關
        register(Protocol.LOGIN, new LoginCommand());

        // 遊戲模式
        register(Protocol.PVE_START, new PveStartCommand());

        // 房間操作
        register(Protocol.CREATE_ROOM, new CreateRoomCommand());
        register(Protocol.JOIN_ROOM, new JoinRoomCommand());
        register(Protocol.LEAVE, new LeaveCommand());

        // 遊戲操作
        register(Protocol.START, new StartGameCommand());
        register(Protocol.READY, new ReadyCommand());
        register(Protocol.HIT, new HitCommand());
        register(Protocol.STAND, new StandCommand());

        // 聊天
        register(Protocol.CHAT, new ChatCommand());

        // 功能牌
        register(Protocol.USE_FUNCTION_CARD, new UseFunctionCardCommand());
        register(Protocol.SKIP_FUNCTION_CARD, new SkipFunctionCardCommand());
    }

    /**
     * 註冊命令
     */
    public void register(String commandName, Command command) {
        commands.put(commandName, command);
    }

    /**
     * 取得命令
     * 
     * @return 對應的命令，若不存在則返回 null
     */
    public Command getCommand(String commandName) {
        return commands.get(commandName);
    }

    /**
     * 檢查命令是否存在
     */
    public boolean hasCommand(String commandName) {
        return commands.containsKey(commandName);
    }
}
