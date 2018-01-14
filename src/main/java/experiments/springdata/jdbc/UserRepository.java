package experiments.springdata.jdbc;

import experiments.springdata.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

//@org.springframework.stereotype.Repository("UserRepository")
public interface UserRepository
        extends Repository<User, Long> {
}

