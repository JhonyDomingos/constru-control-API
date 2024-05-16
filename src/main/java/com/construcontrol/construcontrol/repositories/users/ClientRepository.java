package com.construcontrol.construcontrol.repositories.users;

import com.construcontrol.construcontrol.model.domain.users.Clients;
import com.construcontrol.construcontrol.model.domain.users.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Clients, Long> {

    Clients getClientsById(long id);
    Optional<Clients> getClientsByCpf(String cpf);

}

