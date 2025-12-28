/**
 * 要牌命令 - 處理 HIT 動作
 */
public class HitCommand implements Command {
    @Override
    public void execute(CommandContext context) {
        GameRoom currentRoom = context.getCurrentRoom();
        if (currentRoom != null) {
            currentRoom.handleGameAction(context.getHandler(), Protocol.HIT);
        }
    }
}
