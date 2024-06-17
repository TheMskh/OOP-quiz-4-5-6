package quizz5;

public class DummyCommunicationManager implements CommunicationManager {
    @Override
    public String sendMessage(String jsonRequest) {
        // Simulate a response from a chatbot service
        return "This is a dummy response from the chatbot service.";
    }
}
