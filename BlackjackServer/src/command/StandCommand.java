/**
 * 停牌命令 - 處理 STAND 動作
 */
public class StandCommand implements Command {
    @Override
    public void execute(CommandContext context) {
        GameRoom currentRoom = context.getCurrentRoom();
        if (currentRoom != null) {
            currentRoom.handleGameAction(context.getHandler(), Protocol.STAND);
        }
    }
}
