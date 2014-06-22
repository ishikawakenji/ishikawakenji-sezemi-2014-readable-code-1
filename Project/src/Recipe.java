public class Recipe {
	private int id;
	private String recipe_name;
	
	public Recipe(int _id, String _recipe_name){
		id          = _id;
		recipe_name = _recipe_name;
	}
	
	public void setId(int _id){
		id = _id;
	}
	
	public int getId(){
		return id;
	}
	
	public void setRecipeName(String _recipe_name){
		recipe_name = _recipe_name;
	}
	
	public String getRecipeName(){
		return recipe_name;
	}
}