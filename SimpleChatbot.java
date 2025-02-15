import java.util.Scanner;
import java.util.Random;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class SimpleChatbot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, I am your AI Assistant. How can I help you today?");
        
        String userName = "";
        boolean isUserNamed = false;

        while(true) {
            String userInput = scanner.nextLine().toLowerCase();

            // Greet the user and ask for their name
            if (userInput.contains("hello") || userInput.contains("hi")) {
                System.out.println("Hello! How can I assist you?");
            } 
            // Ask for the user's name if not already provided
            else if (userInput.contains("what is your name")) {
                if (isUserNamed) {
                    System.out.println("I already know your name, " + userName + "!");
                } else {
                    System.out.println("I don't know your name yet. What's your name?");
                    userName = scanner.nextLine();
                    isUserNamed = true;
                    System.out.println("Nice to meet you, " + userName + "!");
                }
            } 
            // Respond with the current time
            else if (userInput.contains("time")) {
                LocalTime currentTime = LocalTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
                System.out.println("The current time is: " + currentTime.format(formatter));
            } 
            // Basic math calculations
            else if (userInput.contains("calculate")) {
                System.out.println("Sure! Please enter the math expression (e.g., 2 + 2): ");
                String mathExpression = scanner.nextLine();
                try {
                    String result = evaluateMathExpression(mathExpression);
                    System.out.println("The result is: " + result);
                } catch (Exception e) {
                    System.out.println("Sorry, I couldn't understand the math expression.");
                }
            } 
            // Tell a random joke
            else if (userInput.contains("joke")) {
                String[] jokes = {
                    "Why don’t skeletons fight each other? They don’t have the guts.",
                    "I told my wife she was drawing her eyebrows too high. She looked surprised.",
                    "Why don’t programmers like nature? It has too many bugs."
                };
                Random rand = new Random();
                System.out.println(jokes[rand.nextInt(jokes.length)]);
            } 
            // Tell a random quote
            else if (userInput.contains("quote")) {
                String[] quotes = {
                    "The only limit to our realization of tomorrow is our doubts of today. - Franklin D. Roosevelt",
                    "Do not go where the path may lead, go instead where there is no path and leave a trail. - Ralph Waldo Emerson",
                    "In the middle of every difficulty lies opportunity. - Albert Einstein"
                };
                Random rand = new Random();
                System.out.println(quotes[rand.nextInt(quotes.length)]);
            } 
            // Exit the program
            else if (userInput.contains("exit")) {
                System.out.println("Goodbye!");
                break;
            } 
            // Help message
            else if (userInput.contains("help")) {
                System.out.println("I can help you with various things. Ask me about time, jokes, quotes, and calculations.");
            } 
            // Unknown query
            else {
                System.out.println("Sorry, I didn't understand that.");
            }
        }
    }

    // Method to evaluate simple math expressions like "2 + 2"
    public static String evaluateMathExpression(String expression) {
        String[] tokens = expression.split(" ");
        double num1 = Double.parseDouble(tokens[0]);
        String operator = tokens[1];
        double num2 = Double.parseDouble(tokens[2]);
        
        double result = 0;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("Unsupported operator: " + operator);
        }
        return String.valueOf(result);
    }
}
