package acme.entities.filters;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Filter extends DomainEntity{

	protected static final long	serialVersionUID	= 1L;
	
	@NotNull
	protected Double threshold;
	
	
	
}
