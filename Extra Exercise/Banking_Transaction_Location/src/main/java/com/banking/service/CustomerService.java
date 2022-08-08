package com.banking.service;

import com.banking.model.Customer;
import com.banking.model.Location;
import com.banking.model.dto.CustomerDTO;
import com.banking.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerService implements ICustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private LocationService locationService;

    @Override
    public Iterable<Customer> findAll() {
        return null;
    }

    @Override
    public List<CustomerDTO> findAllCustomersDTO() {
        return customerRepository.findAllCustomersDTO();
    }

    @Override
    public Optional<CustomerDTO> findCustomerDTOById(Long id) {
        return customerRepository.findCustomerDTOById(id);
    }

    @Override
    public List<CustomerDTO> findRecipients(Long senderId) {
        return customerRepository.findRecipients(senderId);
    }

    @Override
    public Optional<Customer> findByIdAndDeletedFalse(Long id) {
        return customerRepository.findByIdAndDeletedFalse(id);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }


    @Override
    public boolean existsByEmail(String email) {
        return customerRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByPhone(String phone) {
        return customerRepository.existsByPhone(phone);
    }

    @Override
    public boolean existsByPhoneAndIdIsNot(String phone, Long id) {
        return customerRepository.existsByPhoneAndIdIsNot(phone, id);
    }

    @Override
    public boolean existsByEmailAndIdIsNot(String email, Long id) {
        return customerRepository.existsByEmailAndIdIsNot(email, id);
    }

    @Override
    public Customer getById(Long id) {
        return null;
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public CustomerDTO saveNewCustomerFromDTO(CustomerDTO customerDTO) {

        Location location = customerDTO.getLocation().toLocation();
        locationService.save(location);

        Customer customer = customerDTO.toCustomer();

        customer.setId(0L);
        customer.setBalance(BigDecimal.ZERO);
        customer.setLocation(location);

        return save(customer).toCustomerDTO();
    }

    @Override
    public CustomerDTO saveUpdatedCustomerFromDTO(CustomerDTO customerDTO, Customer customer) {

        Location location = customerDTO.getLocation().toLocation();
        location.setId(customer.getLocation().getId());
        locationService.save(location);

        Customer newCustomer = customerDTO.toCustomer();

        newCustomer.setId(customer.getId());
        newCustomer.setBalance(customer.getBalance());
        newCustomer.setLocation(location);

        return save(newCustomer).toCustomerDTO();
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void suspendCustomer(Long id) {
        customerRepository.suspendCustomer(id);
    }

}
