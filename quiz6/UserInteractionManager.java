package quiz6;

public class UserInteractionManager {
    private CommunicationManager communicationManager;

    public UserInteractionManager(CommunicationManager communicationManager) {
        this.communicationManager = communicationManager;
    }

    public void interactWithUser(String currentMessage, String[][] chatHistory) {
        String jsonRequest = createJson(currentMessage, chatHistory);
        String response = communicationManager.sendMessage(jsonRequest);
        System.out.println("Response from chatbot: " + response);
    }

    private String createJson(String currentMessage, String[][] chatHistory) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");
        jsonBuilder.append("\"currentMessage\": \"").append(currentMessage).append("\",");
        jsonBuilder.append("\"chatHistory\": [");

        for (int i = 0; i < chatHistory.length; i++) {
            jsonBuilder.append("{");
            jsonBuilder.append("\"role\": \"").append(chatHistory[i][0]).append("\",");
            jsonBuilder.append("\"message\": \"").append(chatHistory[i][1]).append("\"");
            jsonBuilder.append("}");
            if (i < chatHistory.length - 1) {
                jsonBuilder.append(",");
            }
        }

        jsonBuilder.append("]");
        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }
}
