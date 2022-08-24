package model;

public class Menu {
	private int menuid;
	private String menuName;
	private int price;
	private Category category;
	private String image;
	
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Menu(int menuid, String menuName, int price, Category category, String image) {
		super();
		this.menuid = menuid;
		this.menuName = menuName;
		this.price = price;
		this.category = category;
		this.image = image;
	}

	public int getMenuid() {
		return menuid;
	}


	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}


	public String getMenuName() {
		return menuName;
	}


	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}

	
	
	
	
	
	
}
