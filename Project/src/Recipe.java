public class Recipe {
	private int id;
	private String recipe_name;
	private String recipe_url;
	
	public Recipe(int _id, String _recipe_name){
		id          = _id;
		recipe_name = _recipe_name;
	}
	
	public Recipe(int _id, String _recipe_name, String _recipe_url){
		id          = _id;
		recipe_name = _recipe_name;
		recipe_url  = _recipe_url;
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
	
	public void setRecipeUrl(String _recipe_url){
		recipe_url = _recipe_url;
	}
	
	public String getRecipeUrl(){
		return recipe_url;
	}
}