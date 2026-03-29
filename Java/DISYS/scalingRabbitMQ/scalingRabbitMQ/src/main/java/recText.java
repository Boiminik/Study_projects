import com.rabbitmq.client.*;

public class recText {
    private final static String QUEUE_NAME = "text_analysis_queue";

    public void receiveText() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Received '" + message + "'");

                String processedMessage = processMessage(message);
                System.out.println(" [x] Processed: '" + processedMessage + "'");
            };

            channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String processMessage(String message) {
        String reversed = revText.reverseText(message);
        String deleted = delEvenChar.deleteEvenChars(reversed);
        return remSpaces.removeSpaces(deleted);
    }
}
