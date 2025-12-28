/**
 * 命令介面 - 定義所有命令的共同行為
 */
public interface Command {
    /**
     * 執行命令
     * 
     * @param context 命令執行上下文
     */
    void execute(CommandContext context);
}
