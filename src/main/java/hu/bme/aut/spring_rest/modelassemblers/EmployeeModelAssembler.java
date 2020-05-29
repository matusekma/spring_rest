package hu.bme.aut.spring_rest.modelassemblers;

import hu.bme.aut.spring_rest.controllers.EmployeeController;
import hu.bme.aut.spring_rest.models.Employee;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class EmployeeModelAssembler implements RepresentationModelAssembler<Employee, EntityModel<Employee>> {
    @Override
    public EntityModel<Employee> toModel(Employee employee) {
        return EntityModel.of(employee,
                linkTo(methodOn(EmployeeController.class).one(employee.getId())).withSelfRel(),
                linkTo(methodOn(EmployeeController.class).all()).withRel("employees"));
    }

    @Override
    public CollectionModel<EntityModel<Employee>> toCollectionModel(Iterable<? extends Employee> employees) {
        List<EntityModel<Employee>> employeeModels = new ArrayList<>();
        for (Employee employee : employees) {
            employeeModels.add(toModel(employee));
        }
        return CollectionModel.of(employeeModels,
                linkTo(methodOn(EmployeeController.class).all()).withSelfRel());
    }
}
