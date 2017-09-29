package DmyDemo.SpringRest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import DmyDemo.SpringRest.Entity.User;

@RepositoryRestResource(path="user")
public interface UserRepository  extends CrudRepository<User, String>{  

	
}
