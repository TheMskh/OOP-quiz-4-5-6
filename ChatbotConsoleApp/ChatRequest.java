import java.util.List;

public class ChatRequest {
    private List<ChatMessage> messages;

    public ChatRequest(List<ChatMessage> messages) {
        this.messages = messages;
    }

    public List<ChatMessage> getMessages() {
        return messages;
    }
}
