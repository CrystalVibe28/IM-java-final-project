/**
 * 準備命令 - 處理玩家準備確認
 */
public class ReadyCommand implements Command {
    @Override
    public void execute(CommandContext context) {
        GameRoom currentRoom = context.getCurrentRoom();
        if (currentRoom != null) {
            currentRoom.handlePlayerReady(context.getHandler());
        }
    }
}
