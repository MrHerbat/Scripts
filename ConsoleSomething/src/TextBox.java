import java.util.ArrayList;

public class TextBox {
    private char[][] textBoxArray= new char[6][102];

    public void CreateTextBoxBorder(){
        for (int i = 0; i < textBoxArray.length; i++) {
            for (int j = 0; j < textBoxArray[0].length; j++) {
                if (i==0||i==textBoxArray.length-1){
                    textBoxArray[i][j]='*';
                }else if(j==0||j==textBoxArray[0].length-1){
                    textBoxArray[i][j]='*';
                }
                else{
                    textBoxArray[i][j]=' ';
                }
            }
        }
    }
    public void FillTextBox(String string){
        ArrayList<String> temp = new ArrayList<>();
        temp.add("");
        int tempArrIndex = 0,tempIndex=0, wordSize=0;
        for (int i = 0; i < string.length(); i++) {
            temp.set(tempIndex,temp.get(tempIndex)+string.charAt(i));
            if (string.charAt(i)==' '){
                temp.add("");
                tempIndex++;
            }
        }
        tempIndex=0;
        for (int i = 0; i < temp.size(); i++) {
            System.out.println(temp.get(i));
        }
        for (int i = 1; i < textBoxArray.length-1; i++) {
            for (int j = 1; j < textBoxArray[0].length-1; j++) {
                if(tempArrIndex>=temp.size())
                {
                    break;
                }
                wordSize=temp.get(tempArrIndex).length()-tempIndex;
                if(j+wordSize<textBoxArray[0].length-2){
                    if(tempIndex>=temp.get(tempArrIndex).length()-1){
                        tempIndex=0;
                        tempArrIndex++;
                    }else {
                        if(temp.get(tempArrIndex).charAt(tempIndex)!=' ')
                        {
                            textBoxArray[i][j] = temp.get(tempArrIndex).charAt(tempIndex);
                            tempIndex++;
                        }else{
                            break;
                        }
                    }
                }else{
                    break;
                }
            }
        }
    }

    public void DisplayTextBox(){
        for (int i = 0; i < textBoxArray.length; i++) {
            for (int j = 0; j < textBoxArray[0].length; j++) {
                System.out.print(textBoxArray[i][j]);
            }
            System.out.println();
        }
    }
}
