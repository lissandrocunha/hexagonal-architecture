package br.com.lissandrocunha.topologyinventory.domain.specification;


import br.com.lissandrocunha.topologyinventory.domain.entity.Equipment;
import br.com.lissandrocunha.topologyinventory.domain.exception.GenericSpecificationException;
import br.com.lissandrocunha.topologyinventory.domain.specification.shared.AbstractSpecification;

public class SameIpSpec extends AbstractSpecification<Equipment> {

    private Equipment equipment;

    public SameIpSpec(Equipment equipment){
        this.equipment = equipment;
    }

    @Override
    public boolean isSatisfiedBy(Equipment anyEquipment) {
        return !equipment.getIp().equals(anyEquipment.getIp());
    }

    @Override
    public void check(Equipment equipment) {
        if(!isSatisfiedBy(equipment))
            throw new GenericSpecificationException("It's not possible to attach routers with the same IP");
    }
}
