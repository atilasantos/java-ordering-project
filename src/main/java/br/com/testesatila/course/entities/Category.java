package br.com.testesatila.course.entities;

public class Category {
	private Integer id;
	private String name;
	
	public Category() {}
	
	public Category(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
}
