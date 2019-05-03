package crdm.appointment.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import crdm.appointment.entity.Doctor;
import crdm.appointment.repository.CrudRepository;
import crdm.appointment.repository.EntityType;
import crdm.appointment.repository.EntityType.Entities;

@Named
@RequestScoped
public class DoctorBean {

	private List<Doctor> doctors;

	@Inject
	@EntityType(Entities.DOCTOR)
	CrudRepository<Doctor, Integer> crudRepository;

	@PostConstruct
	private void load() {
		doctors = crudRepository.findAll();
	}

	public long count() {
		return crudRepository.count();
	}
	
	public List<Doctor> getDoctors() {
		doctors = crudRepository.findAll();
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

}
