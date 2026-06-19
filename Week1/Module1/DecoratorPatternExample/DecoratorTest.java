public class DecoratorTest {
    public static void main(String[] args) {
        // Email only
        Notifier notifier = new EmailNotifier();

        // Email + SMS
        notifier = new SMSNotifierDecorator(notifier);

        // Email + SMS + Slack
        notifier = new SlackNotifierDecorator(notifier);

        notifier.send("Server is down!");
    }
}