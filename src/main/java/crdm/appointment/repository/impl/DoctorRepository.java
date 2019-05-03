package crdm.appointment.repository.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import crdm.appointment.entity.Doctor;
import crdm.appointment.repository.CrudRepository;
import crdm.appointment.repository.EntityType;
import crdm.appointment.repository.EntityType.Entities;


@Stateless
@EntityType(Entities.DOCTOR)
public class DoctorRepository implements CrudRepository<Doctor, Integer>{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Doctor save(Doctor doctor) {
		if(doctor != null) {
			em.persist(doctor);			
		}
		return doctor;
	}

	@Override
	public Doctor findById(Integer id) {
		return em.find(Doctor.class, id);
	}

	@Override
	public List<Doctor> findAll() {
		return em.createQuery("SELECT s FROM Doctor s", Doctor.class).getResultList();
		
	}

	@Override
	public void delete(Doctor doctor) {
		em.remove(doctor);
		
	}

	@Override
	public void deleteById(Integer id) {
		Doctor doctor = em.find(Doctor.class, id);
		if(doctor != null) {
			em.remove(doctor);
		}
	}

	@Override
	public long count() {
		return em.createQuery("SELECT COUNT(d) FROM Doctor d", Long.class).getSingleResult();
	}
	
	@Override
	public Doctor saveOrUpdate(Doctor doctor) {

		if (doctor != null) {
			em.merge(doctor);
		}
		return doctor;
	}

}
