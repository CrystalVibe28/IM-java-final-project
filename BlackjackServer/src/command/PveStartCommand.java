/**
 * PVE 開始命令 - 開始單人練習模式
 */
public class PveStartCommand implements Command {
    @Override
    public void execute(CommandContext context) {
        ClientHandler handler = context.getHandler();

        handler.send(Protocol.PVE_STARTED);
        GameRoom room = new GameRoom(handler, null);
        handler.setCurrentRoom(room);
        room.startGame();
    }
}
