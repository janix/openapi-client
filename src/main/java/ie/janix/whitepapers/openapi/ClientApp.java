package ie.janix.whitepapers.openapi;

import ie.janix.demo.customer.ApiException;
import ie.janix.demo.customer.api.CustomerControllerApi;
import ie.janix.demo.customer.model.Customer;

import java.util.List;

/**
 * Simple client demonstrating the use of autogenerated SDK library
 */
public class ClientApp {

  // Dummy token for demo purposes
  // Authentication and token retrieval is beyond the scope of this project
  public static final String DEMO_TOKEN = "<insert-token-here>";

  public static void main(String[] args) {

    // Create an instance of the API proxy
    // By default references the API running at http://localhost:8080
    CustomerControllerApi apiInstance = new CustomerControllerApi();

    // Alternatively reference a different deployment location, e.g.
    // CustomerControllerApi apiInstance = new CustomerControllerApi(new ApiClient().setBasePath("http://myuatserver"));

    // Add bearer token to authenticate calls
    apiInstance.getApiClient().setBearerToken(DEMO_TOKEN);

    Long id = 1L;

    try {

      // Use the API proxy to call methods
      Customer customer = apiInstance.findById(id);
      System.out.println(customer);
      System.out.println();

      List<Customer> customerList = apiInstance.findCustomers();
      System.out.println(customerList);
      System.out.println();

      customer.setEmail("newemail@test.com");
      Customer updatedCustomer = apiInstance.updateCustomer(id, customer);
      System.out.println(updatedCustomer);
      System.out.println();

    } catch (ApiException e) {
      System.err.println("Exception when calling CustomerControllerApi#findById");
      e.printStackTrace();
    }
  }
}
