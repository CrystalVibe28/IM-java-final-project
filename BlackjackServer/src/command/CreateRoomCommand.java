import java.util.Map;

/**
 * 創建房間命令 - 創建新的遊戲房間
 */
public class CreateRoomCommand implements Command {
    @Override
    public void execute(CommandContext context) {
        ClientHandler handler = context.getHandler();
        Map<String, GameRoom> rooms = context.getRooms();

        String roomId = generateRoomId(rooms);
        GameRoom room = new GameRoom(handler, roomId);
        rooms.put(roomId, room);
        handler.setCurrentRoom(room);
        handler.send(Protocol.ROOM_CREATED + Protocol.DELIMITER + roomId);
    }

    /**
     * 生成不重複的房間 ID
     */
    private String generateRoomId(Map<String, GameRoom> rooms) {
        String roomId;
        do {
            roomId = String.valueOf((int) (Math.random() * 9000) + 1000);
        } while (rooms.containsKey(roomId));
        return roomId;
    }
}
