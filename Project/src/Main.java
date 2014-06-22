import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	/**
	 * @param args
	 */
	static final int NUMBER_OF_RECIPE_ATTRIBUTE = 2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method 
		
		//読み込むテキストファイルのパス
		String recipeFilePath = "../resource/recipe-txt.txt";
		
		//ファイルを一行ずつArrayListに格納する
		ArrayList<String> loadedRecipeString = new ArrayList<String>();
		loadedRecipeString = loadRecipeFile(recipeFilePath);
		
		//引数の配列をrecipeオブジェクトの配列に
		ArrayList<Recipe> recipeObjectArray = makeObjectFromArrayList(loadedRecipeString);
		
		printEachObjectOfArrayList(recipeObjectArray);
	}
	
	public static ArrayList<String> loadRecipeFile(String _recipeFilePath)
	{ 
		//引数文字列(_recipeFilePath)で指定されたテキストファイルを一行ずつ読み込んでArrayListに格納
		String line;
		ArrayList<String>  _loadedLineArray = new ArrayList<String>();
		BufferedReader br = null;
		
		try { 
			br = new BufferedReader(new FileReader(_recipeFilePath));
			//最後の行まで、一行ずつ読み込む
			while((line = br.readLine()) != null){
				_loadedLineArray.add(line);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { 
			//読み込みが終わったら閉じる
			try{
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
		return _loadedLineArray;
	}
	
	/* 配列を渡し、渡された配列の中身を1要素ずつ出力する。
	 * レシピをオブジェクトとして扱うことにしたので、配列から出力するこの関数はおそらく今後使わない（仕様5の段階）
	*/
	public static void printEachLineOfArrayList(ArrayList<String> _arrayList)
	{ 
		//引数配列(_arrayList) の中身を一行ずつ出力する
		int i;
		int length = _arrayList.size();
		for(i = 0; i<length; i++){
			System.out.println(_arrayList.get(i));
		}
	}
	
	/* 配列の先頭から順に、idが1,2,...と割り振られたRecipeオブジェクトの配列を生成し、それを返す
	 * [オムライス, 親子丼, 杏仁豆腐]という仮引数を与えられたら
	 * [<id:1, recipe_name:オムライス>, <id:2, recipe_name:親子丼>, <id:3, recipe_name:杏仁豆腐>]というオブジェクトの配列を返す
	 * (仕様6：追加)Urlも追加する
	 * */
	public static ArrayList<Recipe> makeObjectFromArrayList(ArrayList<String> _arrayList)
	{
		//返り値
		ArrayList<Recipe> recipe_object_array = new ArrayList<Recipe>();
		
		//返り値のリストに引数のリストをrecipe_nameとして持つRecipeオブジェクトを順に入れていく
		for(int i=0; i<_arrayList.size(); i++){
			String line = _arrayList.get(i);
			String[] recipe_attribute = line.split(", ", NUMBER_OF_RECIPE_ATTRIBUTE);
			String recipe_name = recipe_attribute[0];	
			String recipe_url  = recipe_attribute[1];
			Recipe rcp = new Recipe(i+1, recipe_name, recipe_url);
			recipe_object_array.add(rcp);
		}
		return recipe_object_array;
	}
	
	//recipeの配列の要素を1つずつ"id: recipe_name"の形式で出力する
	public static void printEachObjectOfArrayList(ArrayList<Recipe> _arrayList)
	{
		for(int i = 0; i<_arrayList.size(); i++){
			Recipe rcp = _arrayList.get(i);
			System.out.println(rcp.getId() + ": " + rcp.getRecipeName() + " " + rcp.getRecipeUrl());
		}
	}
}
