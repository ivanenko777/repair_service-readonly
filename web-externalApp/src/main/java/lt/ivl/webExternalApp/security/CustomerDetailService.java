package lt.ivl.webExternalApp.security;

import lt.ivl.webExternalApp.domain.Customer;
import lt.ivl.webExternalApp.exception.CustomerNotFoundInDBException;
import lt.ivl.webExternalApp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerDetailService implements UserDetailsService {
    @Autowired
    private CustomerService customerService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Customer customer = null;
        try {
            customer = customerService.findCustomerByEmail(s);
        } catch (CustomerNotFoundInDBException e) {
            throw new UsernameNotFoundException(s);
        }
        return new CustomerPrincipal(customer);
    }
}
