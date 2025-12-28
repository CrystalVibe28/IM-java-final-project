import java.io.*;
import java.net.Socket;
import java.util.Map;

/**
 * 客戶端處理器 - 處理單一客戶端連線
 * 使用 Command Pattern 處理客戶端命令
 */
public class ClientHandler implements Runnable {
    private final Socket socket;
    private final Map<String, GameRoom> rooms;
    private final CommandRegistry commandRegistry;

    private PrintWriter out;
    private BufferedReader in;
    private String uid;
    private String name;
    private GameRoom currentRoom;

    public ClientHandler(Socket socket, Map<String, GameRoom> rooms) {
        this.socket = socket;
        this.rooms = rooms;
        this.commandRegistry = new CommandRegistry();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public GameRoom getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(GameRoom room) {
        this.currentRoom = room;
    }

    @Override
    public void run() {
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String input;
            while ((input = in.readLine()) != null) {
                processCommand(input);
            }
        } catch (IOException e) {
            System.out.println((name != null ? name : "Unknown") + " 斷線");
        } finally {
            cleanup();
        }
    }

    /**
     * 處理客戶端命令 - 使用 Command Pattern
     */
    private void processCommand(String cmd) {
        String[] parts = cmd.split("\\|");
        String action = parts[0];

        Command command = commandRegistry.getCommand(action);
        if (command != null) {
            CommandContext context = new CommandContext(this, parts, rooms);
            command.execute(context);
        }
    }

    /**
     * 離開房間並清理資源
     */
    private void leaveRoom() {
        if (currentRoom != null) {
            currentRoom.removePlayer(this);
            if (currentRoom.isEmpty() && currentRoom.getRoomId() != null) {
                rooms.remove(currentRoom.getRoomId());
            }
            currentRoom = null;
        }
        send(Protocol.LOBBY);
    }

    /**
     * 清理連線資源
     */
    private void cleanup() {
        leaveRoom();
        try {
            socket.close();
        } catch (IOException e) {
            // ignore
        }
    }

    /**
     * 發送訊息給客戶端
     */
    public void send(String message) {
        if (out != null) {
            out.println(message);
        }
    }
}
