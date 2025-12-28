/**
 * 跳過功能牌命令 - 跳過使用功能牌
 */
public class SkipFunctionCardCommand implements Command {
    @Override
    public void execute(CommandContext context) {
        GameRoom currentRoom = context.getCurrentRoom();
        if (currentRoom != null) {
            currentRoom.handleSkipFunctionCard(context.getHandler());
        }
    }
}
