/**
 * 使用功能牌命令 - 處理功能牌使用
 */
public class UseFunctionCardCommand implements Command {
    @Override
    public void execute(CommandContext context) {
        String[] parts = context.getParts();
        GameRoom currentRoom = context.getCurrentRoom();

        if (currentRoom != null && parts.length > 2) {
            try {
                int cardId = Integer.parseInt(parts[1]);
                String targetUid = parts[2];
                currentRoom.handleUseFunctionCard(context.getHandler(), cardId, targetUid);
            } catch (NumberFormatException e) {
                context.send(Protocol.ERROR + Protocol.DELIMITER + "無效的功能牌 ID");
            }
        }
    }
}
