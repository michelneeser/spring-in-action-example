package com.michelneeser.tacos.data;

import com.michelneeser.tacos.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, Long> {


}
