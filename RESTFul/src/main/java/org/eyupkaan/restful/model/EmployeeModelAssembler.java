package org.eyupkaan.restful.model;

import org.eyupkaan.restful.controller.EmployeeController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class EmployeeModelAssembler implements RepresentationModelAssembler<Employee, EntityModel<Employee>> {

    @Override
    public EntityModel<Employee> toModel(Employee entity) {
        return EntityModel.of(entity,
                WebMvcLinkBuilder.linkTo(methodOn(EmployeeController.class).getById(entity.getId())).withSelfRel(),
                linkTo(methodOn(EmployeeController.class).allEmployee()).withRel("employees")
                );
    }
}
