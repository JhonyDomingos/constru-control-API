package com.construcontrol.construcontrol.model.domain.users;

import com.construcontrol.construcontrol.model.domain.users.enums.UserType;
import com.construcontrol.construcontrol.shared.AddressDTO;
import com.construcontrol.construcontrol.DTO.users.ManagerDTO;
import com.construcontrol.construcontrol.shared.Address;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "manager")

public class Manager extends User {

    private UserType userType;

    public Manager(ManagerDTO ManagerDTO) {
        this.name = ManagerDTO.name();
        this.phone = ManagerDTO.phone();
        this.email = ManagerDTO.email();
        this.setCpf(ManagerDTO.cpf());
        this.setRg(ManagerDTO.rg());
        this.setUserType(UserType.GESTOR);
        this.setAddress(createAddress(ManagerDTO.address()));

    }
    private Address createAddress(AddressDTO addressDTO) {
        if (addressDTO != null) {
            return new Address(addressDTO);
        } else {
            return null;
        }
    }

}
