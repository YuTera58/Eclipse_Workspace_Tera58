package kadai_021;

import java.util.HashMap;

public class Dictionary_Chapter21
{
	//HasMap 変数の宣言
	HashMap<String,String> wordsMap = new HashMap<String,String>();
	
	//コンストラクタ
	public Dictionary_Chapter21()
	{
		wordsMap.put("apple","りんご");
		wordsMap.put("peach","桃");
		wordsMap.put("banana","バナナ");
		wordsMap.put("lemon","レモン");
		wordsMap.put("pear","梨");
		wordsMap.put("kiwi","キウィ");
		wordsMap.put("strawberry","いちご");
		wordsMap.put("grape","ぶどう");
		wordsMap.put("muscat","マスカット");
		wordsMap.put("cherry","さくらんぼ");
	}
	
	public void searchWords(String[] words)
	{
		String result;
		
		for(int i = 0; i < words.length; i++)
		{
			result = wordsMap.get(words[i]);
			
			if(result != null)
			{
				System.out.println(words[i] + "の意味は" + result);
			}
			else
			{
				System.out.println(words[i] + "は辞書に存在しません");
			}
		}
	}
}
