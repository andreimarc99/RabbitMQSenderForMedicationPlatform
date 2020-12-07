package com.rabbit.assig2;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Assig2Application {

	private final static String QUEUE_NAME = "assig2-sd-queue";

	public static void main(String[] args) throws Exception {
		System.out.println("send start");
		String uri = "amqps://hawijyqe:qlyZGIW3OuGaNLAVi1Il9wnsBpNb16T-@jaguar.rmq.cloudamqp.com/hawijyqe";
		ConnectionFactory factory = new ConnectionFactory();
		factory.setUri(uri);
		factory.setRequestedHeartbeat(30);
		factory.setConnectionTimeout(30000);
		try (Connection connection = factory.newConnection();
			 Channel channel = connection.createChannel()) {

			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			//for (Activity m : activities) {
			//	System.out.println("Sent: " + m.toString());

			List<Activity> activities = new ArrayList<Activity>();
			BufferedReader reader;
			try {
				reader = new BufferedReader(new FileReader("activity.txt"));
				String line = reader.readLine();
				while (line != null) {
					/*
					DateFormat format = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
					Integer patientId;
					String start, end, activity;

					Activity a = new Activity();
					patientId = Integer.parseInt(line.substring(0, 1));
					start = line.substring(2, 21);
					end = line.substring(23, 42);
					activity = line.substring(42, line.length());
					activity = activity.replaceAll("\\s+", "");
					Date startDate = format.parse(start);
					Date endDate = format.parse(end);

					a.setPatientId(patientId);
					a.setStartTime(startDate);
					a.setEndTime(endDate);
					a.setActivity(activity);
					activities.add(a);
*/
					channel.basicPublish("", QUEUE_NAME, null, line.getBytes());
					Thread.sleep(1000);

					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			//}

			System.out.println(" [x] Sent '" + activities.toString() + "'");

		}
	}
}
