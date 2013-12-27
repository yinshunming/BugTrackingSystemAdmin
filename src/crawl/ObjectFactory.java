package crawl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the crawl package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

	private final static QName _CrawlFromOneBugResponse_QNAME = new QName(
			"http://bugtrackingsystem.citrite.net", "crawlFromOneBugResponse");
	private final static QName _CrawlFromOneBug_QNAME = new QName(
			"http://bugtrackingsystem.citrite.net", "crawlFromOneBug");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package: crawl
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link CrawlFromOneBugResponse }
	 * 
	 */
	public CrawlFromOneBugResponse createCrawlFromOneBugResponse() {
		return new CrawlFromOneBugResponse();
	}

	/**
	 * Create an instance of {@link CrawlFromOneBug }
	 * 
	 */
	public CrawlFromOneBug createCrawlFromOneBug() {
		return new CrawlFromOneBug();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link CrawlFromOneBugResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://bugtrackingsystem.citrite.net", name = "crawlFromOneBugResponse")
	public JAXBElement<CrawlFromOneBugResponse> createCrawlFromOneBugResponse(
			CrawlFromOneBugResponse value) {
		return new JAXBElement<CrawlFromOneBugResponse>(
				_CrawlFromOneBugResponse_QNAME, CrawlFromOneBugResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link CrawlFromOneBug }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://bugtrackingsystem.citrite.net", name = "crawlFromOneBug")
	public JAXBElement<CrawlFromOneBug> createCrawlFromOneBug(
			CrawlFromOneBug value) {
		return new JAXBElement<CrawlFromOneBug>(_CrawlFromOneBug_QNAME,
				CrawlFromOneBug.class, null, value);
	}

}
