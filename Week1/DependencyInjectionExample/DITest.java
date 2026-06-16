public class DITest {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);

        System.out.println("Customer 1: " + service.getCustomer(1));
        System.out.println("Customer 2: " + service.getCustomer(2));
        System.out.println("Customer 3: " + service.getCustomer(3));
    }
}