package crdm.appointment.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import crdm.appointment.entity.Section;
import crdm.appointment.repository.CrudRepository;
import crdm.appointment.repository.EntityType;
import crdm.appointment.repository.EntityType.Entities;

@Named
@RequestScoped
public class SectionBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<Section> sections;
	
	private Section section = new Section();
	
	@Inject
	@EntityType(Entities.SECTION)
	private CrudRepository<Section, Integer> crudRepository;

	@PostConstruct
	private void load() {
		sections = crudRepository.findAll();
	}

	
	public void delete(Integer id) {
		crudRepository.deleteById(id);
		sections = crudRepository.findAll();
	}
	
	public long count() {
		return crudRepository.count();
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	public List<Section> getSections() {
		return sections;
	}
	

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
	
	public void saveOrUpdate() {
		crudRepository.saveOrUpdate(section);
		sections = crudRepository.findAll();
	}
	
	public void clear() {
		this.section = new Section();
	}
	
}
