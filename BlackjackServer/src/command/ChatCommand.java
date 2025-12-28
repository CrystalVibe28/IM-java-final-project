/**
 * 聊天命令 - 處理聊天訊息
 */
public class ChatCommand implements Command {
    @Override
    public void execute(CommandContext context) {
        String[] parts = context.getParts();
        GameRoom currentRoom = context.getCurrentRoom();

        if (currentRoom != null && parts.length > 1) {
            // 拼接所有訊息部分，避免 | 符號導致訊息被截斷
            StringBuilder message = new StringBuilder(parts[1]);
            for (int i = 2; i < parts.length; i++) {
                message.append("|").append(parts[i]);
            }
            currentRoom.broadcastChat(context.getClientName(), message.toString());
        }
    }
}
