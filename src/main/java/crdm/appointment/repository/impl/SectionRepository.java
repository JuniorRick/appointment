package crdm.appointment.repository.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import crdm.appointment.entity.Section;
import crdm.appointment.repository.CrudRepository;
import crdm.appointment.repository.EntityType;
import crdm.appointment.repository.EntityType.Entities;

@Stateless
@EntityType(Entities.SECTION)
public class SectionRepository implements CrudRepository<Section, Integer> {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Section save(Section section) {
		if (section != null) {
			em.persist(section);
		}
		return section;
	}

	@Override
	public Section findById(Integer id) {
		return em.find(Section.class, id);
	}

	@Override
	public List<Section> findAll() {
		return em.createQuery("SELECT s FROM Section s", Section.class).getResultList();

	}

	@Override
	public void delete(Section section) {
		em.remove(section);

	}

	@Override
	public void deleteById(Integer id) {
		Section section = em.find(Section.class, id);
		if (section != null) {
			em.remove(section);
		}

	}

	@Override
	public long count() {
		return em.createQuery("SELECT COUNT(s) FROM Section s", Long.class).getSingleResult();
	}

	@Override
	public Section saveOrUpdate(Section section) {

		if (section != null) {
			em.merge(section);
		}
		return section;
	}

}
