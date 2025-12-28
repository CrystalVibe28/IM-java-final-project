/**
 * 開始遊戲命令 - 嘗試開始遊戲（莊家限定）
 */
public class StartGameCommand implements Command {
    @Override
    public void execute(CommandContext context) {
        GameRoom currentRoom = context.getCurrentRoom();
        if (currentRoom != null) {
            currentRoom.tryStartGame(context.getHandler());
        }
    }
}
