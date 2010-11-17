package no.miles.service;

public final class ServiceFactory {

	private static ProductQueryService productQueryService;

	public ProductQueryService getProductQueryService() {
		if (productQueryService == null) {
			productQueryService = new DefaultProductQueryService();
		}

		return productQueryService;
	}

	public static void setProductQueryServiceInstance(ProductQueryService injectedService) {
		productQueryService = injectedService;
	}

	public static void clearInjectedServices() {
		productQueryService = null;
	}
}
