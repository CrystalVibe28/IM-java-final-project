import java.util.Map;

/**
 * 離開房間命令 - 離開當前房間
 */
public class LeaveCommand implements Command {
    @Override
    public void execute(CommandContext context) {
        ClientHandler handler = context.getHandler();
        GameRoom currentRoom = handler.getCurrentRoom();
        Map<String, GameRoom> rooms = context.getRooms();

        if (currentRoom != null) {
            currentRoom.removePlayer(handler);
            if (currentRoom.isEmpty() && currentRoom.getRoomId() != null) {
                rooms.remove(currentRoom.getRoomId());
            }
            handler.setCurrentRoom(null);
        }
        handler.send(Protocol.LOBBY);
    }
}
