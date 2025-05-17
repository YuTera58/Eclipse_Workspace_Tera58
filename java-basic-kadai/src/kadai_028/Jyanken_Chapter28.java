package kadai_028;

import java.util.HashMap;
import java.util.Scanner;

public class Jyanken_Chapter28
{
	// じゃんけんの判定結果を定数定義
	private static final int DRAW = 0;
	private static final int PLAYER_WIN = 1;
	private static final int PLAYER_LOSE = 2;
	
	
	//自分のじゃんけんの手を入力する
    public String getMyChoice()
    {
    	// do-while の継続判定用変数の宣言
    	boolean keepOn = false;
    	
    	//入力を受け取る変数の宣言
    	String inputKind = "";
    	
    	//入力要求メッセージ
    	System.out.println("自分のじゃんけんの手を入力しましょう\n"
    					 + "グーはrockのrを入力しましょう\n"
    					 + "チョキはscissorsのsを入力しましょう\n"
    					 + "パーはpaperのpを入力しましょう");
    	
    	
    	//Scanner のオブジェクト生成
    	Scanner scanner = new Scanner(System.in);
    	
    	//入力と入力のチェックを行う
    	do
    	{
    		//自分（Player）のじゃんけんの手を入力する
    		inputKind = scanner.nextLine();

    		//正しいじゃんけんの手であるか判定する
    		if(inputKind.equals("r") || inputKind.equals("s") || inputKind.equals("p"))
    		{
    			//正しいじゃんけんの手である場合はループを抜ける
    			keepOn = false;
    		}
    		else
    		{
    			//正しいじゃんけんの手でない場合、エラーを出力し、再度自分のじゃんけんの手を選ぶ
    			System.out.println(" r , s , p  のいずれか一文字を入力して Enter キーを押下して下さい");
    			keepOn = true;
    		}
    	}
    	while(keepOn);
    	
    	//リソースのクローズ処理
    	scanner.close();
    	
    	//自分のじゃんけんの手を返す
    	return inputKind;
    }
    
    
    //対戦相手のじゃんけんの手を乱数で選ぶ
	/*
	 * 乱数で対戦相手のじゃんけんの手を選ぶ際は、乱数で3未満の数を取得
	 * 取得した3未満の数をfloor()メソッドで切り捨て、配列の要素数である0から2を取得する
	 * */
	public String getRandom()
	{
		//配列にじゃんけんの手をセットする
		String[] jyankenKind_Array = {"r","s","p"};
		
		//乱数で対戦相手のじゃんけんの手を選ぶ
		String resultKind = jyankenKind_Array[(int)Math.floor(Math.random() * 3)];
				
		//じゃんけんクラスを実行するクラスに、対戦相手のじゃんけんの手を返す
		return resultKind;
	}
	
	
	//じゃんけんを行う
	public void playGame(String playerKind, String opponentKind)
	{
		// じゃんけんの判定結果を格納する変数定義
		int judgement = DRAW;
		
		
		//じゃんけんの手をキーと値で定義
		HashMap<String,String> kind = new HashMap<String,String>();
		kind.put("r","グー");
		kind.put("s","チョキ");
		kind.put("p","パー");
		
		
		//自分と対戦相手のじゃんけんの手を出力する
		System.out.println("自分の手は" + kind.get(playerKind) + "、対戦相手の手は" + kind.get(opponentKind));
		
		
		//自分と対戦相手のじゃんけんの手を比較する
		if(playerKind.equals(opponentKind)) //自分（Player）と相手が同じ手だった場合
		{
			judgement = DRAW;
		}
		else if(playerKind.equals("r"))	//自分（Player）の手がグーの場合
		{
			if(opponentKind.equals("s")) judgement = PLAYER_WIN;
			if(opponentKind.equals("p")) judgement = PLAYER_LOSE;
		}
		else if(playerKind.equals("s")) //自分（Player）の手がチョキの場合
		{
			if(opponentKind.equals("p")) judgement = PLAYER_WIN;
			if(opponentKind.equals("r")) judgement = PLAYER_LOSE;
		}
		else if(playerKind.equals("p")) //自分（Player）の手がパーの場合
		{
			if(opponentKind.equals("r")) judgement = PLAYER_WIN;
			if(opponentKind.equals("s")) judgement = PLAYER_LOSE;
		}
		
		
		//じゃんけんの結果を出力する
		switch(judgement)
		{
			case DRAW          -> System.out.println("あいこです");
			case PLAYER_WIN    -> System.out.println("自分の勝ちです");
			case PLAYER_LOSE   -> System.out.println("自分の負けです");
		}
	}
}
