package quizz5;

public class Main {
    public static void main(String[] args) {
        CommunicationManager dummyManager = new DummyCommunicationManager();
        UserInteractionManager userManager = new UserInteractionManager(dummyManager);

        // Example chat history
        String[][] chatHistory = {
                {"User", "Hello, chatbot!"},
                {"Chatbot", "Hello! How can I assist you today?"},
                {"User", "Can you tell me a joke?"},
                {"Chatbot", "Why don't scientists trust atoms? Because they make up everything!"}
        };

        // Current user message
        String currentMessage = "What's the weather like today?";

        userManager.interactWithUser(currentMessage, chatHistory);
    }
}
