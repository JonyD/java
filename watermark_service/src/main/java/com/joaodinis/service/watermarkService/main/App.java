package com.joaodinis.service.watermarkService.main;

import java.util.ArrayList;
import java.util.List;

import com.joaodinis.service.watermarkService.model.Book;
import com.joaodinis.service.watermarkService.model.Document;
import com.joaodinis.service.watermarkService.model.Journal;
import com.joaodinis.service.watermarkService.model.Ticket;
import com.joaodinis.service.watermarkService.model.Topic;
import com.joaodinis.service.watermarkService.service.WatermarkService;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		// ----------------------------------------------------------------------
		// prepare list with >100 documents
		final Book d2 = Book.create(2, "title_2", "author_2", Topic.MEDIA);
		final Journal d3 = Journal.create(3, "title_3", "author_3");

		final List<Document> docs = new ArrayList<Document>();
		for (int i = 1; i <= 100; i++) {
			final String title = "title" + i;
			final String author = "author" + i;
			docs.add(Book.create(i, title, author, Topic.BUSINESS));
		}
		docs.add(d2);
		docs.add(d3);
		// ----------------------------------------------------------------------
		for (final Document entry : docs) {
			final WatermarkService runnableService1 = new WatermarkService(entry);
			final WatermarkService runnableService2 = new WatermarkService(entry);
			runnableService1.performService();
			runnableService2.performService();

			final Thread t1 = new Thread(runnableService1);
			final Thread t2 = new Thread(runnableService2);

			t1.start();
			t2.start();
		}
		// ----------------------------------------------------------------------

//		for (final Document entry : docs) {
//			System.out.println("---");
//			System.out.println("before service: " + entry.toString());
//			final Ticket serviceResultTicket = new WatermarkService().performService(entry);
//			System.out.println("service result ticket: " + serviceResultTicket.toString());
//			System.out.println("entry after service: " + entry.toString());
//			System.out.println("watermark: " + entry.getWatermark());
//		}

	}
}
