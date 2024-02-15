import java.util.Random;
import java.util.Scanner;

public class Conversation {

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("How many rounds?");
        int rounds = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Hi there! What's on your mind?");
        StringBuilder transcript = new StringBuilder();

        for (int i = 0; i < rounds; i++) {
            String userResponse = scanner.nextLine();
            transcript.append(userResponse).append("\n");
            StringBuilder botResponse = new StringBuilder();
            boolean mirrored = false; // Track if any pronouns are mirrored

            String[] words = userResponse.split("\\s+");
            String[] pronouns = {"I", "me", "am", "you", "my", "your"};
            boolean containsPronoun = false;
            
            // Check if any pronouns are in user response
            for (String word : words) {
                for (String pronoun : pronouns) {
                    if (word.equalsIgnoreCase(pronoun)) {
                        containsPronoun = true;
                        break;
                    }
                }
                if (containsPronoun) {
                    break;
                }
            }

            // If pronouns are found, mirror them
            if (containsPronoun) {
                for (String word : words) {
                    switch (word.toLowerCase()) {
                        case "i":
                            botResponse.append("you").append(" ");
                            mirrored = true;
                            break;
                        case "me":
                            botResponse.append("you").append(" ");
                            mirrored = true;
                            break;
                        case "am":
                            botResponse.append("are").append(" ");
                            mirrored = true;
                            break;
                        case "you":
                            botResponse.append("I").append(" ");
                            mirrored = true;
                            break;
                        case "my":
                            botResponse.append("your").append(" ");
                            mirrored = true;
                            break;
                        case "your":
                            botResponse.append("my").append(" ");
                            mirrored = true;
                            break;
                        default:
                            botResponse.append(word).append(" ");
                            break;
                    }
                }
              botResponse.append("?");
            } else {
                // If no pronouns found, generate a random response
                String[] cannedResponses = {"Mmm-hm.", "Interesting.", "Tell me more.", "I see."};
                botResponse.append(cannedResponses[random.nextInt(cannedResponses.length)]);
            }

            transcript.append(botResponse).append("\n");
            System.out.println(botResponse.toString().trim());
        }

        System.out.println("See ya!\n");
        System.out.println("TRANSCRIPT:\n" + transcript.append("See ya!").toString());

        scanner.close();
    }
}
