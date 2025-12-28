import java.util.Map;

/**
 * 加入房間命令 - 加入現有遊戲房間
 */
public class JoinRoomCommand implements Command {
    @Override
    public void execute(CommandContext context) {
        String[] parts = context.getParts();
        if (parts.length <= 1) {
            return;
        }

        String roomId = parts[1];
        ClientHandler handler = context.getHandler();
        Map<String, GameRoom> rooms = context.getRooms();
        GameRoom room = rooms.get(roomId);

        if (room == null) {
            handler.send(Protocol.ERROR + Protocol.DELIMITER + "房間不存在");
            return;
        }

        if (room.isFull()) {
            handler.send(Protocol.ERROR + Protocol.DELIMITER + "房間已滿");
            return;
        }

        if (room.hasPlayer(handler.getName())) {
            handler.send(Protocol.ERROR + Protocol.DELIMITER + "房間內已有相同名字的玩家");
            return;
        }

        room.addPlayer(handler);
        handler.setCurrentRoom(room);
        handler.send(Protocol.ROOM_JOINED + Protocol.DELIMITER + roomId);
    }
}
