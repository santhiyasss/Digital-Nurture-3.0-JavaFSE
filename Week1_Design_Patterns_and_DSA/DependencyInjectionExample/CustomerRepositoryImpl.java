public class CustomerRepositoryImpl implements CustomerRepository {
    public String findCustomerById(int id) {
        if (id == 1) return "Santhiya";
        if (id == 2) return "Ramesh";
        return "Customer not found";
    }
}