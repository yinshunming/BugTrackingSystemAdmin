package crawl;

public class CrawlStatusFromOneBug {
	public static String crawlOneBug(String bugId) {
		String request = bugId;
		String response = null;
		CrawlOneBugService cos = new CrawlOneBugService();
		CrawlOneBugDelegate cod = cos.getCrawlOneBugPort();
		response = cod.crawlFromOneBug(request);
		return response;
	}
}
