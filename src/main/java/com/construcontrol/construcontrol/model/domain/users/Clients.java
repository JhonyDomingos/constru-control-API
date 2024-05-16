package com.construcontrol.construcontrol.model.domain.users;

import com.construcontrol.construcontrol.model.domain.users.enums.MaritialStatus;
import com.construcontrol.construcontrol.model.domain.users.enums.UserType;
import com.construcontrol.construcontrol.shared.AddressDTO;
import com.construcontrol.construcontrol.DTO.users.ClientsDTO;

import com.construcontrol.construcontrol.shared.Address;
import jakarta.persistence.*;
import lombok.*;

@SuppressWarnings("ALL")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clientes_cpf")

public class Clients extends User {

    @Enumerated(EnumType.STRING)
    private MaritialStatus maritalStatus;

    public Clients(ClientsDTO clientsDTO) {
        this.name = clientsDTO.name();
        this.phone = clientsDTO.phone();
        this.email = clientsDTO.email();
        this.setCpf(clientsDTO.cpf());
        this.setRg(clientsDTO.rg());
        this.maritalStatus = MaritialStatus.valueOf(clientsDTO.maritalStatus());
        this.setUserType(UserType.CLIENTE);
        this.setAddress(createAddress(clientsDTO.address()));

    }

    private Address createAddress(AddressDTO addressDTO) {
        if (addressDTO != null) {
            return new Address(addressDTO);
        } else {
            return null;
        }
    }


}

